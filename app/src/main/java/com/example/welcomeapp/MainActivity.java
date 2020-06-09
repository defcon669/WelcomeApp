package com.example.welcomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button contBtn;
    private TextView ntextView;
    private EditText inputText;
    private ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = (EditText) findViewById(R.id.inputText);
        contBtn = (Button) findViewById(R.id.contBtn);
        ntextView = (TextView) findViewById(R.id.ntextView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        final LoadingDialog loadingDialog = new LoadingDialog(MainActivity.this);

        loadingDialog.loadingAlert();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.dismissdialog();
            }
        }, 7000);

        contBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String enteredText;

                enteredText = inputText.getText().toString();
                ntextView.setText("Awesome!");
                inputText.setText("");
                contBtn.setText("Thank you!");
            }
        });
    }
}
