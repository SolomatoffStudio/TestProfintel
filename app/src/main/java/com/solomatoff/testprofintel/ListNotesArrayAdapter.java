package com.solomatoff.testprofintel;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListNotesArrayAdapter extends ArrayAdapter<Note> {
    private Note[] Notes;
    private final Activity context;
    private final int resource;

    public interface Listener {
        void onClick(int position);
    }
    private Listener listenerView;

    public void setListenerView(Listener listener) {
        this.listenerView = listener;
    }

    ListNotesArrayAdapter(Activity context, int resource, Note[] array) {
        super(context, resource, array);
        this.Notes = array;
        this.context = context;
        this.resource = resource;
        for (Note note : array) {
            Log.i("ListNotesArrayAdapt", String.format("array[%s].address = %s", note, note.getAddress()));
        }
    }

    static class ViewHolder {
        TextView noteAddress;
        TextView noteFio;
        TextView noteContacts;
        TextView noteTariff;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view;
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(resource, null);

            ViewHolder viewHolder = new ViewHolder();
            // Присваиваем полям viewHolder соответствующие ссылки
            viewHolder.noteAddress = view.findViewById(R.id.note_address);
            viewHolder.noteFio = view.findViewById(R.id.note_fio);
            viewHolder.noteContacts = view.findViewById(R.id.note_contacts);
            viewHolder.noteTariff = view.findViewById(R.id.note_tariff);

            // Устанавливаем Tag
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }
        // Получаем holder по Tag
        final ViewHolder holder = (ViewHolder) view.getTag();
        final int finalPosition = position; // Создаем финализированную переменную finalPosition
        Log.i(this.getClass().toString(), String.format("getView. ListNotesArrayAdapter[%d].getAddress() = %s", position, Notes[position].getAddress()));

        holder.noteAddress.setText(Notes[position].getAddress());
        holder.noteFio.setText(Notes[position].getFio());
        holder.noteContacts.setText(Notes[position].getContacts());
        holder.noteTariff.setText(Notes[position].getTariff());

        // Назначаем СЛУШАТЕЛЯ для строки
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(this.getClass().toString(), String.format("view.setOnClickListener.onClick. finalPosition = %d", finalPosition));
                if (listenerView != null) {
                    listenerView.onClick(finalPosition);
                }
            }
        });
        return view;
    }

    public Note[] getNotes() {
        return Notes;
    }
}