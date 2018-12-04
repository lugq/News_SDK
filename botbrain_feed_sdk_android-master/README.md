# Bot_News_Android_SDK

<p align="center">
    <a href="http://developer.android.com/index.html">
        <img src="https://img.shields.io/badge/platform-android-green.svg">
    </a>
    <a href="">
        <img src="https://img.shields.io/badge/Maven%20Central-5.8.1-green.svg">
    </a>
</p>

## 效果

**[botbrain_feed_sdk-1.4.0.apk](https://github.com/BotBrain/botbrain_feed_sdk_android/releases/download/v1.4.0/release-v1.4.0-pgyer.apk)**

<img src="https://github.com/BotBrain/botbrain_feed_sdk_android/blob/master/SampleNews/effectPicture/effect_pic2.png?raw=true" width = "640" height = "" alt="2800" align=center />

## Usage
### 集成
1.Import library
在 project 下的 build.gradle 中添加
```
allprojects {
    repositories {
        jcenter()
        // 添加私服地址
        maven {
            url 'https://dl.bintray.com/luguoqiang/maven'
        }
    }
}
```


```
compile 'ai.botbrain.ttcloud.lite:libraryTtc:1.4.0-alpha-9'
```


2. In AndroidManifest.xml
```
<application
    .../>
    <meta-data android:name="TTC_APPID" android:value="申请的AppId" />
<application>
```

3. In Application
```
public class XXApplication extends Application {
  
  @Override
  public void onCreate() {
    super.onCreate();
    TtCloudManager.init(this);
    TtcClient client = new TtcClient.Builder()
          // 数据拦截器(可选)
          .setBotBrainDataSourceInterceptor(new MyBotBrainDataSourceInterceptor())
          // 用于自定义新闻列表样式(可选)
          .setNewsFragmentListener(new MyNewsFragmentListener())
          // 自定义详情页样式(可选)
          .setReadNewsActivityListener(new MyReadNewsActivityListener())
          // 定义搜索页样式(可选)
          .setSearNewsActivityListener(new MySearchNewsActivityListener())
          .build();
    TtCloudManager.init(this, client);
  }
}
```

4. In Activity
```
...
  private IndexFragment mNewsIndexFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ...
    
    mNewsIndexFragment = BotBrain.newInstance().getNewsFragment();
    if (!mNewsIndexFragment.isAdded()) {
      FragmentManager fragmentManager = getSupportFragmentManager();
      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
      fragmentTransaction.add(R.id.container, mNewsIndexFragment);
      fragmentTransaction.commit();
    }
  }
...
```

## [WIKI](https://github.com/BotBrain/botbrain_feed_sdk_android/wiki/QuickStart)

-常规使用

1.[QuickStart](https://github.com/BotBrain/botbrain_feed_sdk_android/wiki/QuickStart)

2.[评论和收藏](https://github.com/BotBrain/botbrain_feed_sdk_android/wiki/%E8%AF%84%E8%AE%BA%E5%92%8C%E6%94%B6%E8%97%8F)

3.[分享功能](https://github.com/BotBrain/botbrain_feed_sdk_android/wiki/%E5%88%86%E4%BA%AB%E5%8A%9F%E8%83%BD)

-自定义

1.[自定义新闻列表页](https://github.com/BotBrain/botbrain_feed_sdk_android/wiki/%E8%87%AA%E5%AE%9A%E4%B9%89UI)

2.[自定义新闻详情页](https://github.com/BotBrain/botbrain_feed_sdk_android/wiki/%E8%87%AA%E5%AE%9A%E4%B9%89UI)

3.[自定义搜索页](https://github.com/BotBrain/botbrain_feed_sdk_android/wiki/%E8%87%AA%E5%AE%9A%E4%B9%89UI)

## ProGuard
If you are using ProGuard you might need to add the following options:
```
# sdk
-keep class ai.botbrain.ttcloud.sdk.model.** { *; }

-keep class ai.botbrain.ttcloud.api.**{*;}
-keep class ai.botbrain.ttcloud.sdk.callback.**{*;}
-keep class ai.botbrain.ttcloud.sdk.fragment.IndexFragment {*; }

# qq.e ad
-keep class com.qq.e.** {
    public protected *;
}
-keep class android.support.v4.app.NotificationCompat**{
    public *;
}

# 360 ad
-keep class com.ak.android.** {*;}
-keep class android.support.v4.app.NotificationCompat**{
      public *;
}

# Glide 4.0
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
# for DexGuard only
-keepresourcexmlelements manifest/application/meta-data@value=GlideModule

# eventBus 3.0
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

# Gson
-keepattributes Signature
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
```


## 注意事项
嵌入 Fragment 的 Activity 需要继承 AppCompatActivity 

