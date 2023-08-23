package com.example.sem3reeksamenbackend.api;

import com.example.sem3reeksamenbackend.dto.AlbumRequest;
import com.example.sem3reeksamenbackend.dto.AlbumResponse;
import com.example.sem3reeksamenbackend.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/album")
public class AlbumController {
    AlbumService albumService;

    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @PostMapping()
    public AlbumResponse addAlbum(@RequestBody AlbumRequest body){
        return albumService.addAlbum(body);
    }

    @GetMapping()
    public List<AlbumResponse> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/id/{id}")
    AlbumResponse getSpecific(@PathVariable Integer id){
        return albumService.getSpecificAlbum(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity editAlbum(@PathVariable Integer id, @RequestBody AlbumRequest body){
        albumService.editAlbum(id,body);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlbum(@PathVariable Integer id){
        albumService.deleteAlbum(id);
        return ResponseEntity.ok("Album deleted successfully.");
    }
}
