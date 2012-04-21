package org.st.projs.android.kk.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.st.projs.android.kk.db.Schema.BodyLog;
import org.st.projs.android.kk.db.dto.BodyLogDto;
import org.st.projs.android.util.DaoException;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class BodyLogDao extends DaoBase {

	private static final String[] COLUMNS = { BodyLog.Columns.USER_ID.column(),
			BodyLog.Columns.HEIGHT.column(), BodyLog.Columns.WEIGHT.column(),
			BodyLog.Columns.BODY_FAT.column(),
			BodyLog.Columns.BODY_AGE.column(),
			BodyLog.Columns.BONE_DENSITY.column(),
			BodyLog.Columns.MEASURE_DATE.column(),
			BodyLog.Columns.RECDATE_TIME.column() };

	public BodyLogDao(SQLiteDatabase db) {
		super(db);
	}

	public List<BodyLogDto> findAll() {
		Cursor cursor = null;
		try {
			List<BodyLogDto> list = new ArrayList<BodyLogDto>();
			cursor = db.query(BodyLog.TABLE_NAME, COLUMNS, null, null, null,
					null, BodyLog.Columns.USER_ID.column());

			if (cursor.moveToFirst()) {
				do {
					list.add(BodyLog.convert(cursor));
				} while (cursor.moveToNext());
			}
			return list;
		} catch (SQLException e) {
			throw new DaoException(DaoException.Error.ERROR, e);
		} finally {
			if (cursor != null) {
				try {
					cursor.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
