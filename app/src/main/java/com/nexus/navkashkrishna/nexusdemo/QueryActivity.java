package com.nexus.navkashkrishna.nexusdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nexus.navkashkrishna.nexusdemo.Adapters.QueryAdapter;
import com.nexus.navkashkrishna.nexusdemo.Adapters.TeamAdapter;
import com.nexus.navkashkrishna.nexusdemo.Modals.QueryModal;
import com.nexus.navkashkrishna.nexusdemo.Modals.TitleChild;
import com.nexus.navkashkrishna.nexusdemo.Modals.TitleCreater;
import com.nexus.navkashkrishna.nexusdemo.Modals.TitleParent;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class QueryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    QueryAdapter adapter;
    DatabaseReference ref;
    public static ArrayList<QueryModal> data;
    ProgressDialog p;
    ImageView NexusIcon;
    ImageButton profileIcon,notificationIcon;
    boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        recyclerView=(RecyclerView)findViewById(R.id.myRecyclerView);

        NexusIcon = (ImageView) findViewById(R.id.iv_nexus_icon);
        profileIcon = (ImageButton) findViewById(R.id.profile);
        notificationIcon = (ImageButton) findViewById(R.id.notification);

        NexusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent = new Intent(QueryActivity.this, AboutUsActivity.class);
                startActivity(CompetitionIntent);
            }
        });

        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent=new Intent(QueryActivity.this,NotificationActivity.class);
                startActivity(ProfileIntent);
            }
        });

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent = new Intent(QueryActivity.this, ProfileActivity.class);
                startActivity(ProfileIntent);
            }
        });


//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        data=new ArrayList<>();
        data.add(new QueryModal("What is Nexus","Nexus, the annual Techno-Management fest of SECE. It will span for 3 days: March somethig . The spirit of Nexus lies in encouraging sound practice, making precision engineering a way of life,effectively bringing about a paradigm shift from classroom to path-breaking innovation"));
        data.add(new QueryModal("What are the types of events in Nexus?","Nexus is a plethara of many events. It includes branch events ,gaming events,formal events,fun events,etc"));
        data.add(new QueryModal("Are there any online events","Yes,there will be online events. For details of the online events stay updated to our facebook page."));
        data.add(new QueryModal("What about the accommodation?","Accomodation will be provided for the students in the collage hostel."));
        data.add(new QueryModal("Will participation certificate be given for events","Yes, we do give participation certificate for the registered candidates"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
//        ref= FirebaseDatabase.getInstance().getReference().child("Faq");
//        ref.keepSynced(true);
//        p=new ProgressDialog(this);
//        p.setMessage("Loading Querys....");
//        p.setCancelable(false);
//        p.show();
//
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //Toast.makeText(FAQActivity.this,"fetched"+dataSnapshot.getChildrenCount(),Toast.LENGTH_SHORT).show();
//                p.dismiss();
//                data.clear();
//                if (dataSnapshot.exists()){
//                    try {
//                        for(DataSnapshot ds: dataSnapshot.getChildren())
//                        {
//
//                            // Toast.makeText(FAQActivity.this,"Q"+q.getQuestion()+"\nA:"+q.getAns(),Toast.LENGTH_SHORT).show();
//
//                        }
//
//                        adapter = new QueryAdapter(QueryActivity.this,initData());
//                        adapter.setParentClickableViewAnimationDefaultDuration();
//                        adapter.setParentAndIconExpandOnClick(true);
//                        recyclerView.setAdapter(adapter);
//
//                    } catch (Exception e){
//
//                    }
//                }
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        adapter=new QueryAdapter(QueryActivity.this,initData());
        recyclerView.setAdapter(adapter);

    }

//    public void change_image(View v)
//    {
//        ImageView iv=(ImageView)findViewById(R.id.arrow);
//        //use flag to change image
//        if(flag==true)
//        {
//            iv.setImageResource(R.drawable.up_arrow);
//            flag=true;
//        }
//        else
//        {
//            iv.setImageResource(R.drawable.down_arrow);
//            flag=false;
//        }
//    }

    private List<ParentObject> initData() {
        TitleCreater titleCreater= new TitleCreater(QueryActivity.this);
        //titleCreater= TitleCreater.get(this);
        List<TitleParent> titles=TitleCreater._titleParents;
        List<ParentObject> parentObject = new ArrayList<>();
        // Toast.makeText(FAQActivity.this,"Title:"+titles.size(),Toast.LENGTH_SHORT).show();
        int i=0;
        for(TitleParent title:titles)
        {
            List<Object> childList = new ArrayList<>();
            //childList.add(new TitleChild(("It is LSE web style to title a page of FAQs 'Frequently asked questions (FAQs)'. While the abbreviation is in quite common usage this ensures that there can be no mistaking what they are")));
            childList.add(new TitleChild(data.get(i++).getAns()));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        return parentObject;
    }
}
