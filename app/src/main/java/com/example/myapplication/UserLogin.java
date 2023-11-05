package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityUserLoginBinding;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UserLogin extends AppCompatActivity {
    Button b1,b2;
    EditText t1,t2;
    SQLiteDatabase mydb=null;

    private AppBarConfiguration appBarConfiguration;
    private ActivityUserLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        t1=(EditText)findViewById(R.id.txtUserName);
        t2=(EditText)findViewById(R.id.txtPassword);
        b1=(Button)findViewById(R.id.btnLogin);
        b2=(Button)findViewById(R.id.btnExit);
        myListener1 m=new myListener1();
        b1.setOnClickListener((OnClickListener) m);
        b2.setOnClickListener((OnClickListener) m);

        /*
        binding = ActivityUserLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_login);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
  */
    }

    @Override
    public boolean onSupportNavigateUp() {
        return true;
        /*NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_login);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    */
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.user_login, menu);
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
    class myListener1 implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch(v.getId())
            {
                case R.id.btnLogin:

                    String s1=t1.getText().toString();
                    String s2=t2.getText().toString();
                    mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
                    Cursor c=mydb.rawQuery("Select Count(*) from User Where UserId='" +s1 + "' and Password='" + s2 + "'",null);
                    c.moveToFirst();
                    int count=c.getInt(0);
                    c.close();
                    mydb.close();
                    if(count>0)
                    {

                        cls.LoggedUserId=s1;
                        cls.LoggedUserType="user";
                        Intent i = new Intent(getApplicationContext(),UserMenuOptions.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid UserName/Password", Toast.LENGTH_LONG).show();
                    }

                    break;
                case R.id.btnExit:
                    finish();
                    break;

            }
        }
    }
}
