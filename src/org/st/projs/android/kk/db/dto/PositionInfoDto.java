package org.st.projs.android.kk.db.dto;

public class PositionInfoDto {
	
	private int measure_id;
	private int posi_no;
	private double latitude;
	private double longitude;
	private double alitude;
	private String recdate_time;
	
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
	 * @return the posi_no
	 */
	public int getPosi_no() {
		return posi_no;
	}
	/**
	 * @param posi_no the posi_no to set
	 */
	public void setPosi_no(int posi_no) {
		this.posi_no = posi_no;
	}
	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the alitude
	 */
	public double getAlitude() {
		return alitude;
	}
	/**
	 * @param alitude the alitude to set
	 */
	public void setAlitude(double alitude) {
		this.alitude = alitude;
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
