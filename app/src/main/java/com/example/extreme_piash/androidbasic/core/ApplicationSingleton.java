package com.example.extreme_piash.androidbasic.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Base64;
import android.util.Log;


import com.example.extreme_piash.androidbasic.network.ApiClient;
import com.example.extreme_piash.androidbasic.network.NetworkCallInterface;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;


import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Retrofit;


/**
 * Created by BLACK HAT on 17-Aug-16.
 */
public class ApplicationSingleton extends MultiDexApplication {

    private static ApplicationSingleton sInstance;
    private SharedPreferences mPref;
    private NetworkCallInterface networkCallInterface;

    public static ApplicationSingleton getInstance() {
        return sInstance;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        MultiDex.install(this);
    }



    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sInstance.initializeInstance();
    }

    private void initializeInstance() {
        mPref = this.getApplicationContext().getSharedPreferences("classtune_material_pref_key", MODE_PRIVATE);
        //Fresco.initialize(this);
    }

    public void savePrefString(String key, String value){
        SharedPreferences.Editor editor = mPref.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public String getPrefString(String key){
        return mPref.getString(key, "");
    }


    public void savePrefBoolean(String key, boolean value){
        SharedPreferences.Editor editor = mPref.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
    public boolean getPrefBoolean(String key){
        return mPref.getBoolean(key, false);
    }

    public void savePrefInteger(String key, int value){
        SharedPreferences.Editor editor = mPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public int getPrefInteger(String key){
        return mPref.getInt(key, 0);
    }


    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public String printHashKey(Context pContext) {
        String hashKey = "";
        try {
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                hashKey = new String(Base64.encode(md.digest(), 0));
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e("KEY_HASH", "printHashKey()", e);
        } catch (Exception e) {
            Log.e("KEY_HASH", "printHashKey()", e);
        }
        return  hashKey;
    }

    public boolean isUrlExists(String URLName){
        try {
            HttpURLConnection.setFollowRedirects(false);
            // note : you may also need
            //        HttpURLConnection.setInstanceFollowRedirects(false)
            HttpURLConnection con =
                    (HttpURLConnection) new URL(URLName).openConnection();
            con.setRequestMethod("HEAD");
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public String getFormattedDateString(String inputFormat, String outputFormat, String value){

        SimpleDateFormat inputPattern = new SimpleDateFormat(inputFormat);
        SimpleDateFormat outputPattern = new SimpleDateFormat(outputFormat);

        Date date = null;
        String str = null;

        try {
            date = inputPattern.parse(value);
            str = outputPattern.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public boolean containsKey(String key){
        return mPref.contains(key);
    }

    public void removeKey(String key){
        SharedPreferences.Editor editor = mPref.edit();
        editor.remove(key);
        editor.apply();
    }

    public String getDeviceID(){
        String android_id = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return android_id;
    }

    public String convertJsonElementToString(JsonElement jsonElement){
        Gson gson = new Gson();
        JsonElement element = gson.fromJson (jsonElement.toString(), JsonElement.class);
        JsonObject jsonObj = element.getAsJsonObject();

        return jsonObj.toString();
    }

    public NetworkCallInterface getNetworkCallInterface(){
        Retrofit retrofit = ApiClient.getInstance(ApplicationSingleton.this);
        networkCallInterface = retrofit.create(NetworkCallInterface.class);

        return networkCallInterface;
    }


    public boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

/*    public List<Country> getCountryList(){
        Gson gson = new Gson();
        List<Country> countryList = gson.fromJson(getPrefString(IAppConstant.KEY_COUNTRY_LIST), new TypeToken<List<Country>>(){}.getType());
        return countryList;
    }

    public Client getAlgoliaClient(){
        Client client = new Client("EVFY5FKKL1", "0284bda458156122a6e1013aa11569f6");
        return client;
    }*/

    public String extractYTId(String ytUrl) {
        String vId = null;
        Pattern pattern = Pattern.compile(
                "^https?://.*(?:youtu.be/|v/|u/\\w/|embed/|watch?v=)([^#&?]*).*$",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(ytUrl);
        if (matcher.matches()){
            vId = matcher.group(1);
        }
        return vId;
    }

    public String getDecimalTwoDigitNumberFromDouble(Double value){
        DecimalFormat precision = new DecimalFormat("0.00");
        String str = precision.format(value);
        return str;
    }


}