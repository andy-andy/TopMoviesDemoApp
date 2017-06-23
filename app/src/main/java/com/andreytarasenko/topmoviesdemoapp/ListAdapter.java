package com.andreytarasenko.topmoviesdemoapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andreytarasenko.topmoviesdemoapp.api.model.Result;

import java.util.List;
import java.util.Locale;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder> {

    private List<Result> list;

    public ListAdapter(List<Result> list) {
        this.list = list;
    }


    public static class ListItemViewHolder extends RecyclerView.ViewHolder {

        public TextView itemName;
        public TextView popularity;

        public ListItemViewHolder(View itemView) {
            super(itemView);

            itemName = (TextView) itemView.findViewById(R.id.textView_movie_name);
            popularity = (TextView) itemView.findViewById(R.id.textView_popularity);
        }
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);

        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ListItemViewHolder holder, int position) {
        //Set item name field
        holder.itemName.setText(list.get(position).getTitle());

        //Format double popularity. Set popularity field.
        Double popularityBeforeFormatting = list.get(position).getPopularity();
        String popularityFormatted = String.format(Locale.US, "%1$,.2f", popularityBeforeFormatting);

        holder.popularity.setText(popularityFormatted);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
