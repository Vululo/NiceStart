package com.BrunoV.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        ImageView myplanet = findViewById(R.id.planeta);

        Glide.with(this)
                .load("https://www.pngmart.com/files/3/Space-Planet-Transparent-Background.png")
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .circleCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.TRANSPARENT)))
                .into(myplanet);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Signup_openLogin(View v) {
        Intent intent = new Intent(Signup.this,Login.class);
        startActivity(intent);
    }
    public void Signup_openProfile(View v) {
        Intent intent = new Intent(Signup.this, Profile.class);
        startActivity(intent);
    }

}