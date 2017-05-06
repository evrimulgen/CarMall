# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html

# 不使用大小写混合，混淆后类名称为小写
# proguard会默认我们的操作系统能够区分大小写字母的文件，如b.java和B.java会被认为是两个不同的文件，
# 但是window系统并不这样认为(window系统对大小写不敏感的)。
# 因此在window系统下必须在proguard文件中指明-dontusemixedcaseclassnames选项。
# 如果没这样做并且我们的项目中类的数量超过26个的话，那么proguard就会默认混用大小写文件名，
# 进而导致class文件相互覆盖。所以为了安全起见，我们都默认设置该选项。
-dontusemixedcaseclassnames

# 指定不去忽略非公共的库类
# 用于高速proguard，不要跳过对非公开类的处理。
# 默认情况下是跳过的，因为程序中不会引用它们，有些情况下人们编写的代码与类库中的类在同一个包下，
# 并且对包中内容加以引用，此时需要加入此条声明。
-dontskipnonpubliclibraryclasses

# 输出生成信息
# 混淆时记录日志（混淆后生产映射文件 map 类名 -> 转化后类名的映射
-verbose

# Optimization is turned off by default. Dex does not like code run
# through the ProGuard optimize and preverify steps (and performs some
# of these optimizations on its own).
# 不优化输入的类文件
-dontoptimize

# 不做预校验，preverify是proguard的4个功能之一
# android不需要preverify，去掉这一步加快混淆速度
-dontpreverify
# Note that if you want to enable optimization, you cannot just
# include optimization flags in your own project configuration file;
# instead you will need to point to the
# "proguard-android-optimize.txt" file instead of this one from your
# project.properties file.

# 假如项目中有用到注解，应加入这行配置,对JSON实体映射也很重要,eg:fastjson
-keepattributes *Annotation*
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService

# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
# 保持 native 的方法不去混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# We want to keep methods in Activity that could be used in the XML attribute onClick
#保留在Activity中的方法参数是view的方法，从而我们在layout里面编写onclick的就不会被影响
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclassmembers class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator CREATOR;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}

# The support library contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version.  We know about them, and they are safe.
-dontwarn android.support.**

# Understand the @Keep support annotation.
-keep class android.support.annotation.Keep

-keep @android.support.annotation.Keep class * {*;}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <methods>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <fields>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <init>(...);
}




#Butter Knife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#okhttp
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**

#Gson
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson 下面替换成自己的实体类
-keep class com.loading.carmall.bean.** { *; }
-keep class com.loading.carmall.ui.weiget.banner.** { *; }

#Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# for DexGuard only
#-keepresourcexmlelements manifest/application/meta-data@value=GlideModule

#Bugly
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}
-keep class android.support.**{*;}

# For Guava:
-dontwarn javax.annotation.**
-dontwarn javax.inject.**
-dontwarn sun.misc.Unsafe
