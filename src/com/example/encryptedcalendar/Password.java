package com.example.encryptedcalendar;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Password extends Activity {

	TextView textView;
	EditText passwordEditText;
	Button testPasswordButton;
	KeyStore ks;

	private final OnClickListener testpasswordListener = new OnClickListener() {

		public void onClick(View v) {
			String password = passwordEditText.getText().toString();
			try {
				SecretKey k = (SecretKey) ks.getKey("calendarpass",
						password.toCharArray());
				textView.setText(Arrays.toString(k.getEncoded()));
			} catch (UnrecoverableKeyException e) {

			} catch (KeyStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_password);
		textView = (TextView) findViewById(R.id.keyView);
		passwordEditText = (EditText) findViewById(R.id.passwordEditText);
		testPasswordButton = (Button) findViewById(R.id.testPassword);

		testPasswordButton.setOnClickListener(testpasswordListener);

		try {
			ks = KeyStore.getInstance(KeyStore.getDefaultType());
			ks = new KeyStore();
			SecretKey key = KeyGenerator.getInstance("AES").generateKey();
			String pass = "pass";
			ks.setKeyEntry("calendarpass", key, pass.toCharArray(), null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_password, menu);
		return true;
	}
}
