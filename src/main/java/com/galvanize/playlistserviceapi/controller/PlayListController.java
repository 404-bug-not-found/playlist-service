package com.galvanize.playlistserviceapi.controller;


import com.galvanize.playlistserviceapi.dto.PlayListDto;
import com.galvanize.playlistserviceapi.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("playlists")
public class PlayListController {

    @Autowired
    PlayListService playListService;

    @GetMapping
    public String getPlayList(){

        return "[]";
    }

    @PostMapping("addentry")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewPlayListEntry(@RequestBody PlayListDto playListDto) throws Exception{

        playListService.addEntry(playListDto);
    }


}
