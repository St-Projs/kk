package org.st.projs.android.kk.db.dto;

public class MeasureResultDto {
	
	private int user_id;
	private int measure_id;
	private int mode;
	private double shohi_calorie;
	private double kyori;
	private String s_time;
	private String e_time;

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
	 * @return the measure_id
	 */
	public int getMeasure_id() {
		return measure_id;
	}
	/**
	 * @param measure_id the measure_id to set
	 */
	public void setMeasure_id(int measure_id) {
		this.measure_id = measure_id;
	}
	/**
	 * @return the mode
	 */
	public int getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(int mode) {
		this.mode = mode;
	}
	/**
	 * @return the shohi_calorie
	 */
	public double getShohi_calorie() {
		return shohi_calorie;
	}
	/**
	 * @param shohi_calorie the shohi_calorie to set
	 */
	public void setShohi_calorie(double shohi_calorie) {
		this.shohi_calorie = shohi_calorie;
	}
	/**
	 * @return the kyori
	 */
	public double getKyori() {
		return kyori;
	}
	/**
	 * @param kyori the kyori to set
	 */
	public void setKyori(double kyori) {
		this.kyori = kyori;
	}
	/**
	 * @return the s_time
	 */
	public String getS_time() {
		return s_time;
	}
	/**
	 * @param s_time the s_time to set
	 */
	public void setS_time(String s_time) {
		this.s_time = s_time;
	}
	/**
	 * @return the e_time
	 */
	public String getE_time() {
		return e_time;
	}
	/**
	 * @param e_time the e_time to set
	 */
	public void setE_time(String e_time) {
		this.e_time = e_time;
	}

}
