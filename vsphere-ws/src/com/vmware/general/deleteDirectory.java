package com.vmware.general;

import java.io.File;

/**
 * Created by zhujunlong on 2016/12/15.
 */
public class deleteDirectory {
    public static void main(String[] args) {
        File file = new File("E:\\QMDownload\\Hotfix");
        deleteAllFilesOfDir(file);
    }
    private static void deleteAllFilesOfDir(File path) {
        if (!path.exists()) {
            return;
        }
        if (path.isDirectory()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteAllFilesOfDir(files[i]);
            }
            path.delete();
        }
        else if (path.isFile()) {
            path.delete();
        }
    }
}
