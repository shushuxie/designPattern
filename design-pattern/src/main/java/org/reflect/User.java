package org.reflect;

import java.util.List;
import java.util.Stack;

public class User extends Person{

   private String name;
   public String age;
   public List<String> stringList;

   private static String privatStaticValue = "20";
   public String publicNormalValue = "30";

   {
      System.out.println("普通代码块");
   }

   static {
      System.out.println("静态代码块");
   }

   public User(String name) {
      this.name = name;
   }

   public static void userMsg() {
      System.out.println("用户对象的信息");
   }

   private static void myPrivateStaticMethod() {
      System.out.println("private static method");
   }

   private void myPirvateNormalMethod() {
      System.out.println("private normal method");
   }

   private static void myPrivateStaticMethod(String content) {
      System.out.println("private static method with param"+content);
   }

   private static void myPrivateStaticMethod2(String content) {
      System.out.println("private static method with param2"+content);
   }








}
