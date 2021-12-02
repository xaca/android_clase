package com.example.ejemplodatos.util;

import java.util.ArrayList;

public class ProcesarDatos {
    public String[] filtrarPor(String datos[],String filtro1,String filtro2){
        String temp[];
        ArrayList<String> salida = new ArrayList<String>();

        for(String fila:datos)
        {
            temp = fila.split(",");
            if(temp[1].equals(filtro1) || temp[3].equals(filtro2)){
                //System.out.println(fila);
                salida.add(fila);
            }
        }
        return salida.toArray(new String[salida.size()]);
    }
}
