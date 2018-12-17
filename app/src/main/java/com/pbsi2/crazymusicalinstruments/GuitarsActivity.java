package com.pbsi2.crazymusicalinstruments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class GuitarsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    final MediaPlayer instrumentPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instruments_layout);
        mRecyclerView = findViewById(R.id.instrumentsview);
        // Setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // For LINEAR
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        // For a GRID
        //mLayoutManager = new GridLayoutManager(this,5);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ArrayList<MyInstruments> MyInstrumentsg = new ArrayList<>();

        MyInstrumentsg.add(new MyInstruments(R.drawable.guitars, R.raw.doctor_turtle_beaconsfield_villas_stomp_guitar, "Guitar (Spain)", "Guitar evolves from Oud and the Luth, it became popular in Spain after people realized that bull fight was a dangerous hobby"));
        MyInstrumentsg.add(new MyInstruments(R.drawable.oud, R.raw.sherita_oud, "Oud (Iran)", "In the 200 century BC it was the main instrument in the Persian civilisation"));
        MyInstrumentsg.add(new MyInstruments(R.drawable.kora, R.raw.andrew_oliver_kora, "Kora (Sahel)", "Derived from the Oud as it migrated into the northern African continent"));
        MyInstrumentsg.add(new MyInstruments(R.drawable.koto, R.raw.etsuko_chida_omoigawa_koto, "Koto (Japan)", "The Koto is the instrument that used to be played on mont Fiji eruptions' day only"));
       // specify an adapter (see also next example)
        mAdapter = new InstrumentsAdapter(MyInstrumentsg, R.color.category_midred);
        mRecyclerView.setAdapter(mAdapter);

    }
    @Override
    protected void onStop(){
        super.onStop();
        MainActivity.instrumentPlayer.reset();
    }
}
