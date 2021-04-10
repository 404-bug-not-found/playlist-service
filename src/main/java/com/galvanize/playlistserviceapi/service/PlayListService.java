package com.galvanize.playlistserviceapi.service;


import com.galvanize.playlistserviceapi.dto.PlayListDto;
import com.galvanize.playlistserviceapi.entity.PlayListEntity;
import com.galvanize.playlistserviceapi.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayListService {


    @Autowired
    PlayListRepository playListRepository;


    public void addEntry(PlayListDto playListDto){

        playListRepository.save(new PlayListEntity(playListDto.getName(),playListDto.getSong()));
    }

    public List<PlayListDto> getEntries(){
        return playListRepository.findAll()
                .stream()
                .map(playListEntity ->{
                    return new PlayListDto(playListEntity.getName(),playListEntity.getSong());
                })
                .collect(Collectors.toList());
    }

}
