package com.bassemtaher.smartattendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bassemtaher.smartattendance.R;

public class Yers extends AppCompatActivity {
    Button year1,year2,year3,year4;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yers);
        year1 = findViewById(R.id.year1);
        year2 = findViewById(R.id.year2);
        year3 = findViewById(R.id.year3);
        year4 = findViewById(R.id.year4);
        textView = findViewById(R.id.selectSm);
        year4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();

            }
        });
    }
    public void openActivity3 () {

        Intent intent = new Intent(this, Subjects.class);
        startActivity(intent);
    }
}





