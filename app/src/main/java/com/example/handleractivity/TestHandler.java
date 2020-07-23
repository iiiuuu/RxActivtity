package com.example.handleractivity;


import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

public class TestHandler extends Handler {
    public static final int TEST_1 = 1;
    public static final int TEST_2 = 2;
    private Context context;

    public TestHandler(Context context) {
        this.context = context;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        switch (msg.what) {
            case TEST_1:
                Toast.makeText(context, "test1", Toast.LENGTH_SHORT).show();
                break;
            case TEST_2:
                Toast.makeText(context, "test2", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
