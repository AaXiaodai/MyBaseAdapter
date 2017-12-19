package example.com.mybaseadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.zhy.adapter.recyclerview.LvCommonAdapter;
import com.zhy.adapter.recyclerview.base.LvViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MyListView extends AppCompatActivity {
    private ListView mListView;
    private LvCommonAdapter mAdapter ;
    private List<String> mDatas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);
        initDatas();
        mListView = (ListView) findViewById(R.id.id_listview_list);
        mListView.setDivider(null);
        mListView.setAdapter(new LvCommonAdapter<String>(this,R.layout.lv_item_list,mDatas) {
            @Override
            protected void convert(LvViewHolder viewHolder, String str, int position) {
                viewHolder.setText(R.id.tv_item_list_title,str +":"+viewHolder.getLayoutId());
            }
        });

    }
    private void initDatas() {
        for (int i = 'A'; i<='z';i++){
            mDatas.add((char)i+"");
        }
    }
}
