package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import Controller.DatabaseHandler;
import Model.Msg;
import Model.User;
import Utils.Utils;
import Views.Admin;
import Views.Container;
import Views.LogIn;
import Views.Register;
import Views.Start;
import Views.Training;
import Views.WriteMsg;

public class MainActivity extends AppCompatActivity {

    TextView T1, T2;
    View line;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
      //  setContentView(R.layout.activity_container);

        setContentView(R.layout.activity_main);

   /*     BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,  R.id.fragmentContainerView);
        NavGraph navGraph = navController.getNavInflater().inflate(R.navigation.my_nav);
        navGraph.setStartDestination(R.id.profile);
        navController.setGraph(navGraph);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);*/

       T1 = (TextView) findViewById(R.id.welcome);
        T2 = (TextView) findViewById(R.id.secmesg);
        line = (View) findViewById(R.id.divider);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        T1.startAnimation(animation1);
        T2.startAnimation(animation1);
        line.startAnimation(animation2);
      /*  handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, Start.class));
                finish();
            }
        }, 2000);
*/
    }

}