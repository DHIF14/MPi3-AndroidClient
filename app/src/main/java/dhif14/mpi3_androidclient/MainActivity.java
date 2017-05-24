package dhif14.mpi3_androidclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private SongList model = new SongList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model.add("Dere");
        model.add("Oida");

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_main, (String[]) model.getSongListeAsArray());

        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(adapter);
    }
}
