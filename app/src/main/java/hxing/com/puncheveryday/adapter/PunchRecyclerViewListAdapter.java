package hxing.com.puncheveryday.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import hxing.com.puncheveryday.R;
import hxing.com.puncheveryday.base.BaseRecyclerAdapter;
import hxing.com.puncheveryday.bean.Punch;

public class PunchRecyclerViewListAdapter extends BaseRecyclerAdapter<Punch> {

    private List<Punch> data;
    private Context Ctx;

    public PunchRecyclerViewListAdapter(Context context,List<Punch> data) {
        super(context);
        Ctx = context;
        super.mItems = data;

    }

    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(Ctx).inflate(R.layout.punch_list_item, parent, false);

        return  new VH(v);
    }

    @Override
    protected void onBindViewHolder(RecyclerView.ViewHolder holder, Punch item, int position) {
        ((VH)holder).title_tv.setText(item.getTitle());
        ((VH)holder).date_tv.setText(item.getDate_warn());

    }

    class VH extends RecyclerView.ViewHolder{

        private TextView title_tv,date_tv;
        private ImageView imageView;

        public VH(View itemView) {
            super(itemView);
            title_tv = itemView.findViewById(R.id.title_tv);
            date_tv = itemView.findViewById(R.id.date_tv);
            imageView = itemView.findViewById(R.id.imageview_tv);

        }

    }

}
