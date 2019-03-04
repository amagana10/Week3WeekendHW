package com.example.navtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import static com.example.navtest.EmployeeDBContract.*;

public class EmployeeDBHelper extends SQLiteOpenHelper {
    public EmployeeDBHelper(@NonNull Context context) {
        super(context, DB_NAME, null, DB_VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
    public long insertEmployeeIntoDB(@NonNull Employee employee){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME,employee.getName());
        contentValues.put(COLUMN_B_DAY,employee.getBirthday());
        contentValues.put(COLUMN_WAGE,employee.getWage());
        contentValues.put(COLUMN_HIRE_DATE,employee.getHiredate());
        contentValues.put(COLUMN_IMAGE,employee.getImage());

        return  database.insert(TABLE_NAME,null,contentValues);
    }

    public ArrayList<Employee> getAllEmployeesFromDB(){
        ArrayList<Employee> returnEmployees = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery(getAllEmployeesQuery(),null);

        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String bday = cursor.getString(cursor.getColumnIndex(COLUMN_B_DAY));
                String wage = cursor.getString(cursor.getColumnIndex(COLUMN_WAGE));
                String hireday = cursor.getString(cursor.getColumnIndex(COLUMN_HIRE_DATE));
                String image = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE));

                returnEmployees.add(new Employee(id,name,bday,wage,hireday,image));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return returnEmployees;
    }

    public Employee getEmployeeByID(int id){
        SQLiteDatabase database = this.getReadableDatabase();

        Employee returnEmployee = new Employee();

        Cursor cursor = database.rawQuery(getEmlployeeByID(id),null);

        if (cursor.moveToFirst()){
            id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String bday = cursor.getString(cursor.getColumnIndex(COLUMN_B_DAY));
            String wage = cursor.getString(cursor.getColumnIndex(COLUMN_WAGE));
            String hireday = cursor.getString(cursor.getColumnIndex(COLUMN_HIRE_DATE));
            String image = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE));

            returnEmployee = new Employee(id,name,bday,wage,hireday,image);
        }
        cursor.close();
        return returnEmployee;
    }

    public  long updateEmployeeInDB(@NonNull Employee employee){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME,employee.getName());
        contentValues.put(COLUMN_B_DAY,employee.getBirthday());
        contentValues.put(COLUMN_WAGE,employee.getWage());
        contentValues.put(COLUMN_HIRE_DATE,employee.getHiredate());
        contentValues.put(COLUMN_IMAGE,employee.getImage());

        return database.update(TABLE_NAME,
                contentValues,
                getWhereClauseById()+
                (new String[]{  String.valueOf(  employee.getId()  )   })[0],
                null   );

    }
    public long deleteDromDBbyID(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String[] ids = new String[]{String.valueOf(id)};
        return sqLiteDatabase.delete(TABLE_NAME,getWhereClauseById() +ids[0],null);
    }
}
