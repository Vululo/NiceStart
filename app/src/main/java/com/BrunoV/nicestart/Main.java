package com.BrunoV.nicestart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.myLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*ImageView men= findViewById(R.id.menu);
        registerForContextMenu(men);*/

        swipeLayout = findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
        myWebView = findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        myWebView.loadUrl("https://www.thispersondoesnotexist.com/");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item1){
            Toast toast = Toast.makeText(this,"Ajustes",Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
        if(id == R.id.item2){
            Intent intent = new Intent(this, Profile.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.item3){
            Snackbar snackbar = Snackbar
                    .make(myWebView,"Descargando...",Snackbar.LENGTH_SHORT)
                    .setAction("CANCELAR", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(myWebView, "Cancelado", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
            });
            snackbar.show();
        }
        if(id == R.id.item4){
            showAlertDialogeButtonClicked(Main.this);
        }
        return false;
    }

    /*
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final ConstraintLayout mLayout = findViewById(R.id.myLayout);
        int id = item.getItemId();
        if(id == R.id.item1){
            Toast toast = Toast.makeText(this,"Item copiado",Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
        if(id == R.id.item2){
            Snackbar snackbar = Snackbar
                    .make(mLayout,"Borrando...",Snackbar.LENGTH_SHORT)
                    .setAction("CANCELAR", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout,"Cancelado",Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            return true;
        }
        return false;
    }*/
    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast.makeText(Main.this, "REFRESHING...", Toast.LENGTH_SHORT).show();
            myWebView.reload();
            swipeLayout.setRefreshing(false);
        }
    };
    public void showAlertDialogeButtonClicked(Main mainActivity){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Exit");
        builder.setMessage("Quieres salir?");
        builder.setIcon(R.drawable.ic_action_user);
        builder.setCancelable(true);

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                // do something like...
                System.exit(0);
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}