package com.galvanize.playlistserviceapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("playlists")
public class PlayListController {

    @GetMapping
    public String getPlayList(){

        return "[]";
    }
}
