package com.kang.part_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicActivity extends AppCompatActivity {
    //Member Variable
    private final boolean D  = true;
    private final String TAG = "DynamicActivity";
    private InputMethodManager imm;

    // View Object
    private EditText edit_name;
    private Button btn_add;
    private ListView listView;

    // data
    private String[] arr_str;
    private ArrayList<String> array;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dynamic);

        init();
    }

    private void init() {
        imm = (InputMethodManager)this.getSystemService(INPUT_METHOD_SERVICE);
        array = new ArrayList<String>();

        arr_str = this.getResources().getStringArray(R.array.fruits_dynamic);
        list = Arrays.asList(arr_str);
        array.addAll(list);

        edit_name = findViewById(R.id.edit_name);
        btn_add = findViewById(R.id.button_add);

        listView = findViewById(R.id.list_name);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "Item : " + ((TextView)view).getText());

                TextView text = ((TextView)view).findViewById(android.R.id.text1);
                text.setText("change");
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(edit_name.getText()).equals(""))
                    return;
                array.add(String.valueOf(edit_name.getText()));
                adapter.notifyDataSetChanged();
                edit_name.setText("");
                imm.hideSoftInputFromWindow(edit_name.getWindowToken(), 0);
            }
        });
    }
}