package com.example.proyectoandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends BaseAdapter {
    Context contexto;
    ArrayList<Cementerio> listado;


    public AdaptadorPersonalizado(Context contexto, ArrayList<Cementerio> listado) {
        this.contexto = contexto;
        this.listado = listado;
    }

    @Override
    public int getCount() {
        return listado.size();
    }

    @Override
    public Cementerio getItem(int position) {
        return listado.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = LayoutInflater.from(contexto).inflate(R.layout.disenho_lista, null);

        TextView Title = convertView.findViewById(R.id.NombreRes);

        Title.setText(listado.get(position).title);

        return convertView;
    }
}
