package com.solomatoff.testprofintel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        JSONResourceReader reader = new JSONResourceReader(getResources(), R.raw.jsonfile);
        Note[] jsonObj = reader.constructUsingGson(Note[].class);
        ListView listView = findViewById(R.id.lv_notes);
        // Создаем адаптер
        ListNotesArrayAdapter listAdapter = new ListNotesArrayAdapter((Activity) context, R.layout.notes_row, jsonObj);
        listView.setAdapter(listAdapter);
        listAdapter.setListenerView(new ListNotesArrayAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Log.i(this.getClass().toString(), String.format("    replaceArrayAdapterForLvVacancies. listAdapter.setListenerButton. onClick. position = %d", position));
                // ToDo доделать
                /*Intent intent = new Intent(context, OneNotesActivity.class);
                // Формируем интент
                int idItem = listNotes.get(position).getId();
                intent.putExtra(OneNotesActivity.EXTRA_ID_ITEM, idItem);
                String nameItem = listNotes.get(position).getVacancy_name();
                intent.putExtra(OneNotesActivity.EXTRA_ID_NAME, nameItem);
                context.startActivity(intent);*/
            }
        });
    }
}
