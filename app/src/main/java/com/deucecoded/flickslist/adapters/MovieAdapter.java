package com.deucecoded.flickslist.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.deucecoded.flickslist.R;
import com.deucecoded.flickslist.models.Movie;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.List;


public class MovieAdapter extends ArrayAdapter<Movie> {

    public MovieAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.item_movie, parent, false);
        }

        ImageView imageView = (ImageView)convertView.findViewById(R.id.movieImageView);
        imageView.setImageResource(0);

        TextView titleView = (TextView)convertView.findViewById(R.id.titleTextView);
        TextView descriptionView = (TextView)convertView.findViewById(R.id.overviewTextView);

        titleView.setText(movie.getOriginalTitle());
        descriptionView.setText(movie.getOverview());
        Picasso.with(getContext()).load(movie.getPosterPath()).into(imageView);

        return convertView;
    }
}
