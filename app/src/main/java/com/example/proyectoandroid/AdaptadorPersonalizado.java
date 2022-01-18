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

    ArrayList<Restaurante> listado;
    Context contexto;

    public AdaptadorPersonalizado(ArrayList<Restaurante> listado, Context contexto) {
        this.listado = listado;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return listado.size();
    }

    @Override
    public Object getItem(int position) {
        return listado.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewInflado = LayoutInflater.from(contexto).inflate(R.layout.disenho_lista, null);
        ImageView imgRes = viewInflado.findViewById(R.id.ImgRes);
        TextView nombreRes = viewInflado.findViewById(R.id.NombreRes);
        Restaurante resARellenar = (Restaurante) getItem(position);
        imgRes.setImageResource(resARellenar.img);
        nombreRes.setText(resARellenar.nombre);
        return viewInflado;
    }
}
