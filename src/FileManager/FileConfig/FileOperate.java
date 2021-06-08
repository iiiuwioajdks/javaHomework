package FileManager.FileConfig;

import java.io.File;
import java.io.IOException;

/**
 * @Author lmx
 * @Date 2021/6/8 20:35
 * @Version 1.0
 */
class FileOperate {
    //源文件名与目标文件名
    protected String src, des;
    //源文件与目标文件
    protected File from, to;

    //进行操作，返回该操作是否成功
    public boolean operate() throws IOException {
        return true;
    }

    //初始化当前文件名
    FileOperate(String s) {
        src = s;
    }

    //初始化源文件名与目标文件名
    FileOperate(String s1, String s2) {
        src = s1;
        des = s2;
    }

    //初始化当前文件
    FileOperate(File f) {
        from = f;
    }

    //初始化源文件与目标文件
    FileOperate(File f, File t) {
        from = f;
        to = t;
    }
}
