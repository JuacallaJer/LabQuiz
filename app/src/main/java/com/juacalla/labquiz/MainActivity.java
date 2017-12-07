package com.juacalla.labquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button remember, login;
    SharedPreferences sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.editText);
        edit2 = (EditText) findViewById(R.id.editText3);
        remember = (Button) findViewById(R.id.button);
        login = (Button) findViewById(R.id.button2);
        sharedpref = getPreferences(Context.MODE_PRIVATE);

        edit1.setOnKeyListener(new EditText.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String userName = preferences.getString("username","");
                String passWord = preferences.getString("password","");

                String sUsername = edit1.getText().toString();

                if(!userName.isEmpty()) {
                    if (sUsername.equals(userName)) {
                        edit2.setText(passWord);
                        edit2.setBackgroundColor(Color.GRAY);
                    }
                    else if (!(sUsername.equals(userName))){
                        edit2.setText("");
                        edit2.setBackgroundColor(Color.TRANSPARENT);
                    }
                }

                return false;
            }
        });

        edit2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    String userName = preferences.getString("username","");
                    String passWord = preferences.getString("password","");

                    String nameUser = edit1.getText().toString();

                    if(!userName.isEmpty()) {
                        if (nameUser.equals(userName)) {
                            edit2.setText(passWord);
                            edit2.setBackgroundColor(Color.GRAY);
                        }
                        else if (!(nameUser.equals(userName))){
                            edit2.setText("");
                            edit2.setBackgroundColor(Color.GRAY);
                        }
                    }

                }
            }
        });
    }




    public void Remember(View View) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", edit1.getText().toString());
        editor.putString("password", edit2.getText().toString());
        editor.commit();
        Toast.makeText(this, "The text inputted was saved!", Toast.LENGTH_SHORT).show();
    }

    public void logIn (View View) {
        Intent intent= new Intent(this, SecondActivity.class);
        startActivity(intent);


    }
}

