package jd.movietracker.download;

import jd.movietracker.filewriters.txt.BasicTxtWriter;
import jd.movietracker.filewriters.txt.TxtWriter;
import jd.movietracker.mediaitems.MediaItem;
import jd.movietracker.filewriters.json.GsonWriter;
import jd.movietracker.filewriters.json.JsonWriter;
import jd.movietracker.mediaitems.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DownloadService {
    @Autowired
    private MovieService movieService;

    public String getFileType(DownloadOptions options) {
        return options.getFileType();
    }

    public byte[] getItemsToDownload(DownloadOptions options) {
        List<MediaItem> itemsToDownload;

        if (Objects.equals(options.getMediaItemsToDownload(), "movies")) {
            itemsToDownload = new ArrayList<>(movieService.getAll());
        } else {
            return new byte[0];
        }

        if (Objects.equals(options.getFileType(), "json")) {
            JsonWriter writer = new GsonWriter();
            String jsonString = writer.toJson(itemsToDownload);
            return jsonString.getBytes();
        } else if (Objects.equals(options.getFileType(), "txt")) {
            TxtWriter writer = new BasicTxtWriter();
            String result = writer.toTxt(itemsToDownload);
            return result.getBytes();
        } else {
            return new byte[0];
        }
    }
}
