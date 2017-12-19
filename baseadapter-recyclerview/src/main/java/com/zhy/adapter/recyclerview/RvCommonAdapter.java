package com.zhy.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;

import com.zhy.adapter.recyclerview.base.RvItemViewDelegate;
import com.zhy.adapter.recyclerview.base.RvViewHolder;

import java.util.List;

/**
 * Created by zhy on 16/4/9.
 */
public abstract class RvCommonAdapter<T> extends RvMultiItemTypeAdapter<T>
{
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public RvCommonAdapter(final Context context, final int layoutId, List<T> datas)
    {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(new RvItemViewDelegate<T>()
        {
            @Override
            public int getItemViewLayoutId()
            {
                return layoutId;
            }

            @Override
            public boolean isForViewType( T item, int position)
            {
                return true;
            }

            @Override
            public void convert(RvViewHolder holder, T t, int position)
            {
                RvCommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(RvViewHolder holder, T t, int position);


}
