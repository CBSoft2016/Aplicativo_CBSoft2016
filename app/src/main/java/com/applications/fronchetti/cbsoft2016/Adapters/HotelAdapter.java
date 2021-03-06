package com.applications.fronchetti.cbsoft2016.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.applications.fronchetti.cbsoft2016.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinicius on 28/10/15.
 */
public class HotelAdapter extends ArrayAdapter<Hotel>{
    Context context;
    int resource;
    List<Hotel> hoteis = new ArrayList<Hotel>();

    public HotelAdapter(Context context, int resource, List<Hotel> hoteis) {
        super(context, resource, hoteis);
        this.resource = resource;
        this.context = context;
        this.hoteis = hoteis;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(resource, parent, false);
        }

        Hotel item = hoteis.get(position);

        if(item != null){
            TextView Nome = (TextView) convertView.findViewById(R.id.textHotelNome);
            TextView Endereco = (TextView) convertView.findViewById(R.id.textHotelEndereco);
            TextView Telefone = (TextView) convertView.findViewById(R.id.textHotelTelefone);
            ImageView Imagem = (ImageView) convertView.findViewById(R.id.imageHotel);
            Picasso.with(getContext()).load(item.getImagem()).into(Imagem);

            Nome.setText(item.getNome());
            Endereco.setText(item.getEndereco());
            Telefone.setText(item.getTelefone());
        }
        return convertView;
    }
}
