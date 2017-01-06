
package com.admai.days15forcasttest.bessel;

import android.graphics.Rect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BesselCalculator {

    /** 图形的高度 */
    public int height;
    /** 图形的宽度 */
    public int width;
    /** 横轴的长度 */
    public int xAxisWidth; 
    //item宽度
    public int itemWidth;
    /** 画布X轴的平移，用于实现曲线图的滚动效果 */
    private ChartData data;
    /** 光滑因子 */
    private float smoothness;
    
    public BesselCalculator(ChartData data) {
        this.data = data;
        this.smoothness = 0.33f;
    }
    
    public void setItemWidth(int itemWidth) {
        this.itemWidth = itemWidth;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * 计算图形绘制的参数信息
     * 
     * 
     */
    public void compute(int itemHeight,int itemWidth,int mar_h,int mar_s,int pointR) {
        this.height = itemHeight;
        computeSeriesCoordinate(itemHeight,itemWidth,mar_h,mar_s,pointR);// 计算坐标点
        computeBesselPoints();// 计算贝塞尔结点
    }
    
 /** 计算序列的坐标信息 */
    private void computeSeriesCoordinate(int itemHeight,int itemWidth,int mar_h,int mar_s,int pointR) {
        for (Series series : data.getSeriesList()) {
            List<Point> points = series.getPoints();
            List<Integer> temps = series.getTemps();
            xAxisWidth = temps.size() * itemWidth;
            points.clear();
            Integer maxTemp = Collections.max(temps);
            Integer minTemp = Collections.min(temps);
            if (series.isUp) {
                for (int i = 0; i < temps.size(); i++) {
                    Point point = new Point();
                    // 计算数据点的坐标
                    point.x = itemWidth/2 + i*itemWidth;
                    point.y = itemHeight - mar_s - (temps.get(i) - minTemp) * 1.0f / (maxTemp - minTemp) * (itemHeight - mar_h - mar_s);
                    // itemHeight - (点距离下部) - (temps.get(i) - minTemp) * 1.0f / (maxTemp - minTemp) * (itemHeight - mar_h);
                    point.txtTempRect = new Rect(i*itemWidth, (int) point.y - 6*pointR  ,(i+1)*itemWidth, (int) point.y - 2*pointR);
                    points.add(point);
                }
            }else {
                this.height = 2*itemHeight;
                for (int i = 0; i < temps.size(); i++) {
                    Point point = new Point();
                    // 计算数据点的坐标
                    point.x = itemWidth/2 + i*itemWidth;
                    point.y = height - mar_h - (temps.get(i) - minTemp) * 1.0f / (maxTemp - minTemp) * (itemHeight - mar_h - mar_s);
                    point.txtTempRect = new Rect(i*itemWidth, (int) point.y+6*pointR  ,(i+1)*itemWidth, (int) point.y+2*pointR);
                    points.add(point);
                } 
            }
        }
    }
    

    
    /** 计算贝塞尔结点 */
    private void computeBesselPoints() {
        for (Series series : data.getSeriesList()) {    //几条线
            List<Point> besselPoints = series.getBesselPoints();
            List<Point> points = new ArrayList<Point>();
            for (Point point : series.getPoints()) {
//                if (point.valueY > 0)
                    points.add(point);
            }
            int count = points.size();
            if (count < 2)
                continue;
            besselPoints.clear();
            for (int i = 0; i < count; i++) {
                if (i == 0 || i == count - 1) {
                    computeUnMonotonePoints(i, points, besselPoints);
                } else {
                    Point p0 = points.get(i - 1);
                    Point p1 = points.get(i);
                    Point p2 = points.get(i + 1);
                    if ((p1.y - p0.y) * (p1.y - p2.y) >= 0) {// 极值点
                        computeUnMonotonePoints(i, points, besselPoints);
                    } else {
                        computeMonotonePoints(i, points, besselPoints);
                    }
                }
            }
        }
    }

    /** 计算非单调情况的贝塞尔结点 */
    private void computeUnMonotonePoints(int i, List<Point> points, List<Point> besselPoints) {
        if (i == 0) {
            Point p1 = points.get(0);
            Point p2 = points.get(1);
            besselPoints.add(p1);
            besselPoints.add(new Point(p1.x + (p2.x - p1.x) * smoothness, p1.y));
        } else if (i == points.size() - 1) {
            Point p0 = points.get(i - 1);
            Point p1 = points.get(i);
            besselPoints.add(new Point(p1.x - (p1.x - p0.x) * smoothness, p1.y));
            besselPoints.add(p1);
        } else {
            Point p0 = points.get(i - 1);
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            besselPoints.add(new Point(p1.x - (p1.x - p0.x) * smoothness, p1.y));
            besselPoints.add(p1);
            besselPoints.add(new Point(p1.x + (p2.x - p1.x) * smoothness, p1.y));
        }
    }

    /**
     * 计算单调情况的贝塞尔结点
     * 
     * @param i
     * @param points
     * @param besselPoints
     */
    private void computeMonotonePoints(int i, List<Point> points, List<Point> besselPoints) {
        Point p0 = points.get(i - 1);
        Point p1 = points.get(i);
        Point p2 = points.get(i + 1);
        float k = (p2.y - p0.y) / (p2.x - p0.x);
        float b = p1.y - k * p1.x;
        Point p01 = new Point();
        p01.x = p1.x - (p1.x - (p0.y - b) / k) * smoothness;
        p01.y = k * p01.x + b;
        besselPoints.add(p01);
        besselPoints.add(p1);
        Point p11 = new Point();
        p11.x = p1.x + (p2.x - p1.x) * smoothness;
        p11.y = k * p11.x + b;
        besselPoints.add(p11);
    }

    public void setSmoothness(float smoothness) {
        this.smoothness = smoothness;
    }
}
