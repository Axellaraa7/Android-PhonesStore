package com.computomovil.proyecto_2.celulares;

import java.io.Serializable;

public class Celular implements Serializable {

    //Atributos de la clase celular
    private String model,marca,s_operativo;
    private String rom,ram;
    int img;
    private long id;

    //Constructor de la clase celular
    public Celular(String model, String marca, long id, String rom, String ram, String s_operativo,int img){
        this.model=model; //Modelo
        this.marca=marca; //Marca del celular
        this.id=id; //Id del producto
        this.rom=rom; //Memoria interna del del celular
        this.ram=ram; //Memoria RAM del celular
        this.s_operativo=s_operativo; //SO del celular
        this.img=img;
    }

    public String getModel(){return this.model;} //Getter Modelo
    public String getMarca(){return this.marca;} //Getter Marca
    public long getId(){return this.id;} //Getter id producto
    public String getRom(){return this.rom;}  //Getter Memoria interna
    public String getRam(){return this.ram;} //Getter RAM
    public String getS_operativo(){return this.s_operativo;} //Getter SO
    public int getImg(){return this.img;}

}
