package com.education.online.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.education.online.R;
import com.education.online.adapter.MainAdapter;
import com.education.online.adapter.OnlineCourseAdapter;
import com.education.online.bean.OnlineCourseBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/20.
 */

public class OnlineCoursePage extends BaseFragment {

    private RecyclerView OnlineCoursePageRecycleList;
    ArrayList<OnlineCourseBean> onlineCourseBeanArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.online_course_layout, container, false);

        initView(view);
        return view;
    }


    private void initView(View v) {
        onlineCourseBeanArrayList.clear();
        OnlineCourseBean courseBean = new OnlineCourseBean();
        onlineCourseBeanArrayList.add(courseBean);
        onlineCourseBeanArrayList.add(courseBean);
        onlineCourseBeanArrayList.add(courseBean);
        onlineCourseBeanArrayList.add(courseBean);

        OnlineCoursePageRecycleList = (RecyclerView) v.findViewById(R.id.OnlineCoursePageRecycleList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        OnlineCoursePageRecycleList.setLayoutManager(layoutManager);
        OnlineCoursePageRecycleList.setAdapter(new  OnlineCourseAdapter(getActivity(),onlineCourseBeanArrayList));
    }
}
