/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dudaskank.testecubo;

import com.dudaskank.testecubo.beans.Corrida;
import com.dudaskank.testecubo.beans.ResultadoCorrida;
import com.dudaskank.testecubo.textreader.CorridaFileReader;
import java.io.File;

/**
 *
 * @author Eduardo
 */
public class TesteCubo {

  /**
   * @param args the command line arguments
   * @throws com.dudaskank.testecubo.CuboException
   */
  public static void main(String[] args) throws CuboException {
    String arquivo;
    if (args.length == 1) {
      arquivo = args[0];
    } else {
      arquivo = "corrida.txt";
    }
    File file = new File(arquivo);
    CorridaFileReader reader = new CorridaFileReader();
    Corrida corrida = reader.parseFile(file);
    ResultadoCorrida resultado = corrida.processarCorrida();
    resultado.render();
  }

}
