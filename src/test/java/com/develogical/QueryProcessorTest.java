package com.develogical;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void knowsAboutShakespeare() throws Exception {
    assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
  }

  @Test
  public void knowsAddition() throws Exception {
    assertThat(queryProcessor.process("What is 11 plus 22?"), is("33"));
  }

  @Test
  public void knowsMultiplication() throws Exception {
    assertThat(queryProcessor.process("What is 2 multiplied by 3?"), is("6"));
  }

  @Test
  public void knowsMaximum() throws Exception {
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 7, 96, 73?"), is("96"));
  }

}

