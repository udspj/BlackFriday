package com.example.blackfriday;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class FridayYesActivity extends Activity {

	ImageButton backBtn;
	TextView titleLabel;
	Button gotoBtn1;
	Button gotoBtn2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.friday_yes);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.titlebar);

		backBtn = (ImageButton)findViewById(R.id.backbtn);
		backBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
		titleLabel = (TextView)findViewById(R.id.titlelabel);
		titleLabel.setText("今天是黑色星期五");

		gotoBtn1 = (Button)findViewById(R.id.button1);
		gotoBtn1.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(FridayYesActivity.this,FridayNoActivity.class);
				startActivity(intent);
			}
		});

		gotoBtn2 = (Button)findViewById(R.id.button2);
		gotoBtn2.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(FridayYesActivity.this,fridayAdviceActivity.class);
				startActivity(intent);
			}
		});
	}

}
