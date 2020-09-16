package com.uniso.lpdm.porpefood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends Activity {

    /* Leonardo Rodrigues RA:00101457 Ciências da Computação*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /*Exercicio 3: Função ira atualizar o TextView com um texto
    * Exercicio 4: Função ira enviar o usuario a tela de Registrar pedidos*/
    public void onClickGoRegisterOrderActivity(View view) {
        Intent intent = new Intent(this, RegisterOrderActivity.class);

        startActivity(intent);
    }


    /*Exercicio 3: Função ira atualizar o TextView com um texto
     *Exercicio 4: Função ira enviar o usuario para a tela que gerencia os pontos*/
    public void onClickReturnHours(View view) {
        Intent intent = new Intent(this, TimeManagerActivity.class);

        startActivity(intent);
    }
}