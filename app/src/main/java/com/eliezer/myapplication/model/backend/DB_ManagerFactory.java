package com.eliezer.myapplication.model.backend;

/**
 * Created by Eliezer on 20/11/2017.
 */

public final class DB_ManagerFactory {

    private static  DB_Manager manager = null;

    public  static DB_Manager getDB_Manager()
    {
        if (manager ==null)
        {
            manager = new DB_Manager_List();
        }
        return  manager;
    }
}
