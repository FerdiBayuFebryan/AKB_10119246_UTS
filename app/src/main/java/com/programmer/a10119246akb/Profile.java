package com.programmer.a10119246akb;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Profile extends AppCompatActivity {
    // Tanggal Pengerjaan   : 7 MEI 2022
    // NIM                  : 10119246
    // Nama                 : Ferdi Bayu Febryan
    // Kelas                : IF-6
    Button callme, instagram, location;


    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        instagram = findViewById(R.id.btn_instagram);
//        callme = findViewById(R.id.btn_callme);
//        callme.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                callMe("tel:082115115392");
//            }
//        });
        instagram.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/ferdibayufbryan/");
            }
        });

        location = findViewById(R.id.btn_findme);

        location.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                gotoUrl("https://maps.app.goo.gl/X9x6dUjTMFsHoNLG8");
            }
        });
        //ass
        drawerLayout = findViewById(R.id.DrawerLayout);
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    public void ClickMenu(View view) {
        //Open drawer
        com.programmer.a10119246akb.HomeActivity.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view) {
        com.programmer.a10119246akb.HomeActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view) {
        //redirect to home
        com.programmer.a10119246akb.HomeActivity.redirectActivity(this, com.programmer.a10119246akb.HomeActivity.class);
    }

    public void ClickGallery(View view) {
        //redirect to gallery
        com.programmer.a10119246akb.HomeActivity.redirectActivity(this, Gallery.class);
    }

    public void ClickDaily(View view) {
        //redirect to gallery
        com.programmer.a10119246akb.HomeActivity.redirectActivity(this, com.programmer.a10119246akb.Daily.class);
    }

    public void ClickMusic(View view) {
        //redirect to music
        com.programmer.a10119246akb.HomeActivity.redirectActivity(this, com.programmer.a10119246akb.Music.class);

    }

    public void ClickProfile(View view) {
        //recreate
        recreate();

    }

    public void ClickLogout(View view) {
        //close
        com.programmer.a10119246akb.HomeActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        com.programmer.a10119246akb.HomeActivity.closeDrawer(drawerLayout);
    }

    public void ClickAbout(View view) {
        //redirect to Gallery
        About(this);
    }

    public static void About(final Activity activity) {
        //alert
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("About");
        //set message
        builder.setMessage("dip v0.01 Aplikasi ini berisi Tentang pribadi FerdiBayuFebryan ");

        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //dismiss dialog
                dialog.dismiss();

            }

        });
        //show dialog
        builder.show();
    }

    public void onButtonTap(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ferdi.10119246@mahasiswa.unikom.ac.id"});
        intent.putExtra(Intent.EXTRA_CC, new String[]{""});
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(intent, null));
        } catch (android.content.ActivityNotFoundException ex) {
            //do something else
        }
    }

    public void callClick(View view) {
        Intent intentCall = new Intent(Intent.ACTION_CALL);
        intentCall.setData(Uri.parse("tel:+6282115115392"));
        if (ContextCompat.checkSelfPermission(Profile.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(Profile.this,
                    new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else {
            startActivity(intentCall);
        }
    }
}