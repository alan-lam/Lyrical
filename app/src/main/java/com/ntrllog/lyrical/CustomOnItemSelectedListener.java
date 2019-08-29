package com.ntrllog.lyrical;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    private ImageButton playButton;
    private Context context;
    private MediaPlayer mediaPlayer;

    private Song[] songArray = {
            new Song("iceicebaby", R.raw.iceicebaby),
            new Song("golddigger", R.raw.golddigger),
            new Song("feels", R.raw.feels),
            new Song("clique", R.raw.clique),
            new Song("themotto", R.raw.themotto),
            new Song("youalreadyknow", R.raw.youalreadyknow),
            new Song("mobounce", R.raw.mobounce),
            new Song("logic", R.raw.logic),
            new Song("ghostfacekillah", R.raw.ghostfacekillah),
            new Song("raekwon", R.raw.raekwon),
            new Song("rza", R.raw.rza),
            new Song("methodman", R.raw.methodman),
            new Song("inspectahdeck", R.raw.inspectahdeck),
            new Song("cappadonna", R.raw.cappadonna),
            new Song("jackpotscottywotty", R.raw.jackpotscottywotty),
            new Song("ugod", R.raw.ugod),
            new Song("mastakilla", R.raw.mastakilla),
            new Song("gza", R.raw.gza) };

    public CustomOnItemSelectedListener(Context c) {
        this.context = c;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
        final Uri mediaPath = Uri.parse("android.resource://" + context.getPackageName() + "/" + songArray[position].getResource());

        final ImageButton playButton = this.playButton;
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* media player will be null after releasing */
                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                    /* change back to play button after audio is done */
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                            playButton.setImageResource(R.drawable.ic_play_arrow_black_100dp);
                        }
                    });
                }
                /* if user presses stop */
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    playButton.setImageResource(R.drawable.ic_play_arrow_black_100dp);
                    releaseMediaPlayer();
                }
                /* if user presses play */
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

        /* used for choosing which lyrics to show */
        SharedPreferences whichSong = this.context.getSharedPreferences("song", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = whichSong.edit();
        editor.putString("songName", songArray[position].getName());
        editor.commit();
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
