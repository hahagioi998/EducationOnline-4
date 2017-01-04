package com.education.online.act.chat;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wli on 15/10/8.
 */
public class ConversationListAdapter<T> extends RecyclerView.Adapter<ConversationItemHolder> {

  private List<T> dataList = new ArrayList<T>();
  private Activity act;

  public List<T> getDataList() {
    return dataList;
  }

  public ConversationListAdapter(Activity con){
    act=con;
  }

  public void setDataList(List<T> datas) {
    dataList.clear();
    if (null != datas) {
      dataList.addAll(datas);
    }
  }

  public void addDataList(List<T> datas) {
    dataList.addAll(0, datas);
  }

  @Override
  public ConversationItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ConversationItemHolder(parent, act);
  }

  @Override
  public void onBindViewHolder(ConversationItemHolder holder, int position) {
    if (position >= 0 && position < dataList.size()) {
      holder.bindData(dataList.get(position));
    }
  }

  @Override
  public int getItemCount() {
    return dataList.size();
  }
}
