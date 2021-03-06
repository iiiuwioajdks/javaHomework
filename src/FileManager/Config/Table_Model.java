package FileManager.Config;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

/**
 * @Author lmx
 * @Date 2021/6/17 20:32
 * @Version 1.0
 */
public class Table_Model extends AbstractTableModel {

    private Vector content = null;

    private String[] title_name = {"总文件 "};

    public Table_Model() {
        content = new Vector();
    }

    public Table_Model(int count) {
        content = new Vector(count);
    }

    public void addRow(String file) {
        Vector v = new Vector(4);
        v.add(file);
        content.add(v);
    }

    public void setTitle_name(String name){
        this.title_name = new String[]{name};
    }
    public void removeRow(int row) {
        content.remove(row);
    }

    public void removeRows(int row, int count) {
        for (int i = 0; i < count; i++) {
            if (content.size() > row) {
                content.remove(row);
            }
        }
    }

    public String getColumnName(int col) {
        return title_name[col];
    }

    public int getColumnCount() {
        return title_name.length;
    }

    public int getRowCount() {
        return content.size();
    }

    public Object getValueAt(int row, int col) {
        if (row >= 0 && content != null) {
            Object o = null;
            try {
                o = ((Vector) content.get(row)).get(col);
            }catch (Exception e){

            }
            return o;
        }else {
            return "垃圾文件";
        }
    }

}