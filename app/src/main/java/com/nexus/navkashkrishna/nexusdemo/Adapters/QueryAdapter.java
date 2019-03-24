package com.nexus.navkashkrishna.nexusdemo.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.nexus.navkashkrishna.nexusdemo.Modals.TitleChild;
import com.nexus.navkashkrishna.nexusdemo.Modals.TitleParent;
import com.nexus.navkashkrishna.nexusdemo.R;
import com.nexus.navkashkrishna.nexusdemo.Utils.TitleChildViewHolder;
import com.nexus.navkashkrishna.nexusdemo.Utils.TitleParentViewHolder;

import java.util.List;

public class QueryAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder,TitleChildViewHolder> {

    LayoutInflater inflater;
    Context context;

    public QueryAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view=inflater.inflate(R.layout.query_parent_layout,viewGroup,false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view=inflater.inflate(R.layout.query_child_layout,viewGroup,false);

        return new TitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent title = (TitleParent)o;
        titleParentViewHolder._textView.setText(title.getTitle());

    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChildViewHolder, int i, Object o) {
        TitleChild title=(TitleChild)o;
        titleChildViewHolder.option1.setText(title.getOption1());
    }
}
