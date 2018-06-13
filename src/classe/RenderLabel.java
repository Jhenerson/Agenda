/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author jhene
 */
public class RenderLabel implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
       TableColumn coluna = table.getColumn("Foto");
        coluna.setMinWidth(40);
        coluna.setMaxWidth(40);
        table.setRowHeight(40);
        return (Component) value;
    }
    
}
