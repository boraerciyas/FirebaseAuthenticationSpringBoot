package com.ybe;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.FirebaseCredentialsAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FirebaseAuth getfirebaseAuth() throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        String firebaseSDKPath = "yourPathToAdminSDK"; //Recommended to put on resources/firebaseSdk/
                                                       // and set it firebaseSdk/<project-admin-sdk-name>.json

        File file = new File(classLoader.getResource(firebaseSDKPath).getFile());

        FileInputStream serviceAccount = new FileInputStream(file);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(FirebaseCredentialsAdapter.fromStream(serviceAccount))
                .setDatabaseUrl("yourFirebaseDatabaseUrl")
                .build();

        FirebaseApp.initializeApp(options);

        return FirebaseAuth.getInstance();

    }
}
