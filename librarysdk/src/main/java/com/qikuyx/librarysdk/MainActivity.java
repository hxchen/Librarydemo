package com.qikuyx.librarysdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.qikuyx.librarysdk.common.GetItemId;
import com.qikuyx.librarysdk.common.ResContainer;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.lib_librarysdk_activity_main);
//        setContentView(ResContainer.getResourceId(this, ResContainer.ResType.LAYOUT, "lib_librarysdk_activity_main"));
        setContentView(GetItemId.getIdResIDByName(this, "lib_librarysdk_activity_main"));

    }

    public static void startQikuLoginSDKActivity(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
