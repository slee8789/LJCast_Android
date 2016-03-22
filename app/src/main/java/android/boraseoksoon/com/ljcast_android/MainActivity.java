package android.boraseoksoon.com.ljcast_android;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String testHtmlString;

    // Simply Gradle build dependency test check - it works fine.
    Downloader down = new Downloader() {
        @Override
        public Response load(Uri uri, int networkPolicy) throws IOException {
            return null;
        }

        @Override
        public void shutdown() {
            //
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, SplashActivity.class));
        /*
         * Add ListView
         */

        // ArrayAdapter를 통해 LIST로 표시할 오브젝트를 지정한다.
        // 여기서는 심플하게 그냥 String
        // 레이아웃 android.R.layout.simple_list_item_1 는 안드로이드가 기본적으로 제공하는 간단한 아이템 레이아웃
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        // 아이템을 추가
        adapter.add("GET");
        adapter.add("POST");
        adapter.add("PUT");
        adapter.add("DELETE");
        adapter.add("item6");
        adapter.add("item7");
        adapter.add("item8");
        adapter.add("item9");
        adapter.add("item10");
        adapter.add("item11");
        adapter.add("item12");
        adapter.add("item13");
        adapter.add("item14");
        adapter.add("item15");
        adapter.add("item16");
        // busy so comment only today...T.T

        // ListView 가져오기
        ListView listView = (ListView) findViewById(R.id.main_listview);

        this.createMainListView(listView, adapter);
    }



    private void createMainListView(ListView listView, ArrayAdapter<String> adapter) {
        // ListView에 각각의 아이템표시를 제어하는 Adapter를 설정
        listView.setAdapter(adapter);

        // 아이템을 [클릭]시의 이벤트 리스너를 등록
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
                // TODO 아이템 클릭시에 구현할 내용은 여기에.
                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();

                // just test
                // GET
                if(id == 0){
                    // MainActivity.this.GET();
                    Intent instantIntent = new Intent(MainActivity.this, GETActivity.class);
                    startActivity(instantIntent);
                }
                // startActivity(new Intent(MainActivity.this, ThirdActivity.class));
                // POST
                if(id == 1){
                    Intent instantIntent = new Intent(MainActivity.this, POSTActivity.class);
                    startActivity(instantIntent);
                }

                // PUT
                if(id == 2){
                    Intent instantIntent = new Intent(MainActivity.this, PUTActivity.class);
                    startActivity(instantIntent);
                }

                // DELETE
                if(id == 3){
                    Intent instantIntent = new Intent(MainActivity.this, DELETEActivity.class);
                    startActivity(instantIntent);
                }
            }
        });
    }

    private void GET() {
        new GetTask ().execute(null, null, null);
    }

    private class GetTask extends AsyncTask<Void, Void, Void> {
        /*
         * TIP : [onPreExecute()] -> [doInBackground()] -> [onPostExecute()] is in order.
         */
        @Override
        protected Void doInBackground(Void... params) {
            try {
                URL url = null;
                try {

                    /*
                    127.0.0.1 does not work on Android emulator!!

                     To access your PC localhost from Android emulator, use 10.0.2.2 instead of 127.0.0.1. localhost or 127.0.0.1 refers to the emulated device itself,
                     not the host the emulator is running on.
                    Reference: http://developer.android.com/tools/devices/emulator.html#networkaddresses
                    For Genymotion use:  10.0.3.2 instead of 10.0.2.2

                    http://stackoverflow.com/questions/18341652/connect-failed-econnrefused
                     */

                    url = new URL("http://10.0.2.2:8000/api/profile/users");
                    HttpURLConnection http = (HttpURLConnection)url.openConnection();
                    BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
                    StringBuffer buffer = new StringBuffer();

                    int c;

                    while((c=in.read()) != -1){
                        buffer.append((char)c);
                    }
                    System.out.println(buffer);


                    testHtmlString = buffer.toString();


                    Intent instantIntent = new Intent(MainActivity.this, TestTextViewActivity.class);
                    instantIntent .putExtra("1", testHtmlString);
                    startActivity(instantIntent);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
