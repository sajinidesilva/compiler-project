package callgraph;

import lexer.Lexer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parser.Parser;
import postfix.StackMachine;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: DELL
 * Date: 1/22/14
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class ParserTest {
   private Parser  parser;

    @Before
    public void setUp() throws Exception {




    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testP() throws Exception {

        Lexer lexer=new Lexer();
        StackMachine stackMachine=new StackMachine();
        String s = "float c,d; int b,a;\n" +
                "c=b+a*c;\n" +
                "3*((3+7));\n" +
                "a+3*6;\n" +
                "a=(2+3)*4;\n" +
                "d=2.32+3.24;\n" +
                "b=a+2;" ;
        System.setIn(new ByteArrayInputStream(s.getBytes()));
        parser=new Parser(lexer,stackMachine);
        parser.P();
        assertTrue(parser.matchExecuted);


    }


    @Test
    public void testL1() throws Exception {

        Lexer lexer=new Lexer();
        StackMachine stackMachine=new StackMachine();
        String s = "float c,d; int b,a;\n" +
                "c=b+a*c;\n" +
                "3*((3+7));\n" +
                "a+3*6;\n" +
                "a=(2+3)*4;\n" +
                "d=2.32+3.24;\n" +
                "b=a+2;" ;
        System.setIn(new ByteArrayInputStream(s.getBytes()));
        parser=new Parser(lexer,stackMachine);
        parser.P();
        assertTrue(parser.Lexecuted);


    }

    @Test(expected = Error.class)
    public void testN1() throws Exception {


        Lexer lexer=new Lexer();
        StackMachine stackMachine=new StackMachine();
        String s = "float c,d; int b,a;\n" +
                "c=b+a*c;\n" +
                "3*((3+7));\n" +
                "a+3*6;\n" +
                "a=(2+3)*4;\n" +
                "d=2.32+3.24;\n" +
                "b=a+2" ;
        System.setIn(new ByteArrayInputStream(s.getBytes()));
        parser=new Parser(lexer,stackMachine);
        parser.P();
    }



}
