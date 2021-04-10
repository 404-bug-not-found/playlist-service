package com.galvanize.playlistserviceapi;


import com.galvanize.playlistserviceapi.dto.PlayListDto;
import com.galvanize.playlistserviceapi.entity.PlayListEntity;
import com.galvanize.playlistserviceapi.repository.PlayListRepository;
import com.galvanize.playlistserviceapi.service.PlayListService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayListServiceTests {

    @Mock
    PlayListRepository mockPlayListRepository;

    @InjectMocks
    PlayListService service;


    @Test
    void addEntry(){

        PlayListDto playListDto = new PlayListDto("Playlist1","Song1");
        service.addEntry(playListDto);

        verify(mockPlayListRepository).save(
                new PlayListEntity("Playlist1","Song1")
        );
    }

    @Test
    void getEntries(){

       PlayListEntity playListEntity1 = new PlayListEntity("Playlist1","Song1");
       PlayListEntity playListEntity2 = new PlayListEntity("Playlist1","Song2");

       when(mockPlayListRepository.findAll()).thenReturn(
               List.of(playListEntity1,playListEntity2)
       );
       List<PlayListDto> actual = service.getEntries();

       assertThat(actual).isEqualTo(
         List.of(
                 new PlayListDto("Playlist1","Song1"),
                 new PlayListDto("Playlist1","Song2")
         )
       );
    }

}
