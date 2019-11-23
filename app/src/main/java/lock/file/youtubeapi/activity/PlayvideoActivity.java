package lock.file.youtubeapi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import lock.file.youtubeapi.R;
import lock.file.youtubeapi.api.YoutubeAdd;

public class PlayvideoActivity extends YouTubeBaseActivity {
    YouTubePlayerView playerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
String videoIdlink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);

        playerView = findViewById(R.id.youtubePlayID);

        videoIdlink = getIntent().getStringExtra("video_id");
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

/*
                List<String> videolist = new ArrayList<>();

                videolist.add();
                videolist.add();
                videolist.add();
                videolist.add();
                videolist.add();
                videolist.add();*/

                youTubePlayer.loadVideo(videoIdlink);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };


        playerView.initialize(YoutubeAdd.getApi_KEY(), onInitializedListener);

    }
}
