package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumsRepository albumsRepository;


    @GetMapping("/songs")
    public String allsongs(Model m){
        m.addAttribute("songs",songRepository.findAll());

        return ("songs.html");
    }
    @GetMapping("/addSongs")
    public String addSong (Model m){
        m.addAttribute("albums",albumsRepository.findAll() );
        return "addSong.html";
    }

    @PostMapping("/saveSong")
    public RedirectView saveSong(@RequestParam(value="title") String title, @RequestParam(value="length") int length, @RequestParam(value="trackNumber") int trackNumber,@RequestParam(value="id") Long albumId  ){
        Album album = albumsRepository.findById(albumId).get();
        Song newSong= new Song(title,length,trackNumber,album);
        songRepository.save(newSong);
        return new RedirectView("/songs");

    }

}
