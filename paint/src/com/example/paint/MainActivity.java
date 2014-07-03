package com.example.paint;

import java.util.UUID;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private drawingView drawView;
	private ImageButton currPaint, drawBtn, eraseBtn, newBtn, saveBtn,
			orientation;

	private float smallBrush = 10, mediumBrush = 20, largeBrush = 30;

	AlertDialog.Builder Dialog3;
	AlertDialog.Builder Dialog4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
		drawView = (drawingView) findViewById(R.id.canvas);

		drawBtn = (ImageButton) findViewById(R.id.brush);
		// drawBtn.setOnClickListener(this);

		drawView.setBrushSize(mediumBrush);

		eraseBtn = (ImageButton) findViewById(R.id.eraser);
		// eraseBtn.setOnClickListener(this);

		newBtn = (ImageButton) findViewById(R.id.create);
		// newBtn.setOnClickListener(this);

		saveBtn = (ImageButton) findViewById(R.id.save);
		// saveBtn.setOnClickListener(this);
		orientation = (ImageButton) findViewById(R.id.orientation);
	}

	public void paintClicked(View view) {
		drawView.setErase(false);
		drawView.setBrushSize(drawView.getLastBrushSize());
		if (view != currPaint) {
			ImageButton imgView = (ImageButton) view;
			String color = view.getTag().toString();
			drawView.setColor(color);

			currPaint = (ImageButton) view;
		}
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.brush) {
			final Dialog brushDialog = new Dialog(this);
			brushDialog.setTitle("Brush size:");
			brushDialog.setContentView(R.layout.brush_chooser);

			ImageButton smallBtn = (ImageButton) brushDialog
					.findViewById(R.id.small);
			smallBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					drawView.setErase(false);
					drawView.setBrushSize(smallBrush);
					drawView.setLastBrushSize(smallBrush);
					brushDialog.dismiss();
				}

			});

			ImageButton mediumBtn = (ImageButton) brushDialog
					.findViewById(R.id.medium);
			mediumBtn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					drawView.setErase(false);
					drawView.setBrushSize(mediumBrush);
					drawView.setLastBrushSize(mediumBrush);
					brushDialog.dismiss();
				}
			});

			ImageButton largeBtn = (ImageButton) brushDialog
					.findViewById(R.id.big);
			largeBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					drawView.setErase(false);
					drawView.setBrushSize(largeBrush);
					drawView.setLastBrushSize(largeBrush);
					brushDialog.dismiss();
				}

			});

			brushDialog.show();
		}

		else if (v.getId() == R.id.eraser) {
			final Dialog brushDialog = new Dialog(this);
			brushDialog.setTitle("Eraser size:");
			brushDialog.setContentView(R.layout.brush_chooser);

			ImageButton smallBtn = (ImageButton) brushDialog
					.findViewById(R.id.small);
			smallBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					drawView.setErase(true);
					drawView.setBrushSize(smallBrush);
					brushDialog.dismiss();
				}

			});

			ImageButton mediumBtn = (ImageButton) brushDialog
					.findViewById(R.id.medium);
			mediumBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					drawView.setErase(true);
					drawView.setBrushSize(mediumBrush);
					brushDialog.dismiss();
				}

			});

			ImageButton largeBtn = (ImageButton) brushDialog
					.findViewById(R.id.big);
			largeBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					drawView.setErase(true);
					drawView.setBrushSize(largeBrush);
					brushDialog.dismiss();
				}

			});

			brushDialog.show();
		}

		else if (v.getId() == R.id.create) {
			AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
			newDialog.setTitle("New drawing");
			newDialog
					.setMessage("Start new drawing (you will lose the current drawing)?");
			newDialog.setPositiveButton("Yes",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							drawView.startNew();
							dialog.dismiss();
							AlertDialog.Builder Dialog = new AlertDialog.Builder(
									MainActivity.this);
							Dialog.setTitle("Orientation");
							Dialog.setMessage("Pick a Orientation.(cant be changed while painting)");
							Dialog.setPositiveButton("Portrait",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
										}

									});
							Dialog.setNegativeButton("Landscape",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

										}

									});
							Dialog.show();
						}

					});
			newDialog.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
						}

					});

			newDialog.show();
		}

		else if (v.getId() == R.id.save) {
			AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
			saveDialog.setTitle("Save drawing");
			saveDialog.setMessage("Save drawing to device Gallery?");
			saveDialog.setPositiveButton("Yes",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							drawView.setDrawingCacheEnabled(true);
							String imgSaved = MediaStore.Images.Media
									.insertImage(getContentResolver(), drawView
											.getDrawingCache(), UUID
											.randomUUID().toString() + ".png",
											"drawing");
							if (imgSaved != null) {
								Toast savedToast = Toast.makeText(
										getApplicationContext(),
										"Drawing saved to Gallery!",
										Toast.LENGTH_SHORT);
								savedToast.show();
							} else {
								Toast unsavedToast = Toast.makeText(
										getApplicationContext(),
										"Image failed to save.",
										Toast.LENGTH_SHORT);
								unsavedToast.show();
							}
							drawView.destroyDrawingCache();
						}

					});
			saveDialog.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
						}

					});

			saveDialog.show();
		} else if (v.getId() == R.id.orientation) {
			Dialog3 = new AlertDialog.Builder(this);
			Dialog3.setTitle("orientation");
			Dialog3.setMessage("Are you sure you want to change screen orientation?(Changing orientation will reset the canvas)");
			Dialog3.setPositiveButton("Yes",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							Dialog4 = new AlertDialog.Builder(MainActivity.this);
							Dialog4.setTitle("Orientation");
							Dialog4.setMessage("Pick a Orientation.");
							Dialog4.setPositiveButton("Portrait",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
										}

									});
							Dialog4.setNegativeButton("Landscape",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

										}

									});
							Dialog4.show();
							{
							}

						}
					});
			Dialog3.setNegativeButton("no",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							
							
						}

					});

			Dialog3.show();
		}

	}

}
