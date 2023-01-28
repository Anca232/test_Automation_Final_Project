package IgnoreThemPracticeTests;

import org.junit.*;

public class JUnitProjectTest {

     @BeforeClass
     public static void beforeTestOfAll(){
          System.out.println("Start");
     }

     @Before
     public void beforeTest(){
          System.out.println("This will run before every test");
     }
     @Test
     public void computeAreaTest(){
          System.out.println("Checking the first test");
          Assert.assertEquals("This is not a drill", 3);
     }

     @Test
     public void computeSquareTest(){
          System.out.println("Checking the second test");
     }
     @After
     public void afterTest(){
          System.out.println("After every test");
     }

     @AfterClass
     public static void afterEveryTest(){
          System.out.println("The End");
     }
}

