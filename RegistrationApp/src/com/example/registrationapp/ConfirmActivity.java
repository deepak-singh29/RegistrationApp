package com.example.registrationapp;

import java.net.ContentHandler;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends ActionBarActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm);
		TextView tvName = (TextView) findViewById(R.id.tvName);
		TextView tvPhNo = (TextView) findViewById(R.id.tvContact);
		TextView tvUnit = (TextView) findViewById(R.id.tvUnit);
		TextView tvTech = (TextView) findViewById(R.id.tvTech);
		TextView tvDcName = (TextView) findViewById(R.id.tvDcName);
		Button btConfirm = (Button) findViewById(R.id.btConfirm);
		
		tvName.setText(AppData.name);
		tvPhNo.setText(AppData.contact);
		tvUnit.setText(AppData.unit);
		tvTech.setText(AppData.technology);
		tvDcName.setText(AppData.dcname);
		
		btConfirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				NotificationCompat.Builder bldr = new NotificationCompat.Builder(getApplicationContext());
				bldr.setTicker("Success");
				bldr.setContentTitle("Success");
				bldr.setContentText("You are registered successfully");
				bldr.setSmallIcon(R.drawable.ic_launcher);
				
				Intent intHome = new Intent(ConfirmActivity.this,RegistrationForm.class);
				PendingIntent pIntHome = PendingIntent.getActivity(ConfirmActivity.this, 0, intHome, 0);
				
				bldr.setContentIntent(pIntHome);
				NotificationManager nmgr = (NotificationManager) getSystemService(ConfirmActivity.this.NOTIFICATION_SERVICE);
				nmgr.notify(1001, bldr.build());
			}
		});
	}

	
}
