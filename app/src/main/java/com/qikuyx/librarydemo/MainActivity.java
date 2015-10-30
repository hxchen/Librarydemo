package com.qikuyx.librarydemo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qikuyx.librarysdk.common.GetItemId;
import com.qikuyx.librarysdk.sdk.QikuLoginSDK;


public class MainActivity extends Activity implements View.OnClickListener{
    private static final String TAG = "测试Demo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        Button loginGameButton = (Button) findViewById(R.id.btn_invokeSDK);
        int i = GetItemId.getIdResIDByName(this,"btn_invokeSDK");
        Log.i(TAG, "btn_invokeSDK 的ID是"+i);
        loginGameButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_invokeSDK:
                Log.i(TAG,"点击按钮");
                Toast.makeText(this,"点击",Toast.LENGTH_SHORT).show();
                QikuLoginSDK.getInstance().printLog();
                QikuLoginSDK.getInstance().loginForGame(this, onQikuLoginListener);
                break;
        }
    }
    private QikuLoginSDK.OnQikuLoginListener onQikuLoginListener = new QikuLoginSDK.OnQikuLoginListener() {
        @Override
        public void onSuccess(String s) {
            Log.i("游戏Activity", "用户ID = " + s);
        }

        @Override
        public void onFinish() {
            Log.i("游戏Activity", "用户关闭");
        }

        @Override
        public void onExit() {
            Log.i("游戏Activity", "用户退出 ");
        }
    };
}
