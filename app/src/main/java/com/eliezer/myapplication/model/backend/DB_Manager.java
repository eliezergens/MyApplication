package com.eliezer.myapplication.model.backend;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by Eliezer on 20/11/2017.
 */

public interface DB_Manager {
    int addProperty(ContentValues cv);
    boolean removeProperty(ContentValues cv);
    Cursor getAllProprties();

}
