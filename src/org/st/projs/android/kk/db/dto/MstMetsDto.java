package org.st.projs.android.kk.db.dto;

public class MstMetsDto {
	
	private int _id;
	private int mode;
	private double speed;
	private double mets;

	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(int _id) {
		this._id = _id;
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
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	/**
	 * @return the mets
	 */
	public double getMets() {
		return mets;
	}
	/**
	 * @param mets the mets to set
	 */
	public void setMets(double mets) {
		this.mets = mets;
	}

}
