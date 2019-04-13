package com.bassemtaher.smartattendance;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView text;
    ImageView img;
    Button stubutton;
    Button ssbutton;
    Button docbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stubutton=findViewById(R.id.stuB);
        ssbutton=findViewById(R.id.ssB);
        docbutton=findViewById(R.id.docB);
        text=findViewById(R.id.textView2);
        img=findViewById(R.id.imageView);
        stubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mDatabase;

                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child("Student").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot currentChild : dataSnapshot.getChildren()) {
                            Student currentStudents = currentChild.getValue(Student.class);
                            Log.i("data","on data change"+currentStudents.getEmail());

                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }


                });
                openActivity2();

            }
        });
        docbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                openActivity4();
            }
        });

    }
    public void openActivity2(){

        Intent intent=new Intent(this, Yers.class);
        startActivity(intent);

    }
    public void openActivity4(){

        Intent intent=new Intent(this, scanActivity.class);
        startActivity(intent);

    }

}