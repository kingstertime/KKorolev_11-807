package ru.kpfu.itis.Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class WeatherManager {
    private String city;
    private Integer temperature;
    private String icon;
    private String description;

    public WeatherManager(String city) {
        this.city = city;
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public void getWeather(){
        int d = 0;

        JSONObject json;
        JSONObject json_specific;

        SimpleDateFormat df2 = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        Calendar c = Calendar.getInstance();

        try {
            json = readJsonFromUrl("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=4d55b351377afaaac07bc9d8f8a8b3c6&lang=eng&units=metric");
        } catch (IOException e) {
            return;
        }

        json_specific = json.getJSONObject("main");
        this.temperature = json_specific.getInt("temp");
        json_specific = json.getJSONObject("wind");
        json_specific = json.getJSONObject("clouds");

        c.add(Calendar.DATE, d);

        json_specific = json.getJSONArray("weather").getJSONObject(0);
        this.description = json_specific.get("description").toString();
        this.icon = json_specific.get("icon").toString();
    }


    public String getCity() {
        return city;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }
}
