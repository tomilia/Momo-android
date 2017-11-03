package com.example.tommylee.myapplication;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tommylee on 1/11/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private ArrayList<DataFetch> mDataset;
    private Context context;

    public MainAdapter(Context context,ArrayList<DataFetch> mDataset) {
        this.context=context;this.mDataset = mDataset;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int ViewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
}
@Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position){
    holder.mTitle.setText(mDataset.get(position).getDescription());
}
@Override
    public int getItemCount(){
    return mDataset.size();
}
    @Override
    public int getItemViewType(int position) {
        Log.d("cheees",String.valueOf(super.getItemViewType(position)));
        return super.getItemViewType(position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitle=itemView.findViewById(R.id.recycler_title);
        }
    }
}
