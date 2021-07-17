package com.example.songr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class Lab11AlbumTests {
    Album album;
    @BeforeEach
    public void pickUp(){
        album= new Album("Now or Never","Brett Kissel","https://upload.wikimedia.org/wikipedia/en/thumb/9/96/Now_or_Never_Brett_Kissel.png/220px-Now_or_Never_Brett_Kissel.png",2,600);


    }
    @Test
    public void getTitleTest(){
        assertEquals("Now or Never",album.getTitle());
    }
    @Test
    public void getArtistTest(){
        assertEquals("Brett Kissel",album.getArtist());
    }
    @Test
    public void getImageTest(){
        assertEquals("https://upload.wikimedia.org/wikipedia/en/thumb/9/96/Now_or_Never_Brett_Kissel.png/220px-Now_or_Never_Brett_Kissel.png",album.getImageUrl());
    }
    @Test
    public void getCountTest(){
        assertEquals(2,album.getSongCount());
    }
    @Test
    public void getLengthTest(){
        assertEquals(600,album.getLength());
    }





}
