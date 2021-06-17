package FileManager.FileConfig;

import java.io.File;
import java.io.IOException;

/**
 * @Author lmx
 * @Date 2021/6/8 20:35
 * @Version 1.0
 */
public class FileOperate {
    //源文件名与目标文件名
    protected String src, des;
    //源文件与目标文件
    protected File from, to;

    private static File current = new File("src\\My_File");
    private static File current2 = new File("src\\HuiShouFile");
    public File getCurrentFile() {
        return current;
    }
    public File getCurrentFile2() {
        return current2;
    }
    //改变当前路径
    public static boolean setCurrentFile(String s) {
        File tempFile = current;
        current = new File(s);
        if(current.exists()) return true;
        else {
            current = tempFile;
            return false;
        }
    }

    //进行操作，返回该操作是否成功
    public boolean operate() throws IOException {
        return true;
    }


}
