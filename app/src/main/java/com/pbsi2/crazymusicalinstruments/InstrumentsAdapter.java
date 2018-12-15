package com.pbsi2.crazymusicalinstruments;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class InstrumentsAdapter extends RecyclerView.Adapter<InstrumentsAdapter.MyViewHolder> {
    public ArrayList<MyInstruments> instrumentsArrayList;
    private int background;
    MediaPlayer myAudio = MainActivity.instrumentPlayer;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout mLinearLayout;

        public MyViewHolder(LinearLayout v) {
            super(v);
            mLinearLayout = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public InstrumentsAdapter(ArrayList<MyInstruments> guitarPluck, int color) {
        instrumentsArrayList = guitarPluck;
        background = color;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public InstrumentsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout ll = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.single_recycler, parent, false);
        return new MyViewHolder(ll);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //MediaPlayer myAudio = MainActivity.instrumentPlayer;
        LinearLayout linearLayout = holder.mLinearLayout;
        LinearLayout textLayout = linearLayout.findViewById(R.id.textsLayout);
        textLayout.setBackgroundColor(ContextCompat.getColor(textLayout.getContext(), background));
        ImageView imageview = linearLayout.findViewById(R.id.imageView);
        Drawable drawable = ContextCompat.getDrawable(linearLayout.getContext(), instrumentsArrayList.get(position).getImageId());
        if (instrumentsArrayList.get(position).hasImage()) {
            imageview.setImageDrawable(drawable);
            imageview.setVisibility(View.VISIBLE);
        } else {
            imageview.setVisibility(View.GONE);
        }

        imageview.setContentDescription(instrumentsArrayList.get(position).getDescription());
        TextView dtextView = linearLayout.findViewById(R.id.defaultView);
        dtextView.setText(instrumentsArrayList.get(position).getDescription());
        TextView mtextView = linearLayout.findViewById(R.id.otherView);
        mtextView.setText(instrumentsArrayList.get(position).getCountry());
        ImageButton mRewButton = linearLayout.findViewById(R.id.rewButton);
        mRewButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            //MediaPlayer myAudio = MainActivity.instrumentPlayer;
            @Override
            public void onClick(View view) {
                myAudio.seekTo(0);
            }
        });
        ImageButton mPlayButton = linearLayout.findViewById(R.id.playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            //MediaPlayer myAudio = MainActivity.instrumentPlayer;
            @Override
            public void onClick(View view) {

                myAudio.stop();
                myAudio.reset();

                try {
                    Uri myUri = Uri.parse("android.resource://com.pbsi2.crazymusicalinstruments/" + instrumentsArrayList.get(position).getSoundId());
                    myAudio.setDataSource(view.getContext(), myUri);
                    myAudio.prepare();
                    myAudio.start();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                //MainActivity.instrumentPlayer.stop();
                //MainActivity.instrumentPlayer.create(linearLayout.getContext(), instrumentsArrayList.get(position).getSoundId());

                //MainActivity.instrumentPlayer.stop();
                //MainActivity.instrumentPlayer.create(linearLayout.getContext(), instrumentsArrayList.get(position).getSoundId());


            }

        });
        ImageButton mStopButton = linearLayout.findViewById(R.id.stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            //MediaPlayer myAudio = MainActivity.instrumentPlayer;
            @Override
            public void onClick(View view) {
                myAudio.reset();
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return instrumentsArrayList.size();
    }
}