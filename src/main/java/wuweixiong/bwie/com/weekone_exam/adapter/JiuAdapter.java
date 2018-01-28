package wuweixiong.bwie.com.weekone_exam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import wuweixiong.bwie.com.weekone_exam.MainActivity;
import wuweixiong.bwie.com.weekone_exam.R;
import wuweixiong.bwie.com.weekone_exam.UriBean;

/**
 * Created by Administrator on 2018/1/28,0028.
 */

public class JiuAdapter extends RecyclerView.Adapter<JiuAdapter.ViewHolder>{
    private Context context;
    private List<UriBean.DataBean.Ad5Bean> list;

    public JiuAdapter(Context context, List<UriBean.DataBean.Ad5Bean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public JiuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.jiu_item,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(JiuAdapter.ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
        holder.imageView.setImageURI(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.jiu_image);
            textView = itemView.findViewById(R.id.jiu_text);
        }
    }
}
