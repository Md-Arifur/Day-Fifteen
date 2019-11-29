package com.bitm.addshowevent.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bitm.addshowevent.model.Event;
import com.bitm.addshowevent.repository.EventRepo;

public class EventViewModel extends AndroidViewModel {

    private EventRepo eventRepo;

    public EventViewModel(@NonNull Application application) {
        super(application);
        eventRepo = new EventRepo(application);
    }
    public MutableLiveData<Boolean> saveEvent(Event event){
        return eventRepo.saveEvent(event);
    }
}
