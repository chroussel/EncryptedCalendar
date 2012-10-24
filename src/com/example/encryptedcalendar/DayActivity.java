package com.example.encryptedcalendar;

import java.sql.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DayActivity extends Activity {

	private int year;
	private int month;
	private int dayOfMonth;
	private static final int ADD_EVENT_RESULT = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        Bundle b = this.getIntent().getExtras();
        year = b.getInt("Year");
        month = b.getInt("Month");
        dayOfMonth = b.getInt("dayOfMonth");
        ListView listView= (ListView) findViewById(R.id.day_Calendar);
        TextView textView = new TextView(getBaseContext());
        
        String date = new StringBuilder().append(dayOfMonth).append('-').append(month).append('-').append(year).toString();
        textView.setText(date.toString());
        listView.addHeaderView(textView);
        String[] values= new String[] {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,values);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(listener);
        
    }
    
    private OnItemClickListener listener = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			int hour = Integer.parseInt(((TextView) arg1).getText().toString());
			Bundle b = new Bundle();
			b.putInt("Year", year);
			b.putInt("Month", month);
			b.putInt("dayOfMonth", dayOfMonth);
			b.putInt("Hour",hour);
			Intent intent = new Intent(getBaseContext(), AddEventActivity.class);
			intent.putExtras(b);
			startActivityForResult(intent, ADD_EVENT_RESULT);
			
		}
    	
	};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_day, menu);
        return true;
    }
}
