package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

  @Test
  public void testDistance1() {
    Point A = new Point(0,-2.3);
    Point B = new Point(1,-2.3);
    Assert.assertEquals(A.distance(B),1.0);
  }

  @Test
  public void testDistance2() {
    Point A = new Point(1,3.5);
    Point B = new Point(1,0);
    Assert.assertEquals(A.distance(B),3.5);
  }

  @Test
  public void testDistance3() {
    Point A = new Point(-1,2);
    Point B = new Point(4,0);
    Assert.assertEquals(A.distance(B),5.0);
  }

  @Test
  public void testDistance4() {
    Point A = new Point(2.2,3);
    Point B = new Point(2.2,3);
    Assert.assertEquals(A.distance(B),0.0);
  }

}
