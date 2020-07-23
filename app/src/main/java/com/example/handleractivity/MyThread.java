package com.example.handleractivity;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class MyThread extends Thread {
    public Handler handler;
    private Context context;

    public MyThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        Looper.prepare();
        handler = new TestHandler(context);
        Looper.loop();
    }
}
