package android.boraseoksoon.com.ljcast_android;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by seoksoonjang on 3/8/16.
 */
public class RESTActivity extends AppCompatActivity {
    TextView tv;
    Button b;
    int serverResponseCode = 0;
    ProgressDialog dialog = null;

    private ListView mListView = null;
    private ListViewAdapter mAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_activity);
        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        // 아이템을 추가
        adapter.add("REST_TEST");
        adapter.add("REST_TEST");
        adapter.add("REST_TEST");
        adapter.add("REST_TEST");
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
        ListView listView = (ListView) findViewById(R.id.rest_listView);

        this.createMainListView(listView, adapter);
        */
        mListView = (ListView) findViewById(R.id.rest_listView);

        mAdapter = new ListViewAdapter(this);
        mListView.setAdapter(mAdapter);

        mAdapter.addItem(getResources().getDrawable(R.drawable.ok),
                "게시글 1",
                "2016-03-08");
        mAdapter.addItem(getResources().getDrawable(R.drawable.idonknow),
                "풀스택 개발자 Exercise",
                "2016-03-07");
        mAdapter.addItem(getResources().getDrawable(R.drawable.supersu),
                "Node.jS 연습용",
                "2016-03-08");
        mAdapter.addItem(null, "NULL 이미지 테스트...", "2016-03-08");

        mAdapter.addItem(getResources().getDrawable(R.drawable.img0058),
                "하나둘",
                "2016-03-08");

        mAdapter.addItem(getResources().getDrawable(R.drawable.screenshot),
                "니가 만들어 개새끼야",
                "2016-03-08");

        mAdapter.addItem(getResources().getDrawable(R.drawable.screenshot),
                "니가 만들어 개새끼야2",
                "2016-03-08");

        mAdapter.addItem(getResources().getDrawable(R.drawable.screenshot),
                "니가 만들어 개새끼야3",
                "2016-03-08");

        mAdapter.addItem(getResources().getDrawable(R.drawable.screenshot),
                "Node.jS 연습용",
                "2016-03-08");

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListData mData = mAdapter.mListData.get(position);
                Toast.makeText(RESTActivity.this, mData.mTitle, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createMainListView(ListView listView, ArrayAdapter<String> adapter) {
        // ListView에 각각의 아이템표시를 제어하는 Adapter를 설정
        listView.setAdapter(adapter);

        // 아이템을 [클릭]시의 이벤트 리스너를 등록
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;

                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(RESTActivity.this, item, Toast.LENGTH_LONG).show();

                // just test
                /*
                if(id == 0){
                    Intent instantIntent = new Intent(MainActivity.this, GETActivity.class);
                    startActivity(instantIntent);
                }
                */
            }
        });
    }

    private class ViewHolder {
        public ImageView mIcon;
        public TextView mText;
        public TextView mDate;
    }

    private class ListViewAdapter extends BaseAdapter {
        private Context mContext = null;
        private ArrayList<ListData> mListData = new ArrayList<ListData>();

        public ListViewAdapter(Context mContext) {
            super();
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();

                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listview_item, null);

                holder.mIcon = (ImageView) convertView.findViewById(R.id.mImage);
                holder.mText = (TextView) convertView.findViewById(R.id.mText);
                holder.mDate = (TextView) convertView.findViewById(R.id.mDate);

                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            ListData mData = mListData.get(position);

            if (mData.mIcon != null) {
                holder.mIcon.setVisibility(View.VISIBLE);
                holder.mIcon.setImageDrawable(mData.mIcon);
            }else{
                holder.mIcon.setVisibility(View.GONE);
            }

            holder.mText.setText(mData.mTitle);
            holder.mDate.setText(mData.mDate);

            return convertView;
        }

        public void addItem(Drawable icon, String mTitle, String mDate){
            ListData addInfo = null;
            addInfo = new ListData();
            addInfo.mIcon = icon;
            addInfo.mTitle = mTitle;
            addInfo.mDate = mDate;

            mListData.add(addInfo);
        }

        public void remove(int position){
            mListData.remove(position);
            dataChange();
        }

        public void sort(){
            Collections.sort(mListData, ListData.ALPHA_COMPARATOR);
            dataChange();
        }

        public void dataChange(){
            mAdapter.notifyDataSetChanged();
        }
    }
}
