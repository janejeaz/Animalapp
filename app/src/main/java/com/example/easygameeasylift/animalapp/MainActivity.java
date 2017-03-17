package com.example.easygameeasylift.animalapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //array ที่เก็บ reference ของ Imageview (รูปสัตว์ ทั้ง 9)
    private final ImageView imageAnimals[] = new ImageView[9];
    //object MediaPlayer ที่ใช้เล่นไฟล์เสียง
    private MediaPlayer mPlayer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ค้นหา ImageView ต่างๆ จาก Layout Fine แล้วเก็บการอ้างอิงลง Array
        imageAnimals[0] = (ImageView) findViewById(R.id.imgBs);
        imageAnimals[1] = (ImageView) findViewById(R.id.imgCt);
        imageAnimals[2] = (ImageView) findViewById(R.id.imgCw);
        imageAnimals[3] = (ImageView) findViewById(R.id.imgdg);
        imageAnimals[4] = (ImageView) findViewById(R.id.imgHr);
        imageAnimals[5] = (ImageView) findViewById(R.id.imgPg);
        imageAnimals[6] = (ImageView) findViewById(R.id.imgRn);
        imageAnimals[7] = (ImageView) findViewById(R.id.imgTg);
        imageAnimals[8] = (ImageView) findViewById(R.id.imgGt);

        for (int i = 0; i < imageAnimals.length; i++) {
            imageAnimals[i].setOnClickListener(this);
        }
    }
    public void onClick(View v) {
        int resID = 0;

        switch (v.getId()) {
            case R.id.imgBs:
                resID = R.raw.sheep;
                break;
            case R.id.imgCt:
                resID = R.raw.cat;//แก้ไขให้ตรงกับไฟล์ของเรา
                break;
            case R.id.imgTg:
                resID = R.raw.tiger; //แก้ไขให้ตรงกับไฟล์ของเรา
                break;
            default:
                resID = R.raw.nope; //แก้ไขให้ตรงกับไฟล์ของเรา
                break;
        }
        playSound(resID);

    }

    private void playSound(int id) {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }

        //สร้าง object MediaPlayer เพื่อเล่นเสียงตาม Resource ID ที่ระบุ
        mPlayer = MediaPlayer.create(this, id);
        mPlayer.start();
    }


}