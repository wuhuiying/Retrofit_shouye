package wuweixiong.bwie.com.weekone_exam.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wuweixiong.bwie.com.weekone_exam.UriBean;
import wuweixiong.bwie.com.weekone_exam.presenter.IUriPre;
import wuweixiong.bwie.com.weekone_exam.util.RetrofitHelper;
import wuweixiong.bwie.com.weekone_exam.util.ServiceAPI;

/**
 * Created by Administrator on 2018/1/27,0027.
 */

public class UriModel {
    private IUriPre iUriPre;

    public UriModel(IUriPre iUriPre){
        this.iUriPre = iUriPre;
    }

    public void getData(String url){
        ServiceAPI serviceAPI = RetrofitHelper.getApiService(url);
        serviceAPI.getCall().enqueue(new Callback<UriBean>() {
            @Override
            public void onResponse(Call<UriBean> call, Response<UriBean> response) {
                iUriPre.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<UriBean> call, Throwable t) {

            }
        });

    }
}
