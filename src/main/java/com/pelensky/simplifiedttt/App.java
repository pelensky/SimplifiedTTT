package com.pelensky.simplifiedttt;

import java.io.PrintStream;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    CLI cli = new CLI(new Scanner(System.in), new PrintStream(System.out));
    cli.run();
  }
}
