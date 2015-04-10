package com.example.intentdata;

import com.example.intentdata.code.Code;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TwoActivity extends Activity {

	
	EditText et_message;
	Button bt_back;
	
	
	
	String name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		
		initView();
		
		initData();
		
	}

	private void initData() {
		name=(String) getIntent().getExtras().get("name");
		et_message.setText(name);
		et_message.setSelection(name.length());
	}
	
	private void initView() {
		et_message=(EditText) findViewById(R.id.two_et_message);
		bt_back=(Button) findViewById(R.id.two_bt_back);
		bt_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		name=et_message.getText().toString();
		Intent i=new Intent();
		i.putExtra("name", name);
		setResult(Code.oneResultCode, i);
		
		super.onBackPressed();
	}
	

}
