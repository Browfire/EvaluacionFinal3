package com.example.evaluacionfinal3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Divisas extends AppCompatActivity {

    private EditText etDivisas;
    private TextView tvUSD, tvEUR;
    private float valorUSD, valorEUR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divisas);

        etDivisas = findViewById(R.id.divisaset);
        tvUSD = findViewById(R.id.txtusd);
        tvEUR = findViewById(R.id.txteur);

        valorUSD = (float) 785.10;
        valorEUR = (float) 920.51;

    }

    //Método para el botón convertir
    public void convertir(View view) {

        if (validarDivisas()) {

            float pesos = Float.parseFloat(etDivisas.getText().toString());

            //Realiza el cálculo
            float totalUSD = (pesos / valorUSD);
            float totalEUR = (pesos / valorEUR);

            tvUSD.setText("US$ " + String.format("%.3f", totalUSD));
            tvEUR.setText(String.format("%.3f", totalEUR) + " €");

        } else {

            Toast.makeText(this, "Debe completar todos los campos",
                    Toast.LENGTH_LONG).show();


        }

    }

    public boolean validarDivisas() {

        return !etDivisas.getText().toString().isEmpty();
    }

    //Método para el botón volver
    public void salirDivisas(View view){

        finish();

    }

}