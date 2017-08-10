package com.example.yuqing.fileencrypt;

import android.util.Log;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Created by yuqing on 17/8/10.
 */

public class FileUtils {

    /**
     * 文件重命名
     *
     * @param srcFilePath 源文件的路径
     * @param srcFileName 源文件的文件名
     * @param desFilePath 目标文件的路径
     * @param desFileName 目标文件的文件名
     * @return
     */
    public static boolean renameFile(String srcFilePath, String srcFileName, String desFilePath, String desFileName) {
        try {
            File from = new File(srcFilePath, srcFileName);
            if (from.exists()) {
                File to = new File(desFilePath, desFileName);
                from.renameTo(to);
            } else {
                Log.d("rename file", "源文件不存在");
                return false;
            }
//            File to = new File(desFilePath, desFileName);
//            from.renameTo(to);   // 重命名sd卡文件
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean renameFile(String srcFilePath, String desFilePath) {
        try {
            File from = new File(srcFilePath);
            if (from.exists()) {
                File to = new File(desFilePath);
                from.renameTo(to);
            } else {
                Log.d("rename file", "源文件不存在");
                return false;
            }
//            File to = new File(desFilePath, desFileName);
//            from.renameTo(to);   // 重命名sd卡文件
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean hideFile(String filePath, String fileName) {
        if (fileName.trim().charAt(0) == '.')
            return true;
        return renameFile(filePath, fileName, filePath, "." + fileName);
    }

    public static boolean showFile(String filePath, String fileName) {
        if (fileName.trim().charAt(0) == '.') {
            return renameFile(filePath, fileName, filePath, fileName.substring(1));
        } else {
            return true;
        }
    }

    public void writeTxtToFile(String strcontent, String filePath, String fileName) {
        //生成文件夹之后，再生成文件，不然会出错
//        makeFilePath(filePath, fileName);

        String strFilePath = filePath + fileName;
        // 每次写入时，都换行写
        String strContent = strcontent + "\r\n";
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                Log.d("TestFile", "Create the file:" + strFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
        } catch (Exception e) {
            Log.e("TestFile", "Error on write File:" + e);
        }
    }

    // 生成文件
    public static Boolean createfile(String filePath, String fileName) {
        File file = null;
//        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
            if (!file.exists()) {
                return file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean hideDirectory(String srcPath) {
        if (!srcPath.endsWith("/")) {
            Log.d("hideDirectory", "文件夹路径应以/结尾");
            return false;
        }

        int length = srcPath.length();
        String desPath = srcPath;
        if (srcPath.charAt(length - 1) == '/') {
            desPath = desPath.substring(0, length - 1);
        }
        String path = desPath.substring(0, desPath.lastIndexOf('/') + 1);
        String directoryName = desPath.substring(desPath.lastIndexOf('/') + 1, desPath.length());
        if (directoryName.trim().charAt(0) == '.') {
            Log.d("directoryName", directoryName);
            Log.d("源文件", srcPath);
            return true;
        }
        desPath = path + "." + directoryName + "/";
        return renameFile(srcPath, desPath);
    }

    public static boolean showDirectory(String srcPath) {
        if (!srcPath.endsWith("/")) {
            Log.e("hideDirectory", "文件夹路径应以/结尾");
            return false;
        }

        int length = srcPath.length();
        String desPath = srcPath;
        if (srcPath.charAt(length - 1) == '/') {
            desPath = desPath.substring(0, length - 1);
        }
        String path = desPath.substring(0, desPath.lastIndexOf('/') + 1);
        String directoryName = desPath.substring(desPath.lastIndexOf('/') + 1, desPath.length());

        if (directoryName.trim().charAt(0) != '.') {
            Log.d("directoryName", directoryName);
            Log.d("源文件", srcPath);
            return true;
        } else {
            directoryName = directoryName.substring(1);
        }
        desPath = path + directoryName + "/";
        Log.d("newPath", desPath);
        return renameFile(srcPath, desPath);
    }


}
