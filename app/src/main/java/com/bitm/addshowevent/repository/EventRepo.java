package com.bitm.addshowevent.repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.bitm.addshowevent.model.Event;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventRepo {
    private Application application;
    private DatabaseReference databaseReference;

    public EventRepo(Application application) {
        this.application = application;
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public MutableLiveData<Boolean> saveEvent(Event event){
        final MutableLiveData<Boolean> liveData = new MutableLiveData<>();

        DatabaseReference eventRef = databaseReference.child("events");
        eventRef.setValue(event).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    liveData.postValue(true);
                }else {
                    liveData.postValue(false);
                }
            }
        });

        return liveData;
    }
}
