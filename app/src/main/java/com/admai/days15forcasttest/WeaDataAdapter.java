package com.admai.days15forcasttest;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ZAN on 16/12/29.
 */
public class WeaDataAdapter extends RecyclerView.Adapter<WeaDataAdapter.WeatherDataViewHolder>{
	
	private static final String TAG = WeaDataAdapter.class.getSimpleName();
	private Context mContext;
	private LayoutInflater mInflater;
//	private List<WeatherDailyModel> mDatas;
	private List<com.admai.days15forcasttest.bean.weatherBean.ShowapiResBodyBean.DayListBean> mDatas;
	private int mLowestTem;
	private int mHighestTem;
	onItemClickListener mOnItemClickListener;
	
	public void setOnItemClickListener(onItemClickListener onItemClickListener) {
		mOnItemClickListener = onItemClickListener;
	}
	
//	public WeaDataAdapter(Context context, List<WeatherDailyModel> datats, int lowtem, int hightem) {
//		mContext = context;
//		mInflater = LayoutInflater.from(context);
//		mDatas = datats;
//		mLowestTem = lowtem;
//		mHighestTem = hightem;
//	}
	public WeaDataAdapter(Context context, List<com.admai.days15forcasttest.bean.weatherBean.ShowapiResBodyBean.DayListBean> datats) {
		mContext = context;
		mInflater = LayoutInflater.from(context);
		mDatas = datats;
	}
	
	@Override
	public WeatherDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = mInflater.inflate(R.layout.item_weather_item, parent, false);
		final WeatherDataViewHolder viewHolder = new WeatherDataViewHolder(view);
		viewHolder.dayText = (TextView) view.findViewById(R.id.id_day_text_tv);
		viewHolder.txt_aqi = (TextView) view.findViewById(R.id.txt_aqi);
		viewHolder.txt_date_num = (TextView) view.findViewById(R.id.txt_date_num);
		viewHolder.txt_weekday = (TextView) view.findViewById(R.id.txt_weekday);
		viewHolder.txt_wind_dau = (TextView) view.findViewById(R.id.txt_wind_dura);
		viewHolder.txt_wind_power = (TextView) view.findViewById(R.id.txt_wind_power);
		viewHolder.dayIcon = (ImageView) view.findViewById(R.id.id_day_icon_iv);
		viewHolder.nighticon = (ImageView) view.findViewById(R.id.id_night_icon_iv);
		viewHolder.nightText = (TextView) view.findViewById(R.id.id_night_text_tv);
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(WeatherDataViewHolder holder, int position) {
		// 最低温度设置为15，最高温度设置为30
		Resources resources = mContext.getResources();
		com.admai.days15forcasttest.bean.weatherBean.ShowapiResBodyBean.DayListBean weatherModel = mDatas.get(position);
		holder.dayText.setText(weatherModel.getDay_weather());
		holder.txt_aqi.setText("空气质量");
		holder.txt_date_num.setText(weatherModel.getDaytime().substring(4,6)+"/"+weatherModel.getDaytime().substring(6,8));
		holder.txt_weekday.setText(weatherModel.getDaytime());
		holder.txt_wind_dau.setText(weatherModel.getDay_wind_direction());
		holder.txt_wind_power.setText(weatherModel.getDay_wind_power());
//		int iconday = resources.getIdentifier("wth_code_" + weatherModel.getCode_day(), "drawable", mContext.getPackageName());
		int iconday = 0;
		if (iconday == 0) {
			holder.dayIcon.setImageResource(R.drawable.www1);
		} else {
			holder.dayIcon.setImageResource(iconday);
		}
//		holder.weatherLineView.setLowHighestData(mLowestTem, mHighestTem);
//		int iconight = resources.getIdentifier("wth_code_" + weatherModel.getCode_day(), "drawable", mContext.getPackageName());
		int iconight = 0;
		if (iconight == 0) {
			holder.nighticon.setImageResource(R.drawable.www2);
		} else {
			holder.nighticon.setImageResource(iconight);
		}
		holder.nightText.setText(weatherModel.getNight_weather());
	}
	
	@Override
	public int getItemCount() {
		return mDatas.size();
	}
	
	public static class WeatherDataViewHolder extends RecyclerView.ViewHolder {
		
		TextView txt_weekday;
		TextView txt_date_num;
		TextView txt_aqi;
		TextView txt_wind_dau;
		TextView txt_wind_power;
		TextView dayText;
		ImageView dayIcon;
		ImageView nighticon;
		TextView nightText;
		LinearLayout ll_item;
		
		public WeatherDataViewHolder(View itemView) {
			super(itemView);
		}
	}
	interface onItemClickListener{
		public void setOnItemClickListener();
		
	}
}
