package com.kang.part_2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleActivity extends AppCompatActivity {
    //Member Variable
    private final boolean D  = true;
    private final String TAG = "SimpleActivity";

    // View Object
    private ListView listView;

    // data
    private ArrayList<HashMap<String,String>> arrayList;
    private SimpleAdapter adapter;

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_simple);

        init();
    }

    private void init() {
        listView = findViewById(R.id.list_simple);
        arrayList = new ArrayList<HashMap<String, String>>();
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("name","A");
        map.put("area","Busan");
        arrayList.add(map);

        map = new HashMap<String,String>();
        map.put("name","B");
        map.put("area","Seoul");
        arrayList.add(map);

        adapter = new SimpleAdapter(SimpleActivity.this,
                arrayList,
                R.layout.item_simple,
                new String[] {"name", "area"},
                new int[] {R.id.text1, R.id.text2});

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleActivity.this, "Item : " + ((TextView)view.findViewById(R.id.text1)).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
