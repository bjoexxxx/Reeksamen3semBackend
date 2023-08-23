package com.example.sem3reeksamenbackend.dto;

import com.example.sem3reeksamenbackend.entity.Album;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbumResponse {

    Integer id;

    String artist;

    String title;

    String genre;

    int availability;

    public AlbumResponse(Album album) {
        this.id = album.getId();
        this.artist = album.getArtist();
        this.title = album.getTitle();
        this.genre = album.getGenre();
        this.availability = album.getAvailability();
    }
}
