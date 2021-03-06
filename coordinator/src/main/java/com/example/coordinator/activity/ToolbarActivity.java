package com.example.coordinator.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.coordinator.R;
import com.example.coordinator.adapter.ImageItem;
import com.example.coordinator.adapter.ImageItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/7/9.
 */
public class ToolbarActivity extends AppCompatActivity {

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private List<ImageItem> mImageItemList;
    private ImageItemAdapter mImageItemAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        initialize();
    }

    private void initialize() {
        mImageItemList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            mImageItemList.add(new ImageItem("", ""));
        }
        mImageItemAdapter = new ImageItemAdapter(mRecyclerView, mImageItemList, R.layout.view_imageitem);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(mImageItemAdapter);
    }
}
