package com.bhadresha.tejas.sannibh;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class login_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
    }
    public void login(View view){
        String mail="info@sannibh.in";
        String passwd = "Sannibh1234";
        EditText et = (EditText) findViewById(R.id.email);
        EditText et1 = (EditText) findViewById(R.id.password);
        String email,password;
        email = et.getText().toString();
        password = et1.getText().toString();

        if(mail.equals(email)  && password.equals(passwd)){
            flag.f=1;
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
        else{
            TextView tv = (TextView) findViewById(R.id.error);
            tv.setTextColor(Color.RED);
            tv.setText("wrong email or password! Try again..");
        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            this.finish();
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
            return true; // return
        }
        return false;
    }
}
