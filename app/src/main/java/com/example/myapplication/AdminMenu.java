package com.example.myapplication;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdminMenu extends Activity {
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_menu);
		
		b1=(Button)findViewById(R.id.btnAddFoodDetails); 
        b2=(Button)findViewById(R.id.btnViewFood); 
        b3=(Button)findViewById(R.id.btnViewFoodOrderDetails); 
        b4=(Button)findViewById(R.id.btnFoodOrderApproval); 
        b5=(Button)findViewById(R.id.btnViewFoodOrderApproval);
        b6=(Button)findViewById(R.id.btnDeliveryDetails);
        b7=(Button)findViewById(R.id.btnViewDeliveryDetails);
        b8=(Button)findViewById(R.id.btnExit);
		b9=(Button)findViewById(R.id.btnViewCustomerDetails);


		myListener1 m=new myListener1();
		b1.setOnClickListener((OnClickListener) m);
		b2.setOnClickListener((OnClickListener) m);
		b3.setOnClickListener((OnClickListener) m);
		b4.setOnClickListener((OnClickListener) m);
		b5.setOnClickListener((OnClickListener) m);
		b6.setOnClickListener((OnClickListener) m);
		b7.setOnClickListener((OnClickListener) m);
		b8.setOnClickListener((OnClickListener) m);
		b9.setOnClickListener((OnClickListener) m);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.admin_menu, menu);
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
	case R.id.btnAddFoodDetails:
		Intent i1 = new Intent(getApplicationContext(), AddItemDetails.class);
        startActivity(i1);
		break;
	case R.id.btnViewFood:
		Intent i2 = new Intent(getApplicationContext(), ViewItemDetails.class);
        startActivity(i2);
		break;
	case R.id.btnViewFoodOrderDetails:
		Intent i3 = new Intent(getApplicationContext(), ViewItemOrder.class);
        startActivity(i3);
        break;
	case R.id.btnFoodOrderApproval:
		Intent i4 = new Intent(getApplicationContext(),OrderApproval.class);
        startActivity(i4);
        break;
	case R.id.btnViewFoodOrderApproval:
	Intent i5 = new Intent(getApplicationContext(),ViewOrderStatus.class);
       startActivity(i5);
        break;
	
	case R.id.btnDeliveryDetails:
		Intent i8 = new Intent(getApplicationContext(),DeliveryDetails.class);
        startActivity(i8);
        break;
	case R.id.btnViewDeliveryDetails:
		Intent i9 = new Intent(getApplicationContext(),ViewDeliveryDetails.class);
        startActivity(i9);
        break;
		case R.id.btnViewCustomerDetails:
			Intent i10= new Intent(getApplicationContext(),ViewCustomerRecords.class);
			startActivity(i10);
			break;

   	case R.id.btnExit:
/*		Intent intent = new Intent(Intent.ACTION_MAIN);
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
