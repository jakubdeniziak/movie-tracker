package jd.movietracker.download;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DownloadController {
    @Autowired
    private DownloadService service;

    @GetMapping("/download")
    public String download(Model model) {
        model.addAttribute("options", new DownloadOptions());
        return "download";
    }

    @PostMapping("/download")
    public ResponseEntity<byte[]> newMovieSubmit(@ModelAttribute DownloadOptions options) {
        String fileType = service.getFileType(options);
        byte[] itemsToDownload = service.getItemsToDownload(options);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=items." + fileType)
                .contentType(MediaType.APPLICATION_JSON)
                .contentLength(itemsToDownload.length)
                .body(itemsToDownload);
    }
}
