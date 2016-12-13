package com.lqh.searchpicture.presenter.adapter;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by lqh on 2016/12/12.
 */
public class HomePageRecViewHolder extends BaseViewHolder{


    public HomePageRecViewHolder(View itemView) {
        super(itemView);
    }

    public HomePageRecViewHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);

        TextView textView=new TextView(parent.getContext());
        textView.setText("12356");
        parent.addView(textView);
    }


}
