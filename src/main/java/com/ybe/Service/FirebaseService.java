package com.ybe.Service;

import com.google.api.core.ApiFuture;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {

    public UserRecord verifyToken(String authToken) {

        final String TAG = FirebaseService.class.getSimpleName() + " : ";

        UserRecord user = null;
        ApiFuture<FirebaseToken> task = FirebaseAuth.getInstance().verifyIdTokenAsync(authToken);

        try {
            FirebaseToken token = task.get();
            System.out.println(TAG + "Firebase Token is " + token);
            user = FirebaseAuth.getInstance().getUserAsync(token.getUid()).get();
            System.out.println(TAG + "Firebase user is " + user.toString());

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
