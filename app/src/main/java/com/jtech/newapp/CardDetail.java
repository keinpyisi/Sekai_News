package com.jtech.newapp;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jtech.newapp.utils.DatabaseHelper;

import java.util.ArrayList;

public class CardDetail extends AppCompatActivity {
    private ImageView image;
    private TextView intro , general,work,love,finances,health,spirit,title;
    DatabaseHelper myDbHelper;
    ArrayList<String> data;
    private int[] card= {
            R.drawable.fool,R.drawable.magician,R.drawable.priestress,R.drawable.empress,
            R.drawable.emperor,R.drawable.hierophant,R.drawable.lovers,R.drawable.chariot,
            R.drawable.justice,R.drawable.hermit,R.drawable.fortune,R.drawable.strength,R.drawable.hangedmen,
            R.drawable.death,R.drawable.temperance,R.drawable.tower,R.drawable.devil,R.drawable.star,R.drawable.moon,R.drawable.sun
            ,R.drawable.judgement,R.drawable.world
    };
    private int[] cardreversed = {
            R.drawable.foolreversed,R.drawable.magicianreversed,R.drawable.priestressreversed,R.drawable.empreversed,
            R.drawable.emperorreversed,R.drawable.hieroreversed,R.drawable.loreversed,R.drawable.chareversed,
            R.drawable.justreversed,R.drawable.herreversed,R.drawable.forreversed,R.drawable.strengthreversed,R.drawable.hangreversed,
            R.drawable.deadreversed,R.drawable.temperancereversed,R.drawable.toreversed,R.drawable.devilreversed,R.drawable.streversed,R.drawable.moreversed,R.drawable.sureversed
            ,R.drawable.jureversed,R.drawable.worldreversed
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail);
        Initialization();
        myDbHelper = new DatabaseHelper(getApplicationContext());
        String nametwo= getIntent().getStringExtra("EXTRA_SESSION_ID");
        String from = getIntent().getStringExtra("FROM");
        if(from.equals("MAJOR")){
            data=myDbHelper.getAllData(nametwo);
            if(nametwo.toLowerCase().contains("reversed")){

                if(nametwo.toLowerCase().contains("fool")){
                    image.setImageResource(cardreversed[0]);
                }else if(nametwo.toLowerCase().contains("magician")){
                    image.setImageResource(cardreversed[1]);

                }else if(nametwo.toLowerCase().contains("priestess")){
                    image.setImageResource(cardreversed[2]);

                }else if(nametwo.toLowerCase().contains("empress")){
                    image.setImageResource(cardreversed[3]);

                }else if(nametwo.toLowerCase().contains("emperor")){
                    image.setImageResource(cardreversed[4]);

                }else if(nametwo.toLowerCase().contains("hierophant")){
                    image.setImageResource(cardreversed[5]);

                }else if(nametwo.toLowerCase().contains("lovers")){

                    image.setImageResource(cardreversed[6]);
                }else if(nametwo.toLowerCase().contains("chariot")){

                    image.setImageResource(cardreversed[7]);
                }else if(nametwo.toLowerCase().contains("justice")){
                    image.setImageResource(cardreversed[8]);

                }else if(nametwo.toLowerCase().contains("hermit")){

                    image.setImageResource(cardreversed[9]);
                }else if(nametwo.toLowerCase().contains("fortune")){

                    image.setImageResource(cardreversed[10]);
                }else if(nametwo.toLowerCase().contains("strength")){

                    image.setImageResource(cardreversed[11]);
                }else if(nametwo.toLowerCase().contains("hanged")){

                    image.setImageResource(cardreversed[12]);
                }else if(nametwo.toLowerCase().contains("death")){

                    image.setImageResource(cardreversed[13]);
                }else if(nametwo.toLowerCase().contains("temperance")){

                    image.setImageResource(cardreversed[14]);
                }else if(nametwo.toLowerCase().contains("devil")){

                    image.setImageResource(cardreversed[16]);
                }else if(nametwo.toLowerCase().contains("tower")){

                    image.setImageResource(cardreversed[15]);
                }else if(nametwo.toLowerCase().contains("star")){

                    image.setImageResource(cardreversed[17]);
                }else if(nametwo.toLowerCase().contains("moon")){

                    image.setImageResource(cardreversed[18]);
                }else if(nametwo.toLowerCase().contains("sun")){

                    image.setImageResource(cardreversed[19]);
                }else if(nametwo.toLowerCase().contains("judgment")){

                    image.setImageResource(cardreversed[20]);
                }else {
                    image.setImageResource(cardreversed[21]);
                }



            }else {

                if (nametwo.toLowerCase().contains("fool")) {
                    image.setImageResource(card[0]);

                } else if (nametwo.toLowerCase().contains("magician")) {
                    image.setImageResource(card[1]);

                } else if (nametwo.toLowerCase().contains("priestess")) {
                    image.setImageResource(card[2]);

                } else if (nametwo.toLowerCase().contains("empress")) {
                    image.setImageResource(card[3]);

                } else if (nametwo.toLowerCase().contains("emperor")) {
                    image.setImageResource(card[4]);

                } else if (nametwo.toLowerCase().contains("hierophant")) {
                    image.setImageResource(card[5]);

                } else if (nametwo.toLowerCase().contains("lovers")) {
                    image.setImageResource(card[6]);

                } else if (nametwo.toLowerCase().contains("chariot")) {
                    image.setImageResource(card[7]);

                } else if (nametwo.toLowerCase().contains("justice")) {
                    image.setImageResource(card[8]);

                } else if (nametwo.toLowerCase().contains("hermit")) {
                    image.setImageResource(card[9]);

                } else if (nametwo.toLowerCase().contains("fortune")) {
                    image.setImageResource(card[10]);

                } else if (nametwo.toLowerCase().contains("strength")) {
                    image.setImageResource(card[11]);

                } else if (nametwo.toLowerCase().contains("hanged")) {
                    image.setImageResource(card[12]);

                } else if (nametwo.toLowerCase().contains("death")) {

                    image.setImageResource(card[13]);
                } else if (nametwo.toLowerCase().contains("temperance")) {

                    image.setImageResource(card[14]);
                } else if (nametwo.toLowerCase().contains("devil")) {

                    image.setImageResource(card[16]);
                } else if (nametwo.toLowerCase().contains("tower")) {

                    image.setImageResource(card[15]);
                } else if (nametwo.toLowerCase().contains("star")) {

                    image.setImageResource(card[17]);
                } else if (nametwo.toLowerCase().contains("moon")) {
                    image.setImageResource(card[18]);
                } else if (nametwo.toLowerCase().contains("sun")) {
                    image.setImageResource(card[19]);
                } else if (nametwo.toLowerCase().contains("judgment")) {
                    image.setImageResource(card[20]);
                } else {
                    image.setImageResource(card[21]);
                }
            }

        }


        title.setText(nametwo);
        general.setText(Html.fromHtml("<font color='#EE0000'>GENERAL: </font>\""+data.get(2)));
        work.setText(Html.fromHtml("<font color='#61cc17'>WORK: </font>\""+data.get(3)));
        love.setText(Html.fromHtml("<font color='#17ccbc'>LOVE: </font>\""+data.get(4)));
        finances.setText(Html.fromHtml("<font color='#be0fff'>FINANCE: </font>\""+data.get(5)));
        health.setText(Html.fromHtml("<font color='#0fd7ff'>HEALTH: </font>\""+data.get(6)));
        spirit.setText(Html.fromHtml("<font color='#ff0fd7'>SPIRITUAL: </font>\""+data.get(7)));
        intro.setText(Html.fromHtml("<font color='#0fbeff'>INTRODUCTION: </font>\""+data.get(8)));


    }
    public void Initialization(){
        image = findViewById(R.id.image);
        intro = findViewById(R.id.intro);
        general = findViewById(R.id.general);
        work = findViewById(R.id.work);
        love = findViewById(R.id.love);
        finances = findViewById(R.id.finance);
        health = findViewById(R.id.health);
        spirit = findViewById(R.id.spirit);
        title = findViewById(R.id.titlename);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        data.clear();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        data.clear();
    }
}
