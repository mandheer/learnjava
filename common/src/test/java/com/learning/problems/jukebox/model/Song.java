package com.learning.problems.jukebox.model;

import java.util.ArrayList;
import java.util.List;

public class Song {
    /* data for id, CD (could be null), title, length, etc */
    private String id;
    private CD album;
    private String title;
    private String lyrics;
    private String length;
    private List<Artist> artists;

    public Song(String id, CD album, String title, String lyrics, String length, List<Artist> artists) {
        this.id = id;
        this.album = album;
        this.title = title;
        this.lyrics = lyrics;
        this.length = length;
        this.artists = artists;
    }

    public Song(String id, CD album, String title, String lyrics, String length) {
        this.id = id;
        this.album = album;
        this.title = title;
        this.lyrics = lyrics;
        this.length = length;
        this.artists = new ArrayList<Artist>();
    }

    public void addArtist(Artist artist){
        this.artists.add(artist);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CD getAlbum() {
        return album;
    }

    public void setAlbum(CD album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public List<Artist> getArtists() {
        return artists;
    }
}
