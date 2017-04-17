package com.example.luujfer.servicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
    }

    //EditText editText = (EditText) findViewById(R.id.search);

    public void starter(View view){
        Intent intent = new Intent(MainActivity.this, DemoService.class);
        startService(intent);
    }

    public void stopper(View view){
        Intent intent = new Intent(MainActivity.this, DemoService.class);
        stopService(intent);
    }


}
