package dhif14.mpi3_androidclient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by sandro on 5/24/17.
 */

public class Connection extends AsyncTask<String, String, String>{

    private static final String TAG = "Connection";
    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 7777;

    private Socket connectionSocket;
    private BufferedWriter bw;
    private BufferedReader br;
    private Context context;

    public Connection(Context context) {
        super();
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        if(connectionSocket==null) {
            try {
                connectionSocket = new Socket(SERVER_IP, SERVER_PORT);
                bw = new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
                br = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

                return "true";
            } catch (IOException e) {
                Log.e(TAG, e.getMessage());
                return "false";
            }
        } else {
            try {
                bw.write(params[0]);
                bw.newLine();
                bw.flush();

                return br.readLine();
            } catch (IOException e) {
                Log.e(TAG, e.getMessage());
                return "false";
            }
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    private class Listener extends Thread {

    }
}
