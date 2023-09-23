package com.example.songplayer.service;

import com.example.songplayer.model.Playlist;
import com.example.songplayer.model.Song;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PlaylistService {

    private HashMap<Long, Playlist> playlistHashMap = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();


    public Playlist createPlaylist(Playlist playlist){
        return playlistHashMap.put(idCounter.getAndAdd(1), playlist);
    }

    public List<Playlist> getPlaylists(){
        return (List<Playlist>) playlistHashMap.values();
    }

    public Playlist getPlaylistById(Long id){
        return playlistHashMap.get(id);
    }

    public Playlist addSongToPlaylist(Long playlistId, Long songId){
        playlistHashMap.get(playlistId).getSongList().add(songId);
        return playlistHashMap.get(playlistId);
    }
}
