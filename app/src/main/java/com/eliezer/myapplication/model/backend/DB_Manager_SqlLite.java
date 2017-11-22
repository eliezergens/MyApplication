package com.eliezer.myapplication.model.backend;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by Eliezer on 22/11/2017.
 */

public class DB_Manager_SqlLite implements DB_Manager {
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
