package example.com.mybaseadapter.lv;

import android.content.Context;

import com.zhy.adapter.recyclerview.LvMultiItemTypeAdapter;

import java.util.List;

import example.com.mybaseadapter.bean.ChatMessage;

/**
 * Created by zhy on 15/9/4.
 */
public class ChatAdapter extends LvMultiItemTypeAdapter<ChatMessage>
{
    public ChatAdapter(Context context, List<ChatMessage> datas)
    {
        super(context, datas);

        addItemViewDelegate(new MsgSendItemDelagate());
        addItemViewDelegate(new MsgComingItemDelagate());
    }

}
