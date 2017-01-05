package com.admai.days15forcasttest;

/**
 * Created by ZAN on 16/12/29.
 */
public class WeatherDailyModel {
	
	private static final String TAG = WeatherDailyModel.class.getSimpleName();
	/**
	 * date : 2016-05-30
	 * text_day : 多云
	 * code_day : 4
	 * text_night : 阴
	 * code_night : 9
	 * high : 34
	 * low : 22
	 */
	private String date;
	private String text_day;
	private int code_day;
	private String text_night;
	private int code_night;
	private int high;
	private int low;
	
	public WeatherDailyModel(String date, String text_day, int code_day, String text_night, int code_night, int high, int low) {
		this.date = date;
		this.text_day = text_day;
		this.code_day = code_day;
		this.text_night = text_night;
		this.code_night = code_night;
		this.high = high;
		this.low = low;
	}
	
	public void setHigh(int high) {
		this.high = high;
	}
	
	public void setLow(int low) {
		this.low = low;
	}
	
	public String getText_day() {
		return text_day;
	}
	
	public int getCode_day() {
		return code_day;
	}
	
	public String getText_night() {
		return text_night;
	}
	
	public int getLow() {
		return low;
	}
	
	public int getHigh() {
		return high;
	}
}
