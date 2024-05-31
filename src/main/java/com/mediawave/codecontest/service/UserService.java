package com.mediawave.codecontest.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.mediawave.codecontest.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    Firestore firestore;
    UserService(){
//      Initializes and Returns an instance of Firestore
        firestore= FirestoreClient.getFirestore();
    }


    public ResponseEntity<String> createUser(User user) throws ExecutionException, InterruptedException {
        DocumentReference documentReference= firestore.collection("users").document(user.getId());
//      Asynchronously retrieve all documents
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot=apiFuture.get();

//      Check whether user exist with that id or not
        if(documentSnapshot.exists()){
            return new ResponseEntity<>("An user's object with this ID already exists. Please use a unique ID.",HttpStatus.CONFLICT);
        }

//      Create user
        ApiFuture<WriteResult> collectionsApiFuture = firestore.collection("users").document(user.getId()).set(user);
        return  new ResponseEntity<>("User has been created successfully!!", HttpStatus.CREATED);

    }


    public ResponseEntity<?> getUser(String id) throws ExecutionException, InterruptedException {
        DocumentReference documentReference= firestore.collection("users").document(id);
//      Asynchronously retrieve all documents
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot= future.get();
//      If user exist return it
        if(documentSnapshot.exists()){
            User user = documentSnapshot.toObject(User.class);
            return new ResponseEntity<>(user,HttpStatus.FOUND);
        }
//      If user doesn't exist
        return new ResponseEntity<>("The user's object does not exist.",HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<String> updateUser(User user) throws ExecutionException, InterruptedException {
        DocumentReference documentReference= firestore.collection("users").document(user.getId());
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot=apiFuture.get();

//      First check user must exist
        if(!documentSnapshot.exists()){
            return new ResponseEntity<>("The user's object you are trying to modify does not exist.",HttpStatus.NOT_FOUND);
        }
//      Update the user
        ApiFuture<WriteResult> collectionsApiFuture = firestore.collection("users").document(user.getId()).set(user);
        return  new ResponseEntity<>("User has been modified successfully!!", HttpStatus.OK);
    }


    public ResponseEntity<String> deleteUser(String id) throws ExecutionException, InterruptedException {
        DocumentReference documentReference= firestore.collection("users").document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot=apiFuture.get();

//      First check user exist or not
        if(documentSnapshot.exists()){
            // Delete the user
            ApiFuture<WriteResult> apiFuture1=firestore.collection("users").document(id).delete();
            return new ResponseEntity<>("Deleted Successfully!!",HttpStatus.OK);
        }

        return new ResponseEntity<>("The user's object you are trying to delete does not exist in our database.",HttpStatus.NOT_FOUND);

    }


    public ResponseEntity<List<User>> getAllUser() throws ExecutionException, InterruptedException {
        CollectionReference collectionReference = firestore.collection("users");
//      Asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> querySnapshot = collectionReference.get();

        List<User> users = new ArrayList<>();
//      Store all user in the list
        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            User user = document.toObject(User.class);
            if (user != null) {
                users.add(user);
            }
        }

        return new ResponseEntity<>(users,HttpStatus.OK);
    }
}
