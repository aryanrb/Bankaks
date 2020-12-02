package com.aryan.bankaks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Spinner spChoice;
    private Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spChoice = findViewById(R.id.spinner);
        btnProceed = findViewById(R.id.btnProceed);

        btnProceed.setOnClickListener(v -> {
            if(getResources().getStringArray(R.array.id_value)[spChoice
                    .getSelectedItemPosition()] != null) {
                String option = getResources().getStringArray(R.array.id_value)[spChoice
                        .getSelectedItemPosition()];

//            Toast.makeText(this, ""+option, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ServiceActivity.class);
                intent.putExtra("type", option);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Please select the Option again!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}