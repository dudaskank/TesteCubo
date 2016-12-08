/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dudaskank.testecubo.modelo;

import com.dudaskank.testecubo.beans.Piloto;
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
public class PilotoTest {
  
  public PilotoTest() {
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
   * Test of hashCode method, of class Piloto.
   */
  @Test
  public void testHashCode() {
    System.out.println("hashCode");
    Piloto instance = new Piloto(1, "Teste Hash");
    int expResult = 29 * 7 + instance.getNumero();
    int result = instance.hashCode();
    assertEquals(expResult, result);
  }

  /**
   * Test of equals method, of class Piloto.
   */
  @Test
  public void testEquals() {
    System.out.println("equals");
    Object obj = new Piloto(1, "P1");
    Piloto instance = new Piloto(2, "P2");
    boolean expResult = false;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);
  }

}
