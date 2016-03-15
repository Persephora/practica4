import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by linux on 14/03/16.
 */


public class BenderTest {
    @Test
    public void test01() {
        String mapa = "" +
                "#######\n" +
                "# X   #\n" +
                "#     #\n" +
                "#     #\n" +
                "#     #\n" +
                "# $   #\n" +
                "#     #\n" +
                "#######";
        Bender bender = new Bender(mapa);
        assertEquals("SSSS", bender.run());
    }

    @Test
    public void test02() {
        String mapa = "" +
                "#######\n" +
                "# X   #\n" +
                "#     #\n" +
                "#     #\n" +
                "#     #\n" +
                "#     #\n" +
                "#   $ #\n" +
                "#######";
        Bender bender = new Bender(mapa);
        assertEquals("SSSSSEE", bender.run());
    }

    @Test
    public void test03() {
        String mapa = "" +
                "#######\n" +
                "#     #\n" +
                "#     #\n" +
                "#    $#\n" +
                "#     #\n" +
                "# X   #\n" +
                "#     #\n" +
                "#######";
        Bender bender = new Bender(mapa);
        assertEquals("SEEENNN", bender.run());
    }

    @Test
    public void test04() {
        String mapa = "" +
                "#######\n" +
                "#    $#\n" +
                "#     #\n" +
                "#     #\n" +
                "#     #\n" +
                "#  X  #\n" +
                "#     #\n" +
                "#######";
        Bender bender = new Bender(mapa);
        assertEquals("SEENNNNN", bender.run());
    }

    @Test
    public void test05() {
        String mapa = "" +
                "#######\n" +
                "#     #\n" +
                "#     #\n" +
                "#     #\n" +
                "#     #\n" +
                "#  X###\n" +
                "#$    #\n" +
                "#######";
        Bender bender = new Bender(mapa);
        assertEquals("SEEWWWW", bender.run());
    }
}