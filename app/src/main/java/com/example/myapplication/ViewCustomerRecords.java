package com.example.myapplication;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ViewCustomerRecords extends Activity {
    TableLayout tl1;
    ScrollView sv;

    SQLiteDatabase mydb=null;
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customer_records);


        tl1 = (TableLayout)findViewById(R.id.myTableLayout1);

        mydb=openOrCreateDatabase(cls.dbname,MODE_PRIVATE ,null);
        Cursor c=null;

//if(cls.viewtype==3)
//        if(cls.LoggedUserType.equals("Admin"))
            c=mydb.rawQuery("Select * From Customer",null);

  //      else if(cls.LoggedUserType.equals("Customer"))
    //        c=mydb.rawQuery("Select * From User Where UserId='" + cls.LoggedUserId +"'",null);
        c.moveToFirst();



        ////Add new row in Table ayout
        TableRow tr1 = new TableRow(this);
        TextView b111 = new TextView(this);
        b111.setText("Customer Details");
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


        while (c.isAfterLast()==false)
        {

            // sb1.append(Sc+"\t" + Sn+ "\t" + Sd+ "\r\n");
            TableRow tr = new TableRow(this);
            TableRow tr2 = new TableRow(this);
            TableRow tr3 = new TableRow(this);
            TableRow tr4 = new TableRow(this);
       //     TableRow tr5= new TableRow(this);
         //   TableRow tr6= new TableRow(this);
          //  TableRow tr7= new TableRow(this);
           // TableRow tr8= new TableRow(this);
            //TableRow tr9= new TableRow(this);
            //TableRow tr10= new TableRow(this);

            TextView b1 = new TextView(this);
            b1.setText(c.getString(0));
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


/*
            TextView b5 = new TextView(this);
            b5.setText(c.getString(4));
            //b3.setWidth(150);
            b5.setTextColor(Color.BLACK);

            TextView b6 = new TextView(this);
            b6.setText(c.getString(5));
            //b3.setWidth(150);
            b6.setTextColor(Color.BLACK);

            TextView b7 = new TextView(this);
            b7.setText(c.getString(6));
            //b3.setWidth(150);
            b7.setTextColor(Color.BLACK);

            TextView b8 = new TextView(this);
            b8.setText(c.getString(7));
            //b3.setWidth(150);
            b8.setTextColor(Color.BLACK);

            TextView b9 = new TextView(this);
            b9.setText(c.getString(8));
            //b3.setWidth(150);
            b9.setTextColor(Color.BLACK);

            TextView b10 = new TextView(this);
            b10.setText(c.getString(9));
            //b3.setWidth(150);
            b10.setTextColor(Color.BLACK);
*/

            /////
            TextView bh1 = new TextView(getApplicationContext());
            bh1.setText("User Id.");
            //  b1.setWidth(50);

            TextView bh2 = new TextView(getApplicationContext());
            bh2.setText("User Name");
            //b2.setWidth(150);
            bh2.setTextColor(Color.BLACK);


            TextView bh3 = new TextView(getApplicationContext());
            bh3.setText("Age");
            //b3.setWidth(150);
            bh3.setTextColor(Color.BLACK);


            TextView bh4 = new TextView(getApplicationContext());
            bh4.setText("Door No.");
            //b3.setWidth(150);
            bh4.setTextColor(Color.BLACK);
/*


            TextView bh5 = new TextView(getApplicationContext());
            bh5.setText("Street");
            //b3.setWidth(150);
            bh5.setTextColor(Color.BLACK);

            TextView bh6 = new TextView(getApplicationContext());
            bh6.setText("City");
            //b3.setWidth(150);
            bh6.setTextColor(Color.BLACK);


            TextView bh7 = new TextView(getApplicationContext());
            bh7.setText("LandMark");
            //b3.setWidth(150);
            bh7.setTextColor(Color.BLACK);

            TextView bh8 = new TextView(getApplicationContext());
            bh8.setText("Zip Code");
            //b3.setWidth(150);
            bh8.setTextColor(Color.BLACK);

            TextView bh9 = new TextView(getApplicationContext());
            bh9.setText("Mail Id");
            //b3.setWidth(150);
            bh9.setTextColor(Color.BLACK);


            TextView bh10 = new TextView(getApplicationContext());
            bh10.setText("Mobile No.");
            //b3.setWidth(150);
            bh10.setTextColor(Color.BLACK);
*/
            /////

            tr.addView(bh1);
            tr.addView(b1);
            tr2.addView(bh2);
            tr2.addView(b2);
            tr3.addView(bh3);
            tr3.addView(b3);
            tr4.addView(bh4);
            tr4.addView(b4);
  /*          tr5.addView(bh5);
            tr5.addView(b5);
            tr6.addView(bh6);
            tr6.addView(b6);
            tr7.addView(bh7);
            tr7.addView(b7);
            tr8.addView(bh8);
            tr8.addView(b8);

            tr9.addView(bh9);
            tr9.addView(b9);

            tr10.addView(bh10);
            tr10.addView(b10);
*/
            tl1.addView(tr,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
            tl1.addView(tr2,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
            tl1.addView(tr3,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
            tl1.addView(tr4,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
    /*        tl1.addView(tr5,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
            tl1.addView(tr6,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
            tl1.addView(tr7,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
            tl1.addView(tr8,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));

            tl1.addView(tr9,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
            tl1.addView(tr10,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
*/

            if(rowcount%2==0)
            {
                tr.setBackgroundColor(Color.BLUE);
                tr2.setBackgroundColor(Color.BLUE);
                tr3.setBackgroundColor(Color.BLUE);
                tr4.setBackgroundColor(Color.BLUE);
  /*              tr5.setBackgroundColor(Color.BLUE);
                tr6.setBackgroundColor(Color.BLUE);
                tr7.setBackgroundColor(Color.BLUE);
                tr8.setBackgroundColor(Color.BLUE);
                tr9.setBackgroundColor(Color.BLUE);
                tr10.setBackgroundColor(Color.BLUE);
*/
                b1.setTextColor(Color.WHITE);
                b2.setTextColor(Color.WHITE);
                b3.setTextColor(Color.WHITE);
                b4.setTextColor(Color.WHITE);
  /*              b5.setTextColor(Color.WHITE);
                b6.setTextColor(Color.WHITE);
                b7.setTextColor(Color.WHITE);
                b8.setTextColor(Color.WHITE);
                b9.setTextColor(Color.WHITE);
                b10.setTextColor(Color.WHITE);
*/
                bh1.setTextColor(Color.WHITE);
                bh2.setTextColor(Color.WHITE);
                bh3.setTextColor(Color.WHITE);
                bh4.setTextColor(Color.WHITE);
  /*              bh5.setTextColor(Color.WHITE);
                bh6.setTextColor(Color.WHITE);
                bh7.setTextColor(Color.WHITE);
                bh8.setTextColor(Color.WHITE);
                bh9.setTextColor(Color.WHITE);
                bh10.setTextColor(Color.WHITE);
*/
            }
            else
            {
                tr.setBackgroundColor(Color.GREEN);
                tr2.setBackgroundColor(Color.GREEN);
                tr3.setBackgroundColor(Color.GREEN);
                tr4.setBackgroundColor(Color.GREEN);
  /*              tr5.setBackgroundColor(Color.GREEN);
                tr6.setBackgroundColor(Color.GREEN);
                tr7.setBackgroundColor(Color.GREEN);
                tr8.setBackgroundColor(Color.GREEN);
                tr9.setBackgroundColor(Color.GREEN);
                tr10.setBackgroundColor(Color.GREEN);
*/
                b1.setTextColor(Color.BLACK);
                b2.setTextColor(Color.BLACK);
                b3.setTextColor(Color.BLACK);
                b4.setTextColor(Color.BLACK);
  /*              b5.setTextColor(Color.BLACK);
                b6.setTextColor(Color.BLACK);
                b7.setTextColor(Color.BLACK);
                b8.setTextColor(Color.BLACK);
                b9.setTextColor(Color.BLACK);
                b10.setTextColor(Color.BLACK);
*/
                bh1.setTextColor(Color.BLACK);
                bh2.setTextColor(Color.BLACK);
                bh3.setTextColor(Color.BLACK);
                bh4.setTextColor(Color.BLACK);
  /*              bh5.setTextColor(Color.BLACK);
                bh6.setTextColor(Color.BLACK);
                bh7.setTextColor(Color.BLACK);
                bh8.setTextColor(Color.BLACK);
                bh9.setTextColor(Color.BLACK);
                bh10.setTextColor(Color.BLACK);
*/
            }
            rowcount++;
            c.moveToNext();
        }
        c.close();
        //t1.setText(sb1.toString());
        mydb.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.view_order_status, menu);
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
}
