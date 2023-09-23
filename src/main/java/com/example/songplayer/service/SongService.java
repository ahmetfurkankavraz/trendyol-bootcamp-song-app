package com.example.songplayer.service;

import com.example.songplayer.model.Song;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SongService {

    private final HashMap<Long, Song> songHashMap = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public Song addSong(Song song){
        return songHashMap.put(idCounter.getAndAdd(1), song);
    }

    public List<Song> getSongs(){
        return (List<Song>) songHashMap.values();
    }

    public Song getSongById(Long id){
        return songHashMap.get(id);
    }

    public Song updateSongById(Long id, Song song){
        return songHashMap.put(id, song);
    }

    public void deleteSongById(Long id){
        songHashMap.remove(id);
    }
}
