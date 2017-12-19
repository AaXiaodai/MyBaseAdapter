package com.zhy.adapter.recyclerview.base;


/**
 * Created by zhy on 16/6/22.
 */
public interface LvItemViewDelegate<T>
{

    public abstract int getItemViewLayoutId();

    public abstract boolean isForViewType(T item, int position);

    public abstract void convert(LvViewHolder holder, T t, int position);



}
