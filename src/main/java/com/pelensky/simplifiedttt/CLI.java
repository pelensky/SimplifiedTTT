package com.pelensky.simplifiedttt;

import java.io.PrintStream;
import java.util.Scanner;

class CLI {

    private Scanner in;
    private PrintStream out;

    CLI(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }


    int getNumber() {
        return in.nextInt();
    }
}
