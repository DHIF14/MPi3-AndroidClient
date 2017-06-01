package dhif14.mpi3_androidclient;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class MainActivity extends Activity {

    private SongList model;
    private ListView listView;
    private Button btPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing
        model = new SongList();
        listView = (ListView) findViewById(R.id.lvSongs);
        btPlay = (Button)findViewById(R.id.btPlay);

        //Testing Data
        model.add(new Song("King", "Kollegah", "3:31", BitmapFactory.decodeResource(getResources(), R.drawable.kollegah_king_cover)));
        model.add(new Song("Alpha", "Kollegah", "2:21", BitmapFactory.decodeResource(getResources(), R.drawable.kollegah_king_cover)));
        model.add(new Song("R.I.P.", "Kollegah", "3:24", BitmapFactory.decodeResource(getResources(), R.drawable.kollegah_king_cover)));

        //Setting Adapter
        ListAdapter adapter = new CustomAdapter(this, model.getSongList());
        listView.setAdapter(adapter);

        //Event Listener
        btPlay.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Todo: send Play message to Server
                Connection c = new Connection(getBaseContext());
                c.execute("DEEERE");

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Testing Toast
                Toast.makeText(MainActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        //Event Listener End


    }
}
