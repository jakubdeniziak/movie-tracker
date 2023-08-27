package jd.movietracker.download;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DownloadOptions {
    private String mediaItemsToDownload;
    private String fileType;
}
