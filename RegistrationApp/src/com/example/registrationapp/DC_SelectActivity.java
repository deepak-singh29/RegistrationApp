package com.example.registrationapp;
// Author:724826

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DC_SelectActivity extends ActionBarActivity {
	String DcName[] = {"Banglore","Pune","Jaipur","Chandigarh","Mysore","Trivandrum","Chennai","Hyderabad","Bhuvaneshwar"};
	String selectedDC="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dc__select);
		
		ArrayAdapter<String> dcadapter = new ArrayAdapter<String>(this,R.layout.listview_settings,DcName);
		final ListView lv = (ListView) findViewById(R.id.dc_name_list);
		lv.setAdapter(dcadapter);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> myAdapterView, View arg1, int pos,
					long arg3) {
				//Log.i("DC_SELECT", "Inside OnClick");
				selectedDC = (String) lv.getItemAtPosition(pos);
				//Log.i("DC_SELECT", "Selected DC:"+selectedDC);
				
				AlertDialog.Builder builder = new AlertDialog.Builder(DC_SelectActivity.this);
				builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
				
				builder.setNegativeButton(R.string.cancel,new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int id) {
						finish();
					}
				});
				builder.setPositiveButton(R.string.ok,new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int id) {
						AppData.dcname=selectedDC;
						Intent confirmIntent = new Intent(DC_SelectActivity.this,ConfirmActivity.class);
						startActivity(confirmIntent);
						
					}
				});
				
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		
		Toast.makeText(this, "Selected your DC: ",Toast.LENGTH_LONG).show();
	}

	
}
