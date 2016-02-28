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
    }
}
