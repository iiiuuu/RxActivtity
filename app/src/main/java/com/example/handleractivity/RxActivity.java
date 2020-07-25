package com.example.handleractivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static java.util.stream.IntStream.rangeClosed;

public class RxActivity extends AppCompatActivity {
    @BindView(R.id.start_btn)
    Button startBtn;
    @BindView(R.id.clock_text)
    TextView clockText;

    @OnClick(R.id.start_btn)
    void onClick() {
        startBtn.setEnabled(false);
        startBtn.setClickable(false);
        Flowable.create((FlowableOnSubscribe<Integer>) emitter -> {
            rangeClosed(0, 10).forEach(i -> {
                SystemClock.sleep(1000);
                emitter.onNext(i);
            });
            emitter.onComplete();
        }, BackpressureStrategy.MISSING)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(i -> {
                    clockText.setText(String.valueOf(i));
                    if (i == 10) {
                        startBtn.setEnabled(true);
                        startBtn.setClickable(true);
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        ButterKnife.bind(this);
    }
}