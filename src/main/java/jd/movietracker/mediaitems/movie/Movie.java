package jd.movietracker.mediaitems.movie;

import jd.movietracker.mediaitems.MediaItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Movie extends MediaItem {
    private String title;
    private String director;
    private String language;
    private String runningTime;
}
