/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dudaskank.testecubo.beans;

import com.dudaskank.testecubo.CuboException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Eduardo
 */
public class Corrida {

  private final int maxVoltas = 4;

  /**
   * lista com as voltas da corrida
   */
  protected final List<Volta> voltas;

  public Corrida() {
    voltas = new ArrayList<>();
  }

  public void addVolta(Volta volta) {
    voltas.add(volta);
  }

  public ResultadoCorrida processarCorrida() throws CuboException {
    // LinkedHashMap pois preciso manter a ordem de inserção no mapa
    Map<Piloto, List<Volta>> voltasDoPiloto = new LinkedHashMap<>();
    List<ResultadoPiloto> resultados = new ArrayList<>();
    Duration duracao;
    Duration melhorVolta = null;

    // ordena pelo tempo, para pegar a duração da corrida
    Collections.sort(voltas, new Volta.OrdemCronologica());
    // se eu entendi direito, a hora indica o tempo que a volta foi tomada, então para pegar o início da volta soma o tempo de volta
    LocalTime primeira = voltas.get(0).getHora();
    LocalTime ultima = voltas.get(voltas.size() - 1).getHora();
    long duracaoNano = primeira.until(ultima, ChronoUnit.NANOS);
    duracao = Duration.of(duracaoNano, ChronoUnit.NANOS).plus(voltas.get(0).getTempo());
    
    Collections.sort(voltas, new Volta.OrdemChegada());
    // separa as voltas por cada piloto
    for (Volta volta : voltas) {
      // adiciona a volta para a lista do piloto
      Piloto p = volta.getPiloto();
      if (!voltasDoPiloto.containsKey(p)) {
        voltasDoPiloto.put(p, new ArrayList<>());
      }
      List<Volta> v = voltasDoPiloto.get(p);
      v.add(volta);
      // já verifica a melhor volta
      if (melhorVolta == null || volta.getTempo().compareTo(melhorVolta) < 0) {
        melhorVolta = volta.getTempo();
      }
    }
    
    // depois de ordenado e separado na ordem de chegada, vamos pegar as informações individuais
    int posicao = 1;
    boolean acabouCorrida = false;
    LocalTime quandoAcabou = null;
    for (Map.Entry<Piloto, List<Volta>> entry : voltasDoPiloto.entrySet()) {
      Piloto piloto = entry.getKey();
      List<Volta> voltasPiloto = entry.getValue();
      String atrasDoLider;
      Duration melhorVoltaPiloto = null;
      Duration tempoTotal = Duration.ZERO;
      BigDecimal velocidade = BigDecimal.ZERO;
      // total de voltas dadas
      int totalVoltas = voltasPiloto.size();
      Volta ultimaVoltaPiloto = voltasPiloto.get(totalVoltas - 1);
      
      // o primeiro a chegar no final, guarda o momento que ele passou
      if (!acabouCorrida && totalVoltas == maxVoltas) {
        acabouCorrida = true;
        quandoAcabou = ultimaVoltaPiloto.getHora();
      }
      
      for (Volta volta : voltasPiloto) {
        Duration tempoVolta = volta.getTempo();
        // verifica se é a melhor volta do piloto
        if (melhorVoltaPiloto == null || volta.getTempo().compareTo(melhorVoltaPiloto) < 0) {
          melhorVoltaPiloto = tempoVolta;
        }
        // somando tempos e velocidades
        tempoTotal = tempoTotal.plus(tempoVolta);
        velocidade = velocidade.add(volta.getVelocidadeMedia());
      }
      // cálculo da velocidade média
      velocidade = velocidade.divide(BigDecimal.valueOf(totalVoltas), RoundingMode.HALF_UP);
      // calcuma tempo atrás do lider
      if (totalVoltas != maxVoltas) {
        atrasDoLider = "+" + (maxVoltas - totalVoltas) + " volta(s)";
      } else {
        LocalTime atras = LocalTime.MIDNIGHT.plusNanos(quandoAcabou.until(ultimaVoltaPiloto.getHora(), ChronoUnit.NANOS));
        atrasDoLider = DateTimeFormatter.ofPattern("+m:ss.SSS").format(atras);
      }
      LocalTime chegou = voltasPiloto.get(voltasPiloto.size() - 1).getHora();
      // observe que incrementa a posição para o próximo piloto
      resultados.add(new ResultadoPiloto(posicao++, piloto, tempoTotal, velocidade, melhorVoltaPiloto, totalVoltas, atrasDoLider));
    }
    
    if (!acabouCorrida) {
      throw new CuboException("Ninguém acabou a corrida, não é possível processar");
    }
    ResultadoCorrida resultado = new ResultadoCorrida(duracao, melhorVolta, resultados);
    return resultado;

  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Corrida{maxVoltas=")
            .append(maxVoltas)
            .append(", voltas=[")
            .append(System.lineSeparator());
    for (Volta volta : voltas) {
      s.append(volta).append(System.lineSeparator());
    }
    s.append("]}");
    return s.toString();
  }

}
