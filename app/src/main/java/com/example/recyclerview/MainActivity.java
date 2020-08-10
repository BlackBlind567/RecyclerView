package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "rvResponse" ;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    SearchRv searchRv;
    ArrayList<SearchResponse> searchResponseArrayList = new ArrayList<>();
    Gson gson;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gson = gsonBuilder.create();

        requestQueue = Volley.newRequestQueue(this);
        recyclerView = findViewById(R.id.first_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new
                LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));

        String url = "http://brajtravels.com/apiservice/search/";

        HashMap<String, String> param = new HashMap<>();
        param.put("from","1");
        param.put("to","2");
        param.put("date","2020-02-01");


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url, new JSONObject(param),
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("responseApi", response.toString());

                searchRv = gson.fromJson(response.toString(), SearchRv.class);


                Log.d(TAG, "status: " + searchRv.getStatus());
                Log.d(TAG, "msg: " + searchRv.getMsg());
                Log.d(TAG, "responses: " + searchRv.getResponce());

                if (searchRv.getStatus().equalsIgnoreCase("200")){
//                    searchResponseArrayList.addAll(searchRv.getResponce());
                    searchResponseArrayList = searchRv.getResponce();

                    for (int i = 0; i < searchRv.getResponce().size(); i++) {

                        Log.d(TAG, "responsesList: " + searchResponseArrayList.get(i).getBusName());



                    }

                    recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, searchResponseArrayList );
                    recyclerView.setAdapter(recyclerViewAdapter);


                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", error.getMessage());
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}