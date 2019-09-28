package com.ntrllog.lyrical;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);

        List<String> list = new ArrayList<>();
        list.add("Ice Ice Baby - Vanilla Ice");
        list.add("Gold Digger - Kanye West ft. Jamie Foxx");
        list.add("Feels - Calvin Harris ft. Pharrell Williams, Katy Perry, Big Sean");
        list.add("Clique - Kanye West ft. JAY-Z, Big Sean");
        list.add("The Motto - Drake ft. Lil Wayne, Tyga");
        list.add("You Already Know - Fergie ft. Nicki Minaj");
        list.add("Mo Bounce - Iggy Azalea");
        list.add("Wu Tang Forever - Logic");
        list.add("Wu Tang Forever - Ghostface Killah");
        list.add("Wu Tang Forever - Raekwon");
        list.add("Wu Tang Forever - RZA");
        list.add("Wu Tang Forever - Method Man");
        list.add("Wu Tang Forever - Inspectah Deck");
        list.add("Wu Tang Forever - Cappadonna");
        list.add("Wu Tang Forever - Jackpot Scotty Wotty");
        list.add("Wu Tang Forever - U-God");
        list.add("Wu Tang Forever - Masta Killa");
        list.add("Wu Tang Forever - GZA");
        list.add("Wu Tang Forever - Logic ft. Wu Tang Clan");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        CustomOnItemSelectedListener x = new CustomOnItemSelectedListener(getApplicationContext());
        spinner.setOnItemSelectedListener(x);

        ImageButton playButton = findViewById(R.id.play_button);
        x.setPlayButton(playButton);

        ImageButton lyricsButton = findViewById(R.id.lyrics_button);
        lyricsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences whichSong = getSharedPreferences("song", MODE_PRIVATE);
                String songName = whichSong.getString("songName", "iceicebaby");
                Intent lyricsActivity = new Intent(MainActivity.this, LyricsActivity.class);
                lyricsActivity.putExtra("songName", songName);
                startActivity(lyricsActivity);
            }
        });
    }
}
