/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author lram
 */
public class EmpleoTableRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JButton boton) {
            // Renderizar botones para mejorar la visual
            return boton;
        }
        // Usar renderer por defecto para el resto de componentes
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
