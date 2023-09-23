package com.example.songplayer.controller;

import com.example.songplayer.model.Playlist;
import com.example.songplayer.model.Song;
import com.example.songplayer.service.PlaylistService;
import com.example.songplayer.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    PlaylistController(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist){
        return new ResponseEntity<>(playlistService.createPlaylist(playlist), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> getPlaylists(){
        return new ResponseEntity<>(playlistService.getPlaylists(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable Long id){
        return new ResponseEntity<>(playlistService.getPlaylistById(id), HttpStatus.OK);
    }

    @PutMapping("/{playlistId}/song/{songId}")
    public ResponseEntity<Playlist> addSongToPlaylist(
            @PathVariable Long playlistId,
            @PathVariable Long songId
            ){
        return new ResponseEntity<>(playlistService.addSongToPlaylist(playlistId, songId), HttpStatus.OK);
    }

}
