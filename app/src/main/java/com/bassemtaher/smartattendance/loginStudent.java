package com.bassemtaher.smartattendance;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class loginStudent extends AppCompatActivity implements GetDataInterface{

    private Button registerAccount;
    private EditText email,phone,password;
    private ProgressDialog loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_student);
        registerAccount=findViewById(R.id.register_btn);
        email=findViewById(R.id.register_name_input);
        phone=findViewById(R.id.register_phone_no_input);
        password=findViewById(R.id.register_password_input);
        loading=new ProgressDialog(this);
        registerAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkIfAllMandatoryFieldsEntered()) {

                    HelperMethods.getData(loginStudent.this, "Student", "please wait ", "loading");



                }
            }
        });

    }
    private boolean checkIfAllMandatoryFieldsEntered()
    {
        email.setError(null);
        phone.setError(null);
        password.setError(null);

        String userName= email.getText().toString();
        String number= phone.getText().toString();
        String pass=password.getText().toString();
        boolean cancel=false;
        View focusView=null;

        if (TextUtils.isEmpty(userName)){
            email.setError("name is mandatory");
            focusView=email;
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
    public void updateUI(DataSnapshot data) {
        String x,y,z;
        Log.i("data","update ui : "+data.toString());


        boolean isExist=false;
        for (DataSnapshot currentChild:data.getChildren()){
            Student currentStudent= currentChild.getValue(Student.class);
            x= currentStudent.getEmail().toString();
            y=currentStudent.getPass().toString();
            z=currentStudent.getSecurity().toString();
            Toast.makeText(this, z, Toast.LENGTH_SHORT).show();



            if (x.equalsIgnoreCase(email.getText().toString())
                    && y.equals(password.getText().toString()))
            {
                isExist= true;
                break;


            }
        }


        if (isExist){
            Intent i= new Intent(loginStudent.this,Generator.class);
            startActivity(i);


        }

        if(isExist==false) {

            Toast.makeText(this, "wrong user name or password", Toast.LENGTH_SHORT).show();
        }
    }

}
