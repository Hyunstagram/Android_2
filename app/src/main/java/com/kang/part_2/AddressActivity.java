package com.kang.part_2;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddressActivity extends AppCompatActivity {
    //Member Variable
    private final boolean D  = true;
    private final String TAG = "AddressActivity";

    // View Object
    private EditText nameETXT, phoneETXT, emailETXT;
    private Button button_add, button_del;
    private ListView listView;

    // Data
    private ArrayList<Address> arrayList;
    private AddressAdapter adapter;

    //Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_address);

        init();

        if(D) Log.i(TAG, "onCreate()");
    }

    //Member Method - Custom
    private void init() {
        //XML View
        nameETXT = findViewById(R.id.edit_name);
        phoneETXT = findViewById(R.id.edit_phone);
        emailETXT = findViewById(R.id.edit_email);

        button_add = findViewById(R.id.button_add);
        button_del = findViewById(R.id.button_del);

        listView = findViewById(R.id.list_address);

        arrayList = new ArrayList<Address>();
        arrayList.add(new Address("GANG", "010-1234-5678", "hustar0@hustar.com", R.drawable.icon_address));
        arrayList.add(new Address("SAN", "010-2345-6789", "hustar1@hustar.com", R.drawable.icon_address));

        adapter = new AddressAdapter(this, R.layout.item_address, arrayList);

        listView.setAdapter(adapter);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(nameETXT.getText()).equals("") ||
                        String.valueOf(phoneETXT.getText()).equals("") ||
                        String.valueOf(emailETXT.getText()).equals(""))
                {
                    if (String.valueOf(nameETXT.getText()).equals("")) {
                        nameETXT.setHint("Please Enter");
                        nameETXT.setHintTextColor(Color.rgb(223, 129, 129));
                    }
                    if (String.valueOf(phoneETXT.getText()).equals("")) {
                        phoneETXT.setHint("Please Enter");
                        phoneETXT.setHintTextColor(Color.rgb(223, 129, 129));
                    }
                    if (String.valueOf(emailETXT.getText()).equals("")) {
                        emailETXT.setHint("Please Enter");
                        emailETXT.setHintTextColor(Color.rgb(223, 129, 129));
                    }
                    return;
                }
                arrayList.add(new Address(String.valueOf(nameETXT.getText()), String.valueOf(phoneETXT.getText()), String.valueOf(emailETXT.getText()), R.drawable.icon_address));

                adapter.notifyDataSetChanged();

                nameETXT.setText("");
                phoneETXT.setText("");
                emailETXT.setText("");
                nameETXT.setHint("");
                phoneETXT.setHint("");
                emailETXT.setHint("");
            }
        });

        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lastIdx = arrayList.size() - 1;
                if (arrayList.size() == 0)
                    return;
                arrayList.remove(lastIdx);

                adapter.notifyDataSetChanged();
            }
        });
    }
}
