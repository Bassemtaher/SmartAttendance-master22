package com.bassemtaher.smartattendance;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bassemtaher.smartattendance.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Subjects extends AppCompatActivity {

    Spinner spin;
    Button btn;
    String subjects, subject,text;
    ImageView imageView;
    Date currentTime = Calendar.getInstance().getTime();
    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
        Date date = new Date();
        return dateFormat.format(date);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        spin = findViewById(R.id.spinner);
        btn = findViewById(R.id.button);
        imageView=findViewById(R.id.image);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subjects = spin.getSelectedItem().toString();
                switch (subjects) {
                    case "Security":
                        subject = "security123";
                        break;

                    case "Neural":
                        subject = "neural123";
                        break;

                }
                text=subject+getDateTime();
                Toast.makeText(Subjects.this, text, Toast.LENGTH_SHORT).show();

                try {
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 500, 500);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    imageView.setImageBitmap(bitmap);


                } catch (WriterException e) {

                    e.printStackTrace();

                }


            }
        });


    }
}