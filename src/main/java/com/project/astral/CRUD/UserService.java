package com.project.astral.CRUD;

import java.util.concurrent.ExecutionException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{

    private final static String USER_NOT_FOUND = "user with name %s not found";
    private final UserRepo userRepo;

    public String createUser(User User) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
       
        ApiFuture<WriteResult> collectApiFuture = dbFirestore
            .collection("users")
            .document(User.getDocumentId())
            .set(User); 

        return collectApiFuture.get().getUpdateTime().toString();
    }

    public User getUser(String documentId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        
        DocumentReference docRef = dbFirestore
            .collection("users")
            .document(documentId);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        User User;
        if (document.exists()) {
            User = document.toObject(User.class);
            return User;
        }
        return null;
    }

    public String updateUser(User User) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture = dbFirestore
            .collection("users")
            .document(User.getDocumentId())
            .set(User);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public String deleteUser(String documentId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        
        ApiFuture<WriteResult> writeResult = dbFirestore
            .collection("user")
            .document(documentId).delete();

        return "Successfully deleted " + documentId;
    }

    @Override
    public UserDetails loadUserByUsername(String username) 
        throws UsernameNotFoundException {
       return userRepo.findByName(username).orElseThrow(
        ()-> new UsernameNotFoundException(
            String.format(USER_NOT_FOUND, username, null)));
    }
 
}
