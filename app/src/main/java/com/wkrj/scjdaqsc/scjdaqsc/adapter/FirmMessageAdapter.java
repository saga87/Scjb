package com.wkrj.scjdaqsc.scjdaqsc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BaoGuang;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmList;

import java.util.List;


/**
 * Created by Ywg on 2016/6/29.
 */
public class FirmMessageAdapter extends BaseAdapter {

    private Context mContext;
    private List<FirmList> mItemList;
    private LayoutInflater mInflater;

    public FirmMessageAdapter(Context context, List<FirmList> itemList) {
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
            convertView = mInflater.inflate(R.layout.listview_gr_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_gr_title);
            viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_gr_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        FirmList item = mItemList.get(position);
        viewHolder.tv_title.setText(item.getEnterprise_name());
        viewHolder.tv_time.setText(item.getInput_time());
        return convertView;
    }

    class ViewHolder {
        private TextView tv_title;
        private TextView tv_time;

    }
    //下拉刷新数据
    public void refreshData(List<FirmList> itemList) {
        if (mItemList.size() != 0 && mItemList != null) {
            mItemList.clear();
        }
        mItemList.addAll(itemList);
        notifyDataSetChanged();
    }
    //加载数据
    public void addData(List<FirmList> itemList) {
        if(itemList!=null) {
            mItemList.addAll(itemList);
            notifyDataSetChanged();
        }
    }

}
