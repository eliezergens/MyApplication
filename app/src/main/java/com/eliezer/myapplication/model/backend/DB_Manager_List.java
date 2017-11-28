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

    public void initRentals() {
        //create property elements
        propertyList.add(
                new Property(10, "Smith Street", "Sydney", "NSW", "A large 3 bedroom apartment right in the heart of Sydney! A rare find, with 3 bedrooms and a secured car park.", 450.00, "property_image_1", 3, 1, 1));

        propertyList.add(
                new Property(66, "King Street", "Sydney", "NSW", "A fully furnished studio apartment overlooking the harbour. Minutes from the CBD and next to transport, this is a perfect set-up for city living.", 320.00, "property_image_2", 1, 1, 1));

        propertyList.add(
                new Property(1, "Liverpool Road", "Liverpool", "NSW", "A standard 3 bedroom house in the suburbs. With room for several cars and right next to shops this is perfect for new families.", 360.00, "property_image_3", 3, 2, 2));

        propertyList.add(
                new Property(567, "Sunny Street", "Gold Coast", "QLD", "Come and see this amazing studio appartment in the heart of the gold coast, featuring stunning waterfront views.", 360.00, "property_image_4", 1, 1, 1));
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

    @Override
    public List<Property> getAllProprtiesList() {
        /*
        public class MyData {
            String column1;
            String column2;

            public MyData(String column1, String column2){
                this.column1 = column1;
                this.column2 = column2;
            }
        }
        //iterating the cursor and adding to the list:

        List<MyData> list = new ArrayList<>();

        while(cursor.moveToNext()) {
            String column1 = cursor.getString(cursor.getColumnIndex(COLUMN_NAME1));
            String column2 = cursor.getString(cursor.getColumnIndex(COLUMN_NAME2));
            MyData data = new MyData(column1, column2);
            list.add(data);
        }
      */
        ArrayList<Property> result = new ArrayList<>();
        for (Property p : propertyList) {
            result.add(p);
        }
        return result;
    }
}
