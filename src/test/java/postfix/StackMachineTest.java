package postfix;

import inter.Id;
import lexer.Num;
import lexer.Real;
import lexer.Token;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: denuwanthi
 * Date: 1/22/14
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackMachineTest {
    /*  @Test
    public void testEvaluate() throws Exception {
              StackMachine stackMachine =new StackMachine();
              stackMachine.evaluate("+");
              Assert.assertEquals("Value variable",null,stackMachine.value);



    }*/
    @Test
    public void testEvaluateTwo() throws Exception {
        StackMachine stackMachine =new StackMachine();
        Num numToken1=new Num(1);
        Num numToken2=new Num(2);

        stackMachine.postfixTokenStack.push(numToken1);
        stackMachine.postfixTokenStack.push(numToken2);
        stackMachine.evaluate("+");
        Token tok=stackMachine.postfixTokenStack.pop();
        Assert.assertEquals("Final Result is Num tag", 256, tok.tag);



    }

    @Test
    public void testEvaluateThree() throws Exception {
        StackMachine stackMachine =new StackMachine();
        Id idToken1=new Id(257,"a");
        idToken1.value=1;
        Id idToken2=new Id(257,"b");
        idToken2.value=2;


        stackMachine.postfixTokenStack.push(idToken1);
        stackMachine.postfixTokenStack.push(idToken2);
        stackMachine.evaluate("*");

        Token tok=stackMachine.postfixTokenStack.pop();
        Assert.assertEquals("Final Result is Num tag",256,tok.tag);




    }
    @Test
    public void testEvaluateFour() throws Exception {
        StackMachine stackMachine =new StackMachine();
        Real realToken1=new Real(1.0f);
        Real realToken2=new Real(2.0f);

        stackMachine.postfixTokenStack.push(realToken1);
        stackMachine.postfixTokenStack.push(realToken2);
        stackMachine.evaluate("+");
        Token tok=stackMachine.postfixTokenStack.pop();

        Assert.assertEquals("Final Result is Real tag",259,tok.tag);
        Assert.assertEquals("Final Result of postfix + of 1.0f & 2.0f",3.0f,stackMachine.value);



    }

    @Test
    public void testEvaluateFive() throws Exception {
        StackMachine stackMachine =new StackMachine();
        Num numToken1=new Num(2);
        Real realToken2=new Real(2.0f);

        stackMachine.postfixTokenStack.push(numToken1);
        stackMachine.postfixTokenStack.push(realToken2);
        stackMachine.evaluate("+");
        Token tok=stackMachine.postfixTokenStack.pop();

        Assert.assertEquals("Final Result is Real tag",259,tok.tag);
        Assert.assertEquals("Final Result of postfix + of 1.0f & 2.0f",4.0f,stackMachine.value);



    }

    @Test
    public void testEvaluateSix() throws Exception {
        StackMachine stackMachine =new StackMachine();
        Id idToken1=new Id(257,"a");
        idToken1.value=10;

        stackMachine.postfixTokenStack.push(idToken1);

        stackMachine.evaluate("+");


        Assert.assertEquals("Result Match",10,stackMachine.value);



    }
    @Test
    public void testEvaluateSeven() throws Exception {
        StackMachine stackMachine =new StackMachine();
        Num numToken1=new Num(11);

        stackMachine.postfixTokenStack.push(numToken1);

        stackMachine.evaluate("+");


        Assert.assertEquals("Result Match",11,stackMachine.value);



    }
    @Test
    public void testEvaluateEight() throws Exception {
        StackMachine stackMachine =new StackMachine();
        Real realToken=new Real(13.0f);

        stackMachine.postfixTokenStack.push(realToken);

        stackMachine.evaluate("+");


        Assert.assertEquals("Result Match",13.0f,stackMachine.value);



    }
}
