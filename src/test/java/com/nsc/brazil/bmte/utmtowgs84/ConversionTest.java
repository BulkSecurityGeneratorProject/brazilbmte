package com.nsc.brazil.bmte.utmtowgs84;

import org.junit.Test;


public class ConversionTest {


    @Test
    public void testWGS84() {
        double x = 423803.26;
        double y = 9656998.3;
        WGS84 fromUTM = WGS84.fromUTM(22,'M',x,y);

        System.out.println( "Latitude = " + fromUTM.getLatitude() + ", longitude = " + fromUTM.getLongitude() );

    }
}
