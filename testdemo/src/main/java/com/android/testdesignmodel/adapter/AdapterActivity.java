package com.android.testdesignmodel.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.MarkdownUtils;
import com.android.testdagger.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdapterActivity extends Activity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRecyclerView.setAdapter(new MyAdapter());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

    }
    @OnClick(R.id.button7)
    public void readme(){

        MarkdownUtils.setData(this, "testdesignmodel/builder/建造者.MD");
    }
}
