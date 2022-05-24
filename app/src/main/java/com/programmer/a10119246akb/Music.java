package com.programmer.a10119246akb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Music extends AppCompatActivity {
    // Tanggal Pengerjaan   : 7 MEI 2022
    // NIM                  : 10119246
    // Nama                 : Ferdi Bayu Febryan
    // Kelas                : IF-6
    Context contextVideo, context;
    RecyclerView recyclerViewVideo, recyclerViewMusic;
    RecyclerView.Adapter recyclerViewAdapterVideo, recyclerViewAdapterMusic;
    RecyclerView.LayoutManager recylerViewLayoutManagerVideo, recylerViewLayoutManagerMusic;
    VideoView videoView;
    String[] subjectValuesVideo = {
            "IU","Stadup"
    };
    String[] subjectUrlVideo;
    String[] subjectValuesMusic = {
            "Stay With Me - Chanyeol",
            "Love beyond words - Khyun",
            "Fiersa Besari - Waktu Yang Salah ",
            "Want to be happy- Park Boram",
            "Rizky Febian - Hingga Tua Bersama",
            "You tender heart hurts me - Davichi",
            "One OK rock - The Begenning",
            "Photograph - Ed Sheeran",
            "Padi - Sesuatu Yang Tak Sama ",
            "Dewa 19 - Risalah Hati ",
            "Krispatih - Demi Cinta",
            "Keripatih - Bila Rasaku ini rasamu",
            "Kerispatih - Lupakan AKu "
};
    DrawerLayout drawerLayout;
@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        subjectUrlVideo=new String[]{
        "android.resource://"+getPackageName()+"/"+R.raw.video,
        "android.resource://"+getPackageName()+"/"+R.raw.video3
        };
        contextVideo=getApplicationContext();
        recyclerViewVideo=findViewById(R.id.recyclerViewVideo);
        recylerViewLayoutManagerVideo=new LinearLayoutManager(this);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewVideo.setLayoutManager(recylerViewLayoutManagerVideo);
        recyclerViewAdapterVideo=new AdapterRecycleViewVideo(subjectValuesVideo,subjectUrlVideo,this);
        recyclerViewVideo.setAdapter(recyclerViewAdapterVideo);

        context=getApplicationContext();
        recyclerViewMusic=findViewById(R.id.recyclerViewMusic);
        recylerViewLayoutManagerMusic=new LinearLayoutManager(context);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewMusic.setLayoutManager(recylerViewLayoutManagerMusic);
        recyclerViewAdapterMusic=new AdapterRecycleViewMusic(subjectValuesMusic,context);
        recyclerViewMusic.setAdapter(recyclerViewAdapterMusic);

        //ass
        drawerLayout=findViewById(R.id.DrawerLayout);
        }
public void ClickMenu(View view){
        //Open drawer
        HomeActivity.openDrawer(drawerLayout);

        }
public void ClickLogo(View view){
        HomeActivity.closeDrawer(drawerLayout);
        }
public void ClickHome(View view){
        //redirect to home
        HomeActivity.redirectActivity(this,HomeActivity.class);
        }
public void ClickGallery(View view){
        //redirect to gallery
        HomeActivity.redirectActivity(this,Gallery.class);
        }

public void ClickDaily(View view){
        //redirect to gallery
        HomeActivity.redirectActivity(this,Daily.class);
        }
public void ClickMusic(View view){

        //recreate
        recreate();
        }
public void ClickProfile(View view){
        //redirect to profile
        HomeActivity.redirectActivity(this,Profile.class);
        }
public void ClickLogout(View view){
        //close
        HomeActivity.logout(this);
        }

@Override
protected void onPause(){
        super.onPause();
        //close drawer
        HomeActivity.closeDrawer(drawerLayout);
        }
        }