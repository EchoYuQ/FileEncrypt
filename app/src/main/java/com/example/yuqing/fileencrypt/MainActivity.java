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
                    Toast.makeText(MainActivity.this, "重命名成功，文件位置：" + path + "/可点击可滑动tab栏.yd", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(MainActivity.this, "还原文件名成功，文件位置：" + path + "/可点击可滑动tab栏.mp4", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "还原文件名失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
