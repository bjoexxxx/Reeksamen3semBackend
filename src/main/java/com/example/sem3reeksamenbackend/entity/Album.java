package com.example.sem3reeksamenbackend.entity;

import com.example.sem3reeksamenbackend.dto.AlbumRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String artist;

    String title;

    String genre;

    int availability;

    public static Album getAlbumEntity(AlbumRequest albumRequest){
        return Album.builder()
                .artist(albumRequest.getArtist())
                .title(albumRequest.getTitle())
                .genre(albumRequest.getGenre())
                .availability(albumRequest.getAvailability())
                .build();
    }

}
