package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    Hello("world");
    Hello("user");
    Hello("Alexei");
    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
    Rectangle r = new Rectangle(4,6);
    System.out.println("Площадь прямоуг. со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

  public static void Hello(String somebody){
    System.out.println("Hello," + somebody + "!");
  }

}