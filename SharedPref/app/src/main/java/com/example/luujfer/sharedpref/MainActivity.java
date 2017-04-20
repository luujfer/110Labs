package com.example.luujfer.sharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static String name = "myName";
    static String address = "UCSD";
    static String phoneNumber = "9999";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("user_name", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", name);
        editor.putString("address", address);
        editor.putString("phoneNumber",phoneNumber);

        editor.apply();


        setContentView(R.layout.activity_main);
    }

    public void save(View view){
        EditText firstName = (EditText) findViewById(R.id.text);
        EditText lastName = (EditText) findViewById(R.id.text2);

        SharedPreferences sharedPreferences = getSharedPreferences("user_name", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("firstname", firstName.getText().toString());
        editor.putString("lastname", lastName.getText().toString());

        editor.apply();
        Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();

    }

    public void display(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("user_name", MODE_PRIVATE);
        EditText Name = (EditText) findViewById(R.id.text);

        String name1 = sharedPreferences.getString("name","");
        String enteredName = Name.getText().toString();

        if(name1.equals(enteredName)) {
            String address = sharedPreferences.getString("address","");
            String phoneNumber = sharedPreferences.getString("phoneNumber","");
            TextView add = (TextView) findViewById(R.id.text3);
            TextView phone = (TextView) findViewById(R.id.text4);

            add.setText(address);
            phone.setText(phoneNumber);

            //String firstName = sharedPreferences.getString("firstname","");
            //String lastName = sharedPreferences.getString("lastname","");
            //TextView displayFirstName = (TextView) findViewById(R.id.text3);
            //TextView displayLastName = (TextView) findViewById(R.id.text4);

            //displayFirstName.setText(firstName);
            //displayLastName.setText(lastName);
        }
        else{
            TextView add = (TextView) findViewById(R.id.text3);
            TextView phone = (TextView) findViewById(R.id.text4);

            add.setText("ERROR, no match found");
            phone.setText("");
        }
    }
}
