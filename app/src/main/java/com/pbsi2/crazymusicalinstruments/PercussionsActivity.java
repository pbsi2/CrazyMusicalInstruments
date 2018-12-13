package com.pbsi2.crazymusicalinstruments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class PercussionsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instruments_layout);
        mRecyclerView = findViewById(R.id.instrumentsview);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // For LINEAR
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        // For a GRID
        //mLayoutManager = new GridLayoutManager(this,5);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ArrayList<MyInstruments> MyInstruments = new ArrayList<MyInstruments>();
        MyInstruments.add(new MyInstruments(R.drawable.drum, R.raw.drums, "Drum Set (USA)", "The Modern drum set is an amalgam of different type of drum adapted from many cultures"));
        MyInstruments.add(new MyInstruments(R.drawable.djembe, R.raw.djembes, "Djembe (Mali)", "In the 1200 century the Djembe became the main instrument in Central Africa"));
        MyInstruments.add(new MyInstruments(R.drawable.glockenspiel, R.raw.glockenspiel, "Glokenspiel (Liechtenstein)", "Alps Mmotains are a place where pianos did not fair well, so musicians there hammered flat different spoons in a keyboard key shape to make music"));
        MyInstruments.add(new MyInstruments(R.drawable.conga, R.raw.conga, "Conga (Antigua and Barbuda)", "The Conga originally came from the Antiguo and the Barbudo villages and was modified by slaves when they arrived the the Americas where they changed the Os for As"));

        // specify an adapter (see also next example)
        mAdapter = new InstrumentsAdapter(MyInstruments, R.color.category_red );
        mRecyclerView.setAdapter(mAdapter);

    }
}
