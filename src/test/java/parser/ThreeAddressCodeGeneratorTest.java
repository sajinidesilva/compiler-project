package parser;

import lexer.Token;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: DELL
 * Date: 1/23/14
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeAddressCodeGeneratorTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testInsertAndGetLeaf() throws Exception {
       ThreeAddressCodeGenerator addrCideGen = new ThreeAddressCodeGenerator();
        Token token =new Token(257);
        token.type = "int";
        token.lexeme = "b";
        Leaf leaf = addrCideGen.insertAndGetLeaf(token);
        assertEquals(leaf.token,token);

    }

    @Test
    public void testInsertAndGetLeaf2() throws Exception {
        ThreeAddressCodeGenerator addrCideGen = new ThreeAddressCodeGenerator();
        Token token =new Token(257);
        token.type = "int";
        token.lexeme = "b";
        Leaf leaf = new Leaf(token);
        AbstractNode.processedSymbols.add(leaf);
        Leaf leaf2 = addrCideGen.insertAndGetLeaf(token);
        assertEquals(leaf2.token,leaf.token);

    }

    @Test
    public void testInsertAndGetLeaf3() throws Exception {
        ThreeAddressCodeGenerator addrCideGen = new ThreeAddressCodeGenerator();
        Token token1 =new Token(259);
        token1.type = "float";
        token1.lexeme = "a";
        Leaf leaf = new Leaf(token1);

        Token token2 =new Token(257);
        token2.type = "int";
        token2.lexeme = "b";
        AbstractNode.processedSymbols.add(leaf);
        Leaf leaf2 = addrCideGen.insertAndGetLeaf(token2);
        assertEquals(leaf2.token,token2);

    }
}
