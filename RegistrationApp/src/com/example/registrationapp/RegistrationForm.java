package com.example.registrationapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrationForm extends ActionBarActivity {
	Button btContinue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration_form);
		btContinue = (Button) findViewById(R.id.btContinue);
		
		final CheckBox cbApple = (CheckBox) findViewById(R.id.cbApple);
		final CheckBox cbJava = (CheckBox) findViewById(R.id.cbJava);
		final CheckBox cbAndroid = (CheckBox) findViewById(R.id.cbAndroid);
		final EditText etName = (EditText) findViewById(R.id.etName);
		
		final EditText etPhNo = (EditText) findViewById(R.id.etPhNo);
		final Spinner spUnit = (Spinner) findViewById(R.id.spUnit);
		
		btContinue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name="",contact="", unit="", technology="";
				
				name = etName.getText().toString();
				contact = etPhNo.getText().toString();
				unit = spUnit.getSelectedItem().toString();

				
				if(cbApple.isChecked()){
					technology+=(cbApple.getText().toString()+" ");
				}
				if(cbJava.isChecked()){
					technology+=(cbJava.getText().toString()+" ");
				}
				if(cbAndroid.isChecked()){
					technology+=(cbAndroid.getText().toString()+" ");
				}
				if(name==""||technology==""||unit==""||contact==""){
				Toast.makeText(getApplicationContext(), "Incomplete form", Toast.LENGTH_LONG);
				
				}else{
					AppData.name=name;
					AppData.contact=contact;
					AppData.technology=technology;
					AppData.unit=unit;
					
					Intent dcSelect = new Intent(getApplicationContext(), DC_SelectActivity.class);
					Intent mService = new Intent(getApplicationContext(),MusicService.class);
					
					startService(mService);
					startActivity(dcSelect);
				}
			}
		});
	}

}
