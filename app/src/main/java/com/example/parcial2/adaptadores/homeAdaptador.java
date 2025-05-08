package com.example.parcial2.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2.R;
import com.example.parcial2.clases.Home;
import com.squareup.picasso.Picasso;

public class homeAdaptador extends RecyclerView.Adapter<homeAdaptador.ViewHolder>{
    private Home home;
    public homeAdaptador(Home home) {
        this.home = home;
    }

    @NonNull
    @Override
    public homeAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull homeAdaptador.ViewHolder holder, int position) {
        holder.bind(home);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_home;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_home = itemView.findViewById(R.id.img_home);
        }

        public void bind(Home home) {
            Picasso.get().load(home.getImg()).into(img_home);
        }
    }
}
