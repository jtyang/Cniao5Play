package com.cniao5.cniao5play.common.rx.subscriber;

import android.content.Context;
import android.util.Log;

import com.cniao5.cniao5play.common.exception.BaseException;
import com.cniao5.cniao5play.common.util.ProgressDialogHandler;
import com.cniao5.cniao5play.ui.BaseView;

/**
 * 菜鸟窝http://www.cniao5.com 一个高端的互联网技能学习平台
 *
 * @author Ivan
 * @version V1.0
 * @Package com.cniao5.cniao5play.common.rx.subscriber
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date
 */

public  abstract  class ProgressSubcriber<T> extends ErrorHandlerSubscriber<T>  {




    private BaseView mView;


    public ProgressSubcriber(Context context, BaseView view) {
        super(context);
        this.mView = view;

    }



    public boolean isShowProgress(){
        return true;
    }



    @Override
    public void onStart() {

        if(isShowProgress()){
            mView.showLoading();
        }

    }

    @Override
    public void onCompleted() {

            mView.dismissLoading();
    }

    @Override
    public void onError(Throwable e) {

        e.printStackTrace();

        BaseException baseException =  mErrorHandler.handleError(e);
        mView.showError(baseException.getDisplayMessage());

    }

}
