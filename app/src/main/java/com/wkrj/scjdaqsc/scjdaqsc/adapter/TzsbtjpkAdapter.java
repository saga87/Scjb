package com.wkrj.scjdaqsc.scjdaqsc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BaoGuang;
import com.wkrj.scjdaqsc.scjdaqsc.entity.firm.Tzsbtj;

import java.util.List;


/**
 * Created by Ywg on 2016/6/29.
 */
public class TzsbtjpkAdapter extends BaseAdapter {

    private Context mContext;
    private List<Tzsbtj> mItemList;
    private LayoutInflater mInflater;

    public TzsbtjpkAdapter(Context context, List<Tzsbtj> itemList) {
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
            convertView = mInflater.inflate(R.layout.listview_firm_tzsbtjpk_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_item_tzsbtjpk_tzsbmc = (TextView) convertView.findViewById(R.id.tv_item_tzsbtjpk_tzsbmc);
            viewHolder.tv_item_tzsbtjpk_ggxh = (TextView) convertView.findViewById(R.id.tv_item_tzsbtjpk_ggxh);
            viewHolder.tv_item_tzsbtjpk_zzdw = (TextView) convertView.findViewById(R.id.tv_item_tzsbtjpk_zzdw);
            viewHolder.tv_item_tzsbtjpk_azdw = (TextView) convertView.findViewById(R.id.tv_item_tzsbtjpk_azdw);
            viewHolder.tv_item_tzsbtjpk_jcdw = (TextView) convertView.findViewById(R.id.tv_item_tzsbtjpk_jcdw);
            viewHolder.tv_item_tzsbtjpk_zcbh = (TextView) convertView.findViewById(R.id.tv_item_tzsbtjpk_zcbh);
            viewHolder.tv_item_tzsbtjpk_zhycjcdw = (TextView) convertView.findViewById(R.id.tv_item_tzsbtjpk_zhycjcdw);
            viewHolder.tv_item_tzsbtjpk_xcjcrq = (TextView) convertView.findViewById(R.id.tv_item_tzsbtjpk_xcjcrq);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Tzsbtj item = mItemList.get(position);
        viewHolder.tv_item_tzsbtjpk_tzsbmc.setText(item.getTzsbtj_tzsbmc());
        viewHolder.tv_item_tzsbtjpk_ggxh.setText(item.getTzsbtj_ggxh());
        viewHolder.tv_item_tzsbtjpk_zzdw.setText(item.getTzsbtj_zzdw());
        viewHolder.tv_item_tzsbtjpk_azdw.setText(item.getTzsbtj_azdw());
        viewHolder.tv_item_tzsbtjpk_jcdw.setText(item.getTzsbtj_jydw());
        viewHolder.tv_item_tzsbtjpk_zcbh.setText(item.getTzsbtj_zcbh());
        viewHolder.tv_item_tzsbtjpk_zhycjcdw.setText(item.getTzsbtj_zhycjyrq());
        viewHolder.tv_item_tzsbtjpk_xcjcrq.setText(item.getTzsbtj_xcjyrq());
        return convertView;
    }

    class ViewHolder {
        private TextView tv_item_tzsbtjpk_tzsbmc;
        private TextView tv_item_tzsbtjpk_ggxh;
        private TextView tv_item_tzsbtjpk_zzdw;
        private TextView tv_item_tzsbtjpk_azdw;
        private TextView tv_item_tzsbtjpk_jcdw;
        private TextView tv_item_tzsbtjpk_zcbh;
        private TextView tv_item_tzsbtjpk_zhycjcdw;
        private TextView tv_item_tzsbtjpk_xcjcrq;

    }

    public void refreshData(List<Tzsbtj> itemList) {
        if (mItemList.size() != 0 && mItemList != null) {
            mItemList.clear();
        }
        mItemList.addAll(itemList);
        notifyDataSetChanged();
    }

    public void addData(List<Tzsbtj> itemList) {
        if(itemList!=null) {
            mItemList.addAll(itemList);
            notifyDataSetChanged();
        }
    }

}
