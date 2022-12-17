import org.junit.Test;
import static org.junit.Assert.*;
public class Filktesting {
    @Test
    public void testisSameNumber() {
        assertTrue("a = 1, b = 1, a != b", Flik.isSameNumber(1, 1));
        assertTrue("a = 128, b = 128, a != b", Flik.isSameNumber(128, 128));
        assertFalse("a = 1, b = 0, a = b", Flik.isSameNumber(1, 0));
    }

}
