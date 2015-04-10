package com.example.intentdata;

import com.example.intentdata.code.Code;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OneActivity extends Activity {
	TextView tv_name;
	Button bt_send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		initView();
	}
	private void initView() {
		tv_name=(TextView) findViewById(R.id.one_tv_name);
		
		bt_send=(Button) findViewById(R.id.one_bt_send);
		bt_send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(OneActivity.this,TwoActivity.class);
				i.putExtra("name",tv_name.getText().toString());
				startActivityForResult(i, Code.oneRequestCode);
				
			}
		});
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (requestCode==Code.oneRequestCode&&resultCode==Code.oneResultCode) {
			String name=data.getExtras().getString("name");
			tv_name.setText(name);
		}
	}

}
