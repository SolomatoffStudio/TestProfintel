package com.solomatoff.testprofintel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class OneNotesActivity extends AppCompatActivity {
    public static final String EXTRA_NOTE_ADDRESS = "noteAddress";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_notes);

        // Находим Toolbar и устанавливаем его
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_item);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
