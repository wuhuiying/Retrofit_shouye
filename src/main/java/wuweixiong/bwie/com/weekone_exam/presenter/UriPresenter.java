package wuweixiong.bwie.com.weekone_exam.presenter;

import wuweixiong.bwie.com.weekone_exam.UriBean;
import wuweixiong.bwie.com.weekone_exam.model.UriModel;
import wuweixiong.bwie.com.weekone_exam.util.ServiceAPI;
import wuweixiong.bwie.com.weekone_exam.view.IUriView;

/**
 * Created by Administrator on 2018/1/28,0028.
 */

public class UriPresenter implements IUriPre {

    private UriModel uriModel;
    private IUriView iUriView;

    public UriPresenter(IUriView iUriView){
        this.iUriView = iUriView;
        uriModel = new UriModel(this);
    }

    public void getData(String url){
        uriModel.getData(url);
    }
    @Override
    public void onSuccess(UriBean uriBean) {
        iUriView.onSuccess(uriBean);
    }
}
