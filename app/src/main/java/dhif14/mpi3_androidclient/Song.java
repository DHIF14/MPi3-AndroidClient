package dhif14.mpi3_androidclient;

import android.graphics.Bitmap;

/**
 * Created by sandro on 5/24/17.
 */

public class Song {

    private String title, artist, length;
    private Bitmap cover;

    public Song(String title, String artist, String length, Bitmap cover) {
        this.title = title;
        this.artist = artist;
        this.length = length;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getLength() {
        return length;
    }

    public Bitmap getCover() {
        return cover;
    }
}
