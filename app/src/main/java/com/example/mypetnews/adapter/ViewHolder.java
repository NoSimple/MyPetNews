package com.example.mypetnews.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mypetnews.listener.ClickListener;

public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public final View mView;
    private ClickListener clickListener;

    public ViewHolder(View v) {
        super(v);
        mView = v;
        v.setOnClickListener(this);
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void onClick(View v) {
        clickListener.onClick(v, getAdapterPosition(), false);
    }
}