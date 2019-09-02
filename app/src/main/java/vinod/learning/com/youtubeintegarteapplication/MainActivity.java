package vinod.learning.com.youtubeintegarteapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayerView;
    Button VedioPlay;
    private static final String TAG="MainActivity";
    YouTubePlayer.OnInitializedListener onInitializedListener;
    YoutubeService  youtubeService=new YoutubeService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView=findViewById(R.id.youtubeview);
        VedioPlay=findViewById(R.id.playvedio);
        Log.d(TAG,"starting");
        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG," success initializing");

                //youTubePlayer.loadVideo("https://www.youtube.com/watch?v=a4NT5iBFuZs");
                youTubePlayer.loadVideo("a4NT5iBFuZs");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG," fail initializing");

            }
        };

        VedioPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG," initializing oyutube player");

               // youTubePlayerView.initialize(youtubeService.getApi(),onInitializedListener);
                youTubePlayerView.initialize("AIzaSyCNQiw4EURqKlEiVVmk5nsbJzpnoGq4Z7k",onInitializedListener);

            }
        });
    }
}
