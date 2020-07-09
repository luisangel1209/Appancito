package com.example.appancito.adaptador;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appancito.Model.ItemList;
import com.example.appancito.R;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
    private List<ItemList> items;

    public RecyclerAdapter(List<ItemList> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new RecyclerHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull final RecyclerHolder holder, final int position) {
        final ItemList item = items.get(position);
        holder.imgItem.setImageResource(item.getImgResource());
        holder.tvTitulo.setText(item.getTitulo());
        holder.tvDescripcion.setText(item.getDescripcion());
        holder.tvDispo.setText(item.getDisponible());
        holder.linLay.addView(holder.editText);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        ImageView imgItem;
        TextView tvTitulo;
        TextView tvDescripcion;
        TextView tvDispo;
        EditText editText;
        LinearLayout linLay;

        public RecyclerHolder(@NonNull View itemView_1) {
            super(itemView_1);

            imgItem = itemView.findViewById(R.id.imgItem);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvDispo = itemView.findViewById(R.id.tvDispo);

            linLay = itemView.findViewById(R.id.linLay);

        }
    }
}
