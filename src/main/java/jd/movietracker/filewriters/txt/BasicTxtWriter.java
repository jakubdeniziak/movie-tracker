package jd.movietracker.filewriters.txt;

import jd.movietracker.mediaitems.MediaItem;

import java.util.List;

public class BasicTxtWriter implements TxtWriter {
    @Override
    public String toTxt(List<MediaItem> mediaItems) {
        StringBuilder builder = new StringBuilder();
        for (MediaItem item : mediaItems) {
            builder.append(item.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
