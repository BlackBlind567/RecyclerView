package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<SearchResponse> searchResponses = new ArrayList<>();

    public RecyclerViewAdapter(Context context,
                               ArrayList<SearchResponse> searchResponses) {
        this.context = context;
        this.searchResponses = searchResponses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item, parent, false);

        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView1.setText(searchResponses.get(position).getId());
        holder.textView2.setText(searchResponses.get(position).getBusId());
        holder.textView3.setText(searchResponses.get(position).getRouteId());
        holder.textView4.setText(searchResponses.get(position).getBusName());
        holder.textView5.setText(searchResponses.get(position).getBusType());
        holder.textView6.setText(searchResponses.get(position).getDate());
        holder.textView7.setText(searchResponses.get(position).getDestTime());
        holder.textView8.setText(searchResponses.get(position).getDuration());
        holder.textView9.setText(searchResponses.get(position).getFare());
        holder.textView10.setText(searchResponses.get(position).getSeats());
        holder.textView11.setText(searchResponses.get(position).getTime());

    }


    @Override
    public int getItemCount() {
        return searchResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.rv_text1);
            textView2 = itemView.findViewById(R.id.rv_text2);
            textView3 = itemView.findViewById(R.id.rv_text3);
            textView4 = itemView.findViewById(R.id.rv_text4);
            textView5 = itemView.findViewById(R.id.rv_text5);
            textView6 = itemView.findViewById(R.id.rv_text6);
            textView7 = itemView.findViewById(R.id.rv_text7);
            textView8 = itemView.findViewById(R.id.rv_text8);
            textView9 = itemView.findViewById(R.id.rv_text9);
            textView10 = itemView.findViewById(R.id.rv_text10);
            textView11 = itemView.findViewById(R.id.rv_text11);
        }
    }
}
