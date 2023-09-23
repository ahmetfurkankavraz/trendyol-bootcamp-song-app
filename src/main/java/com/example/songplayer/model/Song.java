package com.example.songplayer.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Song {
    private Long id;
    private String name;
    private String artist;
    private Integer duration;
}
