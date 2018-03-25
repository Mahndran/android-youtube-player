package com.pierfrancescosoffritti.youtubeplayersample.examples.customUIExample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.youtubeplayersample.R;

public class CustomUIActivity extends AppCompatActivity {

    private String[] videoIds = {"6JYIGclVQdw", "LvetJ9U_tVY"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_ui_example);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.setPlayerUIControls(new CustomPlayerUIController(this), R.layout.custom_player_controls);

        youTubePlayerView.initialize(youTubePlayer ->

                youTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        youTubePlayer.loadVideo(videoIds[0], 0);
                    }
                }), true
        );
    }
}