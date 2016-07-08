package com.fox.quickcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout _frameLayout = (FrameLayout) findViewById(R.id.result_frame_layout);
        TextView _textView = new TextView(this);
        _textView.setText("Hello World");
        _frameLayout.addView(_textView);

        FrameLayout bottomFrame = (FrameLayout) findViewById(R.id.keypad_frame_layout);
        TextView _otherText = new TextView(this);
        _otherText.setText("Bottom view, saying 'hey'");
        bottomFrame.addView(_otherText);
    }
}
