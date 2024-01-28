package com.example.sqlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "YourDatabaseName";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your table(s) here
        // Example: db.execSQL("CREATE TABLE IF NOT EXISTS your_table_name (id INTEGER PRIMARY KEY, name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
    }

    public void insertData(String data) {
        new InsertDataTask().execute(data);
    }

    private class InsertDataTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            String data = params[0];
            SQLiteDatabase db = getWritableDatabase();

            // Perform the insertion here
            // Example: db.execSQL("INSERT INTO your_table_name (name) VALUES (?)", new String[]{data});

            db.close();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            // You can update UI or perform any other post-execution tasks if needed
        }
    }
}
