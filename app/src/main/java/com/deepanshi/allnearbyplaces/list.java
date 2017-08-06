package com.deepanshi.allnearbyplaces;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Deepanshi Bansal on 06-08-2017.
 */

public class list extends RecyclerView.Adapter<list.CardViewHolder> {
int number;
//    public list(int num){
//        number=num;
//    }
    @Override
    public list.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout linearLayout=(LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        CardViewHolder cv= new CardViewHolder(linearLayout);
        return cv;
    }
    @Override
    public void onBindViewHolder(list.CardViewHolder holder, int position) {
    holder.setText(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        TextView name,address,distance,type;
        public CardViewHolder(LinearLayout itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            address=(TextView)itemView.findViewById(R.id.address);
            distance=(TextView)itemView.findViewById(R.id.distance);
            type=(TextView)itemView.findViewById(R.id.type);

        }
        public void setText(int pos){

            name.setText("deepanshi"+pos);
            address.setText("deepali"+pos);
            type.setText("public");
            distance.setText(2+pos+"km");
        }
    }
}
