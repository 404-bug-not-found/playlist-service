package com.galvanize.playlistserviceapi.service;


import com.galvanize.playlistserviceapi.dto.PlayListDto;
import com.galvanize.playlistserviceapi.entity.PlayListEntity;
import com.galvanize.playlistserviceapi.repository.PlayListRepository;
import com.galvanize.playlistserviceapi.response.CustomMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayListService {


    @Autowired
    PlayListRepository playListRepository;


    public void addEntry(PlayListDto playListDto){

        playListRepository.save(new PlayListEntity(playListDto.getName(),playListDto.getSong()));
    }

    public ResponseEntity<?> addPlayList(PlayListDto playListDto) {

        CustomMessage message = new CustomMessage();

        Optional<PlayListEntity> playListExists = playListRepository.findAll()
                .stream()
                .filter(familyEntity -> familyEntity.getName().equals(playListDto.getName()))
                .findAny();

        if (playListExists.isPresent()) {

            message.setMessage(playListDto.getName()+" Playlist Already Exists");
            return new ResponseEntity<CustomMessage>(message, HttpStatus.CONFLICT);

        } else {
            playListRepository.save(new PlayListEntity(playListDto.getName(), playListDto.getSong()));
            message.setMessage(playListDto.getName()+" Playlist Added Successfully");
            return new ResponseEntity<CustomMessage>(message, HttpStatus.CREATED);
        }
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
