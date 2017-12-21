##最实用的Android适配器，适用用于Recycleview、ListView的运用。
效果图：
    ![1](https://github.com/872822645/danxuankuangDemo/blob/master/1.jpg)
1、引入
    compile 'com.zhy:base-rvadapter:3.0.3'
2、使用
    ##(1)、超简单、超实用的数据绑定(ListView与其使用方式一致 )
    运用这个适配器常用的书写方式：
    mRecyclerView.setAdapter(new CommonAdapter<String>(this, R.layout.item_list, mDatas)
    {
        @Override
        public void convert(ViewHolder holder, String s)
        {
            holder.setText(R.id.id_item_list_title, s);
        }
    });
    只需要在convert方法中完成数据、事件绑定即可。
    运用这个仿照鸿神封装的Adapter继承CommonAdapter，复写convert方法即可，省去了自己编写ViewHolder等大量的重复的代码。
    a.可以通过holder.getView(id)拿到任何控件。
    b.ViewHolder中封装了大量的常用方法，比如holder.setText(id,text),holder.setOnClickLintener(id,lintener)等，可以的支持使用。
    
    ##(2).添加HeaderView、FooterView
    mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(mAdapter);

    TextView t1 = new TextView(this);
    t1.setText("Header 1");
    TextView t2 = new TextView(this);
    t2.setText("Header 2");
    mHeaderAndFooterWrapper.addHeaderView(t1);
    mHeaderAndFooterWrapper.addHeaderView(t2);

    mRecyclerView.setAdapter(mHeaderAndFooterWrapper);
    mHeaderAndFooterWrapper.notifyDataSetChanged();
    类似装饰者模式，直接将原本的adapter传入，初始化一个HeaderAndFooterWrapper对象，然后调用相关API添加
    ##(3).添加LoadMore
    mLoadMoreWrapper = new LoadMoreWrapper(mOriginAdapter);
    mLoadMoreWrapper.setLoadMoreView(R.layout.default_loading);
    mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener()
    {
        @Override
        public void onLoadMoreRequested()
        {
        }
    });

    mRecyclerView.setAdapter(mLoadMoreWrapper);
    直接将原本的adapter传入，初始化一个LoadMoreWrapper对象，然后调用相关API即可。
3. 类中一些回调
    onViewHolderCreated
    mListView.setAdapter(new CommonAdapter<String>(this, R.layout.item_list, mDatas)
    {
        @Override
        public void convert(ViewHolder holder, String o, int pos)
        {
            holder.setText(R.id.id_item_list_title, o);
        }

        @Override
        public void onViewHolderCreated(ViewHolder holder, View itemView)
        {
            super.onViewHolderCreated(holder, itemView);
           //AutoUtil.autoSize(itemView)
        }
    });
4. 温馨提示：
    a.设置Recycleview不可滚动调用mRecyclerView.setNestedScrollingEnabled(false)方法即可，true默认滚动，false不可滚动
    b.在Scrollview嵌套Recycleview中，解决滑动冲突。则需改变自定义Recycleview改变其高度，其中onMeasure函数决定了组件显示的高度与宽度；
      makeMeasureSpec函数中第一个函数决定布局空间的大小，第二个参数是布局模式MeasureSpec.AT_MOST的意思就是子控件需要多大的控件就扩展
      到多大的空间，之后在ScrollView中添加这个组件就OK了，同样的道理，ListView也适用。
