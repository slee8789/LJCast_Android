package android.boraseoksoon.com.ljcast_android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by seoksoonjang on 3/12/16.
 */
public class ThreadActivity extends Activity{

    public Button threadButton;
    public TextView threadTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.thread_activity);

        (Button)findViewById(R.id.thread_button);
        (TextView)findViewById(R.id.thread_textView;
    }


    public void threadClick(View v){
        Log.i(TAG, "threadClick!");
    }
}
