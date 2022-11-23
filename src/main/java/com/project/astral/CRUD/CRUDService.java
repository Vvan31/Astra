package com.project.astral.CRUD;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class CRUDService {

    public String createCRUD(CRUD crud) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
       
        ApiFuture<WriteResult> collectApiFuture = dbFirestore
            .collection("users")
            .document(crud.getDocumentId())
            .set(crud); 

        return collectApiFuture.get().getUpdateTime().toString();
    }

    public CRUD getCRUD(String documentId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        
        DocumentReference docRef = dbFirestore
            .collection("users")
            .document(documentId);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        CRUD crud;
        if (document.exists()) {
            crud = document.toObject(CRUD.class);
            return crud;
        }
        return null;
    }

    public String updateCRUD(CRUD crud) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture = dbFirestore
            .collection("users")
            .document(crud.getDocumentId())
            .set(crud);
        return collectionApiFuture.get().getUpdateTime().toString();
        
    }

    public String deleteCRUD(String documentId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        
        ApiFuture<WriteResult> writeResult = dbFirestore
            .collection("user")
            .document(documentId).delete();

        return "Successfully deleted " + documentId;
    }

    

}
