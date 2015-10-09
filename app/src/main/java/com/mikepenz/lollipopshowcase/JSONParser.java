package com.mikepenz.lollipopshowcase;


import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.gson.Gson;
import com.mikepenz.lollipopshowcase.Result;
import com.mikepenz.lollipopshowcase.SearchResponse;


public class JSONParser extends MainActivity {

    String url = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/qualities/Legendary?collectible=1&locale=enUS";

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        InputStream source = retrieveStream(url);

        Gson gson = new Gson();

        Reader reader = new InputStreamReader(source);

        SearchResponse response = gson.fromJson(reader, SearchResponse.class);

        response.

        /*List<Result> results = response.;*/



    }

    private InputStream retrieveStream(String url) {

        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet getRequest = new HttpGet(url);

        getRequest.addHeader("X-Mashape-Key","vn2KuqrU0omshwmhyzSpBtYiiAk7p1zDat7jsn51QzyIraeTe3");

        try {

            HttpResponse getResponse = client.execute(getRequest);

            final int statusCode = getResponse.getStatusLine().getStatusCode();

            if (statusCode != HttpStatus.SC_OK) {

                Log.w(getClass().getSimpleName(),

                        "Error " + statusCode + " for URL " + url);

                return null;

            }

            HttpEntity getResponseEntity = getResponse.getEntity();

            return getResponseEntity.getContent();

        }

        catch (IOException e) {

            getRequest.abort();

            Log.w(getClass().getSimpleName(), "Error for URL " + url, e);

        }

        return null;

    }



}