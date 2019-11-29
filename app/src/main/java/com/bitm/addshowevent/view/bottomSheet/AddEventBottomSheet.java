package com.bitm.addshowevent.view.bottomSheet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bitm.addshowevent.R;
import com.bitm.addshowevent.databinding.BottomSheetAddEventBinding;
import com.bitm.addshowevent.model.Event;
import com.bitm.addshowevent.viewmodel.EventViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddEventBottomSheet extends BottomSheetDialogFragment {

    private BottomSheetAddEventBinding binding;
    private EventViewModel eventViewModel;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_add_event,container,false);

        init();

        binding.saveEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName = binding.eventNameET.getText().toString().trim();
                String eventLocation = binding.eventLocationET.getText().toString().trim();
                String startDate = binding.startDateET.getText().toString().trim();
                String endDate = binding.endDateET.getText().toString().trim();
                double budget =Integer.parseInt(binding.eventBudgetET.getText().toString().trim());

                Event event = new Event(eventName,eventLocation,startDate,endDate,budget);

                saveEvent(event);
            }
        });
        return binding.getRoot();
    }

    private void init() {
        context = getActivity();
        eventViewModel = ViewModelProviders.of((AppCompatActivity)context).get(EventViewModel.class);
    }

    private void saveEvent(Event event) {
        eventViewModel.saveEvent(event).observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                    if (aBoolean==true){
                        Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
                        dismiss();
                    }
            }
        });
    }
}
