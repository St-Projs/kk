package org.st.projs.android.kk.activity;

import org.st.projs.android.kk.R;
import org.st.projs.android.kk.db.KKDbHelper;
import org.st.projs.android.util.GpsProcess;
import org.st.projs.android.util.SdLog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class KKActivity extends Activity {
	private static final int PREFERENCE_INIT = 0;
	private static final int PREFERENCE_BOOTED = 1;
	private static final int ITEM_EXIT = 1;
	private static final int ITEM_EDIT_USER = 0;

	private KKDbHelper mDbHelper;
	private AlertDialog.Builder mMenuAlertDialog;
	private AlertDialog.Builder mEndAlertDialog;

	private LocationManager mLocationManager;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mDbHelper = new KKDbHelper(this);
		mDbHelper.getReadableDatabase();
		
		mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		setContentView(R.layout.main);

		// 計測開始ボタン
		Button startButton = (Button) findViewById(R.id.btn_measurement_start);
		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (GpsProcess.chkGpsService(mLocationManager)) {
					// debug Dialog表示
					new AlertDialog.Builder(v.getContext()).setTitle("計測開始")
							.setMessage("計測が開始されます。").show();
					// LocationManager取得
					// mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
					mLocationManager.requestLocationUpdates(
							LocationManager.GPS_PROVIDER, 0, 0,
							new LocationListener() {

								@Override
								public void onLocationChanged(Location location) {
									Log.v("Main", String.format(
											"Current Location is %s, %s,",
											String.valueOf(location
													.getLatitude()), String
													.valueOf(location
															.getLongitude())));

									// SDカードにログ出力
									SdLog.put(String.format(
											"Current Location is %s, %s,",
											String.valueOf(location
													.getLatitude()), String
													.valueOf(location
															.getLongitude())));
									// リスナを削除
									mLocationManager.removeUpdates(this);

								}

								@Override
								public void onProviderDisabled(String provider) {
									Log.v("Main", "onProviderDisabled");
								}

								@Override
								public void onProviderEnabled(String provider) {
									Log.v("Main", "onProviderEnabled");
								}

								@Override
								public void onStatusChanged(String provider,
										int status, Bundle extras) {
									Log.v("Main", "onStatusChanged");
								}
							});
				}
			}

		});

	}

	/**
	 * 端末のGPSサービス有効/無効を確認する
	 */
	private boolean chkGpsService() {
		String gs = android.provider.Settings.Secure.getString(
				getContentResolver(),
				android.provider.Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
		// if (gs.indexOf("gps", 0) < 0) {
		LocationManager location = (LocationManager) getSystemService(LOCATION_SERVICE);
		if(!location.isProviderEnabled(LocationManager.GPS_PROVIDER)){
			// if (!termGpsService) {
			// GPSサービスがOFFになっているので、メッセージ表示
			AlertDialog.Builder gsDialog = new AlertDialog.Builder(this);
			gsDialog.setTitle("ここにダイアログタイトルを記述");
			gsDialog.setMessage("ここにメッセージを記述");
			gsDialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							// 端末のGSP設定画面へ誘導する
							Intent intent = new Intent(
									android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
							intent.addCategory(Intent.CATEGORY_DEFAULT);
							startActivity(intent);
						}
					}).create().show();
			// }
			return false;
		} else {
			return true;
		}
	}

	/** Called when the app is first started. */
	@Override
	protected void onResume() {
		super.onResume();

		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

		// ダイアログの設定
		alertDialog.setTitle("FirstBoot");
		alertDialog.setMessage("初回メッセージ");
		// alertDialog.setIcon(R.drawable.icon);

		alertDialog.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						setState(PREFERENCE_BOOTED);
					}
				});

		// ダイアログの作成と表示
		if (PREFERENCE_INIT == getState()) {
			// 初回起動時のみ表示する
			alertDialog.create();
			alertDialog.show();
		}
	}

	/** Called when the options menu is displayed first. */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		final CharSequence[] items = { "ユーザ設定", "終了" };
		mMenuAlertDialog = new AlertDialog.Builder(this);
		// タイトル設定。
		mMenuAlertDialog.setTitle("メニュー");
		// 表示項目設定。
		mMenuAlertDialog.setItems(items, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Log.v("OnMenuItemClick", "MenuItemClick : Item(" + which + ")");
				if (which == ITEM_EDIT_USER) {
					startActivity(new Intent(KKActivity.this,
							UserEditActivity.class));
				}
			}
		});
		mMenuAlertDialog.setNegativeButton("キャンセル",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
		return super.onCreateOptionsMenu(menu);
	}

	/** Called when the options menu is displayed. */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// メニューダイアログを表示
		mMenuAlertDialog.create().show();

		return super.onPrepareOptionsMenu(menu);
	}

	// データ読み出し
	private int getState() {
		// 読み込み
		int state;
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		state = sp.getInt("InitState", PREFERENCE_INIT);

		return state;
	}

	// データ保存
	private void setState(int state) {
		// SharedPreferences設定を保存
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		sp.edit().putInt("InitState", state).commit();
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			switch (event.getKeyCode()) {
			case KeyEvent.KEYCODE_BACK:
				if (mEndAlertDialog == null) {
					final CharSequence[] items = { "バックグランド", "終了" };
					mEndAlertDialog = new AlertDialog.Builder(this);
					// タイトル設定。
					mEndAlertDialog.setTitle("終了しますか？");
					// 表示項目設定。
					mEndAlertDialog.setItems(items,
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									Log.v("OnMenuItemClick",
											"MenuItemClick : Item(" + which
													+ ")");
									if (which == ITEM_EXIT) {
										finish();
									}
								}
							});
					mEndAlertDialog.setNegativeButton("キャンセル",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									mEndAlertDialog.create().dismiss();
								}
							});
				}
				// 終了ダイアログを表示
				mEndAlertDialog.create().show();
				return true;
			default:
			}
		}
		return super.dispatchKeyEvent(event);
	}

}