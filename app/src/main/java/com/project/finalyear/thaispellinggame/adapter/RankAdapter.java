package com.project.finalyear.thaispellinggame.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.finalyear.thaispellinggame.R;
import com.project.finalyear.thaispellinggame.model.RankModel;
import com.project.finalyear.thaispellinggame.model.RoundOneModel;

import java.util.List;

public class RankAdapter extends RecyclerView.Adapter <RankAdapter.RankViewHolder>{
    private List<RankModel> list;

    public RankAdapter(List<RankModel> list) {
        this.list = list;
    }

    @Override
    public RankViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rank, parent, false));

    }

    @Override
    public void onBindViewHolder(final RankViewHolder holder, int position) {
        RankModel rankModel = list.get(position);
        holder.tvName.setText(rankModel.name);
        holder.tvLevel.setText(rankModel.level);
        holder.tvScore.setText(rankModel.score);
        holder.tvRank.setText(rankModel.rank);
        holder.itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                contextMenu.add(holder.getAdapterPosition(), 0, 0, "name");
                contextMenu.add(holder.getAdapterPosition(), 1, 1, "rank");
                contextMenu.add(holder.getAdapterPosition(), 2, 2, "level");
                contextMenu.add(holder.getAdapterPosition(), 3, 3, "score");
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RankViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvScore;
        TextView tvLevel;
        TextView tvRank;

        public RankViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvScore = (TextView) itemView.findViewById(R.id.tvScore);
            tvLevel = (TextView) itemView.findViewById(R.id.tvLevel);
            tvRank = (TextView) itemView.findViewById(R.id.tvRank);
        }
    }


}
