package com.admai.days15forcasttest.bessel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;

import com.admai.days15forcasttest.R;

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
    /** 曲线图的数据 */
    private ChartData data;
    /** 是否绘制全部贝塞尔结点 */
    private boolean drawBesselPoint = false;
    private int mTempTextSize = 12;
    private int mTempTextColor;
    private int mBackgroundColor;
    private int mTempLineWidth = 2;
    private int mTempDotRadius = 3;
    private int mItemWidth = 80;
    private int mItemHeight = 80;
    private int mMarLong = 20;
    private int mMarShort = 0;
    
    public BesselChartView(Context context) {
        this(context, null);
    
    }
    public BesselChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public BesselChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
        initPaint();
    }
   
    
    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BesselChartView, defStyleAttr, 0);
        mTempTextSize = (int) a.getDimension(R.styleable.BesselChartView_tempTextSize, dp2px(context, mTempTextSize));
        mTempTextColor = a.getColor(R.styleable.BesselChartView_tempTextColor, Color.WHITE);
        mBackgroundColor = a.getColor(R.styleable.BesselChartView_backgroundColor, Color.TRANSPARENT);
        mTempLineWidth = (int) a.getDimension(R.styleable.BesselChartView_tempLineWidth, dp2px(context, mTempLineWidth));
        mTempDotRadius = (int) a.getDimension(R.styleable.BesselChartView_tempDotRadius, dp2px(context, mTempDotRadius));
        mItemWidth = (int) a.getDimension(R.styleable.BesselChartView_itemWidth, dp2px(context, mItemWidth));
        mItemHeight = (int) a.getDimension(R.styleable.BesselChartView_itemHeight, dp2px(context, mItemHeight));
        mMarLong = (int) a.getDimension(R.styleable.BesselChartView_marLong, dp2px(context, mMarLong));
        mMarShort = (int) a.getDimension(R.styleable.BesselChartView_marShort, dp2px(context, mMarShort));
        drawBesselPoint = a.getBoolean(R.styleable.BesselChartView_isDrawBesselPoint, drawBesselPoint);
        a.recycle();
    }
    
    
    private void initPaint() {
        setBackgroundColor(mBackgroundColor);//背景色
        this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.curvePath = new Path();
    }
    
    public void setSeriesList(List<Series> seriesList) {
        this.data = new ChartData();
        data.setSeriesList(seriesList);
        BesselCalculator calculator = new BesselCalculator(data);
        calculator.compute(mItemHeight,mItemWidth,mMarLong,mMarShort,mTempDotRadius);
        setLayoutParams(new RelativeLayout.LayoutParams(calculator.xAxisWidth, calculator.height));
    }
    
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.getResources().getDisplayMetrics());
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        if (data.getSeriesList().size() == 0)
            return;
        drawCurveAndPoints(canvas);
    }

    /** 绘制曲线和结点 */
    private void drawCurveAndPoints(Canvas canvas) {
        paint.setStrokeWidth(mTempLineWidth);
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
                    paint.setColor(series.getColor());
                    Point point = points.get(i);
                    canvas.drawCircle(point.x, point.y, mTempDotRadius, paint);
                    Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
                    int baseline = (point.txtTempRect.bottom + point.txtTempRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
                    paint.setTextAlign(Paint.Align.CENTER);
                    paint.setTextSize(mTempTextSize);
                    paint.setColor(mTempTextColor);
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
    
    public void setDrawBesselPoint(boolean drawBesselPoint) {
        this.drawBesselPoint = drawBesselPoint;
    }
}
