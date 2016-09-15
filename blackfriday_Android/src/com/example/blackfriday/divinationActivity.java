package com.example.blackfriday;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.blackfriday.DBManager;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class divinationActivity extends Activity {

	ImageButton backBtn;
	TextView titleLabel;
	Button gotoBtn;
	TextView testtext;
    public DBManager dbHelper;
    private SQLiteDatabase database;
    ArrayList<String> itemlist;
    ImageView imageview;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.divination_view);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.titlebar);

		backBtn = (ImageButton)findViewById(R.id.backbtn);
		backBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
		titleLabel = (TextView)findViewById(R.id.titlelabel);
		titleLabel.setText("占卜结果");
		
		itemlist = new ArrayList<String>();
		
		dbHelper = new DBManager(this);
        dbHelper.openDatabase();
        dbHelper.closeDatabase();

        database = SQLiteDatabase.openOrCreateDatabase(DBManager.DB_PATH + "/" + DBManager.DB_NAME, null);
        getCity();
        database.close();
        
        int itemcount = itemlist.size();
        int whichitem = (int) (Math.random() * (itemcount - 0.1));
		
		testtext = (TextView)findViewById(R.id.textView);
		testtext.setText("android:text=占卜结果（5选1）占1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）占卜结果（5选1）");
		//testtext.setText(itemlist.get(whichitem));
		
		gotoBtn = (Button)findViewById(R.id.button1);
		gotoBtn.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				Intent intent = new Intent(divinationActivity.this,sendWeiboActivity.class);
//	            intent.putExtra("bitmap", getscreen());
//				startActivity(intent);
				getscreen();
			}
		});
	}
	
	private void getscreen(){
		//WindowManager windowManager = getWindowManager();   
	    //Display display = windowManager.getDefaultDisplay();   
	    DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
	    int w = dm.widthPixels;
	    int h = dm.heightPixels;
	    Log.i("selflogout", "width "+w+" height "+h);
	        
	    //2.获取屏幕   
	    View decorview = this.getWindow().getDecorView();    
	    decorview.setDrawingCacheEnabled(true);    
	    Bitmap bmp = decorview.getDrawingCache();
	    
	    imageview = (ImageView)findViewById(R.id.imgview1);
	    //imageview.setImageResource(R.drawable.ic_launcher); 
//	    imageview.setImageBitmap(bmp);

	   // Bitmap bitmap = bmp;
	    
	    Intent intent = new Intent(divinationActivity.this,sendWeiboActivity.class);
//	    Bundle bundle = new Bundle();
//	    bundle.putParcelable("bitmap", bitmap);
//	    intent.putExtra("bundle", bundle);//intent.putExtras(bundle);
	    ByteArrayOutputStream baos=new ByteArrayOutputStream();  
	    bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);  
	    byte [] bitmapByte = baos.toByteArray();  
	    intent.putExtra("bitmap", bitmapByte);  
		startActivity(intent);
	    
//	    return bmp;
	}
	
	private void getCity() {
        
        Cursor cur = database.rawQuery("select * from City", null);
        
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {
                    String Tname=cur.getString(cur.getColumnIndex("name"));
                    Log.i("selflogout", Tname);
                    itemlist.add(Tname);
                } while (cur.moveToNext());
            }
        } 
    }

}
