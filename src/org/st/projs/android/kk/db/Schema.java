package org.st.projs.android.kk.db;

import org.st.projs.android.kk.db.dto.BodyLogDto;
import org.st.projs.android.util.ArgumentChecker;

import android.database.Cursor;

public final class Schema {
	
	/**
	 * ユーザーマスタ <br>
	 * ユーザ情報を保持するエンティティ
	 */
	public static class MstUsers {
		public static final String TABLE_NAME = "mst_users";
		public enum Columns {
			/** _id */
			ID(android.provider.BaseColumns._ID),
			/** ユーザーID */
			USER_ID("user_id"),
			/** パスワード */
			PASSWORD("password"),
			/** 名前（性） */
			NAME_SEI("name_sei"),
			/** 名前（名） */
			NAME_NA("name_na"),
			/** ふりがな（性） */
			FRGNA_SEI("frgna_sei"),
			/** ふりがな（名） */
			FRGNA_NA("frgna_na"),
			/** 誕生日 */
			BIRTHDAY("birthday"),
			/** 性別 */
			SEX("sex"),
			/** メールアドレス */
			E_MAIL("e_mail"),
			/** 登録日 */
			RECDATE_TIME("recdate_time");

			private String column;

			private Columns(String column) {
				this.column = column;
			}

			public String column() {
				return this.column;
			}
		}
	}
	
	/**
	 * METsマスタ <br>
	 * METs値を保持するエンティティ
	 */
	public static class MstMets {
		public static final String TABLE_NAME = "mst_mets";

		public enum Columns {
			/** _id */
			ID(android.provider.BaseColumns._ID),
			/** 測定モード */
			MODE("mode"),
			/** 時速（km/h） */
			SPEED("speed"),
			/** METs値 */
			METS("mets");

			private String column;

			private Columns(String column) {
				this.column = column;
			}

			public String cloumn() {
				return this.column;
			}
		}
	}
	
	/**
	 * 利用規約<br>
	 * 利用契約を保持するエンティティ
	 */
	public static class Tos {
		public static final String TABLE_NAME = "tos";

		public enum Columns {
			/** 削除フラグ */
			DEL_FLAG("del_flag"),
			/** メッセージ */
			MSG("msg"),
			/** 更新日 */
			UPDATE_TIME("update_time"),
			/** 登録日 */
			RECDATE_TIME("recdate_time");

			private String column;

			private Columns(String column) {
				this.column = column;
			}

			public String column() {
				return this.column;
			}
		}
	}
	
	/**
	 * 身体履歴<br>
	 * ユーザの身体情報履歴を保持するエンティティ
	 */
	public static class BodyLog {
		public static final String TABLE_NAME = "body_log";

		public enum Columns {
			/** ユーザーID */
			USER_ID("user_id"),
			/** 身長 */
			HEIGHT("height"),
			/** 体重 */
			WEIGHT("weight"),
			/** 体脂肪率 */
			BODY_FAT("body_fat"),
			/** 体年齢 */
			BODY_AGE("body_age"),
			/** 骨密度 */
			BONE_DENSITY("body_density"),
			/** 測定日 */
			MEASURE_DATE("measure_date"),
			/** 登録日 */
			RECDATE_TIME("recdate_time");

			private String column;

			private Columns(String column) {
				this.column = column;
			}

			public String column() {
				return this.column;
			}
		}

		public static BodyLogDto convert(Cursor cursor) {
			ArgumentChecker.checkNull(cursor);

			int userIdIndex = cursor.getColumnIndex(Columns.USER_ID.column());
			int heightIndex = cursor.getColumnIndex(Columns.HEIGHT.column());
			int weightIndex = cursor.getColumnIndex(Columns.WEIGHT.column());
			int bodyFatIndex = cursor.getColumnIndex(Columns.BODY_FAT.column());
			int bodyAgeIndex = cursor.getColumnIndex(Columns.BODY_AGE.column());
			int bodyDensityIndex = cursor.getColumnIndex(Columns.BONE_DENSITY
					.column());
			int measreDateIndex = cursor.getColumnIndex(Columns.MEASURE_DATE
					.column());
			int recDateTimeIndex = cursor.getColumnIndex(Columns.RECDATE_TIME
					.column());

			ArgumentChecker.checkRange(userIdIndex, 0, Integer.MAX_VALUE);
			ArgumentChecker.checkRange(heightIndex, 0, Integer.MAX_VALUE);
			ArgumentChecker.checkRange(weightIndex, 0, Integer.MAX_VALUE);
			ArgumentChecker.checkRange(bodyFatIndex, 0, Integer.MAX_VALUE);
			ArgumentChecker.checkRange(bodyAgeIndex, 0, Integer.MAX_VALUE);
			ArgumentChecker.checkRange(bodyDensityIndex, 0, Integer.MAX_VALUE);
			ArgumentChecker.checkRange(measreDateIndex, 0, Integer.MAX_VALUE);
			ArgumentChecker.checkRange(recDateTimeIndex, 0, Integer.MAX_VALUE);

			BodyLogDto dto = new BodyLogDto();

			dto.setUser_id(cursor.getInt(userIdIndex));
			dto.setHeight(cursor.getInt(heightIndex));
			dto.setWeight(cursor.getDouble(weightIndex));
			dto.setBody_fat(cursor.getInt(bodyFatIndex));
			dto.setBody_age(cursor.getInt(bodyAgeIndex));
			dto.setBone_density(cursor.getInt(bodyDensityIndex));
			dto.setMeasure_date(cursor.getString(recDateTimeIndex));
			dto.setRecdate_time(cursor.getString(recDateTimeIndex));

			return dto;
		}
	}
	
	/**
	 * 位置情報<br>
	 * 位置情報を保持するエンティティ
	 */
	public static class PositionInfo {
		public static final String TABLE_NAME = "position_info";

		public enum Columns {
			/** 測定ID */
			MEASURE_ID("measure_id"),
			/** 位置NO */
			POSI_NO("posi_no"),
			/** 緯度 */
			LATITUDE("latitude"),
			/** 経度 */
			LONGITUDE("longitude"),
			/** 高度 */
			ALTITUDE("altitude"),
			/** 登録日時 */
			RECDATE_TIME("recdate_time");

			private String column;

			private Columns(String column) {
				this.column = column;
			}

			public String column() {
				return this.column;
			}
		}
	}
	
	/**
	 * 測定結果<br>
	 * 測定結果を保持するエンティティ
	 */
	public static class MeasureResult {
		public static final String TABLE_NAME = "measure_result";

		public enum Columns {
			/** ユーザーID */
			USER_ID("user_id"),
			/** 測定ID */
			MEASURE_ID("measure_id"),
			/** 測定モード */
			MODE("mode"),
			/** 消費カロリー */
			SHOHI_CALORIE("shohi_calorie"),
			/** 距離 */
			KYORI("kyori"),
			/** 開始時刻 */
			S_TIME("s_time"),
			/** 終了時刻 */
			E_TIME("e_time");

			private String column;

			private Columns(String column) {
				this.column = column;
			}

			public String column() {
				return this.column;
			}
		}
	}

}
