package com.jtech.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DrawCards extends AppCompatActivity {

    private ImageView image;
    private TextView presshere;


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
    ArrayList<Integer>all = new ArrayList<>();
    ArrayList<Integer>first = new ArrayList<>();
    ArrayList<Integer>second = new ArrayList<>();
    int result;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_cards);
        image = findViewById(R.id.drawcard);
        presshere = findViewById(R.id.clickhere);

        for(int a = 0 ; a < card.length ; a++){
            all.add(card[a]);
            all.add(cardreversed[a]);
        }


        // do stuff
        Collections.shuffle(all);

        for(int j=0 ; j<all.size()/2 ; j++){
            first.add(all.get(j));
        }
        for(int k = all.size()/2;k<all.size(); k++){
            second.add(all.get(k));
        }
        all.clear();
        for(int z=0 ;z<second.size();z++){
            all.add(second.get(z));
        }

        for(int y=0 ;y<second.size();y++){
            all.add(first.get(y));
        }
        result = all.get(0);

        image.setImageResource(result);
        presshere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DrawCards.this,"HERE",Toast.LENGTH_LONG).show();
                String name = getResources().getResourceName(result);

                datasearch(name);

            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        all.clear();
        first.clear();
        second.clear();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        all.clear();
        first.clear();
        second.clear();
    }
    public void datasearch(String name){
        Log.d("TAG",name);
            if(name.toLowerCase().contains("fool")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Fool Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("magician")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Magician Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("priestress")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The High Priestess Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("emp")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Empress Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("emperor")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Emperor Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("hiero")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Hierophant Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("lo")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Lovers Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("cha")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Chariot Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("justice")&&name.toLowerCase().contains("reversed")){
            String nametwo = "Justice Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("her")&&name.toLowerCase().contains("reversed")){
            String nametwo = "Hermit Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("for")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Wheel Of Fortune Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("strength")&&name.toLowerCase().contains("reversed")){
            String nametwo = "Strength Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }
        else if(name.toLowerCase().contains("hang")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Hanged Man Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }
        else if(name.toLowerCase().contains("dead")&&name.toLowerCase().contains("reversed")){
            String nametwo = "Death Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("temperance")&&name.toLowerCase().contains("reversed")){
            String nametwo = "Temperance Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("devil")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Devil Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("to")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Tower Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("st")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Star Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("mo")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Moon Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("sun")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The Sun Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("ju")&&name.toLowerCase().contains("reversed")){
            String nametwo = "Judgement Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("world")&&name.toLowerCase().contains("reversed")){
            String nametwo = "The World Reversed";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("fool")){
            String nametwo = "The Fool";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("magician")){
            String nametwo = "The Magician";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("priestress")){
            String nametwo = "The High Priestess";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("empress")){
            String nametwo = "The Empress";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("emperor")){
            String nametwo = "The Emperor";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("hierophant")){
            String nametwo = "The Hierophant";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("lovers")){
            String nametwo = "The Lovers";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("chariot")){
            String nametwo = "The Chariot";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("justice")){
            String nametwo = "Justice";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("hermit")){
            String nametwo = "Hermit";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("fortune")){
            String nametwo = "The Wheel Of Fortune";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("strength")){
            String nametwo = "Strength";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }
        else if(name.toLowerCase().contains("hanged")){
            String nametwo = "The Hanged Man";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }
        else if(name.toLowerCase().contains("death")){
            String nametwo = "Death";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("temperance")){
            String nametwo = "Temperance";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("devil")){
            String nametwo = "The Devil";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("tower")){
            String nametwo = "The Tower";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("star")){
            String nametwo = "The Star";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("moon")){
            String nametwo = "The Moon";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("sun")){
            String nametwo = "The Sun";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("judgement")){
            String nametwo = "Judgement";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }else if(name.toLowerCase().contains("world")){
            String nametwo = "The World";
            Intent intent = new Intent(getBaseContext(), CardDetail.class);
            intent.putExtra("EXTRA_SESSION_ID", nametwo);
            intent.putExtra("FROM","MAJOR");
            startActivity(intent);
            finish();
        }

    }
}
