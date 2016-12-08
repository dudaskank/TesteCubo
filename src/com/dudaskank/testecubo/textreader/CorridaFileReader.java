/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dudaskank.testecubo.textreader;

import com.dudaskank.testecubo.CuboException;
import com.dudaskank.testecubo.beans.Corrida;
import com.dudaskank.testecubo.beans.Piloto;
import com.dudaskank.testecubo.beans.Volta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Eduardo
 */
public class CorridaFileReader {

  public Corrida parseFile(File file) throws CuboException {
    if (file == null) {
      throw new IllegalArgumentException("File pode ser nulo");
    }
    Corrida corrida = new Corrida();
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      int lineNumber = 0;
      String line;
      while ((line = buffer.readLine()) != null) {
        lineNumber++;
        if (lineNumber == 1) {
          // ignora linha inicial
          continue;
        }
        Volta volta = parseLine(line);
        corrida.addVolta(volta);
      }
    } catch(Exception e) {
      throw new CuboException(e);
    }

    return corrida;
  }

  private Volta parseLine(String line) throws CuboException  {
    Volta volta;
    Piloto piloto;

    // tem o '-' do teclado e um outro com código diferente ali no pattern sendo ignorados
    Pattern reg = Pattern.compile("[^\\s–-]+");
    Matcher m = reg.matcher(line);
    List<String> split = new ArrayList<>();
    while (m.find()) {
      split.add(m.group());
    }
    // checa tamanho esperado e vai pegando os campos necessários
    if (split.size() != 6) {
      throw new CuboException("Erro no formato da linha ( " + split.size() + "): " + split.toString());
    }
    LocalTime hora = LocalTime.parse(split.get(0));
    int pilotoNumero = Integer.parseInt(split.get(1));
    String pilotoNome = split.get(2);
    piloto = new Piloto(pilotoNumero, pilotoNome);
    int numeroVolta = Integer.parseInt(split.get(3));

    DateTimeFormatter voltaFormatter = new DateTimeFormatterBuilder()
            .appendPattern("m:ss")
            .appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true)
            .toFormatter();
    TemporalAccessor t = voltaFormatter.parse(split.get(4));
    Duration tempoVolta = Duration.ZERO
            .plusMinutes(t.getLong(ChronoField.MINUTE_OF_HOUR))
            .plusSeconds(t.getLong(ChronoField.SECOND_OF_MINUTE))
            .plusNanos(t.getLong(ChronoField.NANO_OF_SECOND));
    BigDecimal velocidadeMedia = new BigDecimal(split.get(5).replace(',', '.'));

    volta = new Volta(hora, piloto, numeroVolta, tempoVolta, velocidadeMedia);

    return volta;
  }
}
