package com.example.actionrpg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
EditText name;
Button knight;
Button archer;
String playername;
int health;
int damage;
int accuracy;
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			knight=(Button)rootView.findViewById(R.id.knight);
			archer=(Button)rootView.findViewById(R.id.archer);
		name=(EditText)rootView.findViewById(R.id.name);
		name.getText().toString();
		playername=name.getText().toString();
		archer.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				int health=30;
				int damage=7;
				int accuracy=10;
				
				
			}
			
		});
		knight.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
		int health=50;
		int damage=5;
		int accuracy=8;
				
			}
			
		});
		
			return rootView;
		}
	}

}
