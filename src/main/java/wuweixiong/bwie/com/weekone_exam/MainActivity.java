package wuweixiong.bwie.com.weekone_exam;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import wuweixiong.bwie.com.weekone_exam.adapter.JiuAdapter;
import wuweixiong.bwie.com.weekone_exam.adapter.ZhuanAdapter;
import wuweixiong.bwie.com.weekone_exam.presenter.UriPresenter;
import wuweixiong.bwie.com.weekone_exam.util.Api;
import wuweixiong.bwie.com.weekone_exam.util.ServiceAPI;
import wuweixiong.bwie.com.weekone_exam.view.IUriView;

public class MainActivity extends AppCompatActivity implements IUriView {

    private XBanner xBanner;
    private RecyclerView jiu;
    private RecyclerView remen;
    private List<UriBean.DataBean.Ad1Bean> lunbolist;
    private List<String> imageList;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                xBanner.setData(imageList, null);
                xBanner.setPoinstPosition(XBanner.BOTTOM);
                xBanner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(MainActivity.this).load(imageList.get(position)).into((ImageView) view);
                    }
                });
            }
            if (msg.what == 2) {
                JiuAdapter jiuAdapter = new JiuAdapter(MainActivity.this, ad5list);
                jiu.setAdapter(jiuAdapter);
                jiu.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
            }
            if (msg.what == 3) {
                huodong_banner.setData(huodongList, null);
                huodong_banner.setPoinstPosition(XBanner.BOTTOM);
                huodong_banner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view1, int position) {
                        Glide.with(MainActivity.this).load(huoList.get(position)).into((ImageView) view1);
                    }
                });
            }
            if (msg.what == 4) {
                ZhuanAdapter zhuanAdapter = new ZhuanAdapter(MainActivity.this, zhuantiList);
                remen.setAdapter(zhuanAdapter);
                remen.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
            }
        }
    };
    private UriPresenter uriPresenter;
    private List<UriBean.DataBean.Ad5Bean> ad5list;
    private XBanner huodong_banner;
    private List<UriBean.DataBean.Ad8Bean> huodongList;
    private List<String> huoList;
    private List<UriBean.DataBean.DefaultGoodsListBean> zhuantiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        uriPresenter = new UriPresenter(this);
        uriPresenter.getData(Api.URI_API);
        Log.i("--------", "2222222");
    }

    private void findView() {
        xBanner = findViewById(R.id.xBanner);
        jiu = findViewById(R.id.recycle_jiu);
        huodong_banner = findViewById(R.id.huodong_banner);
        remen = findViewById(R.id.recycle_remen);
    }

    /**
     * 重写的方法
     *
     * @param uriBean
     */
    @Override
    public void onSuccess(UriBean uriBean) {
        lunbolist = uriBean.getData().getAd1();
        imageList = new ArrayList<>();
        Log.i("--------", "111111");
        for (UriBean.DataBean.Ad1Bean lunboBean : lunbolist) {
            String image = lunboBean.getImage();
            imageList.add(image);
        }
        handler.sendEmptyMessage(1);
        //九
        ad5list = uriBean.getData().getAd5();
        handler.sendEmptyMessage(2);
        //热门活动
        huodongList = uriBean.getData().getAd8();
        huoList = new ArrayList<>();
        for (UriBean.DataBean.Ad8Bean huodongBean : huodongList) {
            String image = huodongBean.getImage();
            huoList.add(image);
        }
        handler.sendEmptyMessage(3);
        //热门专题
        zhuantiList = uriBean.getData().getDefaultGoodsList();
        handler.sendEmptyMessage(4);
    }
}
