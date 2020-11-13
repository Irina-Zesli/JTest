package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {
  @Test
  public void testMyIp(){
    String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("77.108.219.154");
    System.out.println(geoIP);
    assertEquals(geoIP,"<GeoIP><Country>RU</Country><State>57</State></GeoIP>");
  }
}
