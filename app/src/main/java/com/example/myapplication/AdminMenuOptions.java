package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityAdminMenuOptionsBinding;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class AdminMenuOptions extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityAdminMenuOptionsBinding binding;
    Button b1, b2, b3, b4, b5, b6, b7, b8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu_options);
        b1 = (Button) findViewById(R.id.btnAddHealthTips);
        b2 = (Button) findViewById(R.id.btnAddDoctorDetails);
        b3 = (Button) findViewById(R.id.btnAddDiseaseInformations);
        b4 = (Button) findViewById(R.id.btnViewHealthTips);
        b5 = (Button) findViewById(R.id.btnViewDoctorDetails);
        b6 = (Button) findViewById(R.id.btnViewDiseaseInformations);
        b7 = (Button) findViewById(R.id.btnViewUsers);
        b8 = (Button) findViewById(R.id.btnExit);

        myListener1 m = new myListener1();
        b1.setOnClickListener((OnClickListener) m);
        b2.setOnClickListener((OnClickListener) m);
        b3.setOnClickListener((OnClickListener) m);
        b4.setOnClickListener((OnClickListener) m);
        b5.setOnClickListener((OnClickListener) m);
        b6.setOnClickListener((OnClickListener) m);
        b7.setOnClickListener((OnClickListener) m);
        b8.setOnClickListener((OnClickListener) m);

        /*
        binding = ActivityAdminMenuOptionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_admin_menu_options);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_admin_menu_options);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //   getMenuInflater().inflate(R.menu.admin_menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class myListener1 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
  /*          case R.id.btnAddHealthTips:
                Intent i = new Intent(getApplicationContext(),AddHealthTips.class);
                startActivity(i);
                break;
            case R.id.btnAddDoctorDetails:
                Intent i6 = new Intent(getApplicationContext(),AddDoctorDetails.class);
                startActivity(i6);
                break;
            case R.id.btnAddDiseaseInformations:
                Intent i61 = new Intent(getApplicationContext(),DiseaseInformations.class);
                startActivity(i61);
                break;
            case R.id.btnViewHealthTips:
                Intent i62 = new Intent(getApplicationContext(),ViewHealthTips.class);
                startActivity(i62);
                break;
            case R.id.btnViewDoctorDetails:
                Intent i63 = new Intent(getApplicationContext(),ViewDoctorDetails.class);
                startActivity(i63);
                break;
            case R.id.btnViewDiseaseInformations:
                Intent i64 = new Intent(getApplicationContext(),ViewDiseaseInformations.class);
                startActivity(i64);
                break;
            case R.id.btnViewUsers:
                Intent i65 = new Intent(getApplicationContext(),ViewUsers.class);
                startActivity(i65);
                break;
*/
                case R.id.btnExit:
                    finish();
                    break;
            }
        }
    }

}