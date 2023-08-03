package com.anhnh.learnspring.entitys;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Artist")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArtistId")
    private Long artistId;

    @Column(name = "Name")
    private String name;
}
