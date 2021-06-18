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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    //得到当前路径

    public static void main(String[] args) throws IOException {

        //使用事件调度线程进行管理
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                createUI();
                menuFrame = new FrameSetting("文件网盘", 300, 100, 1100, 700);
                AllAction.getJFrame(menuFrame);
                PictureAction.getJFrame(menuFrame);
                MusicAction.getJFrame(menuFrame);
                HuiAction.getJFrame(menuFrame);
                TxtAction.getJFrame(menuFrame);
                VideoAction.getJFrame(menuFrame);
                //添加各种按钮
                //创建文件夹（在这里可以用哈希表判断是否重复，重复提示删除）
                //删除文件夹（包括单个和批量，这里指放入回收站，不是真正删除）
                Button b1 = new Button("总文件", new AllAction());
                b1.setBounds(0,100,100,50);
                b1.setFocusPainted(false);
                Button b2 = new Button("音乐", new MusicAction());
                b2.setBounds(0,170,100,50);
                b2.setFocusPainted(false);
                Button b3 = new Button("文档", new TxtAction());
                b3.setBounds(0,240,100,50);
                b3.setFocusPainted(false);
                Button b4 = new Button("视频", new VideoAction());
                b4.setBounds(0,310,100,50);
                b4.setFocusPainted(false);
                Button b5 = new Button("图片", new PictureAction());
                b5.setBounds(0,380,100,50);
                b5.setFocusPainted(false);
                Button b6 = new Button("回收站", new HuiAction());
                b6.setBounds(0,450,100,50);
                b6.setFocusPainted(false);

                Button b7 = new Button("");
                b7.setBounds(0,0,100,100);

                Button b8 = new Button("创建文件",new CreateAction());
                b8.setBounds(0,520,100,50);
                b8.setFocusPainted(false);

                b7.setContentAreaFilled(false);
                b7.setBorderPainted(false);
                ImageIcon icon = new ImageIcon(getClass().getResource("top.jpg"));
                b7.setIcon(icon);
                b7.setMargin(new Insets(0,0,0,5));
                // 去除虚线框
                b7.setFocusPainted(false);

                JTextField textField = new JTextField(8);
                textField.setFont(new Font(null, Font.PLAIN, 20));
                textField.setBounds(640,60,350,30);
                menuFrame.add(textField);

                b1.doClick();
                b6.doClick();



                menuFrame.add(b1);
                b1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {  //鼠标移上去
                        b1.setBackground(Color.gray);
                    }
                });
                b1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseExited(MouseEvent e) {  //鼠标离开
                        b1.setBackground(Color.lightGray);
                    }
                });
                menuFrame.add(b2);
                menuFrame.add(b3);
                menuFrame.add(b4);
                menuFrame.add(b5);
                menuFrame.add(b6);
                menuFrame.add(b7);
                menuFrame.add(b8);

                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.setVisible(true);
            }
        });
    }


    public static void createUI(){
        if (SystemTray.isSupported()) {
            // 获取当前平台的系统托盘
            SystemTray tray = SystemTray.getSystemTray();

            // 加载一个图片用于托盘图标的显示
            Image image = Toolkit.getDefaultToolkit().getImage("background.jpg");

            // 创建点击图标时的弹出菜单
            PopupMenu popupMenu = new PopupMenu();

            MenuItem openItem = new MenuItem("打开");
            MenuItem exitItem = new MenuItem("退出");

            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 点击打开菜单时显示窗口
                    if (!menuFrame.isShowing()) {
                        menuFrame.setVisible(true);
                    }
                }
            });
            exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 点击退出菜单时退出程序
                    System.exit(0);
                }
            });

            popupMenu.add(openItem);
            popupMenu.add(exitItem);

            // 创建一个托盘图标
            TrayIcon trayIcon = new TrayIcon(image, "网盘", popupMenu);

            // 托盘图标自适应尺寸
            trayIcon.setImageAutoSize(true);

            trayIcon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    switch (e.getButton()) {
                        case MouseEvent.BUTTON1: {
                            System.out.println("托盘图标被鼠标左键被点击");
                            break;
                        }
                        case MouseEvent.BUTTON2: {
                            System.out.println("托盘图标被鼠标中键被点击");
                            break;
                        }
                        case MouseEvent.BUTTON3: {
                            System.out.println("托盘图标被鼠标右键被点击");
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }
            });

            // 添加托盘图标到系统托盘
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("当前系统不支持系统托盘");
        }
    }

}
