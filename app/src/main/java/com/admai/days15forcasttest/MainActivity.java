package com.admai.days15forcasttest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.admai.days15forcasttest.bessel.BesselCalculator;
import com.admai.days15forcasttest.bessel.BesselChartView;
import com.admai.days15forcasttest.bessel.ChartData;
import com.admai.days15forcasttest.bessel.ChartStyle;
import com.admai.days15forcasttest.bessel.Series;
import com.admai.days15forcasttest.hours.DisplayUtil;
import com.admai.days15forcasttest.hours.IndexHorizontalScrollView;
import com.admai.days15forcasttest.hours.Today24HourView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;



public class MainActivity extends AppCompatActivity {
	
	private RecyclerView mRecyclerView;
	private List<WeatherDailyModel> mWeatherModels;
	private WeaDataAdapter mWeaDataAdapter;
	private IndexHorizontalScrollView indexHorizontalScrollView;
	private Today24HourView today24HourView;
	private RelativeLayout mLChart;
	private ChartStyle style;
	private ChartData data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();  
//		initViews();
		initBessel();
		fillDatatoRecyclerView(createDatas());
	}
	
	
	
	private void initView() {
		//得到控件
		mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_horizontal);
		//设置布局管理器
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
		mRecyclerView.setLayoutManager(layoutManager);
		
	}
	
	private void initBessel() {
		mLChart = (RelativeLayout) findViewById(R.id.ll_chart);
		List<Series> seriess = new ArrayList<Series>();
		ArrayList<Integer> temps = new ArrayList<>();
		ArrayList<Integer> temps2 = new ArrayList<>();
		Random random = new Random();
		int maxTemp = 25;
		int minTemp = 15;
		int maxTemp2 = 15;
		int minTemp2 = 5;
		for (int i = 0; i < 15; i++) {
			int e = random.nextInt(maxTemp) % (maxTemp - minTemp + 1) + minTemp;
			int e2 = random.nextInt(maxTemp2) % (maxTemp2 - minTemp2 + 1) + minTemp2;
			temps.add(e);
			temps2.add(e2);
		}
		Series series = new Series(Color.RED, temps);
		Series series2 = new Series(Color.BLUE, temps2);
		series.setUp(true);
		series.setPointR(DisplayUtil.dip2px(this, 3));
		series2.setUp(false);
		series2.setPointR(DisplayUtil.dip2px(this, 3));
		seriess.add(series);
		seriess.add(series2);
		style = new ChartStyle();
		data = new ChartData();
		data.setSeriesList(seriess);
		BesselCalculator calculator = new BesselCalculator(data, style);
		calculator.compute(DisplayUtil.dip2px(this, 80),DisplayUtil.dip2px(this, 80),DisplayUtil.dip2px(this, 20));
		BesselChartView besselChartView = new BesselChartView(this, data, style, calculator);
		besselChartView.updateSize();
		mLChart.addView(besselChartView);
		
	}
	
	
	/**
	 * date : 2016-05-30
	 * text_day : 多云
	 * code_day : 4
	 * text_night : 阴
	 * code_night : 9
	 * high : 34
	 * low : 22
	 */
	private List<WeatherDailyModel> createDatas(){
		List<WeatherDailyModel> weatherDailyModels = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 15; i++) {
			int e = random.nextInt(35) % (35 - 25 + 1) + 25;
			int e1 = random.nextInt(24) % (24 - 15 + 1) + 15;
			WeatherDailyModel weatherDailyModel = new WeatherDailyModel("2016-"+i,"txt_dat"+i,i,"txt_night"+i,i,e,e1);
			weatherDailyModels.add(weatherDailyModel);
		}
		return weatherDailyModels;
	}
	
	private void fillDatatoRecyclerView(List<WeatherDailyModel> daily) {
		mWeatherModels = daily;
		Collections.sort(daily, new Comparator<WeatherDailyModel>() {
			@Override
			public int compare(WeatherDailyModel lhs,
			                   WeatherDailyModel rhs) {
				// 排序找到温度最低的，按照最低温度升序排列
				return lhs.getLow() - rhs.getLow();
			}
		});
		
		int low = daily.get(0).getLow();
		
		Collections.sort(daily, new Comparator<WeatherDailyModel>() {
			@Override
			public int compare(WeatherDailyModel lhs,
			                   WeatherDailyModel rhs) {
				// 排序找到温度最高的，按照最高温度降序排列
				return rhs.getHigh() - lhs.getHigh();
			}
		});
		int high = daily.get(0).getHigh();
		
		mWeaDataAdapter = new WeaDataAdapter(this, mWeatherModels, low, high);
		mRecyclerView.setAdapter(mWeaDataAdapter);
	}
	
//	private void initViews() {
//		indexHorizontalScrollView = (IndexHorizontalScrollView)findViewById(R.id.indexHorizontalScrollView);
//		today24HourView = (Today24HourView)findViewById(R.id.today24HourView);
//		indexHorizontalScrollView.setToday24HourView(today24HourView);
//		//        LinearLayout ll_chart = (LinearLayout) findViewById(R.id.ll_chart);
//		//        ReDrawLineChartView chartView = new ReDrawLineChartView(this);
//		//        ll_chart.addView(chartView);
//		
//	}
}



