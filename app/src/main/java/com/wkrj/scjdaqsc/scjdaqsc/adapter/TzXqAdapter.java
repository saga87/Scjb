package com.wkrj.scjdaqsc.scjdaqsc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.entity.Ducha;
import com.wkrj.scjdaqsc.scjdaqsc.entity.Filefj;

import java.util.List;


/**
 * Created by Ywg on 2016/6/29.
 */
public class TzXqAdapter extends BaseAdapter {

    private Context mContext;
    private List<Filefj> mItemList;
    private LayoutInflater mInflater;

    public TzXqAdapter(Context context, List<Filefj> itemList) {
        this.mContext = context;
        this.mItemList = itemList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listview_tz_xq_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.item_tv_tz_fujian = (TextView) convertView.findViewById(R.id.item_tv_tz_fujian);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Filefj item = mItemList.get(position);
        viewHolder.item_tv_tz_fujian.setText(item.getName());
        return convertView;
    }

    class ViewHolder {
        private TextView item_tv_tz_fujian;

    }

    public void refreshData(List<Filefj> itemList) {
        if (mItemList.size() != 0 && mItemList != null) {
            mItemList.clear();
        }
        mItemList.addAll(itemList);
        notifyDataSetChanged();
    }

    public void addData(List<Filefj> itemList) {
        if(itemList!=null) {
            mItemList.addAll(itemList);
            notifyDataSetChanged();
        }
    }

}
