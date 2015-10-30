package com.qikuyx.librarysdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.qikuyx.librarysdk.common.GetItemId;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(resName = "lib_librarysdk_activity_main_login")
public class MainActivity extends Activity {

    @ViewById(resName = "btn_show_toast")
    Button btnShowToast;

    @AfterViews
    void afterView(){
        Log.i("SDK UI", "UI afterView.");
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Log.i("SDK UI", "onCreate");
//        setContentView(GetItemId.getLayoutResIDByName(this, "lib_librarysdk_activity_main"));
//    }
    @Click(resName = "btn_show_toast")
    void showToast(){
        Toast.makeText(this, GetItemId.getStringResIDByName(this, "app_descp"), Toast.LENGTH_SHORT).show();
    }
    public static void startQikuLoginSDKActivity(Context context){
        Log.i("SDK UI", "UI jump..");
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
