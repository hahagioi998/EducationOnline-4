package com.education.online.fragment.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.education.online.R;
import com.education.online.act.teacher.AuthMenu;
import com.education.online.act.teacher.MyOrders;
import com.education.online.act.teacher.TeacherHomePage;
import com.education.online.act.teacher.TeacherInfoEdit;
import com.education.online.bean.CategoryBean;
import com.education.online.fragment.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/25.
 */
public class TeacherPage extends BaseFragment implements View.OnClickListener{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teacher_page, container, false);

        initView(view);
        return view;
    }

    private void initView(View v) {
        v.findViewById(R.id.homepageEditLayout).setOnClickListener(this);
        v.findViewById(R.id.courseManagerLayout).setOnClickListener(this);
        v.findViewById(R.id.commentLayout).setOnClickListener(this);
        v.findViewById(R.id.orderLayout).setOnClickListener(this);
        v.findViewById(R.id.authLayout).setOnClickListener(this);
        v.findViewById(R.id.settingLayout).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.homepageEditLayout:
                startActivity(new Intent(getActivity(), TeacherHomePage.class));
                break;
            case R.id.orderLayout:
                startActivity(new Intent(getActivity(), MyOrders.class));
                break;
            case R.id.authLayout:
                startActivity(new Intent(getActivity(), AuthMenu.class));
                break;
        }
    }
}