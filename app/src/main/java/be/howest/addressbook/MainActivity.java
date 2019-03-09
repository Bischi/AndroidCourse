package be.howest.addressbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import be.howest.addressbook.be.howest.addressbook.entities.Employee;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newContactBtn = findViewById(R.id.addBtn);
        newContactBtn.setOnClickListener(e -> {
            startActivity(new Intent(this, NewContactActivity.class));

        });

        Button listBtn = findViewById(R.id.listBtn);
        listBtn.setOnClickListener(e -> {
            makeJSONRequets();
        });
    }

    private void makeJSONRequets() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, "http://192.168.0.249:8080/employees", null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

//                        Gson gson = new Gson();
//                        Employee employee = null;
//
//
//
//                        try {
//                            JSONArray arr = response.getJSONArray("recordset");
//
//                            employee = gson.fromJson(arr.get(0).toString(), Employee.class);
//
//                        } catch (JSONException e1) {
//                            e1.printStackTrace();
//                        }


                        Employee employee = null;
                        ObjectMapper mapper = new ObjectMapper();
//                        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

//                        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);

                        JSONArray arr = null;
                        try {
                            arr = response.getJSONArray("recordset");
                            String objString = arr.get(0).toString();
                            employee = mapper.readValue(objString, Employee.class);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (JsonParseException e) {
                            e.printStackTrace();
                        } catch (JsonMappingException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        if(employee != null)
                            Log.d("Employee check: ", "Employee is filled!");
                        else
                            Log.d("Employee check", "Employee is null");

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Log.d("onErrorResponse", error.getMessage());
                    }
                });

        // Access the RequestQueue through your singleton class.
        queue.add(jsonObjectRequest);
    }
}
