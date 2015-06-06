package com.huangketech.sunshine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

/**
 * Created by huangke on 2015/6/6.
 */
public class WeatherDataParser {
    private static final String LOG_TAG = WeatherDataParser.class.getSimpleName();

    private static String getReadeableDateString(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");
        return dateFormat.format(time * 1000);
    }

    private static String formattingHighLows(double high, double low) {
        return Math.round(high) + "/" + Math.round(low);
    }

    public static String[] getWeatherDataFromJson(String weatherJsonStr, int numDays) throws JSONException {
        final String OWM_LIST = "list";
        final String OWM_WEATHER = "weather";
        final String OWM_TEMPERATURE = "temp";
        final String OWM_MAX = "max";
        final String OWM_MIN = "min";
        final String OWM_DATETIME = "dt";
        final String OWM_DESCRIPTION = "main";
        JSONObject jsonObject = new JSONObject(weatherJsonStr);
        JSONArray wealist = jsonObject.getJSONArray(OWM_LIST);
        String[] resultStrs = new String[numDays];
        for (int i = 0; i < wealist.length(); i++) {
            String day;
            String description;
            String highAndlow;
            JSONObject dayForecast = wealist.getJSONObject(i);
            long datetime = dayForecast.getLong(OWM_DATETIME);
            day = getReadeableDateString(datetime);
            JSONObject weadesc = dayForecast.getJSONArray(OWM_WEATHER).getJSONObject(0);
            description = weadesc.getString(OWM_DESCRIPTION);

            JSONObject weatherObj = dayForecast.getJSONObject(OWM_TEMPERATURE);
            highAndlow = formattingHighLows(weatherObj.getDouble(OWM_MAX), weatherObj.getDouble(OWM_MIN));
            resultStrs[i] = day + " - " + description + " - " + highAndlow;
        }

        return resultStrs;
    }


    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        JSONObject jsonObject = new JSONObject(weatherJsonStr);
        JSONArray wealist = jsonObject.getJSONArray("list");
        JSONObject day = wealist.getJSONObject(dayIndex);
        return day.getJSONObject("temp").getDouble("max");
    }
}
