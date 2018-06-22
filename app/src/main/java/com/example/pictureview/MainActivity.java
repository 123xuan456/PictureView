package com.example.pictureview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private GridAdapter mGridAdapter;
    List<String> lists = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView)findViewById(R.id.gridView);
        mGridAdapter = new GridAdapter(MainActivity.this);

        lists.add("https://ws1.sinaimg.cn/large/610dc034ly1fgepc1lpvfj20u011i0wv.jpg");
        lists.add("https://ws1.sinaimg.cn/large/610dc034ly1fgdmpxi7erj20qy0qyjtr.jpg");
        lists.add("https://ws1.sinaimg.cn/large/610dc034ly1fgchgnfn7dj20u00uvgnj.jpg");
        lists.add("https://ws1.sinaimg.cn/large/610dc034ly1fgbbp94y9zj20u011idkf.jpg");
        mGridAdapter.setData(lists);
        gridView.setAdapter(mGridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showImage(MainActivity.this,lists,position);
            }
        });
    }
    public static void showImage(Context context, List<String> lists,int position){
        if (lists.size()>0){
            PictureConfig config = new PictureConfig.Builder()
                    .setListData((ArrayList<String>)lists)//图片数据List<String> list
                    .setPosition(position)//图片下标（从第position张图片开始浏览）
                    .setDownloadPath("pictureviewer")//图片下载文件夹地址
                    .needDownload(true)//是否支持图片下载
                    .build();
            ImagePagerActivity.startActivity(context, config);
        }else {
//            LogUtils.i("图片为空");
        }
    }
}
