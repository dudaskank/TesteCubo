/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dudaskank.testecubo.beans;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class ResultadoCorrida {

  private final Duration duracao;
  private final Duration melhorVolta;
  private final List<ResultadoPiloto> resultados;

  /**
   *
   * @param duracao
   * @param melhorVolta
   * @param resultados
   */
  protected ResultadoCorrida(Duration duracao, Duration melhorVolta, List<ResultadoPiloto> resultados) {
    if (duracao == null || melhorVolta == null || resultados == null) {
      throw new IllegalArgumentException("Argumento não pode ser nulo");
    }
    this.duracao = duracao;
    this.melhorVolta = melhorVolta;
    this.resultados = resultados;
  }

  public Duration getDuracao() {
    return duracao;
  }

  public List<ResultadoPiloto> getResultados() {
    return Collections.unmodifiableList(resultados);
  }

  public void render() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    PrintStream s = new PrintStream(bos);
    s.printf("********************%n");
    s.println(" Resultado Corrida ");
    s.printf("********************%n");
    s.printf("Duração total: %s%n", DateTimeFormatter.ISO_LOCAL_TIME.format(LocalTime.MIDNIGHT.plus(duracao)));
    s.printf("Melhor volta: %s%n", DateTimeFormatter.ofPattern("m:ss.SSS").format(LocalTime.MIDNIGHT.plus(melhorVolta)));
    s.printf("********************%n");
    s.println("---+----------------------+-----------+--------+--------------+--------+----------------");
    s.printf("%2s | %-20s | %-9s | %-6s | %-12s | %-6s | %-11s%n", "#", "Piloto", "Tempo", "Média", "Melhor Volta", "Voltas", "Atrás do líder");
    s.println("---+----------------------+-----------+--------+--------------+--------+----------------");
    //s.println("P. | Piloto | Tempo | Média | Melhor volta | Voltas | Atrás Líder");
    for (ResultadoPiloto resultado : resultados) {
      s.println(resultado);
    }
    s.println("---+----------------------+-----------+--------+--------------+--------+----------------");
    return bos.toString();
  }

}
