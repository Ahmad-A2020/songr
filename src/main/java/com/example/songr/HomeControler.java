package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Controller
public class HomeControler {
    @Autowired
    AlbumsRepository albumsRepository;

    @RequestMapping("/hello")
    @ResponseBody
    public String showHello(){
        return "Hello";
    }
    @GetMapping("/capitalize/{word}")
    @ResponseBody
    public String capitalize( @PathVariable("word") String word){

        return word.toUpperCase(Locale.ROOT);
    }

    @GetMapping("/albums")
    public String getAlbums(Model m ){
        m.addAttribute("albums",albumsRepository.findAll());
        return ("albums.html");
    }

    /**
     * this get method created at lab 11 and I have updated it in lab12 with the code above
     *
     *  public String getAlbums(Model m ){
     *         Album Al1= new Album("Cheap Thrills","Sia Furler","https://i.pinimg.com/564x/6c/d2/51/6cd25175c368eeadda247dfb72b4dde6.jpg",5,300);
     *         Album Al2= new Album("Over The Hills And Far Away","John Tams","https://images-na.ssl-images-amazon.com/images/I/61iIvHxCnCL._SX355_.jpg",6,400);
     *         Album Al3= new Album("Three Lions","Frank Skinner","https://i.ytimg.com/vi/OzxMjBEazas/maxresdefault.jpg",8,450);
     *         List<Album> albums= new ArrayList<>();
     *         albums.add(Al1);
     *         albums.add(Al2);
     *         albums.add(Al3);
     *         m.addAttribute("albums",albums);
     *         return ("albums.html");
     *     }
     */


    @GetMapping("/addAlbum")
    public String fillForm(){
        return ("addAlbum.html");
    }
    @PostMapping("/albums")
    public RedirectView showAlbums(@RequestParam(value="title") String title,
                             @RequestParam(value="artist") String artist,
                             @RequestParam(value="imageUrl") String imageUrl,
                             @RequestParam(value="songCount") int songCount,
                             @RequestParam(value="length") int length){
        Album newAlbum= new Album(title,artist,imageUrl,songCount,length);
        albumsRepository.save(newAlbum);
        return new RedirectView("/albums");

    }


}

