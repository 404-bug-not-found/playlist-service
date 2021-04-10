package com.galvanize.playlistserviceapi.controller;


import com.galvanize.playlistserviceapi.dto.PlayListDto;
import com.galvanize.playlistserviceapi.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("playlists")
public class PlayListController {

    @Autowired
    PlayListService playListService;

    @GetMapping
    public List<PlayListDto> getPlayList(){

        return playListService.getEntries();
    }

    @PostMapping("addentry")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewPlayListEntry(@RequestBody PlayListDto playListDto) throws Exception{

        playListService.addEntry(playListDto);
    }

    @PostMapping("addplaylist")
    public ResponseEntity<?> addNewPlayList(@RequestBody PlayListDto playListDto) throws Exception{

        return playListService.addPlayList(playListDto);
    }

}
