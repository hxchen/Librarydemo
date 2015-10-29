package com.qikuyx.librarysdk.common;

import java.lang.reflect.Field;
import android.content.Context;
import android.util.Log;
public class GetItemId {
    public static int getItemId(Context paramContext, String paramString1,
                                String paramString2) {
        try {
            Class<?> localClass = Class.forName(paramContext.getPackageName()
                    + ".R$" + paramString1);
            Field localField = localClass.getField(paramString2);
            int i = Integer.parseInt(localField.get(localField.getName())
                    .toString());
            return i;
        } catch (Exception localException) {
            Log.e("getIdByReflection error", localException.getMessage());
        }
        return 0;
    }
    public static int[] getItemIdArray(Context paramContext,
                                       String paramString1, String paramString2) {
        try {
            Class<?> localClass = Class.forName(paramContext.getPackageName()
                    + ".R$" + paramString1);
            Field localField = localClass.getField(paramString2);
            int[] i = (int[]) localField.get(localField.getName().toString());
            return i;
        } catch (Exception localException) {
            Log.e("getIdByReflection error", localException.getMessage());
        }
        return null;
    }
    public static int getLayoutResIDByName(Context context, String name) {
        return context.getResources().getIdentifier(name, "layout",
                context.getPackageName());
    }
    public static int getIdResIDByName(Context context, String name) {
        return context.getResources().getIdentifier(name, "id",
                context.getPackageName());
    }
    public static int getStringResIDByName(Context context, String name) {
        return context.getResources().getIdentifier(name, "string",
                context.getPackageName());
    }
    public static int getDrawableResIDByName(Context context, String name) {
        return context.getResources().getIdentifier(name, "drawable",
                context.getPackageName());
    }
}
