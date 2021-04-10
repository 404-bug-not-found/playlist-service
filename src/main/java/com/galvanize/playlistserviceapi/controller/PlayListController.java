package com.galvanize.playlistserviceapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("playlists")
public class PlayListController {

    @GetMapping
    public String getPlayList(){

        return "[]";
    }

    @PostMapping("addentry")
    @ResponseStatus(HttpStatus.CREATED)
    public String addNewPlayListEntry(@RequestBody String input) throws Exception{
        return input;
    }


}
