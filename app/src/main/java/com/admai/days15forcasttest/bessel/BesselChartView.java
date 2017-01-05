package com.admai.days15forcasttest.bessel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Scroller;

import com.admai.days15forcasttest.hours.DisplayUtil;

import java.util.List;

/**
 * 贝塞尔曲线图
 * 
 * @author tomkeyzhang（qitongzhang@anjuke.com）
 * @date :2014年5月4日
 */
public class BesselChartView extends View {
    /** 通用画笔 */
    private Paint paint;
    /** 曲线的路径，用于绘制曲线 */
    private Path curvePath;
    /** 曲线图绘制的计算信息 */
    private BesselCalculator calculator;
    /** 曲线图的样式 */
    private ChartStyle style;
    /** 曲线图的数据 */
    private ChartData data;
    /** 手势解析 */
    private GestureDetector detector;
    /** 是否绘制全部贝塞尔结点 */
    private boolean drawBesselPoint;
    /** 滚动计算器 */
    private Scroller scroller;
    /** 曲线图事件监听器 */
//    private ChartListener chartListener;

    public BesselChartView(Context context, ChartData data, ChartStyle style, BesselCalculator calculator) {
        super(context);
        setBackgroundColor(Color.TRANSPARENT);//背景色
        this.calculator = calculator;
        this.data = data;
        this.style = style;
        this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.curvePath = new Path();
        this.drawBesselPoint = false;
        this.scroller = new Scroller(context);

        this.detector = new GestureDetector(getContext(), new SimpleOnGestureListener() {
            float lastScrollX = 0f;
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                if (Math.abs(distanceX / distanceY) > 1) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    BesselChartView.this.calculator.move(distanceX);
                    ViewCompat.postInvalidateOnAnimation(BesselChartView.this);
                    if (e1.getX() != lastScrollX) {
                        lastScrollX = e1.getX();
//                        if (chartListener != null)
//                            chartListener.onMove();
                    }
                    return true;
                }
                return false;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                scroller.fling((int) BesselChartView.this.calculator.getTranslateX(), 0, (int) velocityX, 0, -getWidth(), 0, 0, 0);
                ViewCompat.postInvalidateOnAnimation(BesselChartView.this);
                return true;
            }

            @Override
            public boolean onDown(MotionEvent e) {
                scroller.forceFinished(true);
                ViewCompat.postInvalidateOnAnimation(BesselChartView.this);
                return true;
            }
        });
    }

    public void animateScrollToEnd(int duration) {
        scroller.startScroll(0, 0, -calculator.xAxisWidth / 2, 0, duration);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
            calculator.moveTo(scroller.getCurrX());
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (data.getSeriesList().size() == 0)
            return;
        calculator.ensureTranslation();
        canvas.translate(calculator.getTranslateX(), 0);
        
        drawCurveAndPoints(canvas);
    }

    /** 绘制曲线和结点 */
    private void drawCurveAndPoints(Canvas canvas) {
        paint.setStrokeWidth(DisplayUtil.dip2px(getContext(), 2));
        for (Series series : data.getSeriesList()) {
            paint.setColor(series.getColor());
            curvePath.reset();
            List<Point> list = series.getBesselPoints();
            for (int i = 0; i < list.size(); i = i + 3) {
                if (i == 0) {
                    curvePath.moveTo(list.get(i).x, list.get(i).y);
                } else {
                    curvePath.cubicTo(list.get(i - 2).x, list.get(i - 2).y, list.get(i - 1).x, list.get(i - 1).y, list.get(i).x, list.get(i).y);
                }
            }
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(curvePath, paint);// 绘制光滑曲线
            paint.setStyle(Paint.Style.FILL);
            List<Point> points = series.getPoints();
                for (int i = 0; i < points.size(); i++) {
                    Point point = points.get(i);
                    canvas.drawCircle(point.x, point.y, series.pointR, paint);
                    Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
                    int baseline = (point.txtTempRect.bottom + point.txtTempRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
                    paint.setTextAlign(Paint.Align.CENTER);
                    paint.setTextSize(DisplayUtil.dip2px(getContext(),12));
                    canvas.drawText(String.valueOf(series.getTemps().get(i)), point.txtTempRect.centerX(), baseline, paint);
                }// 绘制结点
            if (drawBesselPoint) {
                for (Point point : list) {
                    if (!points.contains(point)) {
                        paint.setColor(Color.BLUE);
                        paint.setAlpha(255);
                        canvas.drawCircle(point.x, point.y, 5, paint);
                    }
                }// 绘制贝塞尔控制结点
            }
        }
    }
    
    public void updateSize() {
//        LayoutParams lp = getLayoutParams();
//        lp.height = calculator.height;
//        lp.width = calculator.xAxisWidth;
        setLayoutParams(new LayoutParams(calculator.xAxisWidth,calculator.height));
    }

    public void setDrawBesselPoint(boolean drawBesselPoint) {
        this.drawBesselPoint = drawBesselPoint;
    }
}
