/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.enterpriseal.servicehost.service;

import co.com.enterpriseal.commons.model.AreaModel;
import co.com.enterpriseal.commons.model.FixedAssetsModel;
import co.com.enterpriseal.commons.model.PersonModel;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author aye
 */
public class ManagementServiceTest {
    
    public ManagementServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listArea method, of class ManagementService.
     */
    @Test
    public void testListArea() {
        System.out.println("listArea");
        ManagementService instance = new ManagementService();
        ResponseEntity expResult = new ResponseEntity(HttpStatus.OK);
        ResponseEntity result = instance.listArea();
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }

    /**
     * Test of insertArea method, of class ManagementService.
     */
    @Test
    public void testInsertArea() {
        System.out.println("insertArea");
        
        // Create objeto areaModel
        AreaModel pAreaModel = new AreaModel();
        pAreaModel.setName("TEST AREA");
        pAreaModel.setDescription("TEST DESCRIPCION AREA");
        // Tener en cuenta las paremtrizadas en el sistema
        pAreaModel.setCity(1);
        
        ManagementService instance = new ManagementService();
        ResponseEntity expResult = new ResponseEntity(HttpStatus.OK);
        ResponseEntity result = instance.insertArea(pAreaModel);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }

    /**
     * Test of listPerson method, of class ManagementService.
     */
    @Test
    public void testListPerson() {
        System.out.println("listPerson");
        ManagementService instance = new ManagementService();
        ResponseEntity expResult = new ResponseEntity(HttpStatus.OK);
        ResponseEntity result = instance.listPerson();
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }
    
    /**
     * Test of insertFixedAssets method, of class ManagementService.
     */
    @Test
    public void testInsertFixedAssets() {
        System.out.println("insertFixedAssets");
        int minimum = 1;
        int maximum = 200000000;
        int resp = minimum + (int)(Math.random() * maximum);
        FixedAssetsModel pFixedAssetsModel = new FixedAssetsModel();
        pFixedAssetsModel.setInventoryNumber(1);
        pFixedAssetsModel.setSerial("SN987654" + resp);
        pFixedAssetsModel.setName("TEST NOMBRE");
        pFixedAssetsModel.setDescription("TEST DESCRIPCION");
        pFixedAssetsModel.setWeight(new BigDecimal("50"));
        pFixedAssetsModel.setHigh(new BigDecimal("20"));
        pFixedAssetsModel.setWidth(new BigDecimal("100"));
        pFixedAssetsModel.setValue(new BigDecimal("1000000"));
        pFixedAssetsModel.setLength(new BigDecimal("30"));
        pFixedAssetsModel.setDateBuy(java.sql.Date.valueOf("2017-02-12"));
        pFixedAssetsModel.setActiveType(4);
        pFixedAssetsModel.setState(4);
        pFixedAssetsModel.setColor(5);
        ManagementService instance = new ManagementService();
        ResponseEntity expResult = new ResponseEntity(HttpStatus.OK);
        ResponseEntity result = instance.insertFixedAssets(pFixedAssetsModel);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }

    /**
     * Test of updateFixedAssets method, of class ManagementService.
     */
    @Test
    public void testUpdateFixedAssets() {
        System.out.println("updateFixedAssets");
        FixedAssetsModel pFixedAssetsModel = new FixedAssetsModel();
        pFixedAssetsModel.setInventoryNumber(1);
        pFixedAssetsModel.setSerial("SN201702121007");
        pFixedAssetsModel.setDischargeDate(java.sql.Date.valueOf("2017-10-01"));
        ManagementService instance = new ManagementService();
        ResponseEntity expResult = new ResponseEntity(HttpStatus.OK);
        ResponseEntity result = instance.updateFixedAssets(pFixedAssetsModel);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }

    /**
     * Test of listFixedAssets method, of class ManagementService.
     */
    @Test
    public void testListFixedAssets() {
        System.out.println("listFixedAssets");
        ManagementService instance = new ManagementService();
        ResponseEntity result = instance.listFixedAssets();
        assertEquals(new ResponseEntity<>(HttpStatus.OK).getStatusCode(), result.getStatusCode());
    }

    /**
     * Test of listFixedAssetsByType method, of class ManagementService.
     */
    @Test
    public void testListFixedAssetsByType() {
        System.out.println("listFixedAssetsByType");
        ResponseEntity expResult = new ResponseEntity(HttpStatus.OK);
        ManagementService instance = new ManagementService();
        ResponseEntity result = instance.listFixedAssetsByType(4);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }

    /**
     * Test of listFixedAssetsByDateBuy method, of class ManagementService.
     */
    @Test
    public void testListFixedAssetsByDateBuy() {
        System.out.println("listFixedAssetsByDateBuy");
        ResponseEntity expResult = new ResponseEntity(HttpStatus.OK);
        ManagementService instance = new ManagementService();
        ResponseEntity result = instance.listFixedAssetsByDateBuy("2017-02-12");
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }

    /**
     * Test of listFixedAssetsBySerial method, of class ManagementService.
     */
    @Test
    public void testListFixedAssetsBySerial() {
        System.out.println("listFixedAssetsBySerial");
        ResponseEntity expResult = new ResponseEntity(HttpStatus.OK);
        ManagementService instance = new ManagementService();
        ResponseEntity result = instance.listFixedAssetsBySerial("SN201702121007");
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }
}
