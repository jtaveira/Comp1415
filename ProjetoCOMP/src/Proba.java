import java.io.File;

public class Proba
{
   public static void main(String[] args)
   {
      Proba p = new Proba();
      p.start2();
   }

   private void start()
   {
      GraphViz gv = new GraphViz();
      gv.addln(gv.start_graph());
      gv.addln("A -> B;");
      gv.addln("A -> C;");
      gv.addln(gv.end_graph());
      System.out.println(gv.getDotSource());
      
      String type = "gif";
//      String type = "dot";

      File out = new File("C:/Users/TaveiraDude/Desktop/workspaceJava/comp/tmp/out." + type);
      gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
   }
   
   /**
    * Read the DOT source from a file,
    * convert to image and store the image in the file system.
    */
   private void start2()
   {

	   String input = "C:/Users/TaveiraDude/Desktop/workspaceJava/comp/sample/sample.dot";
	   
	   GraphViz gv = new GraphViz();
	   gv.readSource(input);
	   System.out.println(gv.getDotSource());
   		
      String type = "gif";
//    String type = "dot";

	   File out = new File("C:/Users/TaveiraDude/Desktop/workspaceJava/comp/tmp/out." + type);
	   gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
   }
}
