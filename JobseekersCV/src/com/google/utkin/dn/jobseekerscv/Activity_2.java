package com.google.utkin.dn.jobseekerscv;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class Activity_2 extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_2);

		Intent intent = getIntent();
		((TextView)findViewById(R.id.name)).setText(intent.getStringExtra("name"));
		((TextView)findViewById(R.id.gender)).setText(intent.getStringExtra("gender"));
		((TextView)findViewById(R.id.birthDate)).setText(intent.getStringExtra("dateOfBirth"));
		((TextView)findViewById(R.id.position)).setText(intent.getStringExtra("position"));
		((TextView)findViewById(R.id.payment)).setText(intent.getStringExtra("payment"));
		((TextView)findViewById(R.id.email)).setText(intent.getStringExtra("email"));
		((TextView)findViewById(R.id.phone)).setText(intent.getStringExtra("phone"));
	}
	
	public void sendResponce(View view) {
		//TODO отправить ответ куда-то
	}
}
