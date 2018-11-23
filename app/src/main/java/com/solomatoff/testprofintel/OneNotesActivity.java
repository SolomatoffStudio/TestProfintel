package com.solomatoff.testprofintel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class OneNotesActivity extends AppCompatActivity {
    public static final String EXTRA_NOTE = "note";
    public static final String EXTRA_LIST_NOTE = "arrayListNote";
    private TextView noteAddress;
    private TextView noteFio;
    private TextView noteContacts;
    private TextView noteTariff;
    private TextView noteConnectionDate;
    private TextView noteNumberOfContract;

    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_note);

        // Находим Toolbar и устанавливаем его
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_item);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Изменим текст заголовка макета
        TextView noteAction = findViewById(R.id.action_note);
        noteAction.setText(R.string.action_note);

        // Скроем кнопку Отменить
        Button buttonCancel = findViewById(R.id.button_cancel);
        buttonCancel.setVisibility(View.INVISIBLE);

        // Изменим наименование кнопки
        Button buttonSave = findViewById(R.id.button_create);
        buttonSave.setText(R.string.action_save);

        Intent intent = getIntent();
        ArrayList<Note> list = intent.getParcelableArrayListExtra(EXTRA_LIST_NOTE);
        note = list.get(0);

        fillField(note);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(getLocalClassName(), "Start onSaveInstanceState()");
        Note note = new Note(noteAddress.getText().toString(), noteFio.getText().toString(), noteContacts.getText().toString(), noteTariff.getText().toString(), noteConnectionDate.getText().toString(), noteNumberOfContract.getText().toString());
        // Сохраняем
        outState.putParcelable(EXTRA_NOTE, note);
        Log.i(getLocalClassName(), "Finish onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(getLocalClassName(), "Start onSaveInstanceState()");
        // Восстанавливаем
        note = savedInstanceState.getParcelable(EXTRA_NOTE);
        fillField(note);
        Log.i(getLocalClassName(), "Finish onSaveInstanceState()");
    }

    protected void fillField(Note note) {
        noteAddress = findViewById(R.id.new_address);
        noteAddress.setText(note.getAddress());
        noteFio = findViewById(R.id.new_fio);
        noteFio.setText(note.getFio());
        noteContacts = findViewById(R.id.new_contacts);
        noteContacts.setText(note.getContacts());
        noteTariff = findViewById(R.id.new_tariff);
        noteTariff.setText(note.getTariff());
        noteConnectionDate = findViewById(R.id.new_connectionDate);
        noteConnectionDate.setText(note.getConnectionDate());
        noteNumberOfContract = findViewById(R.id.new_numberOfContract);
        noteNumberOfContract.setText(note.getNumberOfContract());
    }
}
