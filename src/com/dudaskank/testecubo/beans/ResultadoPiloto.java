/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dudaskank.testecubo.beans;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Eduardo
 */
public class ResultadoPiloto {

  private final int posicao;
  private final Piloto piloto;
  private final Duration tempoTotal;
  private final BigDecimal velocidadeMedia;
  private final Duration melhorVolta;
  private final int numeroVoltas;
  private final String atrasDoLider;

  public ResultadoPiloto(int posicao, Piloto piloto, Duration tempoTotal, BigDecimal velocidadeMedia, Duration melhorVolta, int numeroVoltas, String atrasDoLider) {
    if (piloto == null || tempoTotal == null || velocidadeMedia == null || melhorVolta == null || atrasDoLider == null) {
      throw new IllegalArgumentException("Argumento não pode ser nulo");
    }
    if (posicao < 1) {
      throw new IllegalArgumentException("Argumento posição inválida");
    }
    if (numeroVoltas < 1 || numeroVoltas > 4) {
      throw new IllegalArgumentException("Argumento número de voltas inválido");
    }

    this.posicao = posicao;
    this.piloto = piloto;
    this.tempoTotal = tempoTotal;
    this.velocidadeMedia = velocidadeMedia;
    this.melhorVolta = melhorVolta;
    this.numeroVoltas = numeroVoltas;
    this.atrasDoLider = atrasDoLider;
  }

  @Override
  public String toString() {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    PrintStream s = new PrintStream(bos);
    s.printf("%2d | %2d - %-15s | %-9s | %6s | %12s | %6d | %14s", posicao, piloto.getNumero(), piloto.getNome(),
            DateTimeFormatter.ofPattern("m:ss.SSS").format(LocalTime.MIDNIGHT.plus(tempoTotal)),
            NumberFormat.getInstance().format(velocidadeMedia),
            DateTimeFormatter.ofPattern("m:ss.SSS").format(LocalTime.MIDNIGHT.plus(melhorVolta)),
            numeroVoltas, atrasDoLider);
    return bos.toString();
  }
}
