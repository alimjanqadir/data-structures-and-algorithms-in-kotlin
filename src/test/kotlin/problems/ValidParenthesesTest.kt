package problems

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidParenthesesTest {
    
  @Test
  fun testIsValid() {
    // Test case 1: Simple valid cases
    assertTrue(isValid("()"))
    assertTrue(isValid("[]"))
    assertTrue(isValid("{}"))
        
    // Test case 2: Nested valid cases
    assertTrue(isValid("({[]})"))
    assertTrue(isValid("([{}])"))
    assertTrue(isValid("{[()]}"))
        
    // Test case 3: Sequential valid cases
    assertTrue(isValid("()[]{}"))
    assertTrue(isValid("({})[]"))
        
    // Test case 4: Simple invalid cases
    assertFalse(isValid("("))
    assertFalse(isValid(")"))
    assertFalse(isValid("([)]"))
    assertFalse(isValid("{[}]"))
        
    // Test case 5: Empty string (valid)
    assertTrue(isValid(""))
        
    // Test case 6: Odd length strings (invalid)
    assertFalse(isValid("((("))
    assertFalse(isValid("())"))
        
    // Test case 7: Complex valid cases
    assertTrue(isValid("((({{{[[[]]]}}})))"))
        
    // Test case 8: Complex invalid cases
    assertFalse(isValid("((({{{[[[]]}}})))"))
    assertFalse(isValid("([)]{}"))
  }
    
  @Test
  fun testIsValidFunctional() {
    // Test case 1: Simple valid cases
    assertTrue(isValidFunctional("()"))
    assertTrue(isValidFunctional("[]"))
    assertTrue(isValidFunctional("{}"))
        
    // Test case 2: Nested valid cases
    assertTrue(isValidFunctional("({[]})"))
    assertTrue(isValidFunctional("([{}])"))
    assertTrue(isValidFunctional("{[()]}"))
        
    // Test case 3: Sequential valid cases
    assertTrue(isValidFunctional("()[]{}"))
    assertTrue(isValidFunctional("({})[]"))
        
    // Test case 4: Simple invalid cases
    assertFalse(isValidFunctional("("))
    assertFalse(isValidFunctional(")"))
    assertFalse(isValidFunctional("([)]"))
    assertFalse(isValidFunctional("{[}]"))
        
    // Test case 5: Empty string (valid)
    assertTrue(isValidFunctional(""))
        
    // Test case 6: Odd length strings (invalid)
    assertFalse(isValidFunctional("((("))
    assertFalse(isValidFunctional("())"))
        
    // Test case 7: Complex valid cases
    assertTrue(isValidFunctional("((({{{[[[]]]}}})))"))
        
    // Test case 8: Complex invalid cases
    assertFalse(isValidFunctional("((({{{[[[]]}}})))"))
    assertFalse(isValidFunctional("([)]{}"))
  }
}
