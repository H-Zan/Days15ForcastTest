package com.admai.days15forcasttest.bessel;

import java.util.ArrayList;
import java.util.List;

public class Series {
	/** 序列曲线的标题 */
	//    private Title title;
	/**
	 * 序列曲线的颜色
	 */
	private int color;
	
	public int pointR;
	/**
	 * 序列点集合
	 */
	private List<Point> points;
	/**
	 * 贝塞尔曲线点
	 */
	private List<Point> besselPoints;
	
	private List<Integer> temps;
	
	private int maxTemp;
	
	private int minTemp;
	public boolean isUp;
	
	//	/**
//	 * @param color
//	 * 	曲线的颜色
//	 * @param points
//	 * 	点集合
//	 */
//	public Series(String title, int color, List<Point> points) {
//		//        this.title=new Title(title, color);
//		this.color = color;
//		this.points = points;
//		this.besselPoints = new ArrayList<Point>();
//	}
//	
	public Series(int color, List<Integer> temps) {
		this.color = color;
		this.temps = temps;
		this.besselPoints = new ArrayList<Point>();
		this.points = new ArrayList<Point>();
	}
	
	public int getColor() {
		return color;
	}
	
	public List<Point> getPoints() {
		return points;
	}
	
	public List<Integer> getTemps() {
		return temps;
	}
	
	public List<Point> getBesselPoints() {
		return besselPoints;
	}
	
	public int getMaxTemp() {
		return maxTemp;
	}
	
	public void setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
	}
	
	public int getMinTemp() {
		return minTemp;
	}
	
	public void setMinTemp(int minTemp) {
		this.minTemp = minTemp;
	}
	public void setUp(boolean up) {
		isUp = up;
	}
	public void setPointR(int r) {
		this.pointR = r;
	}
}
