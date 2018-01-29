package com.example.singh.android_contentprovider.provider;


import android.provider.BaseColumns;

/**
 * Author: singh on: 02-Jan-18.
 */

public final class LocalDataContract {

    public static class People implements BaseColumns{

        //table name
        public static final String TABLE_NAME = "people";
        //table fields
        public static final String NAME = "name";
        public static final String AGE = "age";
        public static final String GENDER = "gender";


    }

}
