package com.example.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ViewItemDetails extends Activity {
	TableLayout tl1;
	ScrollView sv;
	Button b1;
	SQLiteDatabase mydb=null;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_cake_details);
		b1=(Button)findViewById(R.id.btnViewOrder);
		//CustomerLogin.myListener1 m=new CustomerLogin.myListener1();
		myListener2 m=new myListener2();

		b1.setOnClickListener((View.OnClickListener) m);

		try
		{

tl1 = (TableLayout)findViewById(R.id.myTableLayout1);
		
		mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
		Cursor c=null;
		
//if(cls.viewtype==3)
	//	if(cls.LoggedUserType.equals("admin"))
c=mydb.rawQuery("Select * From FoodDetails",null);
		
	//	else if(cls.LoggedUserType.equals("student"))
		//	c=mydb.rawQuery("Select * From FoodDetails Where RegisterNo='" + cls.LoggedUserId +"'",null);
		c.moveToFirst();
	
		
		
		////Add new row in Table ayout
		 TableRow tr1 = new TableRow(this);
		 TextView b111 = new TextView(this);
		 b111.setText("Item Details");
		 tr1.addView(b111);
         tl1.addView(tr1,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT)); 
         tr1.setBackgroundColor(Color.BLUE);
		 ////////////////////////////
         
         TableRow tr11 = new TableRow(this);
         TextView b121 = new TextView(this);
         b121.setText("Records List");
         tr11.addView(b121);
         tl1.addView(tr11,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
         tr11.setBackgroundColor(Color.GREEN);
         //////////////////////////////
    
         int rowcount=0;
         
         
         while (c.isAfterLast()==false) {

			 // sb1.append(Sc+"\t" + Sn+ "\t" + Sd+ "\r\n");
			 TableRow tr = new TableRow(this);
			 TableRow tr2 = new TableRow(this);
			 TableRow tr3 = new TableRow(this);
			 TableRow tr4 = new TableRow(this);
			 TableRow tr5 = new TableRow(this);
			 // TableRow tr6= new TableRow(this);
			 TableRow tr7 = new TableRow(this);
			 TableRow tr8 = new TableRow(this);
			 TableRow tr9 = new TableRow(this);

			 String productcode = c.getString(0);
			 TextView b1 = new TextView(this);
			 b1.setText(productcode);
			 //  b1.setWidth(50);

			 TextView b2 = new TextView(this);
			 b2.setText(c.getString(1));
			 //b2.setWidth(150);
			 b2.setTextColor(Color.BLACK);


			 TextView b3 = new TextView(this);
			 b3.setText(c.getString(2));
			 //b3.setWidth(150);
			 b3.setTextColor(Color.BLACK);


			 TextView b4 = new TextView(this);
			 b4.setText(c.getString(3));
			 //b3.setWidth(150);
			 b4.setTextColor(Color.BLACK);


			 TextView b5 = new TextView(this);
			 b5.setText(c.getString(4));
			 //b3.setWidth(150);
			 b5.setTextColor(Color.BLACK);

	                 
	               
	             /*     ImageView imageView1=new ImageView(ViewFoodDetails.this);
	                    byte[] image=c.getBlob(6);
	        			Bitmap bmp=BitmapFactory.decodeByteArray(image, 0, image.length);
	        			imageView1.setImageBitmap(bmp);
	                  */
			 ImageView imageView1 = new ImageView(this);
			 try {
				 //      tr17 = new TableRow(this);

				 // imageView1.setImageBitmap(BitmapFactory.decodeFile(c.getString(6)));
				 // imageView1.setLayoutParams(params);
				 // imageView1.getLayoutParams().height = 30;
				 Bitmap bmp = BitmapFactory.decodeFile(c.getString(5));
				 bmp = scaleBitmap(bmp, 250, 250);
				 imageView1.setImageBitmap(bmp);
				 imageView1.setMaxHeight(50);
				 //  imageView1.requestLayout();
				 //  tr17.addView(imageView1);

				 // tl1.addView(tr17,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
			 } catch (Exception ex) {

			 }

			 TextView b8 = new TextView(this);
			 b8.setText(c.getString(6));
			 //b3.setWidth(150);
			 b8.setTextColor(Color.BLACK);

			 /////
			 TextView bh1 = new TextView(getApplicationContext());
			 bh1.setText("Product Id.");
			 //  b1.setWidth(50);

			 TextView bh2 = new TextView(getApplicationContext());
			 bh2.setText("Product Name");
			 //b2.setWidth(150);
			 bh2.setTextColor(Color.BLACK);


			 TextView bh3 = new TextView(getApplicationContext());
			 bh3.setText("Quantity");
			 //b3.setWidth(150);
			 bh3.setTextColor(Color.BLACK);


			 TextView bh4 = new TextView(getApplicationContext());
			 bh4.setText("Price");
			 //b3.setWidth(150);
			 bh4.setTextColor(Color.BLACK);


			 TextView bh5 = new TextView(getApplicationContext());
			 bh5.setText("Discount %");
			 //b3.setWidth(150);
			 bh5.setTextColor(Color.BLACK);
	                
	           /*       TextView bh6 = new TextView(getApplicationContext());
	                  bh6.setText("Available");
	                  //b3.setWidth(150);
	                  bh6.setTextColor(Color.BLACK);
	               */
			 TextView bh7 = new TextView(getApplicationContext());
			 bh7.setText("Image");
			 //b3.setWidth(150);
			 bh7.setTextColor(Color.BLACK);
			 /////

			 TextView bh8 = new TextView(getApplicationContext());
			 bh8.setText("Unit of Measure");
			 //b3.setWidth(150);
			 bh8.setTextColor(Color.BLACK);
			 /////
			 Button imgbtn =null;
			 if(cls.LoggedUserType.equals("Customer")) {
imgbtn=	 new Button(this);
	imgbtn.setText("Add to Cart");

	Drawable icon=getResources().getDrawable( R.drawable.carticon);
	imgbtn.setCompoundDrawablesWithIntrinsicBounds( icon, null, null, null );
	imgbtn.setTag(productcode);
	imgbtn.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			cls.selectedproductcode = productcode;
			Intent i65 = new Intent(getApplicationContext(), AddOrder.class);
			startActivity(i65);

		}
	});
}
	                  tr.addView(bh1);
	    		      tr.addView(b1);
	    		      tr2.addView(bh2);
	                  tr2.addView(b2);
	                  tr3.addView(bh3);
	                  tr3.addView(b3);           
	                  tr4.addView(bh4); 
	    		     tr4.addView(b4);
	    		     tr5.addView(bh5);
	    		     tr5.addView(b5);
	    		    /* tr6.addView(bh6);
	    		     tr6.addView(b6);*/
	    		     tr7.addView(bh7);
	    		     tr7.addView(imageView1);
	    		
	    		     tr8.addView(bh8);
	    		     tr8.addView(b8);
			 if(cls.LoggedUserType.equals("Customer")) {

				 tr9.addView(imgbtn);
			 }
			 tl1.addView(tr,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
	                   tl1.addView(tr2,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
	                   tl1.addView(tr3,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
	                   tl1.addView(tr4,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
	                  tl1.addView(tr5,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
	                //  tl1.addView(tr6,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
	                  tl1.addView(tr7,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
	                  tl1.addView(tr8,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
			 if(cls.LoggedUserType.equals("Customer")) {

				 tl1.addView(tr9, new TableLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
			 }
			 if(rowcount%2==0)
	                   {
	                	   tr.setBackgroundColor(Color.BLUE);
	                	   tr2.setBackgroundColor(Color.BLUE);
	                	   tr3.setBackgroundColor(Color.BLUE);
	                	   tr4.setBackgroundColor(Color.BLUE);
	                	   tr5.setBackgroundColor(Color.BLUE);
	                //	   tr6.setBackgroundColor(Color.BLUE);
	                	   tr7.setBackgroundColor(Color.BLUE);
	                	   tr8.setBackgroundColor(Color.BLUE);
						   tr9.setBackgroundColor(Color.BLUE);

						   b1.setTextColor(Color.WHITE);
	                	   b2.setTextColor(Color.WHITE);
	                	   b3.setTextColor(Color.WHITE);
	                	   b4.setTextColor(Color.WHITE);
	                	   b5.setTextColor(Color.WHITE);
	                	//   b6.setTextColor(Color.WHITE);	                	
	                	   b8.setTextColor(Color.WHITE);
	                	   
	                	   bh1.setTextColor(Color.WHITE);
	                	   bh2.setTextColor(Color.WHITE);
	                	   bh3.setTextColor(Color.WHITE);
	                	   bh4.setTextColor(Color.WHITE);
	                	   bh5.setTextColor(Color.WHITE);
	                	//   bh6.setTextColor(Color.WHITE);
	                	   bh7.setTextColor(Color.WHITE);
	                	   bh8.setTextColor(Color.WHITE);
	                
	                   }
	                   else
	                   {
	                	   tr.setBackgroundColor(Color.GREEN);
	                	   tr2.setBackgroundColor(Color.GREEN);
	                	   tr3.setBackgroundColor(Color.GREEN);
	                	   tr4.setBackgroundColor(Color.GREEN);
	                	   tr5.setBackgroundColor(Color.GREEN);
	                	 //  tr6.setBackgroundColor(Color.GREEN);
	                	   tr7.setBackgroundColor(Color.GREEN);
	                	   tr8.setBackgroundColor(Color.GREEN);
						   tr9.setBackgroundColor(Color.GREEN);

						   b1.setTextColor(Color.BLACK);
	                	   b2.setTextColor(Color.BLACK);
	                	   b3.setTextColor(Color.BLACK);
	                	   b4.setTextColor(Color.BLACK);
	                	   b5.setTextColor(Color.BLACK);
	                	//   b6.setTextColor(Color.BLACK);
	                	   b8.setTextColor(Color.BLACK);
	                	
	                	   bh1.setTextColor(Color.BLACK);
	                	   bh2.setTextColor(Color.BLACK);
	                	   bh3.setTextColor(Color.BLACK);
	                	   bh4.setTextColor(Color.BLACK);
	                	   bh5.setTextColor(Color.BLACK);
	                	  // bh6.setTextColor(Color.BLACK);
	                	   bh7.setTextColor(Color.BLACK);
	                	   bh8.setTextColor(Color.BLACK);
	                	
	                   }
	                   rowcount++;
	                   c.moveToNext();
	         }
		c.close();
	//t1.setText(sb1.toString());
		mydb.close();	
		}
		catch(Exception e)
		{
			
		}
	}
	public static Bitmap scaleBitmap(Bitmap bitmap, int wantedWidth, int wantedHeight) {
        Bitmap output = Bitmap.createBitmap(wantedWidth, wantedHeight, Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Matrix m = new Matrix();
        m.setScale((float) wantedWidth / bitmap.getWidth(), (float) wantedHeight / bitmap.getHeight());
        canvas.drawBitmap(bitmap, m, new Paint());

        return output;
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.view_cake_details, menu);
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
	class myListener2 implements View.OnClickListener
	{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())
			{
				case R.id.btnViewOrder:
Intent i = new Intent(getApplicationContext(),ViewItemOrder.class);
						startActivity(i);
			}
		}
	}
	class myListener1 implements View.OnClickListener
	{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

/*			switch(v.getId())
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

			}*/
		}
	}

}
