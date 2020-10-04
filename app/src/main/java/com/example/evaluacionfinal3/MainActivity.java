package com.example.evaluacionfinal3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private EditText etUser, etPass;
    private byte failAttempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.user);
        etPass = findViewById(R.id.pass);

    }

    //Método para el botón
    public void ingresar(View view){

        final String usuario = etUser.getText().toString();
        String password = etPass.getText().toString();

        //Valida los campos
        if (usuario.length() == 0 || password.length() == 0) {

            Toast.makeText(this,"Debes rellenar todos los campos",
                    Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(this, "Validando datos...", Toast.LENGTH_SHORT).show();

            if (validar(password)) {

                Toast.makeText(this, "Ingreso correcto", Toast.LENGTH_SHORT).show();
                //Tiempo de espera antes de cambiar de activity
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        ingresoCorrecto();
                    }
                },4000);

            } else {

                Toast.makeText(this, "Ingreso erróneo", Toast.LENGTH_SHORT).show();
                failAttempts+=1;

                if (failAttempts>=3) {

                    Toast.makeText(this, "Máximo de intentos permitidos",
                            Toast.LENGTH_LONG).show();
                    //Tiempo de espera antes de cerrar la activity
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            finish();
                        }
                    },5000);

                }
            }
        }
    }

    //Método para validar contraseña
    private boolean validar(String password){
        return password.equals("awakelab");
    }

    //Método que envía al menú
    public void ingresoCorrecto() {

        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("usuario",etUser.getText().toString());
        startActivity(i);

    }
}