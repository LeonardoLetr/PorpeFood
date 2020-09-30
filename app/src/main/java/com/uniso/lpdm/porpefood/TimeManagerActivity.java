package com.uniso.lpdm.porpefood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class TimeManagerActivity extends Activity {

    private int seconds = 0;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_manager);

        ConstraintLayout constraintLayout = findViewById(R.id.include);

        TextView textView = constraintLayout.findViewById(R.id.txtTitle);

        textView.setText("BATIDA DE PONTO");

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }

        runningChronometer();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running", running);

        super.onSaveInstanceState(savedInstanceState);
    }

    public void onClickStart(View view) {
        Button btnStart = (Button) findViewById(R.id.btnStart);

        btnStart.setEnabled(false);
        running = true;
    }

    public void onClickStop(View view) {
        Button btnStart = (Button) findViewById(R.id.btnStart);

        btnStart.setText(R.string.btn_resume);
        btnStart.setEnabled(true);
        running = false;
    }

    public void onClickReset(View view) {
        Button btnStart = (Button) findViewById(R.id.btnStart);


        btnStart.setText(R.string.btn_start);
        btnStart.setEnabled(true);

        running = false;
        seconds = 0;
    }

    private void runningChronometer() {
        final TextView textView = (TextView) findViewById(R.id.txtTime);

        final Handler handler = new Handler();

        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        int hours = seconds / 3600;
                        int minutes = (seconds % 3600) / 60;
                        int internalSeconds = seconds % 60;

                        String time = String.format(Locale.getDefault(),
                                "%d:%02d:%02d", hours, minutes, internalSeconds);

                        textView.setText(time);

                        if (running) {
                            seconds++;
                        }

                        handler.postDelayed(this, 1000);
                    }
                }
        );
    }
}