package com.example.encryptedcalendar;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddEventActivity extends Activity {

	private int year;
	private int month;
	private int dayOfMonth;
	private int hour;
	private EditText eLieu;
	private final OnClickListener okListener = new OnClickListener() {

		public void onClick(View v) {

			Calendar beginTime = Calendar.getInstance();
			beginTime.set(year, month, dayOfMonth, hour, 0);
			String lieu = eLieu.getText().toString();
			String cLieu = "";
			try {
				SecretKey key = KeyGenerator.getInstance("AES").generateKey();

				Cipher c = Cipher.getInstance("AES");
				c.init(Cipher.ENCRYPT_MODE, key);

				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				CipherOutputStream cos = new CipherOutputStream(bos, c);
				byte[] bytes = lieu.getBytes();
				cos.write(bytes);
				cos.close();
				cLieu = bos.toString("UTF-8");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Calendar endTime = Calendar.getInstance();
			endTime.set(year, month, dayOfMonth, hour + 1, 0);

			Intent intent = new Intent(Intent.ACTION_INSERT);
			intent.setData(Events.CONTENT_URI);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					beginTime.getTimeInMillis());
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endTime.getTimeInMillis());
			intent.putExtra(Events.TITLE, "JE TEST DES TRUCS");
			intent.putExtra(Events.DESCRIPTION, "JE TEST ENCORE DES TRUCS");
			intent.putExtra(Events.EVENT_LOCATION, cLieu);
			intent.putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY);
			startActivityForResult(intent, 0);

			setResult(0);
			finish();
		}
	};

	private final OnClickListener cancelListener = new OnClickListener() {

		public void onClick(View v) {
			setResult(RESULT_CANCELED);
			finish();
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_event);
		Bundle b = this.getIntent().getExtras();
		year = b.getInt("Year");
		month = b.getInt("Month");
		dayOfMonth = b.getInt("dayOfMonth");
		hour = b.getInt("Hour");

		Button bOk_button = (Button) findViewById(R.id.ok_button);
		Button bCancel = (Button) findViewById(R.id.cancel_button);
		eLieu = (EditText) findViewById(R.id.lieuEditText);

		bOk_button.setOnClickListener(okListener);
		bCancel.setOnClickListener(cancelListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_add_event, menu);
		return true;
	}
}
