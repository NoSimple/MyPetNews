package com.example.mypetnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mypetnews.R;
import com.example.mypetnews.listener.ClickListener;
import com.example.mypetnews.viewmodel.StoryListItemViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public final class FrontPageListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<StoryListItemViewModel> mDataset;
    private final ClickListener mClickListener;
    private Context mContext;

    public FrontPageListAdapter(List<StoryListItemViewModel> myDataset, ClickListener clickListener) {
        mDataset = myDataset;
        mClickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        RelativeLayout v = (RelativeLayout) LayoutInflater.from(mContext)
                .inflate(R.layout.item_story_list, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StoryListItemViewModel item = mDataset.get(position);

        TextView scoreText = (TextView) holder.mView.findViewById(R.id.score);
        TextView domainText = (TextView) holder.mView.findViewById(R.id.domain);
        TextView titleText = (TextView) holder.mView.findViewById(R.id.title);
        TextView commentCountText = (TextView) holder.mView.findViewById(R.id.commentCount);
        TextView relativeTimeText = (TextView) holder.mView.findViewById(R.id.relativeTime);
        ImageView featureImage = (ImageView) holder.mView.findViewById(R.id.featureImage);

        holder.setClickListener(mClickListener);

        scoreText.setText(item.getScore());
        domainText.setText(item.getDomain());
        titleText.setText(item.getTitle());
        commentCountText.setText(item.getCommentCount());
        relativeTimeText.setText(item.getRelativeTime());

        Picasso.get()
                .load("https://logo.clearbit.com/" + item.getDomain() + "?size=256&format=png")
                .resize(128, 128)
                .centerCrop()
                .into(featureImage);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}