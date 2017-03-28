package com.tracedebug.gyorgygabor.tracedebug;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.tracedebug.gyorgygabor.runtimeannotation.DebugTrace;

public class MainActivity extends Activity {

    private static final String TAG = ACCOUNT_SERVICE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        method1();
    }

    private void method1() {
        method2();
    }

    private void method2() {
        method3();
    }

    private void method3() {
        method4();
    }

    @DebugTrace(5)
    private void method4() {
        Log.d(TAG, "method4() called");
    }
}
