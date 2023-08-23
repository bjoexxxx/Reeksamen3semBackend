package com.example.sem3reeksamenbackend.repository;

import com.example.sem3reeksamenbackend.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
