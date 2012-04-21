package org.st.projs.android.kk.activity;

import java.util.Calendar;
import java.util.Date;

import org.st.projs.android.kk.R;
import org.st.projs.android.kk.db.KKDbHelper;
import org.st.projs.android.kk.db.Schema;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UserEditActivity extends Activity {
	private KKDbHelper mDbHelper = new KKDbHelper(this);

	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_edit);
		
		Log.i("kk", "create");
	}
	
	/**
	 * findViewByIdの EditTextのtoStringでラッパー。
	 * @param id id
	 * @return editTextの中にある文字列
	 */
	private String findGetText(int id) {
		return ((EditText)findViewById(id)).getText().toString();
	}
	
	/**
	 * 日付ボタンが押された
	 * @param v view
	 */
	public void btnSetDate(View v){
		setDate(v.getId());
	}
	
	/**
	 * submit時
	 * @param view view
	 */
	public void onSubmit(View view){
		//FIXME 仮登録中、一度しか保存できません。
		//TODO idとuser_idの扱い
		String id = "5";
		String user_id = "010";
		
		// DBに登録
		setUserInfo(view, id, user_id);
		Toast.makeText(view.getContext(), "登録しました", Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * ユーザ情報をDBに登録する
	 * @param view 
	 * @param id
	 * @param user_id
	 */
	private void setUserInfo(View view, String id, String user_id) {
		mDbHelper = new KKDbHelper(view.getContext());
		// mst_usersとbody_logに登録すればOK？
		SQLiteDatabase db = mDbHelper.getWritableDatabase();
		db.beginTransaction();
		
		//mst_users保存
		ContentValues mstUsersVal = new ContentValues();
		mstUsersVal.put(Schema.MstUsers.Columns.ID.column(), id);
		mstUsersVal.put(Schema.MstUsers.Columns.USER_ID.column(), user_id);
		mstUsersVal.put(Schema.MstUsers.Columns.PASSWORD.column(), "");
		mstUsersVal.put(Schema.MstUsers.Columns.NAME_SEI.column(), findGetText(R.id.name_sei));
		mstUsersVal.put(Schema.MstUsers.Columns.NAME_NA.column(), findGetText(R.id.name_na));
		mstUsersVal.put(Schema.MstUsers.Columns.FRGNA_SEI.column(), findGetText(R.id.frgna_sei));
		mstUsersVal.put(Schema.MstUsers.Columns.FRGNA_NA.column(), findGetText(R.id.frgna_na));
		mstUsersVal.put(Schema.MstUsers.Columns.BIRTHDAY.column(), ((Button)findViewById(R.id.birthday)).getText().toString());
		RadioGroup sex = (RadioGroup) findViewById(R.id.sex);
		RadioButton rb = (RadioButton) findViewById(sex.getCheckedRadioButtonId());
		mstUsersVal.put(Schema.MstUsers.Columns.SEX.column(), rb.getTag().toString());
		mstUsersVal.put(Schema.MstUsers.Columns.E_MAIL.column(), findGetText(R.id.e_mail));
		mstUsersVal.put(Schema.MstUsers.Columns.RECDATE_TIME.column(), new Date().toString());
		db.insert(Schema.MstUsers.TABLE_NAME, null, mstUsersVal);
		//body_log保存
		ContentValues bodyLogVal = new ContentValues();
		bodyLogVal.put(Schema.BodyLog.Columns.USER_ID.column(), user_id);
		bodyLogVal.put(Schema.BodyLog.Columns.WEIGHT.column(), findGetText(R.id.weight));
		bodyLogVal.put(Schema.BodyLog.Columns.HEIGHT.column(), findGetText(R.id.height));
		bodyLogVal.put(Schema.BodyLog.Columns.BODY_FAT.column(), findGetText(R.id.body_fat));
		bodyLogVal.put(Schema.BodyLog.Columns.BODY_AGE.column(), findGetText(R.id.body_age));
		bodyLogVal.put(Schema.BodyLog.Columns.BONE_DENSITY.column(), findGetText(R.id.bone_destiny));
		bodyLogVal.put(Schema.BodyLog.Columns.MEASURE_DATE.column(), ((Button)findViewById(R.id.measure_date)).getText().toString());
		bodyLogVal.put(Schema.BodyLog.Columns.RECDATE_TIME.column(), new Date().toString());
		db.insert(Schema.BodyLog.TABLE_NAME, null, bodyLogVal);
		
		db.setTransactionSuccessful();
		db.endTransaction();
		Log.i("kk", "insert");
	}

	/**
	 * 日付を設定する<br>
	 * *今のところbuttonにValueセットする処理。
	 * @param id id
	 */
	private void setDate(final int id) {
		// 日付選択ダイアログ
		Calendar cal = Calendar.getInstance();
		DatePickerDialog dpDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				Button birthday = (Button) findViewById(id);
				birthday.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
			}
		}, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.HOUR_OF_DAY));
		
		// タイトルを設定
		dpDialog.setTitle("日付を選択してください");
		dpDialog.show();
	}
}
