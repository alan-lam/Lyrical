package com.ntrllog.lyrical;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LyricsActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyrics);

        TextView textView = findViewById(R.id.lyrics_text_view);
        textView.setMovementMethod(new ScrollingMovementMethod());
        String songName = getIntent().getStringExtra("songName");
        textView.setText(getResources().getIdentifier(songName, "string", getPackageName()));

        switch (songName) {
            case "iceicebaby":
                setTitle("Ice Ice Baby");
                break;
            case "golddigger":
                setTitle("Gold Digger");
                break;
            case "feels":
                setTitle("Feels");
                break;
            case "clique":
                setTitle("Clique");
                break;
            case "themotto":
                setTitle("The Motto");
                break;
            case "youalreadyknow":
                setTitle("You Already Know");
                break;
            case "mobounce":
                setTitle("Mo Bounce");
                break;
            case "logic":
                setTitle("Logic");
                break;
            case "ghostfacekillah":
                setTitle("Ghostface Killah");
                break;
            case "raekwon":
                setTitle("Raekwon");
                break;
            case "rza":
                setTitle("RZA");
                break;
            case "methodman":
                setTitle("Method Man");
                break;
            case "inspectahdeck":
                setTitle("Inspectah Deck");
                break;
            case "cappadonna":
                setTitle("Cappadonna");
                break;
            case "jackpotscottywotty":
                setTitle("Jackpot Scotty Wotty");
                break;
            case "ugod":
                setTitle("U-God");
                break;
            case "mastakilla":
                setTitle("Masta Killa");
                break;
            case "gza":
                setTitle("GZA");
                break;
        }
    }
}
