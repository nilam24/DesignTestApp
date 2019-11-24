package com.example.codemingleapp;

import android.os.Bundle;
import android.view.View;
import com.example.codemingleapp.ui.home.HomeViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    AppBarConfiguration appBarConfiguration;
    BottomNavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_view);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        decorView.setSystemUiVisibility(uiOptions);
        final ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        homeViewModel.getResponse(" ");
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

                if(destination.getId()==R.id.navigation_dashboard){


                }
                if(destination.getId()==R.id.navigation_home){

                }
                if(destination.getId()==R.id.navigation_notifications){

                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        final ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
    }

    @Override
    protected void onPause() {
        super.onPause();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        final ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
    }

    @Override
    protected void onStop() {
        super.onStop();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        final ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
    }

    @Override
    public void onBackPressed() {

        //super.onBackPressed();   --this will do the natural back press from one by one screen the user has loaded while navigation

//        NavigationUI.navigateUp(navController,appBarConfiguration);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
        int id=navView.getSelectedItemId();
        if(id==R.id.navigation_home){
            finish();
            super.onBackPressed();

        }
        else if(id==R.id.navigation_dashboard) {

            navView.setSelectedItemId(R.id.navigation_home);
//            super.onBackPressed();
        }



    }
}
