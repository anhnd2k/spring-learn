package com.anhnh.learnspring.services;

import com.anhnh.learnspring.entitys.ArtistEntity;
import com.anhnh.learnspring.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;
    public ArtistService(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    public List<ArtistEntity> getListArtist(){
        return artistRepository.findAll();
    }
}
