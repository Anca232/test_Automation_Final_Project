package IgnoreThemPracticeTests;

import org.testng.annotations.Test;

@Test
public class TestNGProjectTest {

     @Test(description = "This is my first test", groups = "Regression")
     public void test1(){
          System.out.println("I am test 1");
     }

     @Test(groups = "Smoke")
     public void testLogin(){
          System.out.println("I am test login");
     }

     private void test2(){
          System.out.println("Test 2");
     }
}
