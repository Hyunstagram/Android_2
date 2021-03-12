package com.kang.part_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AddressAdapter extends ArrayAdapter<Address> {
    //Member Variable
    private Context context;
    private int layout_id;
    private ArrayList<Address> array_address;

    // Constructor Method
    public AddressAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Address> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout_id = resource;
        this.array_address = objects;
    }

    // Override Method
    @Override
    public int getCount() {
        return array_address.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout_id,null);

            AddressHolder holder = new AddressHolder(convertView);
            convertView.setTag(holder);
        }

        AddressHolder holder = (AddressHolder) convertView.getTag();

        //TextView text_name = convertView.findViewById(R.id.text_name);
        //TextView text_phone = convertView.findViewById(R.id.text_phone);
        //TextView text_email = convertView.findViewById(R.id.text_email);
        //ImageView image_icon = convertView.findViewById(R.id.image_icon);

        TextView text_name = holder.text_name;
        TextView text_phone = holder.text_phone;
        TextView text_email = holder.text_email;
        ImageView image_icon = holder.image_icon;

        final Address item = array_address.get(position);

        text_name.setText(item.getName());
        text_phone.setText(item.getPhone());
        text_email.setText(item.getEmail());
        image_icon.setImageResource(item.getIcon());

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), item.getIcon());
        bitmap = bitmap.createScaledBitmap(bitmap, 70, 70, true);
        image_icon.setImageBitmap(bitmap);

        return convertView;
    }
}
