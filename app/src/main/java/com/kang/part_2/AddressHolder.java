package com.kang.part_2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AddressHolder {
    public TextView text_name;
    public TextView text_phone;
    public TextView text_email;
    public ImageView image_icon;

    public AddressHolder(View root) {
        this.text_name = root.findViewById(R.id.text_name);
        this.text_phone = root.findViewById(R.id.text_phone);
        this.text_email = root.findViewById(R.id.text_email);
        this.image_icon = root.findViewById(R.id.image_icon);
    }
}
