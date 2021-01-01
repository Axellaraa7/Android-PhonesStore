package com.computomovil.proyecto_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.computomovil.proyecto_2.celulares.Celular;
import java.util.ArrayList;

public class AdapterCel extends BaseAdapter {

    AppCompatActivity app;
    Context registers;
    ArrayList<Celular> celulares;
    TextView tvModelo,tvRam,tvRom,tvSO;
    ImageView ivMarca;

    public AdapterCel(Context registers, ArrayList<Celular> celulares){
        this.registers=registers;
        this.celulares=celulares;
    }

    @Override
    public int getCount() {
        return celulares.size();
    }

    @Override
    public Object getItem(int position) {
        return celulares.get(position);
    }

    @Override
    public long getItemId(int position) {
        return celulares.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Celular cel=celulares.get(position);

        if(convertView==null) convertView=LayoutInflater.from(registers).inflate(R.layout.prototype,null);

        tvModelo=convertView.findViewById(R.id.tvModel);
        tvRam=convertView.findViewById(R.id.tvValueRAM);
        tvRom=convertView.findViewById(R.id.tvValueROM);
        tvSO=convertView.findViewById(R.id.tvSO);
        ivMarca=convertView.findViewById(R.id.ivMarca);

        tvModelo.setText(cel.getModel());
        tvRam.setText(cel.getRam());
        tvRom.setText(cel.getRom());
        tvSO.setText(cel.getS_operativo());
        ivMarca.setImageResource(cel.getImg());

        return convertView;
    }

}
