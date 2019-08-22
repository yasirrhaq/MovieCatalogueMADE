package com.example.moviecatalogue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie_data";

    private TextView tvTittleDetail;
    private TextView tvDescriptionDetail;
    private TextView tvReleaseDate;
    private TextView tvUserScore;
    private TextView tvTopCastDetail;

    private ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        tvTittleDetail = findViewById(R.id.tv_title_detail);
        tvDescriptionDetail = findViewById(R.id.tv_description_detail);
        tvReleaseDate = findViewById(R.id.tv_release_date_detail);
        tvUserScore = findViewById(R.id.tv_score_value_detail);
        tvTopCastDetail = findViewById(R.id.tv_top_cast_detail);
        poster = findViewById(R.id.img_poster_detail);

        getMovieData();
    }

    private void getMovieData(){
        Movie movie =  getIntent().getParcelableExtra(EXTRA_MOVIE);

        tvTittleDetail.setText(movie.getTitle());
        tvDescriptionDetail.setText(movie.getDescription());
        tvReleaseDate.setText(movie.getReleaseDate());
        tvUserScore.setText(movie.getUserScore());
        tvTopCastDetail.setText(movie.getTopCast());

        poster.setImageResource(movie.getPoster());
    }
}
