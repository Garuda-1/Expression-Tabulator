/*
 * Copyright (c) 2019. ITMO Homework by Ian Dolzhansky
 */

package expression.testing;

import expression.TripleExpression;
import expression.ops.BigIntegerOps;
import expression.ops.ByteOps;
import expression.ops.DoubleOps;
import expression.ops.IntegerOps;
import expression.parser.ExpressionParser;

import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;

public class LocalParserTest {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Locale.setDefault(Locale.UK);

        switch (args[0].charAt(0)) {
            case 'i': {
                TripleExpression<Integer> result;
                result = new ExpressionParser<>(new IntegerOps()).parse(in.nextLine());
                System.out.println("parsed");
                while (true) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    int z = in.nextInt();
                    try {
                        System.out.println(result.evaluate(x, y, z));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                }
                break;
            }
            case 'd': {
                TripleExpression<Byte>result;
                result = new ExpressionParser<>(new ByteOps()).parse(in.nextLine());
                System.out.println("parsed");
                while (true) {
                    byte x = in.nextByte();
                    byte y = in.nextByte();
                    byte z = in.nextByte();
                    try {
                        System.out.println(result.evaluate(x, y, z));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                }
                break;
            }
            case 'b': {
                TripleExpression<BigInteger> result;
                result = new ExpressionParser<>(new BigIntegerOps()).parse(in.nextLine());
                System.out.println("parsed");
                while (true) {
                    BigInteger x = in.nextBigInteger();
                    BigInteger y = in.nextBigInteger();
                    BigInteger z = in.nextBigInteger();
                    try {
                        System.out.println(result.evaluate(x, y, z));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                }
                break;
            }
        }

    }
}