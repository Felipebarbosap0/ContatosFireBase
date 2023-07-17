package com.example.contatosfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cadastro extends AppCompatActivity {
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;
    Map<String,String> dados = new HashMap<>();

    EditText email,numero,nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        email = findViewById(R.id.editEmailCad);
        numero = findViewById(R.id.editNumeroCad);
        nome = findViewById(R.id.editNomeCad);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


    }

    public  void BtnConfirmar(View V){



                            myRef = database.getReference("User/" + mAuth.getUid()+"/contatos/");

                            dados.put("nome",nome.getText().toString());
                            dados.put("número",numero.getText().toString());
                            dados.put("email",email.getText().toString());


                            myRef.setValue(dados);

                            Intent ie = new Intent(Cadastro.this, Home.class);
                            startActivity(ie);




    }
}