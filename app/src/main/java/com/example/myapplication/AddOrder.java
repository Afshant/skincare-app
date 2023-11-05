package com.example.myapplication;

import java.util.ArrayList;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddOrder extends Activity {
	Button b1,b2;
	EditText t1,t2,t3,t4,t5,t6;
	Spinner spnCustomerId,spnFoodId;
	SQLiteDatabase mydb=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_order);
		
		b1=(Button)findViewById(R.id.btnSave);
		b2=(Button)findViewById(R.id.btnBack);
		
		t1=(EditText)findViewById(R.id.txtOrderId);
		t2=(EditText)findViewById(R.id.txtDate);
		t3=(EditText)findViewById(R.id.txtFoodName);
		t4=(EditText)findViewById(R.id.txtPrice);
		t5=(EditText)findViewById(R.id.txtQuantity);
		t6=(EditText)findViewById(R.id.txtTotalAmount);
		
		
		/*
	        t2.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                final Calendar cldr = Calendar.getInstance();
	                int day = cldr.get(Calendar.DAY_OF_MONTH);
	                int month = cldr.get(Calendar.MONTH);
	                int year = cldr.get(Calendar.YEAR);
	                // date picker dialog
	                DatePickerDialog   picker = new DatePickerDialog(FoodOrder.this,new DatePickerDialog.OnDateSetListener() {
	                @Override
	                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
	                t2.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
	                            }
			                    }, year, month, day);
	                if(!isFinishing())
	                picker.show();
	            }
	        });
	        */
	        
		//datetime
				java.util.Date d=new java.util.Date();
				java.text.SimpleDateFormat sdf1=new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
				//java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
				t2.setText(sdf1.format(d));
				//datetime
				
		
	        
		t5.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
            try
            {
            	if(t5.getText()!=null && t4.getText()!=null)
            	{
            		if(t5.getText().toString().length()>0 && t4.getText().toString().length()>0)
            		{
            		double qty=Double.parseDouble(t5.getText().toString());
            		double rate=Double.parseDouble(t4.getText().toString());
            		
            		
            		String discount = spnFoodId.getSelectedItem().toString().split(":")[3];
            		
            		try
            		{
            			double disc = Double.parseDouble(discount);
            			
            			double total =qty*rate;
            			double amt=  total - ( (disc/100.0)  *total);
            			java.text.DecimalFormat dcf=new java.text.DecimalFormat ("0.00");
            			t6.setText(dcf.format(amt));
            		}
            		catch(Exception ex)
            		{
            			
            		}
            		
            		
            		
            		
            		//t6.setText( dcf.format(qty * rate));
            		}
            		else
            		{
            			t6.setText("0.00");
            		}
            	}
            }
            catch(Exception ex)
            {
            	
            }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
            	/*if(t5.getText()!=null && t4.getText()!=null)
            	{
            		int qty=Integer.parseInt(t5.getText().toString());
            		double rate=Double.parseDouble(t4.getText().toString());
            		t6.setText(new Double(qty * rate).toString());
            	}*/
            	
            }
        });
		
		
		
		spnCustomerId = (Spinner) findViewById(R.id.spnCustomerId);
		mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		Cursor cc=null;
		cc=mydb.rawQuery("Select CustomerId From Customer Where CustomerId='" + cls.LoggedUserId +"'",null);
		cc.moveToFirst();
		ArrayList<String> CustId = new ArrayList<String>();
		CustId.add("Select");
		while(cc.isAfterLast()==false)
		{
			CustId.add(cc.getString(0));	
			cc.moveToNext();
		}
	    ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, CustId);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCustomerId.setAdapter(dataAdapter1);
	    cc.close();
        mydb.close();
		spnCustomerId.setSelection(1);
		
        spnFoodId = (Spinner) findViewById(R.id.spnFoodId);
		mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		Cursor cfi=null;
		cfi=mydb.rawQuery("Select FoodId,FoodName,UnitOfMeasure,Offer From FoodDetails Where FoodId='" + cls.selectedproductcode +"'",null);
		cfi.moveToFirst();
		ArrayList<String> FoodId = new ArrayList<String>();
		FoodId.add("Select");
String pid="";
String pname="";
String uom="";
		String offer="";
			//FoodId.add(cls.selectedproductcode);
			while(cfi.isAfterLast()==false) {
pid=cfi.getString(0);
pname =cfi.getString(1);
uom=cfi.getString(2);
offer =cfi.getString(3);
cfi.moveToNext();
;			}
cfi.close();
		FoodId.add(pid + ":" + pname + ":" + uom + ":" + offer);
				cfi=mydb.rawQuery("Select FoodId,FoodName,UnitOfMeasure,Offer From FoodDetails",null);
		cfi.moveToFirst();
//		ArrayList<String> FoodId = new ArrayList<String>();

		//if (cls.selectedproductcode!="")
		//FoodId.add(cls.selectedproductcode);
		while(cfi.isAfterLast()==false)
		{
			FoodId.add(cfi.getString(0) + ":" + cfi.getString(1) +  ":" + cfi.getString(2)+  ":" + cfi.getString(3));	
			cfi.moveToNext();
		}
	    ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, FoodId);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFoodId.setAdapter(dataAdapter2);

		spnFoodId.setSelection(1);
        cfi.close();
        mydb.close();
        
        spnFoodId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          @Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			

				mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
           		Cursor c=mydb.rawQuery("Select FoodName,Price From FoodDetails Where FoodId='" + arg0.getSelectedItem().toString().split(":")[0] + "'", null);
				c.moveToFirst();
				while(c.isAfterLast()==false)
				{
					t3.setText(c.getString(0));	
					t4.setText(c.getString(1));	
				
					c.moveToNext();
				}
				c.close();
				mydb.close();
				
				t5.setText("0");
				t6.setText("0");
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
				
			}
        });
        
        
        
        myListener1 m=new myListener1();
		b1.setOnClickListener((OnClickListener) m);
		b2.setOnClickListener((OnClickListener) m);
	
		mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		
		//mydb.execSQL("Drop Table OrderDetails");
		mydb.execSQL("Create Table If Not Exists OrderDetails(OrderId Varchar(10),Date Varchar(10),CustomerId Varchar(10), FoodId Varchar(20),FoodName Varchar(20),Price Varchar(10),Quantity Varchar(10),TotalAmount Varchar(10),OrderApproved Varchar(10),ApprovalDate Date,Cancellation Varchar(10),CancellationApproved Varchar(10))");
		mydb.close();
		
		mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		Cursor c=mydb.rawQuery("Select Max(OrderId) From OrderDetails",null);
		c.moveToFirst();
		int count=0;
		if(c.isAfterLast()==false)
		{
			count=c.getInt(0);
		}
		c.close();
		t1.setText(new Integer(count+1).toString());
		mydb.close();
		
		t4.setEnabled(false);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.cake_order, menu);
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
	//TODO Auto-generated method stub
		try
		{
	switch(v.getId())
	{
	case R.id.btnSave:

	String s1=t1.getText().toString();
	String s2=t2.getText().toString();
	String s3=spnCustomerId.getSelectedItem().toString();
	String s4=spnFoodId.getSelectedItem().toString();
	String s5=t3.getText().toString();
	String s6=t4.getText().toString();
	String s7=t5.getText().toString();
	String s8=t6.getText().toString();
	
	if(s1.equals(""))
	{
	t1.requestFocus();
	return;
	}
	if(s2.equals(""))
	{
	t2.requestFocus();
	return;
	}
	if(s3.equals(""))
	{
		spnCustomerId.requestFocus();
	return;
	}
	if(s4.equals(""))
	{
		spnFoodId.requestFocus();
	return;
	}
	if(s5.equals(""))
	{
	t3.requestFocus();
	return;
	}
	if(s6.equals(""))
	{
	t4.requestFocus();
	return;
	}
	if(s7.equals(""))
	{
	t5.requestFocus();
	return;
	}
	try
	{
		if( Integer.parseInt(s6)<=0)
		{
			t4.requestFocus();
			return;
		}
	}
	catch(Exception ex )
	{
		t4.requestFocus();
		return;
	}
	try
	{
		if( Integer.parseInt(s7)<=0)
		{
			t5.requestFocus();
			return;
		}
	}
	catch(Exception ex )
	{
		t5.requestFocus();
		return;
	}
	if(s8.equals(""))
	{
	t6.requestFocus();
	return;
	}
	
	
	
	
	mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
	//mydb.execSQL("Delete From OrderDetails Where OrderId='" + s1 + "'");
	mydb.execSQL("Insert into OrderDetails (OrderId ,Date ,CustomerId , FoodId ,FoodName ,Price ,Quantity ,TotalAmount ) Values('" + s1 + "','" + s2 + "','" + s3 + "','"  + s4 + "','"  + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')");
	Toast.makeText(getApplicationContext(), "Order Details Saved", Toast.LENGTH_LONG).show();
	mydb.close();
	
	
	break;
	case R.id.btnBack:
	finish();
	break;
	}
		}
		catch(Exception e)
		{
			//Toast.makeText(getApplicationContext(), e.getMessage(), 1000).show();
		}
	}
	}
}
