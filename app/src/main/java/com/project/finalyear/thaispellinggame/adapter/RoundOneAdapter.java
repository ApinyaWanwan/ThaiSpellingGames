package com.project.finalyear.thaispellinggame.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.finalyear.thaispellinggame.R;
import com.project.finalyear.thaispellinggame.model.RoundOneModel;

import java.util.List;


public class RoundOneAdapter extends RecyclerView.Adapter<RoundOneAdapter.RoundOneViewHolder> {
    private List<RoundOneModel> list;

    public RoundOneAdapter(List<RoundOneModel> list) {
        this.list = list;
    }

    @Override
    public RoundOneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RoundOneViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_round_one, parent, false));

    }

    @Override
    public void onBindViewHolder(final RoundOneViewHolder holder, int position) {
        RoundOneModel roundOne = list.get(position);

        holder.tvCorrectAnswerRoundOne.setText(roundOne.correctAnswer);
        holder.itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                contextMenu.add(holder.getAdapterPosition(), 0,0,"correctAnswer");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RoundOneViewHolder extends RecyclerView.ViewHolder {
        TextView tvCorrectAnswerRoundOne;

        public RoundOneViewHolder(View itemView) {
            super(itemView);
            tvCorrectAnswerRoundOne = itemView.findViewById(R.id.tvCorrectAnswerRoundOne);
        }


    }

}

