package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;
    @GetMapping("/songs")
    public String allsongs(){

        return ("")
    }
}
