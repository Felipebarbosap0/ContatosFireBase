package com.example.contatosfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class Main extends AppCompatActivity {

    EditText EditEmail,EditSenha;

    private FirebaseAuth mAuth;

    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AtivarComponentes();


    }

    private void AtivarComponentes() {
        EditEmail = findViewById(R.id.editEmailCad);
        EditSenha = findViewById(R.id.editSenhaCad);
        mAuth = FirebaseAuth.getInstance();

    }
    public void BtnLogin(View v){
        mAuth.signInWithEmailAndPassword(EditEmail.getText().toString(), EditSenha.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Login efetuado", Toast.LENGTH_LONG).show();
                    Intent ie = new Intent(Main.this, Home.class);
                    startActivity(ie);

                }else{
                    Toast.makeText(getApplicationContext(),"login ou Senha estão erradas", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
    public void BtnCadastrar(View v){
        Intent ie = new Intent(Main.this, CadastroUser.class);
        startActivity(ie);

    }
}