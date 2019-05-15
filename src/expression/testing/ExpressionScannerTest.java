/*
 * Copyright (c) 2019. ITMO Homework by Ian Dolzhansky
 */

package expression.testing;

import expression.exceptions.ParserException;
import expression.ops.IntegerOps;
import expression.parser.ExpressionScanner;
import expression.parser.Token;

import java.util.Scanner;

public class ExpressionScannerTest {
    public static void main(String[] args) throws ParserException {
        Scanner in = new Scanner(System.in);
        ExpressionScanner<Integer> scanner = new ExpressionScanner<>(in.nextLine(), new IntegerOps());
        while (true) {
            scanner.nextToken();
            if (scanner.getToken() == Token.END) {
                break;
            }
            System.out.println(scanner.getToken());
        }
    }
}
