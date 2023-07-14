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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CadastroUser extends AppCompatActivity {

    EditText email,senha,nome,cpf;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;
    Map<String,String> dados = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        email = findViewById(R.id.editEmailCad);
        senha = findViewById(R.id.editSenhaCad);
        nome = findViewById(R.id.editNomeCad);
        cpf = findViewById(R.id.editNumeroCad);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


    }

    public void create(View v){
        // mAuth =  email e senha
        mAuth.createUserWithEmailAndPassword(email.getText().toString(), senha.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Cadastro Realizado com sucesso!!!",
                                    Toast.LENGTH_SHORT).show();
                            myRef = database.getReference("User/" + mAuth.getUid()+"/");

                            dados.put("nome",nome.getText().toString());
                            dados.put("cpf",cpf.getText().toString());
                            dados.put("email",email.getText().toString());
                            dados.put("senha",senha.getText().toString());

                            myRef.setValue(dados);

                            Intent ie = new Intent(CadastroUser.this, Main.class);
                            startActivity(ie);


                        }else {
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao Cadastrar, já existente ou usuario e/ou senha fora do padrão!",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}