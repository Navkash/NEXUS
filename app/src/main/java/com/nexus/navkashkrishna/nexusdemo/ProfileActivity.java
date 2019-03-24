package com.nexus.navkashkrishna.nexusdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Constants;
import com.google.firebase.database.core.utilities.Utilities;
import com.nexus.navkashkrishna.nexusdemo.Adapters.ProfileAdapter;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import static java.security.AccessController.getContext;


public class ProfileActivity extends AppCompatActivity {

    public static final int SQUA_PLACEHOLDER = 1;
    public static final String FIREBASE_REF_USERS = "Users";
    private DatabaseReference userRef;
    private FirebaseUser mUser;
    private RecyclerView recyclerView;
    private Button signout;
    public TextView regno;
    private TextView profileName;
    private CircleImageView circleImageView;ImageView NexusIcon;
    ImageButton profileIcon,notificationIcon;

    private int[] images = {R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp,
            R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp
            , R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp
            , R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp
            , R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp};
    private String[] text = {"Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7", "Person 8",
            "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        signout = (Button) findViewById(R.id.signoutButton);
        circleImageView = (CircleImageView) findViewById(R.id.profile_image);
        profileName=(TextView)findViewById(R.id.profile_name);
//        regno=(TextView)findViewById(R.id.regitration_no);

        mUser = FirebaseAuth.getInstance().getCurrentUser();
        userRef = FirebaseDatabase.getInstance().getReference(FIREBASE_REF_USERS).child(mUser.getUid());
        userRef.keepSynced(true);
        setPicassoImage(ProfileActivity.this, mUser.getPhotoUrl().toString(), circleImageView, SQUA_PLACEHOLDER);
        profileName.setText(mUser.getDisplayName());
//        String uid=mUser.getUid().toString();
//        regno.setText("NXS100"+uid.substring(0, Math.min(uid.length(), 6)));


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });


        NexusIcon = (ImageView) findViewById(R.id.iv_nexus_icon);
        profileIcon = (ImageButton) findViewById(R.id.profile);
        notificationIcon = (ImageButton) findViewById(R.id.notification);

        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent=new Intent(ProfileActivity.this,NotificationActivity.class);
                startActivity(ProfileIntent);
            }
        });

        NexusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent=new Intent(ProfileActivity.this,AboutUsActivity.class);
                startActivity(CompetitionIntent);
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.profile_recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        ProfileAdapter customAdapter = new ProfileAdapter(ProfileActivity.this,images, text);
        recyclerView.setAdapter(customAdapter);


    }

    private void signOut() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(ProfileActivity.this, gso);
        mGoogleSignInClient.signOut();
        FirebaseAuth.getInstance().signOut();
        finish();
        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
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
