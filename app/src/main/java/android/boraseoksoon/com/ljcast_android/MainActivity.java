package android.boraseoksoon.com.ljcast_android;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    String testHtmlString;


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
        adapter.add("item1");
        adapter.add("item2");
        adapter.add("item4");
        adapter.add("item5");
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

        // ListView 가져오기
        ListView listView = (ListView) findViewById(R.id.main_listview);

        this.createMainListView(listView, adapter);
        this.GET();

        /*
         * NetworkOnMainThreadException Occured. so..
         */
        /*
        URL url = null;
        try {
            url = new URL("http://family7914.cafe24.com");
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
            StringBuffer buffer = new StringBuffer();

            int c;

            while((c=in.read()) != -1){
                buffer.append((char)c);
            }
            System.out.println(buffer);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
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
                if(id == 0){
                    Intent instantIntent = new Intent(MainActivity.this, TestTextViewActivity.class);
                    instantIntent .putExtra("1", testHtmlString);
                    startActivity(instantIntent);
                }
                // startActivity(new Intent(MainActivity.this, ThirdActivity.class));
            }
        });
    }

    private void GET()
    {
        new GetTask ().execute(null, null, null);
    }

    //AsyncTask<Params,Progress,Result>
    private class GetTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Void aVoid) {
            super.onCancelled(aVoid);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
        /*
         * TIP : [onPreExecute()] -> [doInBackground()] -> [onPostExecute()] is in order.
         */

        @Override
        protected Void doInBackground(Void... params) {
            try {
                URL url = null;
                try {
                    url = new URL("http://family7914.cafe24.com");
                    HttpURLConnection http = (HttpURLConnection)url.openConnection();
                    BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
                    StringBuffer buffer = new StringBuffer();

                    int c;

                    while((c=in.read()) != -1){
                        buffer.append((char)c);
                    }
                    System.out.println(buffer);


                    testHtmlString = buffer.toString();


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
