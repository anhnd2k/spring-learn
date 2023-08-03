package com.anhnh.learnspring.repository;

import com.anhnh.learnspring.entitys.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {
}
