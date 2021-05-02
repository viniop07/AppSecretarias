package com.example.appsecretarias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    EditText nome,edemail,edsenha,repsenha;
    Button cadastro;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        db = new DBHelper(this);
        nome = (EditText)findViewById(R.id.nome);
        edemail = (EditText)findViewById(R.id.edemail);
        edsenha = (EditText)findViewById(R.id.edsenha);
        repsenha = (EditText)findViewById(R.id.repsenha);
        cadastro = (Button)findViewById(R.id.cadastro);

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email= edemail.getText().toString();
                String senha = edsenha.getText().toString();
                String senha2 = repsenha.getText().toString();
                
                if (email.equals("")){
                    Toast.makeText(Registrar.this, "Email não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else if(senha.equals("")|| senha2.equals("")) {
                    Toast.makeText(Registrar.this, "Preencha a senha, tente novamente", Toast.LENGTH_SHORT).show();
                }else if (!senha.equals(senha2)){
                    Toast.makeText(Registrar.this, "As senhas não correspondem, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else {
                    long res = db.CriarUltilizador(email,senha);
                    if (res>0){
                        Toast.makeText(Registrar.this, "Cadastro concluido com sucesso!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Registrar.this, Login.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(Registrar.this, "Cadastro invalido, tente novamente", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}