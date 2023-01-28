package com.finalProjectTest;

public class TestProject {

     static int y = 0;
     public static void main(String[] args) {
          System.out.println("Hello");
          int x = 1;
          String name = "Anca";
          System.out.println("My name is " + name);
//          System.out.println(args[0] + args[1]);
//          System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
          for(int i=0; i< args.length; i++ ){
               System.out.println(args[i]);
          }


     }
}
