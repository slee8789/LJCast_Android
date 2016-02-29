package android.boraseoksoon.com.ljcast_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        StringBuffer sb = new StringBuffer();
         try {
             // [{"id":2,"name":"dragoon","height":"185","weight":"95","gender":"man","job":"Software Developer","message":"Fuck"},{
            JSONArray jarray = new JSONArray(intent.getExtras().getString("1"));   // JSONArray 생성
            for(int i=0; i < jarray.length(); i++){
                JSONObject jObject = jarray.getJSONObject(i);  // JSONObject 추출
                String name = jObject.getString("name");
                String height = jObject.getString("height");
                String weight = jObject.getString("weight");
                String gender = jObject.getString("gender");
                String job= jObject.getString("job");
                String message = jObject.getString("message");

                sb.append(
                        "이름:" + name + "\n" +
                        "키:" + height + "\n" +
                        "몸무게:" + weight + "\n" +
                        "성별:" + gender + "\n" +
                        "직업:" + job + "\n" +
                        "메시지:" + message
                    );
            }
             tv.setText(sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
