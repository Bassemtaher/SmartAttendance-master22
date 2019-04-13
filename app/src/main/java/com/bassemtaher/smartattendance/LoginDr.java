package com.bassemtaher.smartattendance;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by bassem on 13/04/2019.
 */

public class LoginDr extends AppCompatActivity implements AddInterface{


    DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference();
    private Button registerAccount;
    private EditText name,phone,password;
    private ProgressDialog loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dr);
    registerAccount=findViewById(R.id.register_btn);
    name=findViewById(R.id.register_name_input);
    phone=findViewById(R.id.register_phone_no_input);
    password=findViewById(R.id.register_password_input);
    loading=new ProgressDialog(this);


        registerAccount.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(checkIfAllMandatoryFieldsEntered()) {
                String a=name.getText().toString();
                String b=phone.getText().toString();
                String c=password.getText().toString();





                HelperMethods.currentUser.setEmail(a);
                HelperMethods.currentUser.setPhone(b);
                HelperMethods.currentUser.setPass(c);
                String id = HelperMethods.currentUser.getEmail().replace(".","");;
                HelperMethods.pushInFireBase("Student", HelperMethods.currentUser, LoginDr.this, "loading", "plz wait", id);

            }

        }
    });

}
    private boolean checkIfAllMandatoryFieldsEntered()
    {
        name.setError(null);
        phone.setError(null);
        password.setError(null);

        String userName= name.getText().toString();
        String number= phone.getText().toString();
        String pass=password.getText().toString();
        boolean cancel=false;
        View focusView=null;

        if (TextUtils.isEmpty(userName)){
            name.setError("name is mandatory");
            focusView=name;
            cancel=true;

        }

        if(TextUtils.isEmpty(number))
        {
            phone.setError("phone number is mandatory");
            focusView=phone;
            cancel=true;
        }

        if (TextUtils.isEmpty(pass))
        {
            password.setError("password is mandatory");
            focusView=password;
            cancel=true;

        }
        if(cancel)
        {
            focusView.requestFocus();
        }

        return !cancel;



    }



    @Override
    public void updateUI(DatabaseError databaseError) {
        if(databaseError==null){

            Toast.makeText(this, "registered", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(LoginDr.this,Subjects.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "error in saving", Toast.LENGTH_SHORT).show();

        }
    }

}





