package com.galvanize.playlistserviceapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.playlistserviceapi.dto.PlayListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@AutoConfigureRestDocs
@AutoConfigureMockMvc
public class PlayListServiceIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getPlayListTest() throws Exception {

        mockMvc.perform(
                get("/playlists"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(0))
                .andDo(print());


    }

    @Test
    void postPlayListTest() throws Exception{

        PlayListDto playListDto = new PlayListDto("Classic","Summer of 69");
        mockMvc.perform(post("/playlists/addentry")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(playListDto)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andDo(document("AddEntry"));
    }

    @Test
    void getMultiplePlayListTest() throws Exception{

        PlayListDto input1 = new PlayListDto("Classic","Summer of 69");
        PlayListDto input2 = new PlayListDto("Classic","Country Road Take me Home");

        mockMvc.perform(post("/playlists/addentry")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(input1)))
                .andExpect(status().isCreated())
                .andDo(print());

        mockMvc.perform(post("/playlists/addentry")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(input2)))
                .andExpect(status().isCreated())
                .andDo(print());

        mockMvc.perform(
                get("/playlists"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andDo(print())
                .andDo(document("PlayList",responseFields(
                        fieldWithPath("[1].name").description("Classic"),
                        fieldWithPath("[1].song").description("Country Road Take me Home")
                )));

    }
}
