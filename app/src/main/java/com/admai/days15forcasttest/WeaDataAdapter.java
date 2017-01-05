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
	private List<WeatherDailyModel> mDatas;
	private int mLowestTem;
	private int mHighestTem;
	onItemClickListener mOnItemClickListener;
	
	public void setOnItemClickListener(onItemClickListener onItemClickListener) {
		mOnItemClickListener = onItemClickListener;
	}
	
	public WeaDataAdapter(Context context, List<WeatherDailyModel> datats, int lowtem, int hightem) {
		mContext = context;
		mInflater = LayoutInflater.from(context);
		mDatas = datats;
		mLowestTem = lowtem;
		mHighestTem = hightem;
	}
	
	@Override
	public WeatherDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = mInflater.inflate(R.layout.item_weather_item, parent, false);
		final WeatherDataViewHolder viewHolder = new WeatherDataViewHolder(view);
		viewHolder.dayText = (TextView) view.findViewById(R.id.id_day_text_tv);
		viewHolder.dayIcon = (ImageView) view.findViewById(R.id.id_day_icon_iv);
//		viewHolder.weatherLineView = (WeatherLineView) view.findViewById(R.id.wea_line);
		viewHolder.nighticon = (ImageView) view.findViewById(R.id.id_night_icon_iv);
		viewHolder.nightText = (TextView) view.findViewById(R.id.id_night_text_tv);
//		viewHolder.ll_item = (LinearLayout) view.findViewById(R.id.ll_item);
		
//		viewHolder.ll_item.setOnTouchListener(new View.OnTouchListener() {
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				if (event.getAction() == MotionEvent.ACTION_DOWN) {
//					viewHolder.ll_item.setBackgroundColor(Color.BLUE);
//				}
//				if (event.getAction() == MotionEvent.ACTION_UP||event.getAction() == MotionEvent.ACTION_MOVE) {
//					viewHolder.ll_item.setBackgroundColor(Color.parseColor("#68aca3"));
//				}
//				return true;
//			}
//		});
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(WeatherDataViewHolder holder, int position) {
		// 最低温度设置为15，最高温度设置为30
		Resources resources = mContext.getResources();
		WeatherDailyModel weatherModel = mDatas.get(position);
		holder.dayText.setText(weatherModel.getText_day());
		int iconday = resources.getIdentifier("wth_code_" + weatherModel.getCode_day(), "drawable", mContext.getPackageName());
		if (iconday == 0) {
			holder.dayIcon.setImageResource(R.drawable.www1);
		} else {
			holder.dayIcon.setImageResource(iconday);
		}
//		holder.weatherLineView.setLowHighestData(mLowestTem, mHighestTem);
		int iconight = resources.getIdentifier("wth_code_" + weatherModel.getCode_day(), "drawable", mContext.getPackageName());
		if (iconight == 0) {
			holder.nighticon.setImageResource(R.drawable.www2);
		} else {
			holder.nighticon.setImageResource(iconight);
		}
		holder.nightText.setText(weatherModel.getText_night());
		int low[] = new int[3];
		int high[] = new int[3];
		low[1] = weatherModel.getLow();
		high[1] = weatherModel.getHigh();
		if (position <= 0) {
			low[0] = 0;
			high[0] = 0;
		} else {
			WeatherDailyModel weatherModelLeft = mDatas.get(position - 1);
			low[0] = (weatherModelLeft.getLow() + weatherModel.getLow()) / 2;
			high[0] = (weatherModelLeft.getHigh() + weatherModel.getHigh()) / 2;
		}
		if (position >= mDatas.size() - 1) {
			low[2] = 0;
			high[2] = 0;
		} else {
			WeatherDailyModel weatherModelRight = mDatas.get(position + 1);
			low[2] = (weatherModel.getLow() + weatherModelRight.getLow()) / 2;
			high[2] = (weatherModel.getHigh() + weatherModelRight.getHigh()) / 2;
		}
//		holder.weatherLineView.setLowHighData(low, high);
	}
	
	@Override
	public int getItemCount() {
		return mDatas.size();
	}
	
	public static class WeatherDataViewHolder extends RecyclerView.ViewHolder {
		
		TextView dayText;
		ImageView dayIcon;
//		WeatherLineView weatherLineView;
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
