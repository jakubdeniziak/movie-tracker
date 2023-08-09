package jd.movietracker.movie;

import jd.movietracker.MediaItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

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
