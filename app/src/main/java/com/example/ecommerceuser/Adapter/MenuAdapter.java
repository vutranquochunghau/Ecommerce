package com.example.ecommerceuser.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecommerceuser.R;
import com.example.ecommerceuser.model.ItemMenu;

import java.util.List;

public class MenuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ItemMenu> list; //tao ra danh sach cac item ben class ItemMenu

    public MenuAdapter(Context context, int layout, List<ItemMenu> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //tao class ViewHolder
    private class ViewHolder{
        TextView tvItem;
        ImageView imgItem;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            //Anh xa
            viewHolder.tvItem = convertView.findViewById(R.id.tvItem);
            viewHolder.imgItem = convertView.findViewById(R.id.imgItem);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //gan gia tri
        viewHolder.tvItem.setText(list.get(position).itemName);
        viewHolder.imgItem.setImageResource(list.get(position).itemIcon);
        return convertView;
    }
}
