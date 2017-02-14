package co.com.enterpriseal.fixedassets.persistence.model;

import java.math.BigDecimal;

/**
 * Tabla que mapea la tabla ges_per de la base de datos
 * @since 2017-02-10
 * @author AdrianL
 */
public class PersonModel {
	private int id;
    private BigDecimal identification;
    private int documentType;
    private String name;
    private String lastName;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the identification
     */
    public BigDecimal getIdentification() {
        return identification;
    }

    /**
     * @param identification the identification to set
     */
    public void setIdentification(BigDecimal identification) {
        this.identification = identification;
    }

    /**
     * @return the documentType
     */
    public int getDocumentType() {
        return documentType;
    }

    /**
     * @param documentType the documentType to set
     */
    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
