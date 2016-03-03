package android.boraseoksoon.com.ljcast_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by seoksoonjang on 2/29/16.
 */
public class GETActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_activity);

        TextView tv = (TextView)findViewById(R.id.getTextView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // HTTP GET AGAIN USING LIBRARY THROUGH GRABLE.
                /*
                try
                {
                    HttpClient client = new DefaultHttpClient();
                    String getURL = "http://www.google.com";
                    HttpGet get = new HttpGet(getURL);
                    HttpResponse responseGet = client.execute(get);
                    HttpEntity resEntityGet = responseGet.getEntity();
                    if (resEntityGet != null) {
                        // 결과를 처리합니다.
                        Log.i("RESPONSE", EntityUtils.toString(resEntityGet));
                    }
                } catch (Exception e) { e.printStackTrace(); }
                */
            }
        });




    }
}
