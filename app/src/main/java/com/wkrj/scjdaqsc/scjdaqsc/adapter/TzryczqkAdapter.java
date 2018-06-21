package com.wkrj.scjdaqsc.scjdaqsc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.entity.firm.Ryczqk;
import com.wkrj.scjdaqsc.scjdaqsc.entity.firm.Tzsbtj;

import java.util.List;


/**
 * Created by Ywg on 2016/6/29.
 */
public class TzryczqkAdapter extends BaseAdapter {

    private Context mContext;
    private List<Ryczqk> mItemList;
    private LayoutInflater mInflater;

    public TzryczqkAdapter(Context context, List<Ryczqk> itemList) {
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
            convertView = mInflater.inflate(R.layout.listview_firm_tzryczqk_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_item_tzryczqk_mc = (TextView) convertView.findViewById(R.id.tv_item_tzryczqk_mc);
            viewHolder.tv_item_tzryczqk_age = (TextView) convertView.findViewById(R.id.tv_item_tzryczqk_age);
            viewHolder.tv_item_tzryczqk_zgzmc = (TextView) convertView.findViewById(R.id.tv_item_tzryczqk_zgzmc);
            viewHolder.tv_item_tzryczqk_zgzbh = (TextView) convertView.findViewById(R.id.tv_item_tzryczqk_zgzbh);
            viewHolder.tv_item_tzryczqk_fzbm = (TextView) convertView.findViewById(R.id.tv_item_tzryczqk_fzbm);
            viewHolder.tv_item_tzryczqk_zhpsrq = (TextView) convertView.findViewById(R.id.tv_item_tzryczqk_zhpsrq);
            viewHolder.tv_item_tzryczqk_fsrq = (TextView) convertView.findViewById(R.id.tv_item_tzryczqk_fsrq);
            viewHolder.tv_item_tzryczqk_xcfsrq = (TextView) convertView.findViewById(R.id.tv_item_tzryczqk_xcfsrq);
            viewHolder.tv_item_tzryczqk_ysrq = (TextView) convertView.findViewById(R.id.tv_item_tzryczqk_ysrq);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Ryczqk item = mItemList.get(position);
        viewHolder.tv_item_tzryczqk_mc.setText(item.getRyczqk_rymc());
        viewHolder.tv_item_tzryczqk_age.setText(item.getRyczqk_age()+"");
        viewHolder.tv_item_tzryczqk_zgzmc.setText(item.getRyczqk_zgzmc());
        viewHolder.tv_item_tzryczqk_zgzbh.setText(item.getRyczqk_zgzbh());
        viewHolder.tv_item_tzryczqk_fzbm.setText(item.getRyczqk_fzbm());
        viewHolder.tv_item_tzryczqk_zhpsrq.setText(item.getRyczqk_zjfsrq());
        viewHolder.tv_item_tzryczqk_fsrq.setText(item.getRyczqk_fszq());
        viewHolder.tv_item_tzryczqk_xcfsrq.setText(item.getRyczqk_xcfsrq());
        viewHolder.tv_item_tzryczqk_ysrq.setText(item.getRyczqk_yxrq());
        return convertView;
    }

    class ViewHolder {
        private TextView tv_item_tzryczqk_mc;
        private TextView tv_item_tzryczqk_age;
        private TextView tv_item_tzryczqk_zgzmc;
        private TextView tv_item_tzryczqk_zgzbh;
        private TextView tv_item_tzryczqk_fzbm;
        private TextView tv_item_tzryczqk_zhpsrq;
        private TextView tv_item_tzryczqk_fsrq;
        private TextView tv_item_tzryczqk_xcfsrq;
        private TextView tv_item_tzryczqk_ysrq;
    }

    public void refreshData(List<Ryczqk> itemList) {
        if (mItemList.size() != 0 && mItemList != null) {
            mItemList.clear();
        }
        mItemList.addAll(itemList);
        notifyDataSetChanged();
    }

    public void addData(List<Ryczqk> itemList) {
        if(itemList!=null) {
            mItemList.addAll(itemList);
            notifyDataSetChanged();
        }
    }

}
