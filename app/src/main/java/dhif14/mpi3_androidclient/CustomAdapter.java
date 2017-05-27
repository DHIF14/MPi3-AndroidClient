package dhif14.mpi3_androidclient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sandro on 5/27/17.
 */

public class CustomAdapter extends ArrayAdapter<Song>{

    public CustomAdapter(@NonNull Context context, List<Song> songlist) {
        super(context, R.layout.item_song, songlist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Prepare inlater
        LayoutInflater inflater = LayoutInflater.from(getContext());
        //Create View and set Layout
        View customView = inflater.inflate(R.layout.item_song, parent, false);

        //Inizializing
        Song song = getItem(position);
        ImageView ivCover = (ImageView) customView.findViewById(R.id.ivCover);
        TextView tvSongTitle = (TextView) customView.findViewById(R.id.tvSongTitle);
        TextView tvSongArtist = (TextView) customView.findViewById(R.id.tvSongArtist);
        TextView tvSongDuration = (TextView) customView.findViewById(R.id.tvSongDuration);

        //setter
        ivCover.setImageBitmap(song.getCover());
        tvSongTitle.setText(song.getTitle());
        tvSongArtist.setText(song.getArtist());
        tvSongDuration.setText(song.getLength());

        return customView;
    }
}
