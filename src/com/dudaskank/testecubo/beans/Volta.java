/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dudaskank.testecubo.beans;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Eduardo
 */
public class Volta implements Comparable<Volta> {

  private final LocalTime hora; // hora em que a volta foi completada, em ms
  private final Piloto piloto; // piloto que realizou a volta
  private final int volta; // número da volta
  private final Duration tempo; // tempo da volta, em ms
  private final BigDecimal velocidadeMedia;

  public Volta(LocalTime hora, Piloto piloto, int volta, Duration tempo, BigDecimal velocidadeMedia) {
    this.hora = hora;
    this.piloto = piloto;
    this.volta = volta;
    this.tempo = tempo;
    this.velocidadeMedia = velocidadeMedia;
  }

  public LocalTime getHora() {
    return hora;
  }

  public Piloto getPiloto() {
    return piloto;
  }

  public int getVolta() {
    return volta;
  }

  public Duration getTempo() {
    return tempo;
  }

  public BigDecimal getVelocidadeMedia() {
    return velocidadeMedia;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 37 * hash + Objects.hashCode(this.hora);
    hash = 37 * hash + Objects.hashCode(this.piloto);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Volta other = (Volta) obj;
    if (!Objects.equals(this.hora, other.hora)) {
      return false;
    }
    return Objects.equals(this.piloto, other.piloto);
  }

  // ordena a volta pela última com menor tempo de conclusão, ou seja, ordem de chegada
  @Override
  public int compareTo(Volta o) {
    return new OrdemChegada().compare(this, o);
  }

  @Override
  public String toString() {
    return "Volta{" + "hora=" + hora + ", piloto=" + piloto + ", volta=" + volta + ", tempo=" + tempo + ", velocidadeMedia=" + velocidadeMedia + '}';
  }

  protected static class OrdemChegada implements Comparator<Volta> {
    // ordena a volta pela última com menor tempo de conclusão, ou seja, ordem de chegada
    @Override
    public int compare(Volta o1, Volta o2) {
      int compare = o2.volta - o1.volta;
      if (compare == 0) {
        compare = o1.hora.compareTo(o2.hora);
      }
      return compare;
    }
  }
  
  protected static class OrdemCronologica implements Comparator<Volta> {

    @Override
    public int compare(Volta o1, Volta o2) {
      int compare = o1.hora.compareTo(o2.hora);
      if (compare == 0) {
        compare = o1.volta - o2.volta;
      }
      return compare;
    }
  }

}
