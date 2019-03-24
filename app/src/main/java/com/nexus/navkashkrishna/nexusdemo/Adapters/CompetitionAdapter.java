package com.nexus.navkashkrishna.nexusdemo.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nexus.navkashkrishna.nexusdemo.AboutUsActivity;
import com.nexus.navkashkrishna.nexusdemo.MainpageActivity;
import com.nexus.navkashkrishna.nexusdemo.R;
import com.nexus.navkashkrishna.nexusdemo.SubCompetitionActivity;
import com.nexus.navkashkrishna.nexusdemo.TeamActivity;

import java.util.ArrayList;

public class CompetitionAdapter extends RecyclerView.Adapter<CompetitionAdapter.CompetitionViewHolder> {
    private ArrayList competitionNames;
    private ArrayList competitionImages;
    private Context context;

    public CompetitionAdapter( Context context, ArrayList competitionNames, ArrayList competitionImages) {
        this.context = context;
        this.competitionNames = competitionNames;
        this.competitionImages = competitionImages;
    }

    @Override
    public CompetitionViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // infalte the item Layout
        context =viewGroup.getContext();
        int layoutIdForListItem = R.layout.competition_grid_item;
        View view =LayoutInflater.from(context).inflate(layoutIdForListItem, viewGroup, false);
        return new CompetitionViewHolder(view);
    }

//    @Override
    @Override
    public void onBindViewHolder(CompetitionViewHolder holder, final int position) {
        // set the data in items
        holder.nameTextView.setText(competitionNames.get(position).toString());
        holder.imageTextView.setImageResource(competitionImages.get(position).hashCode());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent=new Intent(context,SubCompetitionActivity.class);
                    intent.putExtra("title",""+competitionNames.get(position));
                    context.startActivity(intent);

            }
        });
    }

    //    }
    @Override
    public int getItemCount() {
        if (null == competitionNames) return 0;
        return competitionNames.size();
    }


    public class CompetitionViewHolder extends RecyclerView.ViewHolder{
        public final TextView nameTextView;
        public final ImageView imageTextView;

        public CompetitionViewHolder(View view) {
            super(view);
            nameTextView = (TextView) view.findViewById(R.id.name);
            imageTextView = (ImageView) view.findViewById(R.id.image);
        }

    }
}
