package com.andreytarasenko.topmoviesdemoapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.andreytarasenko.topmoviesdemoapp.api.model.Result;

import java.util.List;
import java.util.Locale;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder> {

    private static final String TAG = "TopMoviesListAdapter";

    private List<Result> list;

    private Context context;

    public ListAdapter(List<Result> list, Context context) {
        this.list = list;
        this.context = context;
    }


    public static class ListItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView itemName;
        private final TextView popularity;

        public ListItemViewHolder(final View itemView, final Context context) {
            super(itemView);

            // Define click listener for the ViewHolder's View.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                    Toast.makeText(context, "Click at position: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });

            itemName = (TextView) itemView.findViewById(R.id.textView_movie_name);
            popularity = (TextView) itemView.findViewById(R.id.textView_popularity);
        }
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);

        return new ListItemViewHolder(itemView, context);
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
