package com.example.android.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BlankFragment.PlayerListener {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.tvDetails);
    }

    @Override
    public void onPlayerSelected(int index) {
     String[] s=getResources().getStringArray(R.array.descriptions);
     textView.setText(s[index]);
    }
}
