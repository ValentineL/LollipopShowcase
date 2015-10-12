package com.mikepenz.lollipopshowcase;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new SimpleTask().execute();

    }

    private class SimpleTask extends AsyncTask<Void, Void, String> {

        private static final String TAG = "SimpleTask";

       /* public static final String SERVER_URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/qualities/Legendary?collectible=1&locale=enUS";*/

        @Override
        protected String doInBackground(Void... params) {


            try {





                    String url = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/qualities/Legendary?collectible=1&locale=enUS";

                    URL obj = new URL(url);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    //add request header
                    con.setRequestProperty("X-Mashape-Key", "vn2KuqrU0omshwmhyzSpBtYiiAk7p1zDat7jsn51QzyIraeTe3");

                    // optional default is GET
                    con.setRequestMethod("GET");




                    int responseCode = con.getResponseCode();
                    System.out.println("\nSending 'GET' request to URL : " + url);
                    System.out.println("Response Code : " + responseCode);

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
                    String responseJSONString = response.toString();
                    SearchResponse[] myObject = gson.fromJson(responseJSONString, new TypeToken<Collection<SearchResponse>>() {
                    }.getType());
                    in.close();

                    //print result
                    System.out.println(response.toString());






            } catch(Exception ex) {
                Log.e(TAG, "Failed to send HTTP POST request due to: " + ex);

            }
            return null;
        }
    }
}







