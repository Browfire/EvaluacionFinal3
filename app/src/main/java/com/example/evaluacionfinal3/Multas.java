package com.example.evaluacionfinal3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Multas extends AppCompatActivity {

    private EditText etRun, etNombre, etSueldo;
    private TextView tvMulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multas);

        etRun = findViewById(R.id.run);
        etNombre = findViewById(R.id.nombre);
        etSueldo = findViewById(R.id.sueldo);
        tvMulta = findViewById(R.id.multatv);

    }

    //Método para el botón calcular
    public void calcular(View view) {

        if(validarMultas()) {
            int sueldo = Integer.parseInt(etSueldo.getText().toString());

            //Validamos sueldo
            if (sueldo > 100000000) {
                Toast.makeText(this, "Ingrese un sueldo menor", Toast.LENGTH_SHORT).show();
                nuevo(view);
            } else {
                int totalmulta = (sueldo * 10) / 100;
                String total = String.valueOf(totalmulta);
                tvMulta.setText(total);
            }

        } else {

            Toast.makeText(this, "Debe completar todos los campos",
                    Toast.LENGTH_LONG).show();

        }

    }

    public boolean validarMultas() {

        return !etRun.getText().toString().isEmpty() &&
                !etNombre.getText().toString().isEmpty() &&
                !etSueldo.getText().toString().isEmpty();

    }//Nunca se solicita validar nombre ni run, por lo que se asume son válidos

    //Método para el botón nuevo
    public void nuevo(View view){

        etRun.setText("");
        etNombre.setText("");
        etSueldo.setText("");
        tvMulta.setText("");

    }

    //Método para el botón volver
    public void salirMultas(View view){

        finish();

    }

}