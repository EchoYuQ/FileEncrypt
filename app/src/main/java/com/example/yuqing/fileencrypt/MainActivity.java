package com.example.yuqing.fileencrypt;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //    /storage/emulated/0/LuPingDaShi/Rec/可点击可滑动tab栏.mp4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.encrypt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = Environment.getExternalStorageDirectory().getAbsolutePath() + "/LuPingDaShi/Rec/可点击可滑动tab栏.mp4";
                Log.e("filepath", filename);
                boolean success = FileDES.encrypt(filename);
                if (success) {
                    Toast.makeText(MainActivity.this, "加密成功，文件位置：" + filename, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "加密失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.decrypt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = Environment.getExternalStorageDirectory().getAbsolutePath() + "/LuPingDaShi/Rec/可点击可滑动tab栏.yd";
                Log.e("filepath", filename);
                boolean success = FileDES.encrypt(filename);
                if (success) {
                    Toast.makeText(MainActivity.this, "解密成功，文件位置：" + filename, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "解密失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.rename).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/LuPingDaShi/Rec/";
                boolean success = FileDES.renameFile(path, "可点击可滑动tab栏.mp4", path, "可点击可滑动tab栏.yd");
                Log.d("rename", success + "");
                if (success) {
                    Toast.makeText(MainActivity.this, "重命名成功，文件位置：" + path + "可点击可滑动tab栏.yd", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "重命名失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.recover_name).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/LuPingDaShi/Rec/";
                boolean success = FileDES.renameFile(path, "可点击可滑动tab栏.yd", path, "可点击可滑动tab栏.mp4");
                Log.d("recover name", success + "");
                if (success) {
                    Toast.makeText(MainActivity.this, "还原文件名成功，文件位置：" + path + "可点击可滑动tab栏.mp4", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "还原文件名失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.hide_file).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/LuPingDaShi/Rec/";
                String filename = "可点击可滑动tab栏.mp4";
                boolean success = FileUtils.hideFile(path, filename);
                Log.d("hide file", success + "");
                if (success) {
                    Toast.makeText(MainActivity.this, "隐藏文件成功，文件位置：" + path + "." +
                            "可点击可滑动tab栏.mp4", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "隐藏文件失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.show_file).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/LuPingDaShi/Rec/";
                String filename = ".可点击可滑动tab栏.mp4";
                boolean success = FileUtils.showFile(path, filename);
                Log.d("show file", success + "");
                if (success) {
                    Toast.makeText(MainActivity.this, "显示文件成功，文件位置：" + path + filename.substring(1), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "显示文件失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.create_file).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/LuPingDaShi/.Rec/";
//                FileUtils.createfile(path, ".nomedia");
                String filename = ".新视频aa.mp4";

                boolean success = FileUtils.createfile(path, filename);
                Log.d("show file", success + "");
                if (success) {
                    Toast.makeText(MainActivity.this, "创建文件成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "创建文件失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.hide_directory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/LuPingDaShi/Rec/";
                boolean success = FileUtils.hideDirectory(path);
                Log.d("hide directory", success + "");
                if (success) {
                    Toast.makeText(MainActivity.this, "隐藏文件夹成功，文件位置：" + path, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "隐藏文件夹失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.show_directory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/LuPingDaShi/.Rec/";
                boolean success = FileUtils.showDirectory(path);
                Log.d("show directory", success + "");
                if (success) {
                    Toast.makeText(MainActivity.this, "显示文件夹成功，文件位置：" + path, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "显示文件夹失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
