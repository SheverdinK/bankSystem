/** all right received  @ Sheverdin Konstantin  */

package myLabrairy;

public class ToExit extends MyUtil {

    MyUtil symbol = new MyUtil ();

    public boolean isExit () {
        System.out.println ("Press 'Y' to continue or ANY  to exit");
        String inSymbol = symbol.getString ();
        return inSymbol.equals ("Y") || inSymbol.equals ("y");
    }
}




