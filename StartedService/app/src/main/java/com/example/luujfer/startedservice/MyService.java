package com.example.luujfer.startedservice;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class MyService extends Service {


    public MyService() {
    }

    final class MyThread implements Runnable{
        int startId;
        public MyThread(int startId){
            this.startId = startId;
        }
        @Override
        public void run(){


            SharedPreferences sharedPreferences = getSharedPreferences("user_name", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("name", "Harry");

            editor.apply();
            //Toast.makeText(MyService.this, "Started", Toast.LENGTH_SHORT).show();

            synchronized (this){
                try{
                    wait(10000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

                stopSelf(startId);
            }
            //Toast.makeText(MyService.this, "Stopped", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(MyService.this,"Service Started", Toast.LENGTH_SHORT).show();
        Thread thread = new Thread(new MyThread(startId));
        thread.start();

        return super.onStartCommand(intent, flags, startId);
    }



    public void onDestroy(){
        Toast.makeText(MyService.this,"Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
