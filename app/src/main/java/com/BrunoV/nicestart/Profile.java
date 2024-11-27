package com.BrunoV.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class Profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("Perfil");

        ImageView perfil = findViewById(R.id.perfil);

        perfil.setVisibility(View.VISIBLE);

        Glide.with(this)
                .load("https://static.vecteezy.com/system/resources/previews/016/778/853/original/planet-galaxy-space-free-png.png")
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(perfil);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_perfil,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item1){
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.item2){
            Intent intent = new Intent(this, Login.class);

            Toast toast = Toast.makeText(this,"Sign Out",Toast.LENGTH_SHORT);
            toast.show();

            startActivity(intent);
            return true;
        }
        return false;
    }


}