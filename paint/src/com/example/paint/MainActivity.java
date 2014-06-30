package com.example.paint;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	private final int DIALOG_SINGLE_CHOICE = 0;

	TextView test;
	int color = 0;
	canvas drawing;
	ImageButton create;
	ImageButton brush;
	ImageButton save;
	ImageButton eraser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		drawing = (canvas) findViewById(R.id.canvas);

	
		create = (ImageButton) findViewById(R.id.create);
		brush = (ImageButton) findViewById(R.id.brush);
		eraser = (ImageButton) findViewById(R.id.brush);
		save = (ImageButton) findViewById(R.id.save);
		save.setOnClickListener(new OnClickListener() {
			AlertDialog.Builder savedialog = new AlertDialog.Builder(MainActivity.this);
			@Override
			public void onClick(View v) {
				

			}

		});
		eraser.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				Dialog eraserdialog = new Dialog(MainActivity.this);
				eraserdialog.setTitle("Eraser Size");
				eraserdialog.setContentView(R.layout.eraser_chooser);
			eraserdialog.show();}

		});
		
		brush.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Dialog brushdialog = new Dialog(MainActivity.this);
				brushdialog.setTitle("Brush Size");
				brushdialog.setContentView(R.layout.brush_chooser);
			brushdialog.show();}

		});
		create.setOnClickListener(new OnClickListener() {
			AlertDialog.Builder createdialog = new AlertDialog.Builder(MainActivity.this);

			@Override
			public void onClick(View arg0) {

			}

		});
	}

}
