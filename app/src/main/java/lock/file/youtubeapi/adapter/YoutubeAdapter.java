package lock.file.youtubeapi.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;

import lock.file.youtubeapi.R;
import lock.file.youtubeapi.api.YoutubeAdd;
import lock.file.youtubeapi.interfaceClick.ItemClickList;
import lock.file.youtubeapi.model.YouModelClass;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.MyViewHolder> {

    Context c;
    ArrayList<YouModelClass> videoList;
    ItemClickList itemClickList;
    Activity activity;
    RecyclerView recyclerView;

    public YoutubeAdapter(Context c, ArrayList<YouModelClass> videoList,  Activity activity, RecyclerView recyclerView) {
        this.c = c;
        this.videoList = videoList;
        this.activity = activity;
        this.recyclerView = recyclerView;
        itemClickList = (ItemClickList) activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.videolayout,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

         final YouModelClass modelClass = videoList.get(i);
        myViewHolder.length.setText(modelClass.getLength());
        myViewHolder.title.setText(modelClass.getTitle());

        myViewHolder.thumVideio.initialize(YoutubeAdd.getApi_KEY(), new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(modelClass.getVideoId());
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                    @Override
                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                        youTubeThumbnailLoader.release();
                    }

                    @Override
                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                        Toast.makeText(c, "falidto release", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

                Toast.makeText(c, "falied to load", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        YouTubeThumbnailView thumVideio;
        TextView title,length;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            thumVideio = itemView.findViewById(R.id.video_thumbnail_image_view);
            title = itemView.findViewById(R.id.video_title_label);
            length = itemView.findViewById(R.id.video_duration_label);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickList.onItemClick(getAdapterPosition());
                }
            });

        }
    }
}
