package com.galvanize.playlistserviceapi.dto;

import lombok.NoArgsConstructor;
import lombok.Value;

@Value
//@NoArgsConstructor
public class PlayListDto {
    String name;
    String song;

    public PlayListDto(){
        this.name = "";
        this.song = "";
    }

    public PlayListDto(String n, String s){
        this.name = n;
        this.song = s;
    }

}
