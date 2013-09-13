package com.google.utkin.dn.jobseekerscv;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Activity_1 extends FragmentActivity {
	public static class DatePickerFragment extends DialogFragment
	implements DatePickerDialog.OnDateSetListener{

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.YEAR, -21);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			GregorianCalendar settedDate = new GregorianCalendar(year,monthOfYear,dayOfMonth);
			GregorianCalendar maxDate = new GregorianCalendar();
			maxDate.add(GregorianCalendar.YEAR, -14);
			
			TextView tv = (TextView)getActivity().findViewById(R.id.dateField);
			if(maxDate.after(settedDate))
			{
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				tv.setText(dateFormat.format(settedDate.getTime()));
				tv.setBackgroundColor(Color.WHITE);
			}
			else
			{
				tv.setBackgroundColor(Color.RED);	
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_1);
	}
	public void showDatePickerDialog(View v) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getSupportFragmentManager(), "DatePicker");
	}
	
	public void sendMessage(View view) {
	    Intent intent = new Intent(this, Activity_2.class);
	    intent.putExtra("name", ((EditText)findViewById(R.id.nameField)).getText().toString());
	    intent.putExtra("gender", (String.valueOf(((Spinner)findViewById(R.id.genderChoser)).getSelectedItem())));
	    intent.putExtra("dateOfBirth", ((TextView)findViewById(R.id.dateField)).getText().toString());
	    intent.putExtra("position", ((EditText)findViewById(R.id.positionField)).getText().toString());
	    intent.putExtra("payment", ((EditText)findViewById(R.id.paymentField)).getText().toString());
	    intent.putExtra("email", ((EditText)findViewById(R.id.emailField)).getText().toString());
	    intent.putExtra("phone", ((EditText)findViewById(R.id.phoneField)).getText().toString());	    
	    startActivity(intent);
	}
}
