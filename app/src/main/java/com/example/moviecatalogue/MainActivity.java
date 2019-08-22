package com.example.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] title;
    private String[] description;
    private String[] userScore;
    private String[] topCast;
    private String[] releaseDate;

    private TypedArray poster;

    private MoviesAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MoviesAdapter(this);

        prepare();
        addItem();

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movies.get(i).getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("extra_movie_data", movies.get(i));
                Log.d("Ada isinya", "onItemClick: "+movies.get(i));
                startActivity(intent);
            }
        });
    }

    private void prepare(){
        title = getResources().getStringArray(R.array.title);
        description = getResources().getStringArray(R.array.description);
        userScore = getResources().getStringArray(R.array.score);
        topCast = getResources().getStringArray(R.array.featured_crew);
        releaseDate = getResources().getStringArray(R.array.release_date);
        poster = getResources().obtainTypedArray(R.array.poster);
    }

    private void addItem(){
        movies = new ArrayList<>();

        for(int i = 0; i <=description.length-1; i++){
            Movie movie =  new Movie();
            movie.setTitle(title[i]);
            movie.setDescription(description[i]);
            movie.setUserScore(userScore[i]);
            movie.setTopCast(topCast[i]);
            movie.setReleaseDate(releaseDate[i]);
            movie.setPoster(poster.getResourceId(i, -1));
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }
}
