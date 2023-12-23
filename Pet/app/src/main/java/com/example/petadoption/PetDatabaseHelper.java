package com.example.petadoption;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "pet_database2";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "pets";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_BREED = "breed";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_OWNER_INFO = "owner_info";
    public static final String COLUMN_TYPE = "pet_type";
    public static final String COLUMN_GENDER = "pet_gender";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_AGE + " REAL, " +
                    COLUMN_WEIGHT + " REAL, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_LOCATION + " TEXT, " +
                    COLUMN_BREED + " TEXT, " +
                    COLUMN_DESCRIPTION + " TEXT, " +
                    COLUMN_OWNER_INFO + " TEXT, " +
                    COLUMN_TYPE + " TEXT, " +
                    COLUMN_GENDER + " TEXT)";

    public PetDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public Cursor getAllPets() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
