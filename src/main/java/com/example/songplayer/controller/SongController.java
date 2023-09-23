package com.example.songplayer.controller;

import com.example.songplayer.model.Song;
import com.example.songplayer.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1/songs")
public class SongController {

    private final SongService songService;

    SongController(SongService songService){
        this.songService = songService;
    }


    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song){
        return new ResponseEntity<>(songService.addSong(song), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Song>> getSongs(){
        return new ResponseEntity<>(songService.getSongs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id){
        return new ResponseEntity<>(songService.getSongById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSongById(
            @PathVariable Long id,
            @RequestBody Song song
    ){
        return new ResponseEntity<>(songService.updateSongById(id, song), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Song> deleteSongById(@PathVariable Long id){
        songService.deleteSongById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/play")
    public ResponseEntity<String> playSongById(@PathVariable Long id){
        return new ResponseEntity<>(id + " song playing...", HttpStatus.OK);
    }
}
