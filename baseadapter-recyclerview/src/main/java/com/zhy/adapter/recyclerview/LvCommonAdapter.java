package com.zhy.adapter.recyclerview;

import android.content.Context;

import com.zhy.adapter.recyclerview.base.LvItemViewDelegate;
import com.zhy.adapter.recyclerview.base.LvViewHolder;

import java.util.List;

public abstract class LvCommonAdapter<T> extends LvMultiItemTypeAdapter<T>
{

    public LvCommonAdapter(Context context, final int layoutId, List<T> datas)
    {
        super(context, datas);

        addItemViewDelegate(new LvItemViewDelegate<T>()
        {
            @Override
            public int getItemViewLayoutId()
            {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position)
            {
                return true;
            }

            @Override
            public void convert(LvViewHolder holder, T t, int position)
            {
                LvCommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(LvViewHolder viewHolder, T item, int position);

}
