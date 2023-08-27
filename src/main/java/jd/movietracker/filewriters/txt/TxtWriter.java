package jd.movietracker.filewriters.txt;

import jd.movietracker.mediaitems.MediaItem;

import java.util.List;

public interface TxtWriter {
    String toTxt(List<MediaItem> mediaItems);
}
