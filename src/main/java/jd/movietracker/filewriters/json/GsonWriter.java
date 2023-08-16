package jd.movietracker.filewriters.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonWriter implements JsonWriter {
    private final Gson jsonWriter;

    public GsonWriter() {
        jsonWriter = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public String toJson(Object src) {
        return jsonWriter.toJson(src);
    }
}
