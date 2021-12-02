package com.example.ejemplodatos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ejemplodatos.util.ProcesarDatos;

import java.sql.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ProcesarDatos procesador_datos;
    private String[]usuarios;
    private LinearLayout ll;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.datos);

        usuarios = new String[6];
        usuarios[0] = "1,Ana,ana@gmail.com,F,3000";
        usuarios[1] = "2,Juan,juan@gmail.com,M,2000";
        usuarios[2] = "3,Carolina,caro@gmail.com,F,5000";
        usuarios[3] = "4,Ana,ana.caro@gmail.com,F,4000";
        usuarios[4] = "5,Jorge,jorge@gmail.com,M,1000";
        usuarios[5] = "6,Luisa,luisa.pony@gmail.com,F,2000";

        procesador_datos = new ProcesarDatos();
        String []resp = procesador_datos.filtrarPor(usuarios,"Ana","");

        for(String fila:resp)
        {
            ll.addView(crearFila(fila));
        }
        iv = findViewById(R.id.btn_tierra);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Prueba", Toast.LENGTH_SHORT).show();
            }
        });
        //System.out.println(Arrays.toString(resp));
    }

    @NonNull
    private LinearLayout crearFila(String fila) {
        LinearLayout llh = new LinearLayout(this);
        String datos[] = fila.split(",");
        EditText t1,t2,t3;

        llh.setOrientation(LinearLayout.HORIZONTAL);

        t1 = new EditText(this);
        t1.setText(datos[0]);
        llh.addView(t1);
        t2 = new EditText(this);
        t2.setText(datos[1]);
        llh.addView(t2);
        t3 = new EditText(this);
        t3.setText(datos[2]);
        llh.addView(t3);

        return llh;
    }
}