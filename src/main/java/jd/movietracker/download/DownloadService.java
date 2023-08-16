package jd.movietracker.download;

import jd.movietracker.MediaItem;
import jd.movietracker.filewriters.json.GsonWriter;
import jd.movietracker.filewriters.json.JsonWriter;
import jd.movietracker.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DownloadService {
    @Autowired
    MovieService movieService;

    public byte[] getItemsToDownload(DownloadOptions options) {
        List<MediaItem> itemsToDownload;

        if(Objects.equals(options.getMediaItemsToDownload(), "movies")) {
            itemsToDownload = new ArrayList<>(movieService.getAll());
        } else {
            return null;
        }

        if(Objects.equals(options.getFormat(), "json")) {
            JsonWriter writer = new GsonWriter();
            String jsonString = writer.toJson(itemsToDownload);
            return jsonString.getBytes();
        } else {
            return null;
        }
    }
}