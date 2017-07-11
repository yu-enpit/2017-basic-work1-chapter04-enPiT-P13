package com.example.u90684.janken;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();

        Intent intent = getIntent();
        int id = intent.getIntExtra("MY_HAND", 0);
        ImageView myHandImageView = (ImageView) findViewById(R.id.my_hand_image);
    }

    public void onJankenButtonTapped(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("MY_HAND", view.getId());
        startActivity(intent);
    }
}
