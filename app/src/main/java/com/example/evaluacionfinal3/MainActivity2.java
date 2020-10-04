package com.example.evaluacionfinal3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvUser;
    private Button btnDivisas, btnMultas, btnSeguros, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvUser = findViewById(R.id.usertv);
        btnDivisas = findViewById(R.id.btn1);
        btnMultas = findViewById(R.id.btn2);
        btnSeguros = findViewById(R.id.btn3);
        btnSalir = findViewById(R.id.btn4);

        String usuario = getIntent().getStringExtra("usuario");
        tvUser.setText("Hola " + usuario + ", por favor selecciona una opción");
    }

    //Método para el botón Cambio de Divisas
    public void accederDivisas(View view) {

        Toast.makeText(this, "Cargando conversor de divisas...",
                Toast.LENGTH_SHORT).show();
        Intent d = new Intent(this, Divisas.class);
        startActivity(d);

    }

    //Método para el botón Calcular Multa
    public void accederMultas(View view) {

        Toast.makeText(this, "Cargando calculadora de multas...",
                Toast.LENGTH_SHORT).show();
        Intent m = new Intent(this, Multas.class);
        startActivity(m);

    }

    //Método para el botón Seguro Automotriz
    public void accederSeguros(View view) {

        Toast.makeText(this, "Cargando administradora de seguros...",
                Toast.LENGTH_SHORT).show();
        Intent s = new Intent(this, Seguros.class);
        startActivity(s);

    }

    //Método para el botón Salir
    public void salirMenu(View view) {

        finishAffinity();
        System.exit(0);

    }
}