/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.Button;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lram
 */
public class EmpleoTableModel extends AbstractTableModel  {
    public static final int ACCEPT_COLUMN = 4;
    public static final int DELETE_COLUMN = 5;
    private final JButton aceptarEnabled = new JButton("Aceptar");
    private final JButton aceptarDisabled = new JButton("Aceptar");
    private final JButton rechazarEnabled = new JButton("Rechazar");
    private final JButton rechazarDisabled = new JButton("Rechazar");
    private final String[] columnas
            = {
                "Id",
                "Id Empleado",
                "Fecha",
                "Descripción",
                "Acción 1",
                "Acción 2"
            };

    private final List<Empleo> empleos;

    public EmpleoTableModel() {
        empleos = new ArrayList<>();
        initComponents();
    }
    
    public EmpleoTableModel(List<Empleo> empleos) {
        this.empleos = empleos;
        initComponents();
    }
    
    private void initComponents() {
        aceptarDisabled.setEnabled(false);
        rechazarDisabled.setEnabled(false);
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public int getRowCount() {
        return empleos.size();
    }

    @Override
    public Class getColumnClass(int column) {
        return switch (column) {
            case 0 -> int.class;
            case 1 -> int.class;
            case 2 -> Date.class;
            case 4 -> Button.class;
            case 5 -> Button.class;
            default -> String.class;
        };
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return switch (column) {
            default -> false;
        };
    }

    @Override
    public Object getValueAt(int row, int column) {
        Empleo empleo = getEmpleo(row);

        return switch (column) {
            case 0 -> empleo.getId();
            case 1 -> empleo.getIdEmpleado();
            case 2 -> empleo.getFecha();
            case 3 -> empleo.getDescripcion();
            case 4 -> (empleo.getEstado() == 0) ? aceptarEnabled : aceptarDisabled;
            case 5 -> (empleo.getEstado() == 0) ? rechazarEnabled : rechazarDisabled;
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object valor, int fila, int columna) {
        Empleo empleo = getEmpleo(fila);

        switch (columna) {
            case 0 -> empleo.setId((int) valor);
            case 1 -> empleo.setIdEmpleado((int) valor);
            case 2 -> empleo.setFecha((Date) valor);
            case 3 -> empleo.setDescripcion((String) valor);
        }
        
        fireTableCellUpdated(fila, columna);
    }
    
    public Empleo getEmpleo(int fila) {
        return empleos.get(fila);
    }

    public void agregarEmpleo(Empleo empleo) {
        insertarEmpleo(getRowCount(), empleo);
    }

    public void insertarEmpleo(int fila, Empleo empleo) {
        empleos.add(fila, empleo);
        fireTableRowsInserted(fila, fila);
    }

    public void eliminarEmpleo(int row) {
        empleos.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public void actualizarDatos() {
        fireTableDataChanged();
    }
}
