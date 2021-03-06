package com.example.luujfer.servicetest;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DemoService extends Service {
    public DemoService() {
    }

    final class MyThread implements Runnable{
        int startId;
        public MyThread(int startId){
            this.startId = startId;
        }
        @Override
        public void run(){
            EditText search = (EditText) findViewById(R.id.search);

            SharedPreferences sharedPreferences = getSharedPreferences("user_name", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("firstname", search.getText().toString());

            editor.apply();
            Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();

            synchronized (this){
                try{
                    wait(10000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

                stopSelf(startId);
            }
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(DemoService.this,"Service Started", Toast.LENGTH_SHORT).show();
        Thread thread = new Thread(new MyThread(startId));
        thread.start();

        return super.onStartCommand(intent, flags, startId);
    }



    public void onDestroy(){
        Toast.makeText(DemoService.this,"Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
