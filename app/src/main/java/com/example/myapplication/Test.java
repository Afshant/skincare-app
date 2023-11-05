package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Test extends AppCompatActivity {
    SQLiteDatabase mydb=null;

    Button b1,b2,b3,b4,b5;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);




        ImageView mimageView = (ImageView) findViewById(R.id.image_from_camera);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Test.this,Home.class);
                startActivity(intent);
            }
        }, 5000); // 4 seconds


        //        setContentView(R.layout.activity_home);
/*
        b1=(Button)findViewById(R.id.btnAdmin);
        b2=(Button)findViewById(R.id.btnNewUser);
        b3=(Button)findViewById(R.id.btnUserLogin);
        b4=(Button)findViewById(R.id.btnBMI);
        b5=(Button)findViewById(R.id.btnExit);

        myListener1 m=new myListener1();
        b1.setOnClickListener((OnClickListener) m);
        b2.setOnClickListener((OnClickListener) m);
        b3.setOnClickListener((OnClickListener) m);
        b4.setOnClickListener((OnClickListener) m);
        b5.setOnClickListener((OnClickListener) m);
  */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.test, menu);
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
            switch(v.getId())
            {
         /*       case R.id.btnAdmin:
  Intent i2 = new Intent(getApplicationContext(),AdminLogin.class);
                    startActivity(i2);
                    break;
                case R.id.btnNewUser:
                    Intent i3 = new Intent(getApplicationContext(),UserRegister.class);
                    startActivity(i3);
                    break;
                case R.id.btnUserLogin:
          //          Intent i4 = new Intent(getApplicationContext(),UserLogin.class);
            //        startActivity(i4);
                    break;
                case R.id.btnBMI:
              //      Intent i5 = new Intent(getApplicationContext(),BMICalculation.class);
                //    startActivity(i5);
                    break;
                case R.id.btnExit:

                    finish();
                    break;*/
            }
        }
    }
}
