package FileManager.Action;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author dzc
 * @Date 2021/6/19 02：04
 * @Version 1.0
 */
public class CreateAction implements ActionListener {
    private static JFrame menuFrame;
    private int appendm = 1;
    private int appendp = 1;
    private int appendt = 1;
    private String input = null;
    String name = null;

    @Override
    public void actionPerformed(ActionEvent e) {

        JPanel j2 = new JPanel();       //中间容器

        j2.setBackground(Color.white);
        JLabel j1 = new JLabel("");
        j1.setText("suffix");
//        j1.setBackground(Color.BLACK);
        JComboBox<String> format = new JComboBox<String>();
        format.addItem("mp3");
        format.addItem("jpg");
        format.addItem("txt");

        j2.add(j1);
        j2.add(format);

        j2.setBounds(640, 0, 80, 100);

        menuFrame.add(j2);
        menuFrame.setVisible(true);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        format.setSelectedIndex(-1);
        format.setEditable(true);

        format.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {

                JTextField field = (JTextField) format.getEditor().getEditorComponent();
                String input = field.getText();
                BufferedOutputStream bos = null;

                byte[] temp = new byte[1024];
                try {
                    if (input.equals("mp3")) {
                        if (appendm != 1) {
                            name = "（副本）空音乐.mp3";
                        } else {
                            name = "空音乐.mp3";
                        }
                        appendm++;
                        bos = new BufferedOutputStream(new FileOutputStream("src\\My_File\\" + name));
                        bos.write(temp);
                    } else if (input.equals("jpg")) {
                        if (appendp != 1) {
                            name = "（副本）空图片.jpg" ;
                        } else {
                            name = "空图片.jpg";
                        }
                        appendp++;
                        bos = new BufferedOutputStream(new FileOutputStream("src\\My_File\\" + name));
                        bos.write(temp);
                    } else if (input.equals("txt")) {
                        if (appendt != 1) {
                            name = "（副本）空文档.txt";
                        } else {
                            name = "空文档.txt";
                        }
                        appendt++;
                        bos = new BufferedOutputStream(new FileOutputStream("src\\My_File\\" + name));
                        bos.write(temp);
                    }
                } catch (
                        Exception E) {
                } finally {
                    try {
                        if (bos != null) {
                            bos.close();
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                }


            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });

        j2.updateUI();

    }


    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }

}
