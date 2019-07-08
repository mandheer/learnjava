package com.learning.problems.jukebox;

import com.learning.problems.jukebox.model.CD;
import com.learning.problems.jukebox.model.Song;

public class CDPlayer {
    private Playlist playlist;
    private CD cd;

    /**constructors
     *
     * @param playlist
     * @param cd
     */
    public CDPlayer(Playlist playlist, CD cd) {
        this.playlist = playlist;
        this.cd = cd;
    }

    /**constructors
     *
     * @param cd
     */
    public CDPlayer(CD cd) {
        this.cd = cd;
    }

    /**constructors
     *
     * @param playlist
     */
    public CDPlayer(Playlist playlist) {
        this.playlist = playlist;
    }

    public void playSong(Song song){

    }

    /** Getters and setters
     */
    public Playlist getPlaylist() { return playlist; }
    public void setPlaylist(Playlist p) { this.playlist = p; }

    public CD getCD() { return cd; }
    public void setCD(CD c) { this.cd = c; }

}
