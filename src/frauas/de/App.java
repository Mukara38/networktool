package frauas.de;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String fileName = "small_graph.graphml";
        if(args.length > 0)
         fileName = args[0];

        ReadXmlFile readFile = new ReadXmlFile();
       readFile.read(fileName);


    }
}
