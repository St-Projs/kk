package org.st.projs.android.kk.db.dao;

import android.database.sqlite.SQLiteDatabase;

public class DaoBase {
	
	// SQLitDatabase
	protected SQLiteDatabase db;
	
	public DaoBase(SQLiteDatabase db){
		this.db = db;
	}

}
