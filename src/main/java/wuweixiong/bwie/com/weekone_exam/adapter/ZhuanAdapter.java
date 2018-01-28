package wuweixiong.bwie.com.weekone_exam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import wuweixiong.bwie.com.weekone_exam.MainActivity;
import wuweixiong.bwie.com.weekone_exam.R;
import wuweixiong.bwie.com.weekone_exam.UriBean;

/**
 * Created by Administrator on 2018/1/28,0028.
 */

public class ZhuanAdapter extends RecyclerView.Adapter<ZhuanAdapter.ViewHolder>{
    private Context context;
    private List<UriBean.DataBean.DefaultGoodsListBean> list;

    public ZhuanAdapter(Context context, List<UriBean.DataBean.DefaultGoodsListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ZhuanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.zhuan_item,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ZhuanAdapter.ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getGoods_name());
        holder.image.setImageURI(list.get(position).getGoods_img());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView image;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.zhuan_image);
            textView = itemView.findViewById(R.id.zhuan_text);
        }
    }
}
