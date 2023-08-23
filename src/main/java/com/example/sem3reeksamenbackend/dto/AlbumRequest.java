package com.example.sem3reeksamenbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlbumRequest {

    String artist;

    String title;

    String genre;

    int availability;
}
