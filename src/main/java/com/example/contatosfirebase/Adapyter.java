package com.example.contatosfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapyter extends BaseAdapter {

    Context context;

    List<String> nome ;
    List<String>numero ;
    List<String>email ;

    LayoutInflater inflater;


    public Adapyter(Context context, List<String> nome, List<String> numero, List<String> email) {
        this.context = context;
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return nome.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.adapyter,null);

        TextView nometv = convertView.findViewById(R.id.textViewNome);
        TextView numerotv = convertView.findViewById(R.id.textViewNumero);
        TextView emailtv = convertView.findViewById(R.id.textViewEmail);

        nometv.setText(nome.get(position));
        numerotv.setText(numero.get(position));
        emailtv.setText(email.get(position));


        return convertView;
    }
}
