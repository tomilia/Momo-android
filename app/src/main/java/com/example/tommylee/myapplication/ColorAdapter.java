package com.example.tommylee.myapplication;

/**
 * Created by tommylee on 3/11/2017.
 */

        import android.content.Context;
        import android.graphics.Color;
        import android.service.autofill.Dataset;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.Random;


public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder>{
    private ArrayList<DataFetch> mDataSet;
    private Context mContext;
    private Random mRandom = new Random();

    public ColorAdapter(Context context,ArrayList<DataFetch> DataSet){
        mDataSet = DataSet;
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ViewHolder(View v){
            super(v);
            mTextView = (TextView)v.findViewById(R.id.tv);
        }
    }

    @Override
    public ColorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // Create a new View
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_view,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.mTextView.setText(mDataSet.get(position).getDescription());
        // Set a random height for TextView
      switch(position) {
          case 0:holder.mTextView.getLayoutParams().height = 450;
              break;
          case 1:holder.mTextView.getLayoutParams().height = 260;
              break;
          case 2:holder.mTextView.getLayoutParams().height = 180;
              break;
      }
        // Set a random color for TextView background
        holder.mTextView.setBackgroundColor(getRandomHSVColor());
    }

    @Override
    public int getItemCount(){
        return mDataSet.size();
    }

    // Custom method to get a random number between a range
    protected int getRandomIntInRange(int max, int min){
        return mRandom.nextInt((max-min)+min)+min;
    }

    // Custom method to generate random HSV color
    protected int getRandomHSVColor(){
        // Generate a random hue value between 0 to 360
        int hue = mRandom.nextInt(361);
        // We make the color depth full
        float saturation = 1.0f;
        // We make a full bright color
        float value = 1.0f;
        // We avoid color transparency
        int alpha = 255;
        // Finally, generate the color
        int color = Color.HSVToColor(alpha, new float[]{hue, saturation, value});
        // Return the color
        return color;
    }
}