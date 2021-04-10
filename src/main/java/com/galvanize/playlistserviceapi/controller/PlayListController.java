package com.galvanize.playlistserviceapi.controller;


import com.galvanize.playlistserviceapi.dto.PlayListDto;
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
    public PlayListDto addNewPlayListEntry(@RequestBody PlayListDto playListDto) throws Exception{
        return playListDto;
    }


}
