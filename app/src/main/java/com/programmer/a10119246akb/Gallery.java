package com.programmer.a10119246akb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Gallery extends AppCompatActivity {
    // Tanggal Pengerjaan   : 7 MEI 2022
    // NIM                  : 10119246
    // Nama                 : Ferdi Bayu Febryan
    // Kelas                : IF-6
    Context contextGallery;
    RecyclerView recyclerViewGallery;
    RecyclerView.Adapter recyclerViewAdapterGallery;
    RecyclerView.LayoutManager recylerViewLayoutManagerGallery;
    String[] subjectsGallery = {
            "Poto1", "Poto2", "Poto3","Poto4", "Poto5", "Poto6","Poto7", "Poto8", "Poto9"
    };
    int[] subjectImageGallery={
            R.drawable.galery1,R.drawable.galery2,
            R.drawable.galery3,

            R.drawable.galery4,R.drawable.galery5,
            R.drawable.galery6,

            R.drawable.galery7,R.drawable.galery8,
            R.drawable.galery9
    };
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery);
        contextGallery = getApplicationContext();
        recyclerViewGallery = findViewById(R.id.recyclerViewGallery);
        recylerViewLayoutManagerGallery = new GridLayoutManager( contextGallery, 2);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewGallery.setLayoutManager(recylerViewLayoutManagerGallery);
        recyclerViewAdapterGallery = new com.programmer.a10119246akb.AdapterRecyclerViewGallery(subjectsGallery, subjectImageGallery,contextGallery );
        recyclerViewGallery.setAdapter(recyclerViewAdapterGallery);
        //ass
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
    public void ClickGallery(View view){
        //recreate
        recreate();
    }

    public void ClickDaily(View view){
        //redirect to gallery
        com.programmer.a10119246akb.HomeActivity.redirectActivity(this, com.programmer.a10119246akb.Daily.class);
    }
    public void ClickMusic(View view){
        //redirect to music
        com.programmer.a10119246akb.HomeActivity.redirectActivity(this, com.programmer.a10119246akb.Music.class);
    }
    public void ClickProfile(View view){
        //redirect to profile
        com.programmer.a10119246akb.HomeActivity.redirectActivity(this, com.programmer.a10119246akb.Profile.class);
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