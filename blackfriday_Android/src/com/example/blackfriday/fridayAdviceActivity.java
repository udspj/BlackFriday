package com.example.blackfriday;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class fridayAdviceActivity extends Activity {

	ImageButton backBtn;
	TextView titleLabel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.friday_advice);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.titlebar);

		backBtn = (ImageButton)findViewById(R.id.backbtn);
		backBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
		titleLabel = (TextView)findViewById(R.id.titlelabel);
		titleLabel.setText("黑色星期五建议");
	}

}
