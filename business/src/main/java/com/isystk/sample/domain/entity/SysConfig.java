package com.isystk.sample.domain.entity;

import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = SysConfigListener.class)
@Table(name = "sys_config")
public class SysConfig {

    /**  */
    @Id
    @Column(name = "variable")
    String variable;

    /**  */
    @Column(name = "value")
    String value;

    /**  */
    @Column(name = "set_time")
    Timestamp setTime;

    /**  */
    @Column(name = "set_by")
    String setBy;

    /** 
     * Returns the variable.
     * 
     * @return the variable
     */
    public String getVariable() {
        return variable;
    }

    /** 
     * Sets the variable.
     * 
     * @param variable the variable
     */
    public void setVariable(String variable) {
        this.variable = variable;
    }

    /** 
     * Returns the value.
     * 
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /** 
     * Sets the value.
     * 
     * @param value the value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /** 
     * Returns the setTime.
     * 
     * @return the setTime
     */
    public Timestamp getSetTime() {
        return setTime;
    }

    /** 
     * Sets the setTime.
     * 
     * @param setTime the setTime
     */
    public void setSetTime(Timestamp setTime) {
        this.setTime = setTime;
    }

    /** 
     * Returns the setBy.
     * 
     * @return the setBy
     */
    public String getSetBy() {
        return setBy;
    }

    /** 
     * Sets the setBy.
     * 
     * @param setBy the setBy
     */
    public void setSetBy(String setBy) {
        this.setBy = setBy;
    }
}