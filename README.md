# PictureView
图片查看器
在根构建中添加它:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
添加依赖关系

	dependencies {
	        implementation 'com.github.123xuan456:PictureView:v1.0.2'//androidstudio3.0 
		compile 'com.github.123xuan456:PictureView:v1.0.2'
	}

使用方法：
```java
	if (lists.size()>0){
            PictureConfig config = new PictureConfig.Builder()
                    .setListData((ArrayList<String>)lists)//图片数据List<String> list
                    .setPosition(position)//图片下标（从第position张图片开始浏览）
                    .setDownloadPath("pictureviewer")//图片下载文件夹地址
                    .needDownload(true)//是否支持图片下载
                    .setPlacrHolder(R.mipmap.a)//点位图
                    .build();
            ImagePagerActivity.startActivity(context, config);
        }else {
            LogUtils.i("图片为空");
        }


