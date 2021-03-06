package com.applications.fronchetti.cbsoft2016.Fragmentos;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.applications.fronchetti.cbsoft2016.Adapters.Hotel;
import com.applications.fronchetti.cbsoft2016.Adapters.HotelAdapter;
import com.applications.fronchetti.cbsoft2016.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hoteis extends Fragment {

    public Hoteis() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospedagem, container, false);
        final List<Hotel> Hoteis = new ArrayList<Hotel>();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("hotel");
            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            for (int i = 0; i < m_jArry.length(); i++) {

                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String hotel_hostel = jo_inside.getString("hotel_hostel");
                String endereco = jo_inside.getString("endereco");
                String telefone = jo_inside.getString("telefone");
                String url = jo_inside.getString("url");
                String imagem = jo_inside.getString("image");

                Hoteis.add(new Hotel(hotel_hostel,endereco,telefone,url,imagem));

                m_li = new HashMap<String, String>();
                m_li.put("image", imagem);
                m_li.put("hotel_hostel", hotel_hostel);
                m_li.put("endereco", endereco);
                m_li.put("telefone", telefone);
                m_li.put("url", url);

                formList.add(m_li);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HotelAdapter adapter = new HotelAdapter(getActivity(), R.layout.fragment_hospedagem_item, Hoteis);
        final ListView Lista = (ListView) view.findViewById(R.id.listViewHospedagem);
        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(Hoteis.get(position));
            }
        });
        System.out.println(Lista);
        Lista.setAdapter(adapter);
        return view;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("hoteis.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
