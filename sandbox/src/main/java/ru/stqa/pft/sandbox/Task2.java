package ru.stqa.pft.sandbox;

public class Task2 {

  public static void main(String[] args){
    Point p1 = new Point(4,5);
    Point p2 = new Point(1,1);
    double d = p1.distance(p2);
    System.out.println("Расстояние между точками (" + p1.x + ";" + p1.y + ") и (" + p2.x + ";" + p2.y +") ранво " + d);
  }

}
