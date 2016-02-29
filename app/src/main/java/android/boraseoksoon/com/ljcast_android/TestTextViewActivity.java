package android.boraseoksoon.com.ljcast_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by seoksoonjang on 2/28/16.
 */
public class TestTextViewActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_textview);

        Intent intent = this.getIntent();

        TextView tv = (TextView)findViewById(R.id.testTextView);

        tv.setText(intent.getExtras().getString("1"));

        // Ready To Parse JSON
        /*
         try {
            JSONArray jarray = new JSONArray(str);   // JSONArray 생성
            for(int i=0; i < jarray.length(); i++){
                JSONObject jObject = jarray.getJSONObject(i);  // JSONObject 추출
                String address = jObject.getString("address");
                String name = jObject.getString("name");
                int age = jObject.getInt("age");

                sb.append(
                        "주소:" + address +
                        "이름:" + name +
                        "나이:" + age + "\n"
                    );
            }
            tv.setText(sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
         */



    }
}
