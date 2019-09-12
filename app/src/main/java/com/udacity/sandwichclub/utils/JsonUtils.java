package com.udacity.sandwichclub.utils;


import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonUtils {
 /*   public static  String getSandwichesdata(URL url) throws IOException {
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
        try {
            InputStream in = connection.getInputStream();
            Scanner scan = new Scanner(in);
            scan.useDelimiter("");
            boolean has = scan.hasNext();
            if (has) {
                return scan.next();
            } else {
                return null;
            }
        }finally {
             connection.disconnect();
        }
        try {
            URL url = new URL(json);
            String respond ك
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }*/

    public static Sandwich parseSandwichJson(String json) {
  //      List<String> known= new ArrayList<>();
        Sandwich fastfood = new Sandwich();
        try {
            JSONObject club = new JSONObject(json);
            System.out.println(club);
            JSONObject sand = club.getJSONObject("name");
            String main = sand.getString("mainName");
            JSONArray Know = sand.getJSONArray("alsoKnownAs");
            List<String> Knew = new ArrayList<>();
            for (int i = 0; i < Know.length(); i++) {
                Knew.add((String) Know.get(i));
            }

            String loc = club.getString("placeOfOrigin");
            System.out.println(loc);
            String description = club.getString("description");
            System.out.println(description);
            String imv = club.getString("image");
JSONArray ingre = club.getJSONArray("ingredients");
                List<String> ingred = new ArrayList<>();
            for (int i = 0; i < ingre.length(); i++) {
                ingred.add((String)ingre.get(i));
            }
            //  String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients
            fastfood = new Sandwich(main, Knew, loc, description, imv, ingred);
            System.out.println(fastfood);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fastfood;
    }
}
