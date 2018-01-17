package com.mewlang;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gg_shily on 1/17/18.
 */
public class Mew {
    private ArrayList<Integer> stack = new ArrayList<>();
    private int current;

    public Mew() {
        stack.add(0);
    }

    public void execute(String code) throws IOException {
        for (int i = 0; i < code.length(); i++) {
            switch (code.charAt(i)) {
                case '>':
                    current++;
                    if (current == stack.size())
                        stack.add(0);
                    break;
                case '<':
                    current--;
                    break;
                case '+':
                    stack.set(current, stack.get(current) + 1);
                    break;
                case '-':
                    stack.set(current, stack.get(current) - 1);
                    break;
                case '.':
                    System.out.print((char)stack.get(current).intValue());
                    break;
                case ',':
                    stack.set(current, System.in.read());
                    break;
                case '[':
                    if (stack.get(current) == 0) {
                        int innerCount = 0;
                        while (++i < code.length()) {
                            if (code.charAt(i) == ']')
                                if (innerCount == 0)
                                    break;
                                else
                                    innerCount--;
                            if (code.charAt(i) == '[')
                                innerCount++;
                        }
                    }
                    break;
                case ']':
                    if (stack.get(current) != 0) {
                        int innerCount = 0;
                        while (--i >= 0) {
                            if (code.charAt(i) == '[')
                                if (innerCount == 0)
                                    break;
                                else
                                    innerCount--;
                            if (code.charAt(i) == ']')
                                innerCount++;
                        }
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        if (args.length > 0)
            new Mew().execute(args[0]);
    }
}
