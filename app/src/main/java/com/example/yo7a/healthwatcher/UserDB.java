package com.example.yo7a.healthwatcher;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yo7A on 4/17/2017.
 */

class user {
    private String username;
    private String name;
    private String password;
    private String email;
    private int age;
    private int height;
    private int weight;
    private int gender;

    public String getUsername() {
        return username;
    }

    public String getemail() {
        return email;
    }

    public String getname() {
        return name;
    }

    public String getPass() {
        return password;
    }

    public int getage() {
        return age;
    }

    public int getheight() {
        return height;
    }

    public int getweight() {
        return weight;
    }

    public int getgender() {
        return gender;
    }


    public void setUsername(String usrname) {

        username = usrname;
    }

    public void setemail(String E) {

        email = E;
    }

    public void setname(String nam) {

        name = nam;
    }

    public void setPass(String pass) {

        password = pass;
    }

    public void setage(int g) {

        age = g;
    }

    public void setheight(int h) {

        height = h;
    }

    public void setweight(int w) {

        weight = w;
    }

    public void setgender(int gen) {

        gender = gen;
    }
}

public class UserDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userDB.db";

    //columns of the user Info table
    private static final String TABLE = "users";
    private static final String USERNAME = "username";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    private static final String AGE = "age";
    private static final String HEIGHT = "height";
    private static final String WEIGHT = "weight";
    private static final String GENDER = "gender";
    private static final String EMAIL = "email";

    SQLiteDatabase db;

    public UserDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //checks if the password is correct
    public String checkPass(String user) {
        db = this.getReadableDatabase();
        String query = "select username, password from users";
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "Not found";

        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if (a.equals(user)) {
                    b = cursor.getString(1);
                    break;
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
        return b;
    }

    //checks if the username exist if yes it will return 0 otherwise it will return 1
    public int checkUser(String user) {
        db = this.getReadableDatabase();
        String query = "select username from users";
        Cursor cursor = db.rawQuery(query, null);
        String a;
        int x = 1;

        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if (a.equals(user)) {
                    x = 0;
                    break;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return x;
    }

    public String getweight(String user) {
        db = this.getReadableDatabase();
        String query = "select username, weight from users";
        Cursor cursor = db.rawQuery(query, null);
        String a, w;
        w = "80";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if (a.equals(user)) {
                    w = cursor.getString(1);
                    break;
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
        return w;
    }

    public String getheight(String user) {
        db = this.getReadableDatabase();
        String query = "select username, height from users";
        Cursor cursor = db.rawQuery(query, null);
        String a, h;
        h = "180";

        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if (a.equals(user)) {
                    h = cursor.getString(1);
                    break;
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
        return h;
    }

    public String getage(String user) {
        db = this.getReadableDatabase();
        String query = "select username, age from users";
        Cursor cursor = db.rawQuery(query, null);
        String a, ag;
        ag = "26";

        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if (a.equals(user)) {
                    ag = cursor.getString(1);
                    break;
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
        return ag;
    }

    public String getgender(String user) {
        db = this.getReadableDatabase();
        String query = "select username, gender from users";
        Cursor cursor = db.rawQuery(query, null);
        String a, g;
        g = "2";

        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if (a.equals(user)) {
                    g = cursor.getString(1);
                    break;
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
        return g;
    }

    public void addUser(user u) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME, u.getUsername());
        values.put(NAME, u.getname());
        values.put(PASSWORD, u.getPass());
        values.put(AGE, u.getage());
        values.put(HEIGHT, u.getheight());
        values.put(EMAIL, u.getemail());
        values.put(WEIGHT, u.getweight());
        values.put(GENDER, u.getgender());
        db.insert(TABLE, null, values);
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "create table users ( username text primary key not null, " +
                " name text not null, password text not null, email text not null, age INTEGER not null, height INTEGER not null, weight INTEGER not null, gender INTEGER not null);";
        db.execSQL(createTable);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS users";
        db.execSQL(query);
        this.db = db;
    }
}
