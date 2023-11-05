package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CustomerMenu extends Activity {
	Button b1,b2,b3,b4,b5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_menu);
		
		b1=(Button)findViewById(R.id.btnViewCake); 
        b2=(Button)findViewById(R.id.btnCakeOrder); 
        b3=(Button)findViewById(R.id.btnViewCakeOrder); 
        b4=(Button)findViewById(R.id.btnViewCakeOrderApproval); 
        b5=(Button)findViewById(R.id.btnExit); 
        
        
        myListener1 m=new myListener1();
		b1.setOnClickListener((OnClickListener) m);
		b2.setOnClickListener((OnClickListener) m);
		b3.setOnClickListener((OnClickListener) m);
		b4.setOnClickListener((OnClickListener) m);
		b5.setOnClickListener((OnClickListener) m);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.customer_menu, menu);
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
	case R.id.btnViewCake:
		Intent i1 = new Intent(getApplicationContext(), ViewItemDetails.class);
        startActivity(i1);
		break;
	case R.id.btnCakeOrder:
		Intent i2 = new Intent(getApplicationContext(), AddOrder.class);
        startActivity(i2);
		break;
	case R.id.btnViewCakeOrder:
		Intent i3 = new Intent(getApplicationContext(), ViewItemOrder.class);
        startActivity(i3);
        break;
	case R.id.btnViewCakeOrderApproval:
		Intent i4 = new Intent(getApplicationContext(),ViewOrderStatus.class);
        startActivity(i4);
        break;
	case R.id.btnExit:
		/*
		Intent intent = new Intent(Intent.ACTION_MAIN);
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
