package com.uniso.lpdm.porpefood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterOrderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_order);
    }

    /*Exercicio 4: Função ira enviar uma mensagem pelo Intent para qualquer aplicativo no
    * android que tenha um ACTION.SEND que recebe um tipo texto*/
    public void onClickRegisterOrder(View view) {
        EditText editText = (EditText) findViewById(R.id.editRequest);
        String message = editText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(intent);
    }
}