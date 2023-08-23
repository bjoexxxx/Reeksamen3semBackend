package com.example.sem3reeksamenbackend.config;

import com.example.sem3reeksamenbackend.entity.Album;
import com.example.sem3reeksamenbackend.repository.AlbumRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {

    AlbumRepository albumRepository;

    public DeveloperData(AlbumRepository albumRepository){this.albumRepository = albumRepository;}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Album> albums = new ArrayList<>(Arrays.asList(
                new Album(1,"Artist1", "Title1", "Genre1", 100),
                new Album(2,"Artist2", "Title2", "Genre2", 100),
                new Album(3,"Artist3", "Title3", "Genre3", 100),
                new Album(4,"Artist4", "Title4", "Genre4", 100),
                new Album(5,"Artist5", "Title5", "Genre5", 100)
        ));

        albumRepository.saveAll(albums);
    }
}
