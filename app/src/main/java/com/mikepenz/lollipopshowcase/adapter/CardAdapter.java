package com.mikepenz.lollipopshowcase.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.lollipopshowcase.MainActivity;
import com.mikepenz.lollipopshowcase.R;
import com.mikepenz.lollipopshowcase.entity.CardInfo;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<CardInfo> cards;
    private int rowLayout;
    private MainActivity mAct;

    public CardAdapter(List<CardInfo> cards, int rowLayout, MainActivity act) {
        this.cards = cards;
        this.rowLayout = rowLayout;
        this.mAct = act;
    }


    public void clearCards() {
        int size = this.cards.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                cards.remove(0);
            }
            this.notifyItemRangeRemoved(0, size);
        }
    }

    public void addCards(List<CardInfo> cards) {
        this.cards.addAll(cards);
        this.notifyItemRangeInserted(0, cards.size() - 1);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final CardInfo cardInfo = cards.get(i);
        viewHolder.name.setText(cardInfo.getName());
        viewHolder.image.setImageDrawable(cardInfo.getIcon());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAct.animateActivity(cardInfo, viewHolder.image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cards == null ? 0 : cards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.countryName);
            image = (ImageView) itemView.findViewById(R.id.countryImage);
        }

    }
}
