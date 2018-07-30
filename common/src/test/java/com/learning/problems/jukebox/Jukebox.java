package com.learning.problems.jukebox;

import com.learning.problems.jukebox.model.CD;
import com.learning.problems.jukebox.model.ClientUser;
import com.learning.problems.jukebox.model.Song;

import java.util.Set;

public class Jukebox {
    private CDPlayer cdPlayer;
    private ClientUser user;
    private Set<CD> cdCollection;
    private SongSelector ts;

    public Jukebox(CDPlayer cdPlayer,ClientUser user, Set<CD> cdCollection, SongSelector ts) {
        this.cdPlayer = cdPlayer;
        this. user = user;
        this.cdCollection = cdCollection;
        this.ts = ts;
    }


    public Song getCurrentSong() {
        return ts.getCurrentSong();
    }

    public void setUser (ClientUser u) {
        this. user = u;
    }
}

