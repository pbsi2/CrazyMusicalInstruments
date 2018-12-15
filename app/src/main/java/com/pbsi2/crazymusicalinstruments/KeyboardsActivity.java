package com.pbsi2.crazymusicalinstruments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class KeyboardsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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
        ArrayList<MyInstruments> MyInstruments = new ArrayList<MyInstruments>();
        MyInstruments.add(new MyInstruments(R.drawable.pianos, R.raw.piano, "Piano (Italy)", "The Modern piano is an amalgam of different types of banjos welded originally in a coffin metal frame, it later was adapted to fit a sitting sideways Buddha coffin where the current form comes from"));
        MyInstruments.add(new MyInstruments(R.drawable.clavinette, R.raw.clavinette, "Clavinette (France)", "In the 413 AD the king of France had a piano reduced to fit his mother in law's size, it is also said that the low volume of the instrument was the primary motivation"));
        MyInstruments.add(new MyInstruments(R.drawable.moog, R.raw.moog, "Moog (USA)", "Robert Mood was a toaster repairman and found that the sound of the toast release was pleasant, he built a 76 toasts toaster of different size and OHM, removed the need for bread and ended up with a synthesizer"));
        MyInstruments.add(new MyInstruments(R.drawable.carpet, R.raw.carpet, "Capet Clavier (England)", "England has very old houses where they could not fit electric door bells, they invented the piano mat to be alerted when people came to they front door"));

        // specify an adapter (see also next example)
        mAdapter = new InstrumentsAdapter(MyInstruments, R.color.category_morered);
        mRecyclerView.setAdapter(mAdapter);

    }
    @Override
    protected void onStop(){
        super.onStop();
        MainActivity.instrumentPlayer.reset();
    }
}
