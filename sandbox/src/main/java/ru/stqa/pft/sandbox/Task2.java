package ru.stqa.pft.sandbox;

public class Task2 {

  public static void main(String[] args){
    Point p1 = new Point(4,5);
    Point p2 = new Point(1,1);
    double d = distance(p1,p2);
    System.out.println("Расстояние между точками (" + p1.x + ";" + p1.y + ") и (" + p2.x + ";" + p2.y +") ранво " + d);

  }

  public static double distance(Point p1, Point p2){
    return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
  }
}
