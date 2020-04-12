package com.example.yo7a.healthwatcher;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StartVitalSigns extends AppCompatActivity {
    private String user;
    private int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_vital_signs);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user = extras.getString("Usr");
            p = extras.getInt("Page");
        }

        ImageButton VS = this.findViewById(R.id.StartVS);

        VS.setOnClickListener(v -> {

            //switch is to decide which activity must be opened
            switch (p) {

                case 1: {
                    Intent i = new Intent(v.getContext(), HeartRateProcess.class);
                    i.putExtra("Usr", user);
                    startActivity(i);
                    finish();
                }
                break;

                case 2: {
                    Intent i = new Intent(v.getContext(), BloodPressureProcess.class);
                    i.putExtra("Usr", user);
                    startActivity(i);
                    finish();
                }
                break;

                case 3: {
                    Intent i = new Intent(v.getContext(), RespirationProcess.class);
                    i.putExtra("Usr", user);
                    startActivity(i);
                    finish();
                }
                break;

                case 4: {
                    Intent i = new Intent(v.getContext(), O2Process.class);
                    i.putExtra("Usr", user);
                    startActivity(i);
                    finish();
                }
                break;

                case 5: {
                    Intent i = new Intent(v.getContext(), VitalSignsProcess.class);
                    i.putExtra("Usr", user);
                    startActivity(i);
                    finish();
                }
                break;
            }

        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(StartVitalSigns.this, Primary.class);
        startActivity(i);
        finish();
        super.onBackPressed();
    }


}
