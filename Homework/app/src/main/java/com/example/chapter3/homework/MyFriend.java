package com.example.chapter3.homework;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.chapter3.homework.dummy.DummyContent;
import com.example.chapter3.homework.dummy.DummyContent.DummyItem;

import java.util.List;

public class MyFriend extends Fragment {
    private LottieAnimationView lottie;
    private ListView listview;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_list, container, false);
        lottie = view.findViewById(R.id.animation_view);
        // Set the adapter
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                lottie.animate()
                        .alpha(0f)
                        .setDuration(1000)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                lottie.setVisibility(View.GONE);
                            }
                        });

                listview = (ListView) view.findViewById(R.id.lvItems);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1);
                adapter.add("赵铁柱");
                adapter.add("王二狗");
                adapter.add("张翠花");
                adapter.add("钱进");
                adapter.add("李白");
                adapter.add("周州");
                adapter.add("吴起");
                adapter.add("郑钱");
                adapter.add("冯二白");
                adapter.add("陈香");
                adapter.add("楚楚动人");
                listview.animate()
                        .alpha(1f)
                        .setDuration(1000)
                        .setListener(null);
                listview.setVisibility(View.VISIBLE);
                listview.setAdapter(adapter);
            }
        }, 5000);
    }
}
