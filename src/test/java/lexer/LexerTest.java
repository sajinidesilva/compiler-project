package lexer;

import inter.Id;
import org.junit.Test;


import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: sameera
 * Date: 1/20/14
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class LexerTest {


    @Test
    public void testScanFloat() throws IOException {

        String testString="float a;";
        System.setIn(new java.io.ByteArrayInputStream(testString.getBytes()));
        Lexer lex=new Lexer();
        Token testResult=lex.scan();

        assertEquals("float", lex.getCurrentType().lexeme);
    }

    @Test
    public void testScanInt() throws IOException {

        String testString="int";
        System.setIn(new java.io.ByteArrayInputStream(testString.getBytes()));
        Lexer lex=new Lexer();
        Token testResult=lex.scan();

        assertEquals("int", lex.getCurrentType().lexeme);
    }

    @Test
    public void testScanId() throws IOException {

        Id testId = new Id(257,"a");
        Lexer lex=new Lexer();
        lex.getWords().put("a",testId);
        String testString="a";
        System.setIn(new java.io.ByteArrayInputStream(testString.getBytes()));

        Token testResult=lex.scan();

        assertEquals("a", testResult.lexeme);
    }


    @Test
    public void testScanDigitInt() throws IOException {

        Id testId = new Id(257,"a");
        Lexer lex=new Lexer();
        lex.getWords().put("a",testId);
        String testString="a+3*6;";
        System.setIn(new java.io.ByteArrayInputStream(testString.getBytes()));

        Token testResult=lex.scan();

        assertEquals("a", testResult.lexeme);
    }

    @Test
    public void testScanDigitFloat() throws IOException {

        Id testId = new Id(257,"a");
        Lexer lex=new Lexer();
        lex.getWords().put("a",testId);
        String testString="a+3*6.1;";
        System.setIn(new java.io.ByteArrayInputStream(testString.getBytes()));

        Token testResult=lex.scan();

        assertEquals("a", testResult.lexeme);
    }

    @Test(expected = Error.class)
    public void testScanSyntaxError() throws IOException {

        Lexer lex=new Lexer();
        String testString="abc";
        System.setIn(new java.io.ByteArrayInputStream(testString.getBytes()));

        Token testResult=lex.scan();

        assertEquals("a", testResult.lexeme);
    }





}
