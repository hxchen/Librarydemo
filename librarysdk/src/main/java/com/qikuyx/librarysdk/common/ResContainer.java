package com.qikuyx.librarysdk.common;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public abstract class ResContainer
{
    private Map<String, SocializeResource> mResources;
    private Context mContext;
    private static String mPackageName = "";

    public ResContainer(Context paramContext, Map<String, SocializeResource> paramMap)
    {
        this.mResources = paramMap;
        this.mContext = paramContext;
    }

    public static void setPackageName(String paramString)
    {
        mPackageName = paramString;
    }

    public static int getResourceId(Context paramContext, ResType paramResType, String paramString)
    {
        Resources localResources = paramContext.getResources();
        if (TextUtils.isEmpty(mPackageName)) {
            mPackageName = paramContext.getPackageName();
        }
        int i = localResources.getIdentifier(paramString, paramResType.toString(), mPackageName);
        if (i <= 0) {
            throw new RuntimeException("获取资源ID失败:(packageName=" + mPackageName +
                    " type=" + paramResType + " name=" + paramString);
        }
        return i;
    }

    public static String getString(Context paramContext, String paramString)
    {
        int i = getResourceId(paramContext, ResType.STRING, paramString);
        return paramContext.getString(i);
    }

    public synchronized Map<String, SocializeResource> batch()
    {
        if (this.mResources == null) {
            return this.mResources;
        }
        Set<String> localSet = this.mResources.keySet();
        for (String str : localSet) {
            SocializeResource localSocializeResource = (SocializeResource)this.mResources.get(str);
            localSocializeResource.mId = getResourceId(this.mContext, localSocializeResource.mType,
                    localSocializeResource.mName);
            localSocializeResource.mIsCompleted = true;
        }

        return this.mResources;
    }

    public static int[] getStyleableArrts(Context paramContext, String paramString)
    {
        return getResourceDeclareStyleableIntArray(paramContext, paramString);
    }

    private static final int[] getResourceDeclareStyleableIntArray(Context paramContext, String paramString)
    {
        try {
            Field[] arrayOfField1 = Class.forName(paramContext.getPackageName() + ".R$styleable").getFields();

            for (Field localField : arrayOfField1)
            {
                if (localField.getName().equals(paramString))
                {
                    return (int[])localField.get(null);
                }
            }
        }
        catch (Throwable localThrowable) {
            localThrowable.printStackTrace();
        }

        return null;
    }

    public static enum ResType
    {
        LAYOUT,

        ID,

        DRAWABLE,

        STYLE,

        STRING,

        COLOR,

        DIMEN,

        RAW,

        ANIM,

        STYLEABLE;
    }

    public static class SocializeResource
    {
        public ResContainer.ResType mType;
        public String mName;
        public boolean mIsCompleted = false;
        public int mId;

        public SocializeResource(ResContainer.ResType paramResType, String paramString)
        {
            this.mType = paramResType;
            this.mName = paramString;
        }
    }
}
