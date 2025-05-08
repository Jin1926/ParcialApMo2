package com.example.parcial2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parcial2.adaptadores.homeAdaptador;
import com.example.parcial2.clases.Home;


public class Inicio extends Fragment {
    RecyclerView rcv_img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        rcv_img = view.findViewById(R.id.rcv_img);
        Home hom = new Home("/drawable/img.png");
        rcv_img.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_img.setAdapter(new homeAdaptador(hom));
        return view;
    }
}