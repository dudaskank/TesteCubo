/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dudaskank.testecubo;

import com.dudaskank.testecubo.beans.Corrida;
import com.dudaskank.testecubo.textreader.CorridaFileReader;
import java.io.File;
import java.time.Duration;
import java.time.LocalTime;

/**
 *
 * @author Eduardo
 */
public class Testes {
  
  public static void main(String[] args) throws CuboException {
    LocalTime t;
    Duration v;
    t = LocalTime.parse("23:49:08.277");
    v = Duration.ZERO
            .plusMinutes(1)
            .plusSeconds(2)
            .plusMillis(852);
    out(t);
    out(t.minus(v));
    t = LocalTime.parse("23:49:10.858");
    v = Duration.ZERO
            .plusMinutes(1)
            .plusSeconds(4)
            .plusMillis(352);
    out(t);
    out(t.minus(v));
  }
  
  public static void out(Object o) {
    System.out.println(o);
  }
}
