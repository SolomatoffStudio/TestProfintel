package com.solomatoff.testprofintel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static Context context;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Находим FloatingActionButton
        fab = findViewById(R.id.fab_template);
        // Назначаем слушателя для плавающей кнопки
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddNoteAlertDialog();
            }
        });

        JSONResourceReader reader = new JSONResourceReader(getResources(), R.raw.jsonfile);
        Note[] jsonObj = reader.constructUsingGson(Note[].class);
        ListView listView = findViewById(R.id.lv_notes);
        // Создаем адаптер
        ListNotesArrayAdapter listAdapter = new ListNotesArrayAdapter((Activity) context, R.layout.notes_row, jsonObj);
        listView.setAdapter(listAdapter);
        listAdapter.setListenerView(new ListNotesArrayAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Log.i(this.getClass().toString(), String.format("    onCreate. listAdapter.setListenerView. onClick. position = %d", position));
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

    private void showAddNoteAlertDialog() {
        Log.i("", "Start showAddNoteAlertDialog");
        // Создаем диалоговое окно
        // Надуваем макет
        LayoutInflater inflater = getLayoutInflater();
        final View view = inflater.inflate(R.layout.alert_dialog_create_note, null);
        // Создаем AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);
        // Устанавливаем полученную ранее разметку в builder
        builder.setView(view);
        // Создаем диалог
        final AlertDialog dialog = builder.create();
        // Убираем пустое место
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Назначаем слушателей для кнопок
        Button buttonCancel = view.findViewById(R.id.button_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button buttonCreate = view.findViewById(R.id.button_create);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ToDo добавляем заметку
                /*addItem(idItem);
                // Выведем сообщение о том, что заметка добавлена
                String message = getString(R.string.item_have_been_added);
                Toast.makeText(OneNoteActivity.this, message, Toast.LENGTH_LONG).show();
                dialog.dismiss();
                finish();*/
            }
        });
        dialog.show();
        Log.i("", "Finish showAddNoteAlertDialog");
    }
}
