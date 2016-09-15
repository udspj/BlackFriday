package com.example.blackfriday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class FridayNoActivity extends Activity {

	ImageButton backBtn;
	TextView titleLabel;
	String dateStr;
	TextView timerdateTV;
	TextView nextFridayTV;
	Button gotoBtn;
	
	SimpleDateFormat df;
	Date d1;
	Date d2;
	long diff;
	long days;
	long hours;
	long minutes;
	long seconds;
	Handler dateHandler;
    Timer timer = new Timer();
    
    int year;
	int month;
	int day;
	boolean isbreak;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.friday_no);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.titlebar);

		backBtn = (ImageButton)findViewById(R.id.backbtn);
		backBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
		titleLabel = (TextView)findViewById(R.id.titlelabel);
		titleLabel.setText("下个黑色星期五");
		
		timerdateTV = (TextView)findViewById(R.id.nextFridayTimer);
		nextFridayTV = (TextView)findViewById(R.id.nextFriday);
		
		year = Calendar.getInstance().get(Calendar.YEAR);
		month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		Log.i("selflogout ", year+" "+month+" "+day);
		
		Calendar calender = Calendar.getInstance();
		for (int m = year; m < year + 2; m ++) {
	        for (int n = 1; n < 13; n ++) {
	    		calender.set(Calendar.YEAR, m);  
	    		calender.set(Calendar.MONTH, n);  
	    		calender.set(Calendar.DAY_OF_MONTH, 13);
	            
	            if (calender.get(Calendar.DAY_OF_WEEK) == 6) {
	                if (m == year && n > month) {
	                    isbreak = true;
	                    break;
	                }else if(m > year){
	                    isbreak = true;
	                    break;
	                }else if(m == year && n == month && day < 13){
	                    isbreak = true;
	                    break;
	                }else{
	                    continue;
	                }
	            }
	        }
	        if (isbreak == true) {
	            break;
	        }
	    }
		nextFridayTV.setText(calender.get(Calendar.YEAR) + "-" + (calender.get(Calendar.MONTH) + 1) + "-13 00:00:00");
		
		timer.schedule(task, 1000, 1000);
		dateHandler = new Handler(){
			@Override  
	        public void handleMessage(Message msg) {
				switch (msg.what) {  
	            case 1:
					timerdateTV.setText(dateStr);
	            } 
	        }
		};

		gotoBtn = (Button)findViewById(R.id.button1);
		gotoBtn.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent = new Intent(FridayNoActivity.this,divinationActivity.class);
				startActivity(intent);
			}
		});
	}
	
	TimerTask task = new TimerTask(){  
	      public void run() {
	      df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date curDate = new Date(System.currentTimeMillis());   
				String nowtimestr = df.format(curDate);
				d1 = df.parse((String) nextFridayTV.getText());
				d2 = df.parse(nowtimestr);
				diff = d1.getTime() - d2.getTime();//����
				days = diff / (1000 * 60 * 60 * 24);
				hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
				minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
				seconds = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60)-minutes*(1000* 60))/1000;
				dateStr = days + "天" + hours + ":" + minutes + ":" + seconds;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		  Message message = new Message();
		  message.what = 1;
	      dateHandler.sendMessage(message);    
	   }  
	};

}
