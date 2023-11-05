package com.example.myapplication;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;



import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

public class AddItemDetails extends Activity {
	 EditText t1,t2,t3,t4,t5;
	 Button b1,b2,b3;
	 Spinner spnUOM;
	 
	 private static final int CAMERA_REQUEST = 1888;
	 ImageView mimageView;
	 SQLiteDatabase mydb=null;
	 Bitmap mphoto=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_item_details);
		requestWritePermission();
		t1=(EditText)findViewById(R.id.txtFoodId);
		t2=(EditText)findViewById(R.id.txtFoodName);
		t3=(EditText)findViewById(R.id.txtQuantity);
		t4=(EditText)findViewById(R.id.txtPrice);
		t5=(EditText)findViewById(R.id.txtOffer);
		

		b1=(Button)findViewById(R.id.btnSave);
		b2=(Button)findViewById(R.id.btnBack);
        b3=(Button)findViewById(R.id.take_image_from_camera);
		
        
        spnUOM =(Spinner)findViewById(R.id.spnUOM);

		ArrayList<String> owners= new ArrayList<String>();
		owners.add("Nos");	       
		owners.add("Pair");
		owners.add("Dozen");
		owners.add("gm");
		owners.add("kg");
		owners.add("ltr");
		owners.add("ml");
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, owners);
					 
					        // Drop down layout style - list view with radio button
					        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					        // attaching data adapter to spinner
					        spnUOM.setAdapter(dataAdapter);
	
	
				
		mimageView = (ImageView) findViewById(R.id.image_from_camera);
			
		myListener1 m=new myListener1();
		b1.setOnClickListener((OnClickListener) m);
		b2.setOnClickListener((OnClickListener) m);
		b3.setOnClickListener((OnClickListener) m);

		mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
	//	mydb.execSQL("Drop Table FoodDetails");
		mydb.execSQL("Create Table If Not Exists FoodDetails(FoodId Varchar(10),FoodName Varchar(15),Quantity Varchar(10),Price Varchar(10),Offer Varchar(15),CompImg Varchar(255),UnitOfMeasure Varchar(20))");

		Cursor c=mydb.rawQuery("Select Count(*) From FoodDetails",null);
		c.moveToFirst();
		int count=0;
		if(c.isAfterLast()==false)
		{
			count=c.getInt(0);
		}
		c.close();

		t1.setText(new Integer(count+1).toString());

		mydb.close();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.add_cake_details, menu);
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
	///////////////
	Intent in =null;
	ContentValues values=null;
	private static int RESULT_LOAD_IMG = 1;
	String imgDecodableString;
	byte []	 bytes=null;
	
	@RequiresApi(api = Build.VERSION_CODES.Q)
	public void loadImagefromGallery(View view) {
		// Create intent to Open Image applications like Gallery, Google Photos
		Intent galleryIntent = null;// EXTERNAL_CONTENT_URI);//  .Media.EXTERNAL_CONTENT_URI);
		//if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
			galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Downloads.EXTERNAL_CONTENT_URI);
		//}


		galleryIntent.setType("image/*");
	    startActivityForResult(galleryIntent,  1);
	
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		try {
			// When an Image is picked
			if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
					&& null != data) {
				// Get the Image from data

				Uri selectedImage = data.getData();
				String[] filePathColumn = { MediaStore.Images.Media.DATA };

				// Get the cursor
				Cursor cursor = getContentResolver().query(selectedImage,
						filePathColumn, null, null, null);
				// Move to first row
				cursor.moveToFirst();

				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				imgDecodableString = cursor.getString(columnIndex);
				cursor.close();
				ImageView imgView = (ImageView) findViewById(R.id.image_from_camera);
				Toast.makeText(this, imgDecodableString ,
						Toast.LENGTH_LONG).show();
				// Set the Image in ImageView after decoding the String
				imgView.setImageBitmap(BitmapFactory
						.decodeFile(imgDecodableString));

				  InputStream inputStream = getContentResolver().openInputStream(data.getData());
		
				
			} else {
				Toast.makeText(this, "You haven't picked the Image",
						Toast.LENGTH_LONG).show();
			}
		} catch (Exception e) {
			Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
					.show();
		}
		
		
	}
	private static File getOutputMediaFile(){
	    File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
	            Environment.DIRECTORY_PICTURES), "CameraDemo");
	 
	    if (!mediaStorageDir.exists()){
	        if (!mediaStorageDir.mkdirs()){
	            return null;
	        }
	    }
	 
	    String timeStamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
	    return new File(mediaStorageDir.getPath() + File.separator +
	                "IMG_"+ timeStamp + ".jpg");
	}
	private void requestWritePermission(){
		if(ActivityCompat.checkSelfPermission(getApplicationContext(),  android.Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
			ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
		}
		if(ActivityCompat.checkSelfPermission(getApplicationContext(),  android.Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
			ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},0);
		}
	}
	class myListener1 implements View.OnClickListener
	{
	@Override
	public void onClick(View v) {
	//TODO Auto-generated method stub

	switch(v.getId())
	{
	case R.id.btnSave:

	String s1=t1.getText().toString();
	String s2=t2.getText().toString();
	String s3=t3.getText().toString();
	String s4=t4.getText().toString();
	String s5=t5.getText().toString();
	
	String uom=spnUOM.getSelectedItem().toString();
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
	t3.requestFocus();
	return;
	}
	if (cls.isNum(s3.toString())==false) 
	{
	Toast.makeText(getApplicationContext(), "Must enter Numeric Values", Toast.LENGTH_LONG).show();
	t3.requestFocus();
	return; 
	}
	if(s4.equals(""))
	{
	t4.requestFocus();
	return;
	}
	if (cls.isNum(s4.toString())==false) 
	{
	Toast.makeText(getApplicationContext(), "Must enter Numeric Values", Toast.LENGTH_LONG).show();
	t4.requestFocus();
	return; 
	}
	try
	{
		if( Integer.parseInt(s3)<=0)
		{
			t3.requestFocus();
			return;
		}
	}
	catch(Exception ex )
	{
		t3.requestFocus();
		return;
	}
	try
	{
		if( Integer.parseInt(s4)<=0)
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
	if(s5.equals(""))
	{
	t5.requestFocus();
	return;
	}
	
	
	try
	{
	mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
	mydb.execSQL("Delete From FoodDetails Where FoodId='" + s1 + "'");
	mydb.execSQL("Insert into FoodDetails Values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + imgDecodableString +"','" + uom + "')");
	Toast.makeText(getApplicationContext(), "Item Details Saved", Toast.LENGTH_LONG).show();
	//Toast.makeText(getApplicationContext(), imgDecodableString, Toast.LENGTH_LONG).show();
	mydb.close();
	
}
catch(Exception e)
{
	Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
}
	break;
	case R.id.take_image_from_camera:
		loadImagefromGallery(getWindow().getDecorView().getRootView());
		 //Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	        //startActivityForResult(cameraIntent, CAMERA_REQUEST);
	break;
	case R.id.btnBack:
	finish();
	break;
	}
	}
	}
}
