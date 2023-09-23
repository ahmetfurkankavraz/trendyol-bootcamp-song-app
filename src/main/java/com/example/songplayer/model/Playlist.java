package com.example.songplayer.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Playlist {
    private Long id;
    private String name;
    private List<Long> songList;
}
