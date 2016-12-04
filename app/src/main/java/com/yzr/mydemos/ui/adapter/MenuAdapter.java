package com.yzr.mydemos.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yzr.mydemos.R;
import com.yzr.mydemos.model.HomeMenu;
import com.yzr.mydemos.utils.ResourcesUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android-YZR on 2016/12/2.
 */

public class MenuAdapter extends BaseAdapter {
    private List<HomeMenu> datas;
    private int lastSelectedPosition;
    private Context ctx;

    public MenuAdapter(Context ctx, List<HomeMenu> homeMenuList) {
        this.ctx = ctx;
        this.datas = homeMenuList;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public HomeMenu getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(ctx);
            convertView = inflater.inflate(R.layout.item_menu, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        HomeMenu homeMenu =getItem(position);
        holder.txtMenuName.setText(homeMenu.getName());
        if(homeMenu.isSelected()){
            holder.txtMenuName.setTextColor(ResourcesUtil.getColor(ctx,R.color.font_color_dark));
        }else{
            holder.txtMenuName.setTextColor(ResourcesUtil.getColor(ctx,R.color.font_color_light));
        }
        return convertView;
    }

    static


    class ViewHolder {
        @BindView(R.id.txt_menu_name)
        TextView txtMenuName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
