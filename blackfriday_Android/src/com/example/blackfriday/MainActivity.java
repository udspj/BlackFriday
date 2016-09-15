package com.example.blackfriday;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.os.Environment;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.Window;  

//@SuppressLint("SimpleDateFormat")
public class MainActivity extends Activity {

	TextView todayTV;
	Button gotoBtn;
	ImageButton backBtn;
	TextView titleLabel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_main);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.titlebar);
		
		backBtn = (ImageButton)findViewById(R.id.backbtn);
		backBtn.setVisibility(View.INVISIBLE);
		titleLabel = (TextView)findViewById(R.id.titlelabel);
		titleLabel.setText("黑色星期五");
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
		Date curDate = new Date(System.currentTimeMillis());   
		String nowtimestr = formatter.format(curDate);
		
		todayTV = (TextView)findViewById(R.id.TodayTime);
		todayTV.setText(nowtimestr);
		
		final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		final int week = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

		Log.i("selflogout ", day+" "+week);
		gotoBtn = (Button)findViewById(R.id.button1);
		gotoBtn.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) 
			{
            	
				if(day == 13 && week == 6)
				{
					Intent intent = new Intent(MainActivity.this,FridayYesActivity.class);
					startActivity(intent);
				}
				else
				{
					Intent intent = new Intent(MainActivity.this,FridayNoActivity.class);
					startActivity(intent);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
