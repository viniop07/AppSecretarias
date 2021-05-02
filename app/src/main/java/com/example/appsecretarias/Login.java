package com.example.appsecretarias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email,senha;
    Button btlogin;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.email);
        senha = (EditText)findViewById(R.id.senha);
        btlogin = (Button)findViewById(R.id.btlogin);
        db = new DBHelper(this);



        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emaillog = email.getText().toString();
                String senhalog = senha.getText().toString();



                if (emaillog.equals("")){
                    Toast.makeText(Login.this,"Email não inserido, tente novamente",Toast.LENGTH_SHORT).show();
                }
                else if(senhalog.equals("")){
                    Toast.makeText(Login.this,"Senha não inserido, tente novamente",Toast.LENGTH_SHORT).show();
                }
                else {

                    String res = db.ValidarLogin(emaillog,senhalog);

                    if (res.equals("OK")){
                        Toast.makeText(Login.this,"Login realizado com sucesso",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Login.this, MainActivity.class);
                        startActivity(i);

                    }else{
                        Toast.makeText(Login.this,"Login errado, tente novamente",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}