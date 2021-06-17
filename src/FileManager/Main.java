package FileManager;


import FileManager.Action.*;
import FileManager.FileConfig.*;
import FileManager.Action.ZipAction;
//import FileManager.Config.BgPanel;
//import FileManager.Config.BgPanel;
import FileManager.Config.Button;
import FileManager.Config.FrameSetting;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @Author lmx
 * @Date 2021/6/8 20:35
 * @Version 1.0
 */
public class Main{
    static public JFrame menuFrame;    //主面板
          //当前路径
    private static JPanel jPanel;
    private static Button b1;
    //得到当前路径

    public static void main(String[] args) throws IOException {


        //使用事件调度线程进行管理
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                menuFrame = new FrameSetting("文件网盘", 300, 100, 1100, 700);
                AllAction.getJFrame(menuFrame);
                PictureAction.getJFrame(menuFrame);
                MusicAction.getJFrame(menuFrame);
                //添加各种按钮
                //创建文件夹（在这里可以用哈希表判断是否重复，重复提示删除）
                //删除文件夹（包括单个和批量，这里指放入回收站，不是真正删除）
                b1 = new Button("创建文件夹（在这里可以用哈希表判断是否重复，重复提示删除）", new CreateAction());
                b1.setBounds(0,50,100,50);
                Button b2 = new Button("音乐", new MusicAction());
                b2.setBounds(0,100,100,50);
                Button b3 = new Button("文档", new TxtAction());
                b3.setBounds(0,150,100,50);
                Button b4 = new Button("视频", new VideoAction());
                b4.setBounds(0,200,100,50);
                Button b5 = new Button("图片", new PictureAction());
                b5.setBounds(0,250,100,50);
                Button b6 = new Button("回收站（显示删除了的文件，可以恢复，也可以真正删除）", new HuiAction());
                b6.setBounds(0,300,100,50);
//                Button b7 = new Button("文件压缩/解压（赫夫曼树做，可做可不做，应该能加分，有时间就搞）", new ZipAction());
//                b7.setBounds(0,350,100,50);
                Button b7 = new Button("总文件", new AllAction());
                b7.setBounds(0,350,100,50);
                menuFrame.add(b1);
                menuFrame.add(b2);
                menuFrame.add(b3);
                menuFrame.add(b4);
                menuFrame.add(b5);
                menuFrame.add(b6);
                menuFrame.add(b7);

                //显示布局
//                String[] columnType = {"文件名"};
//                String[] file_name = current.list();
//                int length = file_name.length;
//                Object[][] real_file_name = new Object[length][1];
//                for(int i = 0; i < length; i++){
//                    real_file_name[i][0] = file_name[i];
//                }
//                JTable show_info = new JTable(real_file_name, columnType);
//                TableColumn column = null;
//                int column_height = show_info.getColumnCount();
//                for(int i = 0; i < column_height; i++)
//                {
//                    column = show_info.getColumnModel().getColumn(i);
//                    column.setPreferredWidth(100+500*i);
//                }
//                show_info.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//                JScrollPane scroll = new JScrollPane(show_info);
//                scroll.setBounds(300,200,800,500);
//
//                menuFrame.add(scroll);
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.setVisible(true);
            }
        });
    }
}
