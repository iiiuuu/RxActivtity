package com.example.handleractivity;

import android.os.Bundle;
import android.os.Message;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.handleractivity.TestHandler.TEST_1;
import static com.example.handleractivity.TestHandler.TEST_2;

public class HandlerActivity extends AppCompatActivity {
    public static final String TEXT = "text";
    private MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);
        myThread = new MyThread(this);
        myThread.start();
    }

    @OnClick(R.id.test1)
    void test1Onclick() {
        Message message = Message.obtain();
        message.what = TEST_1;
        myThread.handler.sendMessage(message);
    }

    @OnClick(R.id.test2)
    void test2Onclick() {
        Message message = Message.obtain();
        message.what = TEST_2;
        myThread.handler.sendMessage(message);
    }
}