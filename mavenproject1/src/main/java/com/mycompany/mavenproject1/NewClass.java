/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class NewClass {

    public static void main(String[] args) throws Exception {
        String host = "https://covid-19-statistics.p.rapidapi.com/regions";
        String charset = "UTF-8";
        // Headers for a request
        String x_rapidapi_host = "covid-19-statistics.p.rapidapi.com";
        String x_rapidapi_key = "7892ab353fmshda8ddca3952a623p1c6a0bjsn95afd6c40155";//Type here your key
        // Params
        String s = "Pulp";
        // Format query for preventing encoding problems
        String query = String.format("s=%s",
                URLEncoder.encode(s, charset));
        HttpResponse<JsonNode> response = Unirest.get(host)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      JsonParser jp = new JsonParser();
      JsonElement je = jp.parse(response.getBody().toString());
      String prettyJsonString = gson.toJson(je);
      System.out.println(prettyJsonString);
    }
}
