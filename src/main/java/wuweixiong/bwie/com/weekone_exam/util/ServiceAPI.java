package wuweixiong.bwie.com.weekone_exam.util;

import retrofit2.Call;
import retrofit2.http.GET;
import wuweixiong.bwie.com.weekone_exam.UriBean;

/**
 * Created by Administrator on 2018/1/27,0027.
 */

public interface ServiceAPI {
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Call<UriBean> getCall();
}
