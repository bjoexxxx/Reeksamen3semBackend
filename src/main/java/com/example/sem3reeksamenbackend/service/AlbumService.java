package com.example.sem3reeksamenbackend.service;

import com.example.sem3reeksamenbackend.dto.AlbumRequest;
import com.example.sem3reeksamenbackend.dto.AlbumResponse;
import com.example.sem3reeksamenbackend.entity.Album;
import com.example.sem3reeksamenbackend.repository.AlbumRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository){this.albumRepository = albumRepository;}
    public AlbumResponse addAlbum(AlbumRequest body) {
        Album album = Album.getAlbumEntity(body);
        albumRepository.save(album);
        return new AlbumResponse(album);
    }

    public List<AlbumResponse> getAllAlbums() {
        List<Album> albums = albumRepository.findAll();
        List<AlbumResponse> albumResponses;
        albumResponses = albums.stream().map(album -> new AlbumResponse(album)).toList();
        return albumResponses;
    }

    public AlbumResponse getSpecificAlbum(Integer id) {
        Album album = albumRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Could not find Album"));
        return new AlbumResponse(album);
    }


    public ResponseEntity<Boolean> editAlbum(Integer id, AlbumRequest body) {
        Album album = albumRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Could not find Album"));
        if (body.getArtist() != null){
            album.setArtist(body.getArtist());
        }
        if (body.getTitle() != null){
            album.setTitle(body.getTitle());
        }
        if (body.getGenre() != null){
            album.setGenre(body.getGenre());
        }
        if (body.getAvailability() != 0){
            album.setAvailability(body.getAvailability());
        }
        albumRepository.save(album);

        return ResponseEntity.ok(true);
    }

    public void deleteAlbum(Integer id) {
        albumRepository.deleteById(id);
    }
}
