package test;

import bankException.IdException;
import myLabrairy.Util;
import org.junit.Before;
import org.junit.Test;

public class UtilTest extends Util {

    @Before
    public void setUp () throws Exception {

    }

    @Test
    public void testGetId () throws Exception {

        String message = "TEST!!!";
        int  nClientId = 9;
        int id = 123456789;
        boolean isId = false;
            try {
                System.out.println (message + " ID = " + id);
               isId (id, nClientId);
            }
            catch (IdException eId) {
                System.out.println( eId.getMessage());
            }
        }
}

