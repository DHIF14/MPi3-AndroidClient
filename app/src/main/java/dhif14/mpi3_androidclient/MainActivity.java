package dhif14.mpi3_androidclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        model.add("Dere");
        model.add("Oida");

        //Setting Adapter
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, model.getSongList());
        listView.setAdapter(adapter);

        //Event Handlers
        btPlay.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Todo: send Play message to Server
                Toast.makeText(MainActivity.this, "DEERE", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Testing Toast
                Toast.makeText(MainActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        //Event Handlers End


    }
}
