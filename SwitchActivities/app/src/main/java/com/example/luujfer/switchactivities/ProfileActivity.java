package com.example.luujfer.switchactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button switchScreen = (Button)findViewById(R.id.buttonBACK);
        switchScreen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
                   }
                                        });

        Button showText = (Button)findViewById(R.id.buttonSHOW);
        showText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                show();
            }
                                    });
        textView = (TextView) findViewById(R.id.tv);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void show(){
        textView = (TextView) findViewById(R.id.tv);
        textView.setText(getIntent().getExtras().getString("text"));
    }

}
