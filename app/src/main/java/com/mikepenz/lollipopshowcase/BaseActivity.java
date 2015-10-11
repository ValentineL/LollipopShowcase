package com.mikepenz.lollipopshowcase;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.io.IOException;
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

        public static final String SERVER_URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/qualities/Legendary?collectible=1&locale=enUS";

        @Override
        protected String doInBackground(Void... params) {


            try {

                HttpRequest request = Unirest.get(SERVER_URL)
                        .header("X-Mashape-Key", "vn2KuqrU0omshwmhyzSpBtYiiAk7p1zDat7jsn51QzyIraeTe3");
                HttpResponse<JsonNode> jsonResponse = request.asJson();
                Gson gson = new Gson();
                String responseJSONString = jsonResponse.getBody().toString();
                Gson myObject = gson.fromJson(responseJSONString, new TypeToken<Collection<SearchResponse>>() {
                }.getType());

            } catch(Exception ex) {
                Log.e(TAG, "Failed to send HTTP POST request due to: " + ex);

            }
            return null;
        }
    }
}







