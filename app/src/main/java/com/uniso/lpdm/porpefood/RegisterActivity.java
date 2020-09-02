package com.uniso.lpdm.porpefood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    /* Leonardo Rodrigues RA:00101457 Ciências da Computação*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_order);
    }

    /*Por enquanto a função ira atualizar o TextView com um texto
    * Posteriormento ira registrar um pedido*/
    public void onClickRegisterOrder(View view) {
        TextView text = (TextView) findViewById(R.id.txtRegisterOrder);
        String message = "Registrando Pedido";

        text.setText(message);
    }

    /*Por enquanto a função ira atualizar o TextView com um texto
     * Posteriormento ira retornar o total de horas trabalhadas por um empregado*/
    public void onClickReturnHours(View view) {
        TextView text = (TextView) findViewById(R.id.txtRegisterOrder);
        String message = "Total de Horas";

        text.setText(message);
    }
}