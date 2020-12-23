package com.example.carsharing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class DriverTimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_timer);
        textView = findViewById(R.id.text_countdown);
        timer();
    }

    TextView textView;
    int hour = 0;
    int minute = 15;
    int sec = 0;
    boolean isTimerStop = false;

    public void timer() {
        new CountDownTimer((hour * 360000) + (minute * 60000) + (sec * 1000), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sec--;
                if (sec >= 0) {
                    textView.setText(Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(sec));
                } else {
                    minute--;
                    sec = 59;
                    if (minute >= 0) {
                        textView.setText(Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(sec));
                    } else {
                        hour--;
                        minute = 59;
                        textView.setText(Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(sec));
                    }
                }
            }

            @Override
            public void onFinish() {
                textView.setText(Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(sec));
            }
        }.start();
    }

    public void restart(View view) {
        if (isTimerStop) {
            timer();
            isTimerStop = false;
        }
    }

    public void stop(View view) {
        finish();
        startActivity(new Intent(this, DriverTimerActivity.class));
    }

    public void cancel(View view) {
        finish();
        startActivity(new Intent(this, DriverTimerActivity.class));
    }

    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), DialogActivity.class);
        startActivity(intent);
    }
}
