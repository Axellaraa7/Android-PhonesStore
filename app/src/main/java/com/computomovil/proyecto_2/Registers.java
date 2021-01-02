package com.computomovil.proyecto_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.computomovil.proyecto_2.celulares.Celular;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Registers extends AppCompatActivity {

    ListView lvRegistros;
    ArrayList<Celular> celulares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registers);

        lvRegistros=findViewById(R.id.lvRegistros);
        celulares=(ArrayList<Celular>)getIntent().getSerializableExtra("celulares");

        AdapterCel adapter=new AdapterCel(this,celulares);
        lvRegistros.setAdapter(adapter);

        lvRegistros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(Registers.this,getResources().getString(R.string.toastID) + id,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getHome(View view){
        Intent home=new Intent(this,MainActivity.class);
        home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home);
    }

}