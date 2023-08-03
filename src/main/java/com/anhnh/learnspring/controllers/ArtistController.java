package com.anhnh.learnspring.controllers;

import com.anhnh.learnspring.entitys.ArtistEntity;
import com.anhnh.learnspring.models.ResponseObject;
import com.anhnh.learnspring.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/artist")
public class ArtistController {
    @Autowired
    ArtistService artistService;

    @GetMapping("/getList")
    public ResponseEntity<ResponseObject> getAllArtist(){
        List<ArtistEntity> artistList = artistService.getListArtist();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Message", artistList)
        );
    }
}
