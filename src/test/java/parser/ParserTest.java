package parser;

import inter.Id;
import lexer.Lexer;
import lexer.Num;
import lexer.Real;
import lexer.Token;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import postfix.StackMachine;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Chaamini Mangaleswaran
 * Date: 1/22/14
 * Time: 8:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class ParserTest {

    @Test
    public void testF() throws Exception {
        Lexer lex = new Lexer();
        StackMachine stama = new StackMachine();

        String s="float a;\t";
        System.setIn(new ByteArrayInputStream(s.getBytes()));
        Parser p1 = new Parser(lex,stama) ;
        AbstractNode testresult;
        p1.setLook(new Num(4));
        testresult = p1.F();

        assertTrue("Test Success",testresult.type=="int");

    }

    @Test
    public void testF1() throws Exception {
        Lexer lex = new Lexer();
        StackMachine stama = new StackMachine();

        String s="float a;\t";
        System.setIn(new ByteArrayInputStream(s.getBytes()));
        Parser p1 = new Parser(lex,stama) ;
        AbstractNode testresult;
        p1.setLook(new Real(11.5f));
        testresult = p1.F();

        assertTrue("Test Success",testresult.type=="float");
    }

    @Test
    public void testF2() throws Exception {
        Lexer lex = new Lexer();
        StackMachine stama = new StackMachine();

        String s="float a;\t";
        System.setIn(new ByteArrayInputStream(s.getBytes()));
        Parser p1 = new Parser(lex,stama) ;
        AbstractNode testresult;
        p1.setLook(new Id(257 ,"a"));
        testresult = p1.F();

        assertTrue("Test Failure",testresult.type==null);
    }

}


