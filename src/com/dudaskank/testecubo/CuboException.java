/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dudaskank.testecubo;

/**
 *
 * @author Eduardo
 */
public class CuboException extends Exception {

  public CuboException(String message) {
    super(message);
  }

  public CuboException(Exception exception) {
    super(exception);
  }
  
}
