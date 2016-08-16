package com.education.online.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.education.online.R;
import com.education.online.bean.CategoryBean;
import com.education.online.util.ImageUtil;
import com.education.online.util.ScreenUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class SelectorRightAdapter extends RecyclerView.Adapter<ViewHolder>{
	
	ArrayList<CategoryBean> dataList;
	private Activity act;
	private LayoutInflater listInflater;
	private ImageLoader imageLoader;
	private int itemWidth=0, itemHeight=0;
	
	public SelectorRightAdapter(Activity act, ArrayList<CategoryBean> arrayList)
    {
        this.act=act;
        this.dataList=arrayList;
        imageLoader=ImageLoader.getInstance();
        listInflater= LayoutInflater.from(act);
		itemWidth= (ScreenUtil.getWidth(act)-ImageUtil.dip2px(act, 80+40+20))/3;
		itemHeight=ImageUtil.dip2px(act, 30);
    }

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return dataList.size();
	}
	
	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public void onBindViewHolder(ViewHolder vh, int pos) {
		CategoryBean itemData=dataList.get(pos);
		ItemViewHolder ivh=(ItemViewHolder) vh;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup arg0, int pos) {
		ViewHolder vh=null;
		View view=listInflater.inflate(R.layout.selector_right_item, null);
		view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
		vh=new ItemViewHolder(view, pos);
		return vh;
	}

	public class ItemViewHolder extends RecyclerView.ViewHolder
    {
    	TextView labelTxt;
		LinearLayout itemsLayout;

        public ItemViewHolder(View v, int position)
        {
            super(v);
			CategoryBean cate=dataList.get(position);
			labelTxt = (TextView) v.findViewById(R.id.labelTxt);
			labelTxt.setText(cate.getName());
			itemsLayout = (LinearLayout) v.findViewById(R.id.itemsLayout);
			LinearLayout.LayoutParams llp=new LinearLayout.LayoutParams(itemWidth, itemHeight);
			llp.rightMargin=itemHeight/3;
			LinearLayout linelayout=new LinearLayout(act);
			int size=5;
			for(int i=0;i<size;i++){
				TextView txt=new TextView(act);
				txt.setTextSize(13);
				txt.setGravity(Gravity.CENTER);
				txt.setBackgroundResource(R.drawable.shape_corner_blackline);
				txt.setTextColor(Color.GRAY);
				txt.setText("测试项目");
				linelayout.addView(txt, llp);
				if(i%3==2||i==size-1){
					itemsLayout.addView(linelayout);
					linelayout=new LinearLayout(act);
					linelayout.setPadding(0, llp.rightMargin,0,0);
				}
			}
        }
    }

}