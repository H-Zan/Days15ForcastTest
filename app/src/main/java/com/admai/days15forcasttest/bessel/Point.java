package com.admai.days15forcasttest.bessel;

import android.graphics.Rect;

/**
 * 结点
 * @author tomkeyzhang（qitongzhang@anjuke.com）
 * @date :2014年4月17日
 */
public class Point {
    /**是否在图形中绘制出此结点*/
    public boolean willDrawing;
    /** 在canvas中的X坐标 */
    public float x;
    /** 在canvas中的Y坐标 */
    public float y;
    public Rect txtTempRect;
    public Point() {
	}

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
