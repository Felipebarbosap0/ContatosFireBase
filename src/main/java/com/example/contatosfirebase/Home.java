package com.example.contatosfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class Home extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        iniciar();

    }

    private void iniciar() {
        list =  findViewById(R.id.list);
    }

    public void BtnAtualizar(View v){
        Adapyter adapyter = new Adapyter( this, List<String> nome, List<String> numero, List<String> email);
        list.setAdapter(adapyter);

    }

    public void BtnCriar(View v){
        Intent ie = new Intent(Home.this,Cadastro.class);
        startActivity(ie);

    }
}