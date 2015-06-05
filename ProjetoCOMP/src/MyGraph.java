import java.util.ArrayList;

public class MyGraph {

	private ArrayList<MyNode> nodes;
	
	public MyGraph( ArrayList<MyNode> nodes){
		this.nodes = nodes;
	}
	
	public MyGraph(){
		this.nodes = new ArrayList<MyNode>();
	}
	
	public void addNode(MyNode node){
		this.nodes.add(node);
	}
	
	public ArrayList<MyNode> getNodes(){
		return this.nodes;
	}
	
	public void setNodes(ArrayList<MyNode> nodes){
		this.nodes = nodes;
	}
	
	public void printGraph(){
		
		for(int i = 0; i < nodes.size(); i++){
			
			System.out.println(nodes.get(i).getName());
			
			for(int j = 0; j < nodes.get(i).getOutEdges().size(); j++){
				System.out.print(" --> " + nodes.get(i).getOutEdges().get(j).getTarget().getName());
				System.out.println();
			}
		}		
	}
}
