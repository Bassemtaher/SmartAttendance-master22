package com.bassemtaher.smartattendance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by bassem on 06/04/2019.
 */

public class Student implements ModelInterface{
    String email,phone,pass;
    ArrayList<Security> security =new ArrayList<>();

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ArrayList<Security> getSecurity() {
        return security;
    }

    public void setSecurity(ArrayList<Security> security) {
        this.security = security;
    }

    @Override
    public Map<String, Object> toMap() {
        HashMap<String ,Object> result =new HashMap<>();


        result.put("email",email);
        result.put("phone",phone);
        result.put("pass",pass);
        result.put("security", security);

        return null;
    }
}
