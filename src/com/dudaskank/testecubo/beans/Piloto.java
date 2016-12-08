/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dudaskank.testecubo.beans;

/**
 *
 * @author Eduardo
 */
public class Piloto {

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 29 * hash + this.numero;
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
    final Piloto other = (Piloto) obj;
    return this.numero == other.numero;
  }

  private final int numero;
  private final String nome;

  public Piloto(int numero, String nome) {
    if (numero < 1) {
      throw new IllegalArgumentException("Número inválido");
    }
    if (nome == null) {
      throw new IllegalArgumentException("Nome não pode ser nulo");
    }
    this.numero = numero;
    this.nome = nome;
  }

  /**
   * @return the numero
   */
  public int getNumero() {
    return numero;
  }

  /**
   * @return the nome
   */
  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return "" + numero + "-" + nome + "";
  }

}
