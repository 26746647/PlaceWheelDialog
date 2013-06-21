package com.view.WheelView;


import java.util.Calendar;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button btn;
	private TextView tv;
	private PlaceWheelDialog placewheeldialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn = (Button) findViewById(R.id.button1);
		tv = (TextView) findViewById(R.id.text1);
		
		
		btn.setOnClickListener(new OnClickListener() {

			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				placewheeldialog = new PlaceWheelDialog.Builder(
						MainActivity.this)
						.setPositiveButton("确定", new View.OnClickListener() {

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								String tempplace = placewheeldialog.getPlace();
								tv.setText(tempplace);
								placewheeldialog.dismiss();
							}
						}).setTitle("请选择省市区").setNegativeButton("取消", null)
						.create();
				placewheeldialog.show();
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
