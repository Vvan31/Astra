package com.project.astral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.File;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AstralApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AstralApplication.class, args);
		connectToDb();
	}

	// Loads Firebase credentials and initialize.
	private static void connectToDb() throws IOException{
		ClassLoader classLoader = AstralApplication.class.getClassLoader();
		File file = new File(Objects.requireNonNull(classLoader.getResource("firebaseCredentials.json")).getFile());
		
		FileInputStream serviceAccount = 
			new FileInputStream(file.getAbsolutePath());

		FirebaseOptions options = new FirebaseOptions.Builder()
			.setCredentials(GoogleCredentials.fromStream(serviceAccount))
			.build();
		
		FirebaseApp.initializeApp(options);
	}
}
