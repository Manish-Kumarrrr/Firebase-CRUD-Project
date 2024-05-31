package com.mediawave.codecontest;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.FileInputStream;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		try {
			FileInputStream serviceAccount =
					new FileInputStream("./src/main/resources/firebase-adminsdk.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://mediawave-code-contest-manish-default-rtdb.firebaseio.com")
					.build();

			FirebaseApp.initializeApp(options);
		}
		catch(Exception e){
			System.out.println(e.getMessage());;
		}





		SpringApplication.run(CrudApplication.class, args);
	}

}
