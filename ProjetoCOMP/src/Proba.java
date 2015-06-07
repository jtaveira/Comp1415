import java.io.File;

public class Proba
{
   public static void main(String[] args)
   {
      Proba p = new Proba();
      p.makeDot();
      //p.makeImageFromDot();
   }

   private void makeDot()
   {
      GraphViz gv = new GraphViz();
      gv.addln(gv.start_graph());
      gv.addln("A -> B;");
      gv.addln("A -> C;");
      gv.addln(gv.end_graph());
      System.out.println(gv.getDotSource());
      
      String type = "dot";

      File out = new File("../comp/output/out." + type);
      gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
   }
   
   private void makeImageFromDot()
   {

	   String input = "../comp/output/out.dot";
	   
	   GraphViz gv = new GraphViz();
	   gv.readSource(input);
	   System.out.println(gv.getDotSource());
   		
      String type = "gif";

	   File out = new File("../comp/graph/out." + type);
	   gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
   }
}
