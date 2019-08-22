package com.example.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class MoviesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies = new ArrayList<Movie>();


    public MoviesAdapter(Context context) {
        this.context = context;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(convertView);
        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);
        return convertView;
    }

    private class ViewHolder {
        private TextView txtTitle;
        private TextView txtDescription;
        private ImageView imgPoster;

        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.tv_title);
            txtDescription = view.findViewById(R.id.tv_description);
            imgPoster = view.findViewById(R.id.image_poster);
        }

        void bind(Movie movie){
            txtTitle.setText(movie.getTitle());
            txtDescription.setText(movie.getDescription());
            imgPoster.setImageResource(movie.getPoster());
        }

    }
}
