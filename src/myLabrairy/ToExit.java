/** all right received  @ Sheverdin Konstantin  */

package myLabrairy;

public class ToExit extends Util {

    Util symbol = new Util ();

    public boolean isExit () {
        System.out.println ("Press 'Y' to continue or ANY  to exit");
        String inSymbol = symbol.getString ();
        return inSymbol.equals ("Y") || inSymbol.equals ("y");
    }
}




