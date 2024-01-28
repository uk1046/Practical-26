package com.example.sqlite;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextData;
    private Button buttonInsert;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextData = findViewById(R.id.editTextData);
        buttonInsert = findViewById(R.id.buttonInsert);
        databaseHelper = new DatabaseHelper(this);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editTextData.getText().toString();
                if (!data.isEmpty()) {
                    databaseHelper.insertData(data);
                    editTextData.setText("");
                    //Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }
}

