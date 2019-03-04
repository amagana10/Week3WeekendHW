package com.example.navtest;

import android.util.Log;

import java.util.Locale;

public class EmployeeDBContract {
    public static final String DB_NAME = "employees_db";
    public static final int DB_VERSION_NUMBER = 1;


    public static final String TABLE_NAME = "employees";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_B_DAY = "birthday";
    public static final String COLUMN_WAGE = "wage";
    public static final String COLUMN_HIRE_DATE = "hireDate";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_ID = "id";

    public static String createQuery(){
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE ");
        builder.append(TABLE_NAME);
        builder.append(" ( ");

        builder.append(COLUMN_ID);
        builder.append(" ");
        builder.append("INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builder.append(COLUMN_NAME);
        builder.append(" TEXT, ");
        builder.append(COLUMN_B_DAY);
        builder.append(" TEXT, ");
        builder.append(COLUMN_WAGE);
        builder.append(" TEXT, ");
        builder.append(COLUMN_HIRE_DATE);
        builder.append(" TEXT, ");
        builder.append(COLUMN_IMAGE);
        builder.append(" TEXT )");

        Log.d("TAG", "createQuery: " + builder.toString());

        return builder.toString();
    }

    public static String getAllEmployeesQuery(){
        return "SELECT * FROM " + TABLE_NAME;
    }

    public static String getEmlployeeByID(int id){
        return String.format("SELECT * FROM %s WHERE %s = \"%d\"",TABLE_NAME,COLUMN_ID,id);
    }
    public static String getWhereClauseById() {
        return String.format(Locale.US, "%s = ", COLUMN_ID);
    }

}
