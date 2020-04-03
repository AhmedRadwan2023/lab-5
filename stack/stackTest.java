package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class stackTest {

	@Test
	void testStack() {
		stack s =new stack();
		 s.push(5);
		 s.push(9);
		 s.push('l');
		 assertEquals(s.pop(),'l');
		 assertEquals(s.peek(),9);
		 assertEquals(s.pop(),9);
		 assertEquals(s.peek(),5);
		 assertEquals(s.pop(),5);

	}
	
	void testApp() {
		App a=new App(); 
		/*    infix to postfix test */
		assertEquals(a.infixToPostfix("2 + 3 * 4"),"2 3 4 * +");
		assertEquals(a.infixToPostfix("(1 + 2) * 7"),"1 2 + 7 *");
		assertEquals(a.infixToPostfix("a * b + 5"),"a b * 5 +");
		assertEquals(a.infixToPostfix("(a / (b - c + d)) * (e - a) * c"),"a b c - d + / e a - * c *");
		assertEquals(a.infixToPostfix("a / b - c + d * e - a * c"),"a b / c - d e * + a c * -");

		
		/* evaluate test */
		assertEquals(a.evaluate("2 + 3 * 4"),14);
		assertEquals(a.evaluate("-2+6*5+12/4"),31);
		assertEquals(a.evaluate("-(53+14/2-9+7-6/3)+5*123-3+8*-9+7+(125/5+6*7-9+21*3)"),612);
		assertEquals(a.evaluate("-12+5*0*95+9--89 +-3*8 * 4"),-10);

		
	}

}
