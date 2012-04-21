package org.st.projs.android.kk.db.dto;

public class BodyLogDto {
	/** ユーザID */
	private int user_id;
	/** 身長(cm) */
	private int height;
	/** 体重(kg) */
	private double weight;
	/** 体脂肪率 */
	private int body_fat;
	/** ?体内年齢? */
	private int body_age;
	/** 骨密度 */
	private int bone_density;
	/** ?測定日? */
	private String measure_date;
	/** 登録日 */
	private String recdate_time;


	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * @return the body_fat
	 */
	public int getBody_fat() {
		return body_fat;
	}
	/**
	 * @param body_fat the body_fat to set
	 */
	public void setBody_fat(int body_fat) {
		this.body_fat = body_fat;
	}
	/**
	 * @return the body_age
	 */
	public int getBody_age() {
		return body_age;
	}
	/**
	 * @param body_age the body_age to set
	 */
	public void setBody_age(int body_age) {
		this.body_age = body_age;
	}
	/**
	 * @return the bone_density
	 */
	public int getBone_density() {
		return bone_density;
	}
	/**
	 * @param bone_density the bone_density to set
	 */
	public void setBone_density(int bone_density) {
		this.bone_density = bone_density;
	}
	/**
	 * @return the measure_date
	 */
	public String getMeasure_date() {
		return measure_date;
	}
	/**
	 * @param measure_date the measure_date to set
	 */
	public void setMeasure_date(String measure_date) {
		this.measure_date = measure_date;
	}	
	/**
	 * @return the recdate_time
	 */
	public String getRecdate_time() {
		return recdate_time;
	}
	/**
	 * @param recdate_time the recdate_time to set
	 */
	public void setRecdate_time(String recdate_time) {
		this.recdate_time = recdate_time;
	}
}
