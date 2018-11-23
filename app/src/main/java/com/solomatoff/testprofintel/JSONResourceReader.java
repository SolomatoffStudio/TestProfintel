package com.solomatoff.testprofintel;

import java.io.*;

import android.content.res.Resources;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Класс для чтения из файла ресурсов JSON и создания объекта из этого файла ресурсов с помощью Gson.
 */
public class JSONResourceReader {
    // Наш json в форме строки
    private String jsonString;
    private static final String LOGTAG = JSONResourceReader.class.getSimpleName();
    /**
     * Метод читает из файла ресурсов и создает строку
     *
     * @param resources ресурсы приложения
     * @param id Идентификатор загружаемого ресурса, обычно хранящийся в папке raw.
     */
    public JSONResourceReader(Resources resources, int id) {
        InputStream resourceReader = resources.openRawResource(id);
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceReader));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            Log.e(LOGTAG, "Unhandled exception while using JSONResourceReader", e);
        } finally {
            try {
                resourceReader.close();
            } catch (Exception e) {
                Log.e(LOGTAG, "Unhandled exception while using JSONResourceReader", e);
            }
        }
        jsonString = writer.toString();
        Log.i(LOGTAG, jsonString);
    }

    /**
     * Создает объект из указанного ресурса JSON с помощью Gson.
     *
     * @param type тип объекта для построения
     *
     * @return Объект типа T, с полями-членами, заполненными с помощью Gson.
     */
    public <T> T constructUsingGson(Class<T> type) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, type);
    }
}