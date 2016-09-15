package com.example.blackfriday;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class sendWeiboActivity extends Activity {

	final int mMaxLength = 140;
	ImageButton backBtn;
	TextView titleLabel;
    ImageView imageview;
    
    EditText editext;
    TextView textlength;
    Button loginbtn;
    Button sendbtn;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.send_weibo);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.titlebar);

		backBtn = (ImageButton)findViewById(R.id.backbtn);
		backBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
		titleLabel = (TextView)findViewById(R.id.titlelabel);
		titleLabel.setText("发送到微博");
		
		// https://github.com/sinaweibosdk/weibo_android_sdk
		
		// 使用Android授权新浪微博实例
		// http://blog.csdn.net/is_zhoufeng/article/details/11967487
		
		// Android上百实例源码分析以及开源分析集合打包
		// http://www.apkbus.com/android-59572-1-1.html


		
//		Intent intent=getIntent();
//		Bundle bundle = this.getIntent().getExtras();
//		Bitmap bitmap = (Bitmap) bundle.get("bitmap");
////		 if(intent!=null)
////	        {
////	        	Bitmap bitmap=intent.getParcelableExtra("bitmap");
//	            imageview.setImageBitmap(bitmap);
////	        }
		Intent intent=getIntent();  
        if(intent !=null)  
        {  
            byte [] bis=intent.getByteArrayExtra("bitmap");  
            Bitmap bitmap=BitmapFactory.decodeByteArray(bis, 0, bis.length);  
//    		imageview=(ImageView)findViewById(R.id.imgview2);
            //imageview.setImageBitmap(bitmap);  
        }  
        
        
        loginbtn = (Button)findViewById(R.id.buttonlogin);
        loginbtn.setOnClickListener(new OnClickListener() 
		{
        	public void onClick(View v) 
			{
        		
			}
		});
        
        sendbtn = (Button)findViewById(R.id.buttonsend);
        sendbtn.setOnClickListener(new OnClickListener() 
		{
        	public void onClick(View v) 
			{
        		
			}
		});
        
        
        textlength = (TextView)findViewById(R.id.editextlength);
        textlength.setText(0 + "/" + mMaxLength);

        editext = (EditText)findViewById(R.id.edittext);
        editext.addTextChangedListener(new TextWatcher() 
        {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                String str = s.toString();
                int length = str.length();
                textlength.setText(length + "/" + mMaxLength);
            }

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}
        });
        
//        InputMethodManager imm =  (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);   
//        if(imm != null) {   
//        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),    
//                               0);   
//                             }  
	}

}
