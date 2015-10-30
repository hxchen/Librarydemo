package com.qikuyx.librarysdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.qikuyx.librarysdk.common.GetItemId;
import com.qikuyx.librarysdk.common.ResContainer;


public class MainActivity extends Activity {
    private static final String TAG = "SDK的UI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "SDK UI初始化");
//        setContentView(R.layout.lib_librarysdk_activity_main);
        int x = GetItemId.getLayoutResIDByName(this, "lib_librarysdk_activity_main");
        Log.i(TAG, "x = "+x);
//        int y = ResContainer.getResourceId(this, ResContainer.ResType.LAYOUT, "lib_librarysdk_activity_main");
//        Log.i(TAG, "y = "+y);
//        setContentView(ResContainer.getResourceId(this, ResContainer.ResType.LAYOUT, "lib_librarysdk_activity_main"));
        setContentView(GetItemId.getLayoutResIDByName(this, "lib_librarysdk_activity_main"));

    }

    public static void startQikuLoginSDKActivity(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
