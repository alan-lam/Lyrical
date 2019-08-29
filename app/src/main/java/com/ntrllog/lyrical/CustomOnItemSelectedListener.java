package com.ntrllog.lyrical;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    private ImageButton playButton;
    private Context context;
    private MediaPlayer mediaPlayer;

    private int[] songResources = { R.raw.iceicebaby,
            R.raw.golddigger,
            R.raw.feels,
            R.raw.clique,
            R.raw.themotto,
            R.raw.youalreadyknow,
            R.raw.mobounce,
            R.raw.logic,
            R.raw.ghostfacekillah,
            R.raw.raekwon,
            R.raw.rza,
            R.raw.methodman,
            R.raw.inspectahdeck,
            R.raw.cappadonna,
            R.raw.jackpotscottywotty,
            R.raw.ugod,
            R.raw.mastakilla,
            R.raw.gza };

    public CustomOnItemSelectedListener(Context c) {
        this.context = c;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
        final Uri mediaPath = Uri.parse("android.resource://" + context.getPackageName() + "/" + songResources[position]);

        final ImageButton playButton = this.playButton;
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                            playButton.setImageResource(R.drawable.ic_play_arrow_black_100dp);
                        }
                    });
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    playButton.setImageResource(R.drawable.ic_play_arrow_black_100dp);
                    releaseMediaPlayer();
                }
                else {
                    try {
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(context, mediaPath);
                        mediaPlayer.prepare();
                    }
                    catch (Exception e) {}
                    mediaPlayer.start();
                    playButton.setImageResource(R.drawable.ic_stop_black_100dp);
                }
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void setPlayButton(ImageButton b) {
        this.playButton = b;
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
