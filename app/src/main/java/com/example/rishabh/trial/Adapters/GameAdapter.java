package com.example.rishabh.trial.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rishabh.trial.POJOs.games;
import com.example.rishabh.trial.R;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by RISHABH on 13-07-2017.
 */

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    Context context;
    ArrayList<games> gamesArrayList;

    public GameAdapter(Context context, ArrayList<games> gamesArrayList) {
        this.context = context;
        this.gamesArrayList = gamesArrayList;
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.games,parent,false);
        return new GameViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        games thisgame = gamesArrayList.get(position);
        holder.game.setText(thisgame.getGame());
        holder.iv.setImageResource(thisgame.getIv());

    }

    @Override
    public int getItemCount() {
        return gamesArrayList.size();
    }

    public class GameViewHolder extends RecyclerView.ViewHolder{
        TextView game;
        ImageView iv;
        public GameViewHolder(View itemView) {
            super(itemView);
            game=(TextView)itemView.findViewById(R.id.game);
            iv=(ImageView)itemView.findViewById(R.id.iv);
        }
    }
}
