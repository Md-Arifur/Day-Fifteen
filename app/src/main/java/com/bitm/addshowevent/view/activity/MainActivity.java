package com.bitm.addshowevent.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.bitm.addshowevent.R;
import com.bitm.addshowevent.databinding.ActivityMainBinding;
import com.bitm.addshowevent.view.bottomSheet.AddEventBottomSheet;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.addEventFABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddEventBottomSheet addEventBottomSheet = new AddEventBottomSheet();
                addEventBottomSheet.show(getSupportFragmentManager(),"AddEventBottomSheet");

            }
        });
    }
}
