package com.bassemtaher.smartattendance;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bassem on 12/04/2019.
 */

public class Security implements ModelInterface {
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public Map<String, Object> toMap() {
        HashMap<String ,Object> result =new HashMap<>();

        result.put("date",date);

        return null;
    }
}
