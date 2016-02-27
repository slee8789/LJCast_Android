package android.boraseoksoon.com.ljcast_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
            }
        });
    }
}
