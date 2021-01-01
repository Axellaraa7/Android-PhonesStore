package com.computomovil.proyecto_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.computomovil.proyecto_2.celulares.Celular;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    EditText etModelo,etRom,etRam;
    Spinner spMarca,spSO;
    ArrayList<Celular>celulares=new ArrayList<>();
    Intent registro;
    long id=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etModelo=findViewById(R.id.etModelo);
        etRom=findViewById(R.id.etROM);
        etRam=findViewById(R.id.etRAM);
        spMarca=findViewById(R.id.spMarca);
        spSO=findViewById(R.id.spSO);
        eraseElements();

    }

    public void clkValidar(View view){
        String model=getResources().getString(R.string.vacio),so=getResources().getString(R.string.vacio),marca=getResources().getString(R.string.vacio),rom=getResources().getString(R.string.vacio),ram=getResources().getString(R.string.vacio);
        int idMarca=getResources().getInteger(R.integer.cero);
        if(missingField(etModelo) && missingField(etRom) && missingField(etRam) && valuesROM(etRom) && valuesRAM(etRam) && spMarca.getSelectedItemId()!=getResources().getInteger(R.integer.cero) && spSO.getSelectedItemId()!=getResources().getInteger(R.integer.cero)) {
            model = etModelo.getText().toString();
            rom = etRom.getText().toString();
            ram = etRam.getText().toString();
            marca = spMarca.getSelectedItem().toString();
            idMarca = (int) spMarca.getSelectedItemId();
            so = spSO.getSelectedItem().toString();
            Celular celular = new Celular(model, marca, id, rom, ram, so,setImage(idMarca));
            id++;
            celulares.add(celular);
            eraseElements();
        }else{
            Toast.makeText(this,getResources().getString(R.string.errGral),Toast.LENGTH_SHORT).show();
            if(!missingField(etModelo)) etModelo.setError(getResources().getString(R.string.errModel));
            if(spMarca.getSelectedItemId()==getResources().getInteger(R.integer.cero)) Toast.makeText(this,getResources().getString(R.string.errBrand),Toast.LENGTH_SHORT).show();
            if(spSO.getSelectedItemId()==getResources().getInteger(R.integer.cero)) Toast.makeText(this,getResources().getString(R.string.errSO),Toast.LENGTH_SHORT).show();
            if(!missingField(etRom)) etRom.setError(getResources().getString(R.string.errRom));
            else{
                if(!valuesROM(etRom)) etRom.setError(getResources().getString(R.string.valRom));
            }
            if(!missingField(etRam)) etRam.setError(getResources().getString(R.string.errRam));
            else{
                if(!valuesRAM(etRam) && missingField(etRam)) etRam.setError(getResources().getString(R.string.valRam));
            }
        }
    }

    public void clkRegisters(View view){
        registro=new Intent(MainActivity.this,Registers.class);
        registro.putExtra("celulares",celulares);
        startActivity(registro);
    }

    private boolean missingField(EditText et){
        if(et.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }

    private boolean valuesROM(EditText et){
        int capacity=Integer.parseInt(et.getText().toString());
        if(capacity==32 || capacity==64 || capacity==128 || capacity==256 || capacity==512){
            return true;
        }
        return false;
    }

    private boolean valuesRAM(EditText et){
        int capacity=Integer.parseInt(et.getText().toString());
        if(capacity==2 || capacity==3 || capacity==4 || capacity==6 || capacity==8 || capacity==12){
            return true;
        }
        return false;
    }

    private void eraseElements(){
        etModelo.setText(getResources().getString(R.string.vacio));
        etRam.setText(getResources().getString(R.string.vacio));
        etRom.setText(getResources().getString(R.string.vacio));
        spMarca.setSelection(getResources().getInteger(R.integer.cero));
        spSO.setSelection(getResources().getInteger(R.integer.cero));
        etModelo.requestFocus();
    }

    protected int setImage(int idMarca){
        switch (idMarca){
            case 1:
                return R.drawable.xiaomi_logo;
            case 2:
                return R.drawable.nokia_logo;
            case 3:
                return R.drawable.samsung_logo;
            case 4:
                return R.drawable.huawei_logo;
            case 5:
                return R.drawable.htc_logo;
            case 6:
                return R.drawable.motorola_logo;
            default:
                return R.drawable.ic_baseline_close_24;
        }
    }
}