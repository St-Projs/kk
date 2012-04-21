package org.st.projs.android.kk.db;

import org.st.projs.android.kk.db.Schema.BodyLog;
import org.st.projs.android.kk.db.Schema.MeasureResult;
import org.st.projs.android.kk.db.Schema.MstMets;
import org.st.projs.android.kk.db.Schema.MstUsers;
import org.st.projs.android.kk.db.Schema.PositionInfo;
import org.st.projs.android.kk.db.Schema.Tos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class KKDbHelper extends SQLiteOpenHelper {

	private static final String _REAL_NOT_NULL = " REAL NOT NULL";
	private static final String _TEXT_NOT_NULL = " TEXT NOT NULL";
	private static final String _TEXT = " TEXT";
	private static final String leftP = "(";
	private static final String rightPEnd = ");";
	private static final String comma_ = ", ";
	private static final String DATABASE_NAME = "kk.db";
	private static final int DATABASE_VERSION = 1;

	private static final String SQL_CREATE_TABLE_MST_USERS = "CREATE TABLE "
			+ MstUsers.TABLE_NAME + leftP + MstUsers.Columns.ID.column()
			+ " INTEGER PRIMARY KEY" + comma_ + MstUsers.Columns.USER_ID.column()
			+ _TEXT + comma_ + MstUsers.Columns.PASSWORD.column() + _TEXT
			+ comma_ + MstUsers.Columns.NAME_SEI.column() + _TEXT_NOT_NULL
			+ comma_ + MstUsers.Columns.NAME_NA.column() + _TEXT_NOT_NULL
			+ comma_ + MstUsers.Columns.FRGNA_SEI.column() + _TEXT + comma_
			+ MstUsers.Columns.FRGNA_NA.column() + _TEXT + comma_
			+ MstUsers.Columns.BIRTHDAY.column() + _TEXT_NOT_NULL + comma_
			+ MstUsers.Columns.SEX.column() + " INTEGER NOT NULL" + comma_
			+ MstUsers.Columns.E_MAIL.column() + _TEXT + comma_
			+ MstUsers.Columns.RECDATE_TIME.column() + _TEXT_NOT_NULL + rightPEnd;

	private static final String SQL_CREATE_TABLE_MST_METS = "CREATE TABLE "
			+ MstMets.TABLE_NAME + leftP + MstMets.Columns.ID.cloumn()
			+ " INTEGER PRIMARY KEY" + comma_ + MstMets.Columns.MODE.cloumn()
			+ _TEXT_NOT_NULL + comma_ + MstMets.Columns.SPEED.cloumn()
			+ _REAL_NOT_NULL + comma_ + MstMets.Columns.METS.cloumn()
			+ _REAL_NOT_NULL + rightPEnd;

	private static final String SQL_CREATE_TABLE_TOS = "CREATE TABLE "
			+ Tos.TABLE_NAME + leftP + Tos.Columns.DEL_FLAG.column() + " INTEGER"
			+ comma_ + Tos.Columns.MSG.column() + _TEXT + comma_
			+ Tos.Columns.UPDATE_TIME.column() + _TEXT + comma_
			+ Tos.Columns.RECDATE_TIME.column() + _TEXT + rightPEnd;

	private static final String SQL_CREATE_TABLE_BODY_LOG = "CREATE TABLE "
			+ BodyLog.TABLE_NAME + leftP + BodyLog.Columns.USER_ID.column()
			+ " INTEGER NOT NULL" + comma_ + BodyLog.Columns.HEIGHT.column()
			+ " INTEGER NOT NULL" + comma_ + BodyLog.Columns.WEIGHT.column()
			+ _REAL_NOT_NULL + comma_ + BodyLog.Columns.BODY_FAT.column()
			+ " INTEGER" + comma_ + BodyLog.Columns.BODY_AGE.column()
			+ " INTEGER" + comma_ + BodyLog.Columns.BONE_DENSITY.column()
			+ " INTEGER" + comma_ + BodyLog.Columns.MEASURE_DATE.column()
			+ _TEXT_NOT_NULL + comma_ + BodyLog.Columns.RECDATE_TIME.column()
			+ " TEXT NOT NULL " + rightPEnd;

	private static final String SQL_CREATE_TABLE_POSITION_INFO = "CREATE TABLE "
			+ PositionInfo.TABLE_NAME
			+ leftP
			+ PositionInfo.Columns.MEASURE_ID.column()
			+ " INTEGER NOT NULL"
			+ comma_
			+ PositionInfo.Columns.POSI_NO.column()
			+ " INTEGER NOT NULL"
			+ comma_
			+ PositionInfo.Columns.LATITUDE.column()
			+ _REAL_NOT_NULL
			+ comma_
			+ PositionInfo.Columns.LONGITUDE.column()
			+ _REAL_NOT_NULL
			+ comma_
			+ PositionInfo.Columns.ALTITUDE.column()
			+ " REAL"
			+ comma_
			+ PositionInfo.Columns.RECDATE_TIME + _TEXT_NOT_NULL + rightPEnd;

	private static final String SQL_CREATE_TABLE_MEASURE_RESULT = "CREATE TABLE "
			+ MeasureResult.TABLE_NAME
			+ leftP
			+ MeasureResult.Columns.USER_ID.column()
			+ " INTEGER NOT NULL"
			+ comma_
			+ MeasureResult.Columns.MEASURE_ID.column()
			+ " INTEGER NOT NULL"
			+ comma_
			+ MeasureResult.Columns.MODE.column()
			+ " INTEGER NOT NULL"
			+ comma_
			+ MeasureResult.Columns.SHOHI_CALORIE.column()
			+ _REAL_NOT_NULL
			+ comma_
			+ MeasureResult.Columns.KYORI.column()
			+ _REAL_NOT_NULL
			+ comma_
			+ MeasureResult.Columns.S_TIME.column()
			+ _TEXT_NOT_NULL
			+ comma_
			+ MeasureResult.Columns.E_TIME.column()
			+ _TEXT_NOT_NULL
			+ rightPEnd;

	public KKDbHelper(final Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public KKDbHelper(final Context context, final String name, final CursorFactory factory,
			final int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(final SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_TABLE_MST_USERS);
		db.execSQL(SQL_CREATE_TABLE_MST_METS);
		db.execSQL(SQL_CREATE_TABLE_TOS);
		db.execSQL(SQL_CREATE_TABLE_BODY_LOG);
		db.execSQL(SQL_CREATE_TABLE_POSITION_INFO);
		db.execSQL(SQL_CREATE_TABLE_MEASURE_RESULT);
	}

	@Override
	public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + BodyLog.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + MeasureResult.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + MstMets.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + MstUsers.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + PositionInfo.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Tos.TABLE_NAME);

		onCreate(db);
	}

}
