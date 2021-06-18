package FileManager.Action;

import FileManager.Config.Button;
import FileManager.Config.Table_Model;
import FileManager.FileConfig.FileOperate;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

/**
 * @Author lry
 * @Date 2021/6/17 16:00
 * @Version 1.0
 */
public class AllAction implements ActionListener {
    private static JFrame menuFrame;
    private JTable show_info;
    private JButton b1;
    private Table_Model model;
    public int drow;
    public int drowCopy;
    public String name;
    private ArrayList<String> file_name;
    private String[] CopyFileName;
    private JButton b2;

    @Override
    public void actionPerformed(ActionEvent e) {

        FileOperate fileOperate = new FileOperate();
        //显示布局
        String[] columnType = {"文件名"};
        File current = fileOperate.getCurrentFile();
        file_name = new ArrayList<>();
        String[] list = current.list();
        for (String s : list) {
            file_name.add(s);
        }
        int length = this.file_name.size();
        model = new Table_Model(50);
        for (int i = 0; i < length; i++) {
            model.addRow(this.file_name.get(i));
        }
        TableColumn column = null;
        show_info = new JTable(model);
        show_info.setBackground(Color.white);
        int column_height = show_info.getColumnCount();
        for (int i = 0; i < column_height; i++) {
            column = show_info.getColumnModel().getColumn(i);
            column.setPreferredWidth(100 + 500 * i);
        }
        show_info.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scroll = new JScrollPane(show_info);
        scroll.setBounds(100, 100, 1100, 800);
        menuFrame.add(scroll);
        b1 = new Button("删除", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeData();
                } catch (Exception ee) {
                }
            }
        });

        menuFrame.add(b1);
        show_info.updateUI();
        b1.setBounds(1000, 0, 99, 50);

        setMouseColor(b1);
        b2 = new Button("复制", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show_info.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (show_info.getValueAt(show_info.getSelectedRow(), 0) != null) {
                            drow = show_info.getSelectedRow();
                        }
                    }
                });
                int len = 0;
                BufferedOutputStream bos = null;
                BufferedInputStream bis = null;
                String name = file_name.get(drow);
                System.out.println(name);
                byte[] temp = new byte[1024];

                try {
                    name = "(副本)"+name;
                    bis = new BufferedInputStream(new FileInputStream("src\\My_File\\" + file_name.get(drow)));
                    bos = new BufferedOutputStream(new FileOutputStream("src\\My_File\\" + name));
                    while ((len = bis.read(temp)) != -1) {
                        bos.write(temp, 0, len);
                    }
                } catch (Exception E) {
                } finally {
                    try {
                        bis.close();
                        bos.close();
                    } catch (Exception E) {
                    }
                }

            }
        });

        setMouseColor(b2);
        menuFrame.add(b2);
        b2.setBounds(760, 0, 99, 50);
        show_info.updateUI();
    }

    private void removeData() throws IOException {
        show_info.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (show_info.getValueAt(show_info.getSelectedRow(), 0) != null) {
                    drow = show_info.getSelectedRow();
                }
            }
        });
        ;

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("src\\My_File\\" + file_name.get(drow));
            os = new FileOutputStream("src\\HuiShouFile\\" + file_name.get(drow));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (Exception e) {
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        }
        File file = null;
        try {
            file = new File("src\\My_File\\" + file_name.get(drow));
        } catch (Exception e) {
        }
        file.delete();
//        file_name.remove(drow);
        System.out.println(file_name.get(drow));
        this.model.removeRow(drow);
        file_name.remove(drow);
        show_info.updateUI();
    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }

    public static void setMouseColor(JButton b) {
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {  //鼠标移上去
                b.setBackground(Color.gray);
            }
        });
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {  //鼠标离开
                b.setBackground(Color.lightGray);
            }
        });
    }
}
