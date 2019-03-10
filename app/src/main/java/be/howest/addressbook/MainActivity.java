package be.howest.addressbook;

import android.content.Intent;
import android.os.AsyncTask;
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
import java.util.ArrayList;
import java.util.List;

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

//        Button listBtn = findViewById(R.id.listBtn);
//        listBtn.setOnClickListener(e -> {
//            getEmployeesFromSRV();
//        });
    }

    private void getEmployeesFromSRV() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, "http://192.168.0.249:8080/employees", null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        ObjectMapper mapper = new ObjectMapper();
                        List<Employee> employees = new ArrayList<>();

                        try {
                            JSONArray arr = response.getJSONArray("recordset");

                            for(int i = 0; i < arr.length(); i++) {
                                employees.add(mapper.readValue(arr.get(i).toString(), Employee.class));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (JsonParseException e) {
                            e.printStackTrace();
                        } catch (JsonMappingException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, error -> {
                    error.printStackTrace();
                    Log.d("onErrorResponse", error.getMessage());
                });

        queue.add(jsonObjectRequest);
    }
}

