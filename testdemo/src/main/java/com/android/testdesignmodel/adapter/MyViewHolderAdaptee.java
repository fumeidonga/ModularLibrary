package com.android.testdesignmodel.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.android.testdagger.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewHolderAdaptee extends RecyclerView.ViewHolder {

    @BindView(R.id.text_adapter)
    TextView mTextView;

    public MyViewHolderAdaptee(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
