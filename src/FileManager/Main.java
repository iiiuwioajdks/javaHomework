package FileManager;

import FileManager.Action.ChangeAction;
import FileManager.Config.FrameSetting;
import FileManager.Config.Button;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @Author lmx
 * @Date 2021/6/8 20:35
 * @Version 1.0
 */
public class Main {
    static private JFrame menuFrame;    //主面板
    private static File current;        //当前路径
    //得到当前路径
    public static File getCurrentFile() {
        return current;
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
    public static void main(String[] args) throws IOException {
        current = new File((new File("")).getAbsolutePath());
        //使用事件调度线程进行管理
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                menuFrame = new FrameSetting("主菜单", 500, 100, 800, 800);
                //添加各种按钮
//                menuFrame.add(new Button("创建文件夹（在这里可以用哈希表判断是否重复，重复提示删除）", new FileManager.CreateAction()));
//                menuFrame.add(new Button("删除文件夹（包括单个和批量，这里指放入回收站，不是真正删除）", new DeleteAction()));
//                menuFrame.add(new Button("列举（分类）文件（类似下拉框，选中后缀类型出现）", new ListAction()));
//                menuFrame.add(new Button("文件检索（模糊查找，快速查找，后缀名查找）", new ListAction()));
//                menuFrame.add(new Button("复制文件夹（文件批量操作）", new CopyAction()));
//                menuFrame.add(new Button("文件回收站（显示删除了的文件，可以恢复，也可以真正删除）", new CopyAction()));
//                menuFrame.add(new Button("文件压缩/解压（赫夫曼树做，可做可不做，应该能加分，有时间就搞）", new ZipAction()));
                menuFrame.add(new Button("设置目录", new ChangeAction()));
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.setVisible(true);
            }
        });
    }
}
