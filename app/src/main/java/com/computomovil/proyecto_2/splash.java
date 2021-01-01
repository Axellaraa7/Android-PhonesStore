package com.computomovil.proyecto_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread hilo=new Thread(){
            public void run(){
                try{
                    sleep(getResources().getInteger(R.integer.secSplash));
                }catch(Exception e){

                }finally{
                    Intent main=new Intent(splash.this,MainActivity.class);
                    startActivity(main);
                    finish();
                }
            }
        };

        hilo.start();
        Toast.makeText(splash.this,getResources().getString(R.string.bienvenida),Toast.LENGTH_LONG).show();
    }
}