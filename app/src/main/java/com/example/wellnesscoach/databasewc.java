package com.example.wellnesscoach;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class databasewc extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Wellness_Coach.db";
    private static final int DATABASE_VERSION = 1;
    private static final String COLUMN_NUMBER = "colno";
    private static final String COLUMN_DATE = "date";
    private static final String TABLE_NAME = "Customer";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_MOBILE = "mobile";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_IDEAL_WEIGHT = "ideal_weight";
    private static final String COLUMN_EXTRA = "extra";
    private static final String COLUMN_LESS = "less";
    private static final String COLUMN_BODY_FAT = "body_fat";
    private static final String COLUMN_VISCERAL_FAT = "visceral_fat";
    private static final String COLUMN_RESTING_METABOLISM = "resting_metabolism";
    private static final String COLUMN_BMI = "bmi";
    private static final String COLUMN_BODY_AGE = "body_age";
    private static final String COLUMN_WHOLE_BODY_SUB = "whole_body_subcutaneous";
    private static final String COLUMN_TRUNK_FAT = "trunk_fat";
    private static final String COLUMN_ARM_FAT = "arm_fat";
    private static final String COLUMN_LEG_FAT = "leg_fat";
    private static final String COLUMN_SKELETAL_MUSCLE = "skeletal_muscle";
    private static final String COLUMN_TRUNK_MUSCLE = "trunk_muscle";
    private static final String COLUMN_ARM_MUSCLE = "arm_muscle";
    private static final String COLUMN_LEG_MUSCLE = "leg_muscle";

    public databasewc(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" +
                COLUMN_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_DATE + " TEXT," +
                COLUMN_NAME + " TEXT, " +
                COLUMN_MOBILE + " INTEGER, " +
                COLUMN_CITY + " TEXT, " +
                COLUMN_AGE + " INTEGER, " +
                COLUMN_WEIGHT + " INTEGER, " +
                COLUMN_IDEAL_WEIGHT + " INTEGER, " +
                COLUMN_EXTRA + " INTEGER, " +
                COLUMN_LESS + " INTEGER, " +
                COLUMN_BODY_FAT + " INTEGER, " +
                COLUMN_VISCERAL_FAT + " INTEGER, " +
                COLUMN_RESTING_METABOLISM + " INTEGER, " +
                COLUMN_BMI + " INTEGER, " +
                COLUMN_BODY_AGE + " INTEGER, " +
                COLUMN_WHOLE_BODY_SUB + " INTEGER, " +
                COLUMN_TRUNK_FAT + " INTEGER, " +
                COLUMN_ARM_FAT + " INTEGER, " +
                COLUMN_LEG_FAT + " INTEGER, " +
                COLUMN_SKELETAL_MUSCLE + " INTEGER, " +
                COLUMN_TRUNK_MUSCLE + " INTEGER, " +
                COLUMN_ARM_MUSCLE + " INTEGER, " +
                COLUMN_LEG_MUSCLE + " INTEGER );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addCustomer(String n, int m, String c, int a, int w, int iw, int e, int l, int bf, int vf, int rm, int bmi, int ba, int wbs, int tf, int af, int lf, int sm, int tm, int am, int lm, String d) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, n);
        cv.put(COLUMN_DATE, d);
        cv.put(COLUMN_MOBILE, m);
        cv.put(COLUMN_CITY, c);
        cv.put(COLUMN_AGE, a);
        cv.put(COLUMN_WEIGHT, w);
        cv.put(COLUMN_IDEAL_WEIGHT, iw);
        cv.put(COLUMN_EXTRA, e);
        cv.put(COLUMN_LESS, l);
        cv.put(COLUMN_BODY_FAT, bf);
        cv.put(COLUMN_VISCERAL_FAT, vf);
        cv.put(COLUMN_RESTING_METABOLISM, rm);
        cv.put(COLUMN_BMI, bmi);
        cv.put(COLUMN_BODY_AGE, ba);
        cv.put(COLUMN_WHOLE_BODY_SUB, wbs);
        cv.put(COLUMN_TRUNK_FAT, tf);
        cv.put(COLUMN_ARM_FAT, af);
        cv.put(COLUMN_LEG_FAT, lf);
        cv.put(COLUMN_SKELETAL_MUSCLE, sm);
        cv.put(COLUMN_TRUNK_MUSCLE, tm);
        cv.put(COLUMN_ARM_MUSCLE, am);
        cv.put(COLUMN_LEG_MUSCLE, lm);


        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successful", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
