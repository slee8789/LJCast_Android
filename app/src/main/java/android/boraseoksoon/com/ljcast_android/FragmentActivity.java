package android.boraseoksoon.com.ljcast_android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by seoksoonjang on 3/12/16.
 */
public class FragmentActivity extends Activity {

    public static final String TAG = "JSS_TAG";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);

        Log.e(TAG, "OnCreate");
        Log.d(TAG, "OnCreate");
        Log.i(TAG, "OnCreate");
        Log.v(TAG, "OnCreate");
        Log.w(TAG, "OnCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

