package dhif14.mpi3_androidclient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandro on 5/24/17.
 */

public class SongList {

    private List songlist = new ArrayList();

    public Object[] getSongListeAsArray() {
        return songlist.toArray();
    }

    public void add(String song) {
        songlist.add(song);
    }
}
