package com.example.evaluacionfinal3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Seguros extends AppCompatActivity {

    private EditText etPropietario, etValor, etAccidentes;
    private TextView tvTotal;
    private RadioButton rbModelo1,rbModelo2,rbModelo3;
    private CheckBox cbEdad1,cbEdad2,cbEdad3;
    private RadioGroup rg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguros);

        etPropietario = findViewById(R.id.propietarioet);
        etValor = findViewById(R.id.valoret);
        etAccidentes = findViewById(R.id.accidenteset);
        rbModelo1 = findViewById(R.id.modelo1rb);
        rbModelo2 = findViewById(R.id.modelo2rb);
        rbModelo3 = findViewById(R.id.modelo3rb);
        cbEdad1 = findViewById(R.id.edad1cb);
        cbEdad2 = findViewById(R.id.edad2cb);
        cbEdad3 = findViewById(R.id.edad3cb);
        tvTotal = findViewById(R.id.costototaltv);
        rg1 = findViewById(R.id.rg1);

    }

    //Método para el botón calcular
    public void calcularSeguro(View view) {

        if(validarSeguros()) {

            String st_accidentes = etAccidentes.getText().toString();
            String st_valor = etValor.getText().toString();

            float valor = Float.parseFloat(st_valor);
            int accidentes = Integer.parseInt(st_accidentes);
            float modelo = (float) 0.00;
            float edad = 0;
            float cargo = (float) 17000.00; //La instrucción decía 17, pero lo dejé en 17000

            //Definir cargo por valor
            float cargoValor = valor * 35 / 1000;

            //Definir cargo por modelo
            if (rbModelo1.isChecked()) {
                modelo = valor * 11 / 1000;
            } else if (rbModelo2.isChecked()) {
                modelo = valor * 12 / 1000;
            } else if (rbModelo3.isChecked()) {
                modelo = valor * 15 / 1000;
            }

            //Definir cargo por edad del propietario
            //La instrucción decía 360, 240 y 430, pero para hacerlo más práctico, multipliqué x1000
            if (cbEdad1.isChecked()) {
                edad = 360000;
            } else if (cbEdad2.isChecked()) {
                edad = 240000;
            } else if (cbEdad3.isChecked()) {
                edad = 430000;
            }

            //Definir cargo por accidentes previos
            if (accidentes > 3) {
                for (int i = 4; i <= accidentes; ++i) {
                    cargo += 21000; //La instrucción decía 21, pero lo dejé en 21000
                }
            }

            //Definir costo total
            float valorTotal = cargoValor + modelo + edad + cargo;

            //Mostrar total
            tvTotal.setText(String.format("%.0f", valorTotal));

        } else {

            Toast.makeText(this,
                    "Debe completar todos los campos e ingresar valor mayor a $100000",
                    Toast.LENGTH_LONG).show();

        }

    }

    public boolean validarSeguros(){

        return !etPropietario.getText().toString().isEmpty() &&
                !etValor.getText().toString().isEmpty() &&
                !etAccidentes.getText().toString().isEmpty() &&
                Integer.parseInt(etValor.getText().toString()) >= 100000 &&
                (rbModelo1.isChecked() || rbModelo2.isChecked() || rbModelo3.isChecked()) &&
                (cbEdad1.isChecked() || cbEdad2.isChecked() || cbEdad3.isChecked());

    }

    public void refresh (View view){

        etPropietario.setText("");
        etValor.setText("");
        etAccidentes.setText("");
        tvTotal.setText("");
        rg1.clearCheck();
        cbEdad1.setChecked(false);
        cbEdad2.setChecked(false);
        cbEdad3.setChecked(false);

    }

    public void salirSeguros (View view){

        finish();

    }

}