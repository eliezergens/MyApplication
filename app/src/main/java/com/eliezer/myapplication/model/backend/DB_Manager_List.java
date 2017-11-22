package com.eliezer.myapplication.model.backend;

import android.content.ContentValues;
import android.database.Cursor;

import com.eliezer.myapplication.model.entities.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eliezer on 20/11/2017.
 */

public class DB_Manager_List implements DB_Manager {
    private static List<Property> propertyList;

    static {
        propertyList = new ArrayList<Property>();
    }

    @Override
    public int addProperty(ContentValues cv) {
        return 0;
    }

    @Override
    public boolean removeProperty(ContentValues cv) {
        return false;
    }

    @Override
    public Cursor getAllProprties() {
        return null;
    }
}
