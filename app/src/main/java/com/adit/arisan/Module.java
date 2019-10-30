package com.adit.arisan;

import android.app.Application;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Module extends Application {


    public Module() {

    }

    public ArrayList<String> garrList= new ArrayList<>();
    public ArrayAdapter<String> garrAdp;
    public String gvalue_username;
    public String gvalue_name;

    public String getGvalue_username() {
        return gvalue_username;
    }

    public void setGvalue_username(String gvalue_id) {
        this.gvalue_username = gvalue_id;
    }

    public String getGvalue_name() {
        return gvalue_name;
    }

    public void setGvalue_name(String gvalue_name) {
        this.gvalue_name = gvalue_name;
    }
}
