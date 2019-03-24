package com.nexus.navkashkrishna.nexusdemo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.utilities.Utilities;
import com.nexus.navkashkrishna.nexusdemo.Modals.Team;
import com.nexus.navkashkrishna.nexusdemo.ProfileActivity;
import com.nexus.navkashkrishna.nexusdemo.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.nexus.navkashkrishna.nexusdemo.ProfileActivity.FIREBASE_REF_USERS;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder>{

    public static final int SQUA_PLACEHOLDER = 1;
    Context context;
    List<Team> mData;
    private FirebaseUser mUser;

    public TeamAdapter(Context context,List<Team> mData){
        this.context=context;
        this.mData=mData;
    }
    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.team_item,parent,false);
        return new TeamAdapter.TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder viewHolder, int i) {
        final Team team = mData.get(i);
//        mUser = FirebaseAuth.getInstance().getCurrentUser();
//        setPicassoImage(context, mUser.getPhotoUrl().toString(), viewHolder.circleImageView, SQUA_PLACEHOLDER);
//        setPicassoImage(context, mData.get(i).getImageSrc(), viewHolder.circleImageView, SQUA_PLACEHOLDER);
        viewHolder.nameTextView.setText(team.getName());
        viewHolder.desgTextView.setText(team.getDesg());
        viewHolder.circleImageView.setImageResource(team.getImage());
        viewHolder.phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+91"+team.getPhone()));
                context.startActivity(intent);
            }
        });
        viewHolder.whatsAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = ""+ FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String url = "https://api.whatsapp.com/send?phone=91" + team.getWhatsApp() + "&text=Hey! I'm "+userName+".";
                intent.setData(Uri.parse(url));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder {
        ImageButton phoneButton,whatsAppButton;
        TextView nameTextView,desgTextView;
        ImageView circleImageView;
        public TeamViewHolder( View itemView) {
            super(itemView);
            phoneButton=itemView.findViewById(R.id.phone_button);
            whatsAppButton=itemView.findViewById(R.id.whatsApp_button);
            nameTextView=itemView.findViewById(R.id.team_name);
            desgTextView=itemView.findViewById(R.id.team_description);
            circleImageView=itemView.findViewById(R.id.team_pic);
        }
    }

    public static void setPicassoImage(final Context context, final String imgSrc, final ImageView iv, final int FLAG){
        if (FLAG == SQUA_PLACEHOLDER){
            Picasso.with(context).load(imgSrc).placeholder(R.drawable.placeholder_square).fit().networkPolicy(NetworkPolicy.OFFLINE).into(iv, new Callback() {
                @Override
                public void onSuccess() {
                }
                @Override
                public void onError() {
                    Picasso.with(context).load(imgSrc).placeholder(R.drawable.placeholder_square).fit().into(iv);
                }
            });
        } else {
            Picasso.with(context).load(imgSrc).placeholder(R.drawable.placeholder_square).fit().networkPolicy(NetworkPolicy.OFFLINE).into(iv, new Callback() {
                @Override
                public void onSuccess() {
                }
                @Override
                public void onError() {
                    Picasso.with(context).load(imgSrc).placeholder(R.drawable.placeholder_square).fit().into(iv);
                }
            });
        }
    }
}
