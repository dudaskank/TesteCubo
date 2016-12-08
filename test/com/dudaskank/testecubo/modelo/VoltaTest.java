/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dudaskank.testecubo.modelo;

import com.dudaskank.testecubo.beans.Piloto;
import com.dudaskank.testecubo.beans.Volta;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduardo
 */
public class VoltaTest {
  
  public VoltaTest() {
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
   * Test of getHora method, of class Volta.
   */
  @Test
  public void testGetHora() {
    System.out.println("getHora");
    Volta instance = null;
    LocalTime expResult = null;
    LocalTime result = instance.getHora();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getPiloto method, of class Volta.
   */
  @Test
  public void testGetPiloto() {
    System.out.println("getPiloto");
    Volta instance = null;
    Piloto expResult = null;
    Piloto result = instance.getPiloto();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getVolta method, of class Volta.
   */
  @Test
  public void testGetVolta() {
    System.out.println("getVolta");
    Volta instance = null;
    int expResult = 0;
    int result = instance.getVolta();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getTempo method, of class Volta.
   */
  @Test
  public void testGetTempo() {
    System.out.println("getTempo");
    Volta instance = null;
    Duration expResult = null;
    Duration result = instance.getTempo();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getVelocidadeMedia method, of class Volta.
   */
  @Test
  public void testGetVelocidadeMedia() {
    System.out.println("getVelocidadeMedia");
    Volta instance = null;
    BigDecimal expResult = null;
    BigDecimal result = instance.getVelocidadeMedia();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of hashCode method, of class Volta.
   */
  @Test
  public void testHashCode() {
    System.out.println("hashCode");
    Volta instance = null;
    int expResult = 0;
    int result = instance.hashCode();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of equals method, of class Volta.
   */
  @Test
  public void testEquals() {
    System.out.println("equals");
    Object obj = null;
    Volta instance = null;
    boolean expResult = false;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of compareTo method, of class Volta.
   */
  @Test
  public void testCompareTo() {
    System.out.println("compareTo");
    Volta o = null;
    Volta instance = null;
    int expResult = 0;
    int result = instance.compareTo(o);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of toString method, of class Volta.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    Volta instance = null;
    String expResult = "";
    String result = instance.toString();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
