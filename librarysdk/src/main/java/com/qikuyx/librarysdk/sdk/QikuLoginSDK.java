package com.qikuyx.librarysdk.sdk;

import android.content.Context;
import android.util.Log;

import com.qikuyx.librarysdk.MainActivity;


/**
 * Created by Administrator on 2015/10/21.
 */
public final class QikuLoginSDK {
    private static final String TAG = "SDK的UI";
    private static final QikuLoginSDK INSTANCE = new QikuLoginSDK();

    public static QikuLoginSDK getInstance(){
        return INSTANCE;
    }

    public  final void loginForGame(Context context, OnQikuLoginListener onQikuLoginListener){

        MainActivity.startQikuLoginSDKActivity(context);

    }

    public final void printLog(){
        Log.i("QikuLoginSDK", "SDK调用成功!");
    }
    public interface OnQikuLoginListener {

        /**
         * 登陆成功回调
         * @param userID
         */
        public void onSuccess(String userID);

        /**
         * 关闭登陆窗口
         */
        public void onFinish();

        /**
         * 退出回调
         */
        public void onExit();
    }
}
