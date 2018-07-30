package com.learning.problems.jukebox;

import com.learning.problems.jukebox.model.Song;

import java.util.Queue;

public class Playlist {
    private Song song;
    private Queue<Song> songQueue;

    public Playlist(Song song, Queue<Song> songQueue) {
        this.song = song;
        this.songQueue = songQueue;
    }

    public Song getNextSToPlay(){
        return songQueue.peek();
    }

    public void queueUpSong(Song song){
        songQueue.add(song);
    }
}
