package com.juacalla.labquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvdisplay;
    Button logout, display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        logout = (Button) findViewById(R.id.button3);
        tvdisplay=(TextView) findViewById(R.id.textView4);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String userName = preferences.getString("username","");
        tvdisplay.setText(userName);
    }

    public void logOut(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
