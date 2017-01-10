package com.admai.days15forcasttest.bean;

/**
 * Created by ZAN on 17/1/10.
 */
public class WeatherData {
	
	private static final String TAG = WeatherData.class.getSimpleName();
	public static final String weatherData = "{\n" +
	                                          "  \"showapi_res_code\": 0,\n" +
	                                          "  \"showapi_res_error\": \"\",\n" +
	                                          "  \"showapi_res_body\": {\n" +
	                                          "    \"ret_code\": 0,\n" +
	                                          "    \"area\": \"上海\",\n" +
	                                          "    \"areaid\": \"101020100\",\n" +
	                                          "    \"dayList\": [\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"06\",\n" +
	                                          "        \"day_weather\": \"多云\",\n" +
	                                          "        \"night_weather\": \"雨夹雪\",\n" +
	                                          "        \"night_wind_power\": \"微风\",\n" +
	                                          "        \"day_wind_power\": \"微风\",\n" +
	                                          "        \"day_weather_code\": \"01\",\n" +
	                                          "        \"daytime\": \"20170110\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/01.png\",\n" +
	                                          "        \"night_air_temperature\": \"1\",\n" +
	                                          "        \"day_air_temperature\": \"5\",\n" +
	                                          "        \"day_wind_direction\": \"东北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/01.png\",\n" +
	                                          "        \"night_wind_direction\": \"东北风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"08\",\n" +
	                                          "        \"day_weather\": \"中雨\",\n" +
	                                          "        \"night_weather\": \"中雨\",\n" +
	                                          "        \"night_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_wind_power\": \"微风\",\n" +
	                                          "        \"day_weather_code\": \"08\",\n" +
	                                          "        \"daytime\": \"20170111\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/08.png\",\n" +
	                                          "        \"night_air_temperature\": \"6\",\n" +
	                                          "        \"day_air_temperature\": \"9\",\n" +
	                                          "        \"day_wind_direction\": \"东北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/08.png\",\n" +
	                                          "        \"night_wind_direction\": \"北风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"08\",\n" +
	                                          "        \"day_weather\": \"中雨\",\n" +
	                                          "        \"night_weather\": \"中雨\",\n" +
	                                          "        \"night_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_weather_code\": \"08\",\n" +
	                                          "        \"daytime\": \"20170112\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/08.png\",\n" +
	                                          "        \"night_air_temperature\": \"6\",\n" +
	                                          "        \"day_air_temperature\": \"9\",\n" +
	                                          "        \"day_wind_direction\": \"北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/08.png\",\n" +
	                                          "        \"night_wind_direction\": \"北风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"08\",\n" +
	                                          "        \"day_weather\": \"中雨\",\n" +
	                                          "        \"night_weather\": \"中雨\",\n" +
	                                          "        \"night_wind_power\": \"微风\",\n" +
	                                          "        \"day_wind_power\": \"微风\",\n" +
	                                          "        \"day_weather_code\": \"08\",\n" +
	                                          "        \"daytime\": \"20170113\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/08.png\",\n" +
	                                          "        \"night_air_temperature\": \"6\",\n" +
	                                          "        \"day_air_temperature\": \"9\",\n" +
	                                          "        \"day_wind_direction\": \"北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/08.png\",\n" +
	                                          "        \"night_wind_direction\": \"北风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"01\",\n" +
	                                          "        \"day_weather\": \"多云\",\n" +
	                                          "        \"night_weather\": \"多云\",\n" +
	                                          "        \"night_wind_power\": \"微风\",\n" +
	                                          "        \"day_wind_power\": \"微风\",\n" +
	                                          "        \"day_weather_code\": \"01\",\n" +
	                                          "        \"daytime\": \"20170114\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/01.png\",\n" +
	                                          "        \"night_air_temperature\": \"6\",\n" +
	                                          "        \"day_air_temperature\": \"10\",\n" +
	                                          "        \"day_wind_direction\": \"北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/01.png\",\n" +
	                                          "        \"night_wind_direction\": \"北风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"01\",\n" +
	                                          "        \"day_weather\": \"多云\",\n" +
	                                          "        \"night_weather\": \"多云\",\n" +
	                                          "        \"night_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_weather_code\": \"01\",\n" +
	                                          "        \"daytime\": \"20170115\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/01.png\",\n" +
	                                          "        \"night_air_temperature\": \"0\",\n" +
	                                          "        \"day_air_temperature\": \"6\",\n" +
	                                          "        \"day_wind_direction\": \"西北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/01.png\",\n" +
	                                          "        \"night_wind_direction\": \"西北风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"01\",\n" +
	                                          "        \"day_weather\": \"多云\",\n" +
	                                          "        \"night_weather\": \"多云\",\n" +
	                                          "        \"night_wind_power\": \"微风\",\n" +
	                                          "        \"day_wind_power\": \"微风\",\n" +
	                                          "        \"day_weather_code\": \"01\",\n" +
	                                          "        \"daytime\": \"20170116\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/01.png\",\n" +
	                                          "        \"night_air_temperature\": \"2\",\n" +
	                                          "        \"day_air_temperature\": \"7\",\n" +
	                                          "        \"day_wind_direction\": \"北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/01.png\",\n" +
	                                          "        \"night_wind_direction\": \"北风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"01\",\n" +
	                                          "        \"day_weather\": \"多云\",\n" +
	                                          "        \"night_weather\": \"多云\",\n" +
	                                          "        \"night_wind_power\": \"微风\",\n" +
	                                          "        \"day_wind_power\": \"微风\",\n" +
	                                          "        \"day_weather_code\": \"01\",\n" +
	                                          "        \"daytime\": \"20170117\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/01.png\",\n" +
	                                          "        \"night_air_temperature\": \"1\",\n" +
	                                          "        \"day_air_temperature\": \"6\",\n" +
	                                          "        \"day_wind_direction\": \"东北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/01.png\",\n" +
	                                          "        \"night_wind_direction\": \"北风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"01\",\n" +
	                                          "        \"day_weather\": \"阴\",\n" +
	                                          "        \"night_weather\": \"多云\",\n" +
	                                          "        \"night_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_weather_code\": \"02\",\n" +
	                                          "        \"daytime\": \"20170118\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/02.png\",\n" +
	                                          "        \"night_air_temperature\": \"3\",\n" +
	                                          "        \"day_air_temperature\": \"7\",\n" +
	                                          "        \"day_wind_direction\": \"东北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/02.png\",\n" +
	                                          "        \"night_wind_direction\": \"东北风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"01\",\n" +
	                                          "        \"day_weather\": \"阴\",\n" +
	                                          "        \"night_weather\": \"多云\",\n" +
	                                          "        \"night_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_weather_code\": \"02\",\n" +
	                                          "        \"daytime\": \"20170119\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/02.png\",\n" +
	                                          "        \"night_air_temperature\": \"2\",\n" +
	                                          "        \"day_air_temperature\": \"7\",\n" +
	                                          "        \"day_wind_direction\": \"北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/02.png\",\n" +
	                                          "        \"night_wind_direction\": \"北风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"01\",\n" +
	                                          "        \"day_weather\": \"晴\",\n" +
	                                          "        \"night_weather\": \"多云\",\n" +
	                                          "        \"night_wind_power\": \"微风\",\n" +
	                                          "        \"day_wind_power\": \"微风\",\n" +
	                                          "        \"day_weather_code\": \"00\",\n" +
	                                          "        \"daytime\": \"20170120\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/00.png\",\n" +
	                                          "        \"night_air_temperature\": \"2\",\n" +
	                                          "        \"day_air_temperature\": \"7\",\n" +
	                                          "        \"day_wind_direction\": \"西北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/00.png\",\n" +
	                                          "        \"night_wind_direction\": \"西北风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"00\",\n" +
	                                          "        \"day_weather\": \"多云\",\n" +
	                                          "        \"night_weather\": \"晴\",\n" +
	                                          "        \"night_wind_power\": \"微风\",\n" +
	                                          "        \"day_wind_power\": \"微风\",\n" +
	                                          "        \"day_weather_code\": \"01\",\n" +
	                                          "        \"daytime\": \"20170121\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/01.png\",\n" +
	                                          "        \"night_air_temperature\": \"5\",\n" +
	                                          "        \"day_air_temperature\": \"9\",\n" +
	                                          "        \"day_wind_direction\": \"东北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/01.png\",\n" +
	                                          "        \"night_wind_direction\": \"北风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"02\",\n" +
	                                          "        \"day_weather\": \"多云\",\n" +
	                                          "        \"night_weather\": \"阴\",\n" +
	                                          "        \"night_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_weather_code\": \"01\",\n" +
	                                          "        \"daytime\": \"20170122\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/01.png\",\n" +
	                                          "        \"night_air_temperature\": \"6\",\n" +
	                                          "        \"day_air_temperature\": \"10\",\n" +
	                                          "        \"day_wind_direction\": \"东北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/01.png\",\n" +
	                                          "        \"night_wind_direction\": \"东风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"08\",\n" +
	                                          "        \"day_weather\": \"中雨\",\n" +
	                                          "        \"night_weather\": \"中雨\",\n" +
	                                          "        \"night_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_wind_power\": \"4-5级\",\n" +
	                                          "        \"day_weather_code\": \"08\",\n" +
	                                          "        \"daytime\": \"20170123\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/08.png\",\n" +
	                                          "        \"night_air_temperature\": \"9\",\n" +
	                                          "        \"day_air_temperature\": \"11\",\n" +
	                                          "        \"day_wind_direction\": \"东南风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/08.png\",\n" +
	                                          "        \"night_wind_direction\": \"东南风\"\n" +
	                                          "      },\n" +
	                                          "      {\n" +
	                                          "        \"night_weather_code\": \"08\",\n" +
	                                          "        \"day_weather\": \"中雨\",\n" +
	                                          "        \"night_weather\": \"中雨\",\n" +
	                                          "        \"night_wind_power\": \"4-5级\",\n" +
	                                          "        \"day_wind_power\": \"3-4级\",\n" +
	                                          "        \"day_weather_code\": \"08\",\n" +
	                                          "        \"daytime\": \"20170124\",\n" +
	                                          "        \"day_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/day/08.png\",\n" +
	                                          "        \"night_air_temperature\": \"8\",\n" +
	                                          "        \"day_air_temperature\": \"12\",\n" +
	                                          "        \"day_wind_direction\": \"东北风\",\n" +
	                                          "        \"night_weather_pic\": \"http://appimg.showapi.com/images/weather/icon/night/08.png\",\n" +
	                                          "        \"night_wind_direction\": \"北风\"\n" +
	                                          "      }\n" +
	                                          "    ]\n" +
	                                          "  }\n" +
	                                          "}";
	
	
	
}
