package com.adit.arisan;

import android.app.Application;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Model extends Application {


    private boolean isSelected;
    private String animal;

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
