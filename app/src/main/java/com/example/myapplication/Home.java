package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class Home extends Activity {
	Button b1,b2,b3,b4,b5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		    b1=(Button)findViewById(R.id.btnAdmin); 
	        b2=(Button)findViewById(R.id.btnCustomerRegister); 
	        b3=(Button)findViewById(R.id.btnCustomer); 
	        b4=(Button)findViewById(R.id.btnExit); 
	        
	        myListener1 m=new myListener1();
			b1.setOnClickListener((OnClickListener) m);
			b2.setOnClickListener((OnClickListener) m);
			b3.setOnClickListener((OnClickListener) m);
			b4.setOnClickListener((OnClickListener) m);
	       
	}

	/*@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if(requestCode==1){
			if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
				if (grantResults.length > 0
						&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					startYourCameraIntent();

				} else {
					Toast.makeText(getApplicationContext(), "Please give your permission.", Toast.LENGTH_LONG).show();
				}
			}
			else{
				Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_LONG).show();
			}
		}
	}*/
	class myListener1 implements View.OnClickListener
	{
	@Override
	public void onClick(View v) {
	switch(v.getId())
	{
	case R.id.btnAdmin:
		Intent i1 = new Intent(getApplicationContext(),AdminLogin.class);
        startActivity(i1);
		break;
	case R.id.btnCustomerRegister:
		Intent i3 = new Intent(getApplicationContext(),CustomerRegister.class);
        startActivity(i3);
        break;
   case R.id.btnCustomer:
		Intent i4 = new Intent(getApplicationContext(),CustomerLogin.class);
        startActivity(i4);
        break;
	case R.id.btnExit:
		/*Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
		*/
		finish();
		break;
	
	}
	}
	}
}
