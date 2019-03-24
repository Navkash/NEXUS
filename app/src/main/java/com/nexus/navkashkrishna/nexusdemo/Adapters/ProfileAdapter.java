package com.nexus.navkashkrishna.nexusdemo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nexus.navkashkrishna.nexusdemo.MainActivity;
import com.nexus.navkashkrishna.nexusdemo.MainpageActivity;
import com.nexus.navkashkrishna.nexusdemo.ProfileActivity;
import com.nexus.navkashkrishna.nexusdemo.R;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ImageViewHolder> {

    private Context context;
    private int images[];
    private String text[];
    public ProfileAdapter(Context context, int[] images, String[] text){
        this.context=context;
        this.images=images;
        this.text=text;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_grid_item,parent,false);
        return new ImageViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ImageViewHolder viewHolder, final int position) {
        int image_id=images[position];
        String text_id=text[position];
        viewHolder.imageView.setImageResource(image_id);
        viewHolder.textView.setText(text_id);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(context,MainpageActivity.class);
                        context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ImageViewHolder( View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.rv_profile_image);
            textView=itemView.findViewById(R.id.rv_profile_name);
        }
    }
}
