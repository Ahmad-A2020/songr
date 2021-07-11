package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Controller
public class HomeControler {
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
        Album Al1= new Album("Cheap Thrills","Sia Furler","https://i.pinimg.com/564x/6c/d2/51/6cd25175c368eeadda247dfb72b4dde6.jpg",5,300);
        Album Al2= new Album("Over The Hills And Far Away","John Tams","https://images-na.ssl-images-amazon.com/images/I/61iIvHxCnCL._SX355_.jpg",6,400);
        Album Al3= new Album("Three Lions","Frank Skinner","https://i.ytimg.com/vi/OzxMjBEazas/maxresdefault.jpg",8,450);
        List<Album> albums= new ArrayList<>();
        albums.add(Al1);
        albums.add(Al2);
        albums.add(Al3);
        m.addAttribute("albums",albums);
        return ("albums.html");

    }


}

