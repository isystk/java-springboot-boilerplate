package com.isystk.sample.domain.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = ItemListener.class)
@Table(name = "item")
public class Item {

    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    /**  */
    @Column(name = "name")
    String name;

    /**  */
    @Column(name = "price")
    Double price;

    /**  */
    @Column(name = "vendor")
    String vendor;

    /** 
     * Returns the id.
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /** 
     * Sets the id.
     * 
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
     * Returns the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /** 
     * Sets the name.
     * 
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Returns the price.
     * 
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /** 
     * Sets the price.
     * 
     * @param price the price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /** 
     * Returns the vendor.
     * 
     * @return the vendor
     */
    public String getVendor() {
        return vendor;
    }

    /** 
     * Sets the vendor.
     * 
     * @param vendor the vendor
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}