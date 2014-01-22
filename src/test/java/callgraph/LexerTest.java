package callgraph;

import lexer.Lexer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: DELL
 * Date: 1/22/14
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class LexerTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testReserve() throws Exception {

        Lexer lexer = new Lexer();
        assertTrue(lexer.getWords().containsKey("int"));
        assertTrue(lexer.getWords().containsKey("float"));

    }
}
