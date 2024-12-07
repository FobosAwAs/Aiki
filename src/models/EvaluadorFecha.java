/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import com.toedter.calendar.IDateEvaluator;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lram
 */
public class EvaluadorFecha implements IDateEvaluator {

    private List<Date> fechas;
    @Override
    public boolean isSpecial(Date date) {
        return false;
    }

    @Override
    public Color getSpecialForegroundColor() {
        return null;
    }

    @Override
    public Color getSpecialBackroundColor() {
        return null;
    }

    @Override
    public String getSpecialTooltip() {
        return null;
    }
    @Override
    public boolean isInvalid(Date date) {
        for (Date fechaBloqueada : fechas) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (sdf.format(fechaBloqueada).equals(sdf.format(date))) {
                return true;
            }
        }
        return false;
    }        

    /**
     * Sets the initial date in the range to be validated.
     * @param startDate 
     */
    public void setStartDate(Date startDate) {
    }

    /**
     * @return the initial date in the range to be validated.
     */
    public Date getStartDate() {
        return null;
    }

    /**
     * Sets the final date in the range to be validated.
     * @param endDate 
     */
    public void setEndDate(Date endDate) {
        
    }

    /**
     * @return the final date in the range to be validated.
     */
    public Date getEndDate() {
        return null;
    }        

    @Override
    public Color getInvalidForegroundColor() {
        return null;
    }

    @Override
    public Color getInvalidBackroundColor() {
        return null;
    }

    @Override
    public String getInvalidTooltip() {
        return null;
    }

    public void setFechas(List<Date> fechas) {
        this.fechas = fechas;
    }
}
