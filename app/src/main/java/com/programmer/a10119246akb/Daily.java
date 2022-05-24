package com.programmer.a10119246akb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Daily extends AppCompatActivity {
    // Tanggal Pengerjaan   : 7 MEI 2022
    // NIM                  : 10119246
    // Nama                 : Ferdi Bayu Febryan
    // Kelas                : IF-6
    DrawerLayout drawerLayout;
    Context context, contextFriend;
    RecyclerView recyclerView, recyclerViewFriend;
    RecyclerView.Adapter recyclerViewAdapter, recyclerViewAdapterFriend;
    RecyclerView.LayoutManager recylerViewLayoutManager,recylerViewLayoutManageFriend;
    String[] subjects = {
            "BangunTidur", "Mandi", "Minum Coffe", "Mendengarkan Musik", "Kuliah", "Work Driver Shopefood",
            "Pulang", "Besih-bersih","Belajar Desgn" ,"Sleep"
    };
    int[] subjectImage ={
            R.drawable.ic_bangun,R.drawable.ic_mandi,
            R.drawable.ic_coffe,R.drawable.ic_music,
            R.drawable.ic_kuliah,R.drawable.ic_shope,
            R.drawable.ic_pulang,R.drawable.ic_mandi,
            R.drawable.ic_book,R.drawable.ic_kasur,
    };
    String[] subjectsName = {
            "Widia", "Haul", "Badra"
    };
    int[] subjectImageFriend ={
            R.drawable.widia3,R.drawable.haul1,
            R.drawable.badra2
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        context = getApplicationContext();
        recyclerView = findViewById(R.id.recyclerView);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new com.programmer.a10119246akb.AdapterRecyclerView(subjects, subjectImage,context );
        recyclerView.setAdapter(recyclerViewAdapter);

        contextFriend = getApplicationContext();
        recyclerViewFriend = findViewById(R.id.recyclerViewFriend);
        recylerViewLayoutManageFriend = new LinearLayoutManager(contextFriend,LinearLayoutManager.HORIZONTAL,false);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewFriend.setLayoutManager(recylerViewLayoutManageFriend);
        recyclerViewAdapterFriend = new com.programmer.a10119246akb.AdapterRecyclerViewFriend(subjectsName, subjectImageFriend,contextFriend );
        recyclerViewFriend.setAdapter(recyclerViewAdapterFriend);



        drawerLayout = findViewById(R.id.DrawerLayout);
    }
    public void ClickMenu(View view){
        //Open drawer
        com.programmer.a10119246akb.HomeActivity.openDrawer(drawerLayout);

    }
    public void ClickLogo(View view){
        com.programmer.a10119246akb.HomeActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        //redirect to home
        com.programmer.a10119246akb.HomeActivity.redirectActivity(this, com.programmer.a10119246akb.HomeActivity.class);
    }
    public void ClickDaily(View view){
        //recreate
        recreate();
    }

    public void ClickGallery(View view){
        //redirect to gallery
        com.programmer.a10119246akb.HomeActivity.redirectActivity(this,Gallery.class);
    }
    public void ClickMusic(View view){
        //redirect to music
        com.programmer.a10119246akb.HomeActivity.redirectActivity(this, com.programmer.a10119246akb.Music.class);
    }
    public void ClickProfile(View view){
        //redirect to profile
        com.programmer.a10119246akb.HomeActivity.redirectActivity(this,Profile.class);
    }
    public void ClickLogout(View view){
        //close
        com.programmer.a10119246akb.HomeActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        com.programmer.a10119246akb.HomeActivity.closeDrawer(drawerLayout);
    }
}