package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class AirplaneSeatAssignmentProbabilityTest {
    
  @Test
  fun testNthPersonGetsNthSeat() {
    // Test case 1: Only 1 passenger
    assertEquals(
      1.0,
      nthPersonGetsNthSeat(1),
      0.00001, // Delta for double comparison
      "With only 1 passenger, probability should be 1.0"
    )

    // Test case 2: 2 passengers
    assertEquals(
      0.5,
      nthPersonGetsNthSeat(2),
      0.00001,
      "With 2 passengers, probability should be 0.5"
    )

    // Test case 3: 3 passengers
    assertEquals(
      0.5,
      nthPersonGetsNthSeat(3),
      0.00001,
      "With 3 passengers, probability should be 0.5"
    )

    // Test case 4: 10 passengers
    assertEquals(
      0.5,
      nthPersonGetsNthSeat(10),
      0.00001,
      "With 10 passengers, probability should be 0.5"
    )

    // Test case 5: 100 passengers
    assertEquals(
      0.5,
      nthPersonGetsNthSeat(100),
      0.00001,
      "With 100 passengers, probability should be 0.5"
    )

    // Test case 6: Large number of passengers
    assertEquals(
      0.5,
      nthPersonGetsNthSeat(Int.MAX_VALUE),
      0.00001,
      "With a large number of passengers, probability should be 0.5"
    )
  }
}
