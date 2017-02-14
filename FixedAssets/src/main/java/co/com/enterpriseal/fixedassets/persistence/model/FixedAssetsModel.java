package co.com.enterpriseal.fixedassets.persistence.model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Clase que mapea la tabla gest_acti de la base de datos
 * @since 2017-10-1
 * @author AdrianL
 */
public class FixedAssetsModel {
	private int inventoryNumber; // numero inventario
    private String serial; // serial
    private String name; // nombre activo
    private String description; // descripcion activo
    private BigDecimal weight; // peso activo
    private BigDecimal high; // alto activo
    private BigDecimal width; // ancho activo
    private BigDecimal length; // largo activo
    private BigDecimal value; // valor activo
    private Date dateBuy; // fecha compra
    private Date dischargeDate; // fecha de baja
    private int state; // estado activo
    private int activeType; // tipo activo
    private int color; // color activo

    /**
     * Numero inventario
     * @return the inventoryNumber
     */
    public int getInventoryNumber() {
        return inventoryNumber;
    }

    /**
     * Numero inventario
     * @param inventoryNumber the inventoryNumber to set
     */
    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    /**
     * Serial
     * @return the serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Serial
     * @param serial the serial to set
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * Nombre
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Nombre
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Descripcion
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Descripcion
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Peso
     * @return the weight
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * Peso
     * @param weight the weight to set
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * Alto
     * @return the high
     */
    public BigDecimal getHigh() {
        return high;
    }

    /**
     * Alto
     * @param high the high to set
     */
    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    /**
     * Ancho
     * @return the width
     */
    public BigDecimal getWidth() {
        return width;
    }

    /**
     * Ancho
     * @param width the width to set
     */
    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    /**
     * Largo
     * @return the length
     */
    public BigDecimal getLength() {
        return length;
    }

    /**
     * Largo
     * @param length the length to set
     */
    public void setLength(BigDecimal length) {
        this.length = length;
    }

    /**
     * Valor
     * @return the value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Valor
     * @param value the value to set
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Fecha Compra
     * @return the dateBuy
     */
    public Date getDateBuy() {
        return dateBuy;
    }

    /**
     * Fecha Compra
     * @param dateBuy the dateBuy to set
     */
    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    /**
     * Fecha de baja
     * @return the dischargeDate
     */
    public Date getDischargeDate() {
        return dischargeDate;
    }

    /**
     * Fecha de baja
     * @param dischargeDate the dischargeDate to set
     */
    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    /**
     * Estado
     * @return the state
     */
    public int getState() {
        return state;
    }

    /**
     * Estado
     * @param state the state to set
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * Tipo Activo
     * @return the activeType
     */
    public int getActiveType() {
        return activeType;
    }

    /**
     * Tipo Activo
     * @param activeType the activeType to set
     */
    public void setActiveType(int activeType) {
        this.activeType = activeType;
    }

    /**
     * Color
     * @return the color
     */
    public int getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(int color) {
        this.color = color;
    }
}
