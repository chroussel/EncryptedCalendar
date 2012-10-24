package com.example.encryptedcalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CalendarView;

public class MonthActivity extends Activity {

	protected static int courYear = 0;
	protected static int courMonth = 0;
	protected static int courDayOfMonth = 0;

	private final CalendarView.OnDateChangeListener dateChangeListener = new CalendarView.OnDateChangeListener() {

		public void onSelectedDayChange(CalendarView view, int year, int month,
				int dayOfMonth) {
			courDayOfMonth = dayOfMonth;
			courMonth = month + 1;
			courYear = year;
		}
	};

	private final OnClickListener clickListener = new OnClickListener() {

		public void onClick(View v) {
			if (courYear != 0 && courMonth != 0 && courDayOfMonth != 0)
				;
			Bundle b = new Bundle();
			b.putInt("Year", courYear);
			b.putInt("Month", courMonth);
			b.putInt("dayOfMonth", courDayOfMonth);
			Intent intent = new Intent(getBaseContext(), DayActivity.class);
			intent.putExtras(b);
			startActivity(intent);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_month);

		CalendarView calendarView = (CalendarView) findViewById(R.id.month_Calendar);
		calendarView.setOnDateChangeListener(dateChangeListener);
		calendarView.setOnClickListener(clickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_month, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_Password:
			Intent intent = new Intent(getBaseContext(), Password.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
}
