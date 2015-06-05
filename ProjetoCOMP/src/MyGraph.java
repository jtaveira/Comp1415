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
	
	public ArrayList<MyNode> getStarNodes(){
		
		ArrayList<MyNode> temp = new ArrayList<MyNode>();
		Integer maxCon = 0;
		
		for(int i = 0; i < this.nodes.size(); i++){
			
			if(this.nodes.get(i).getAdjacentNodesNum() > maxCon){
				maxCon = this.nodes.get(i).getAdjacentNodesNum();
				temp.clear();
				temp.add(this.nodes.get(i));
			}
			
			else if(this.nodes.get(i).getAdjacentNodesNum() == maxCon){
				temp.add(this.nodes.get(i));
			}
		}
		
		System.out.println();
		System.out.println(" -- STAR NODES --");
		for(int i = 0; i < temp.size(); i++){
			temp.get(i).printNode();
			System.out.println();
		}
		
		return temp;
	}
	
	public ArrayList<MyNode> getEssentialNodes(){
		
		ArrayList<MyNode> temp = new ArrayList<MyNode>();

		//TODO
		
		return temp;
	}
	
	public ArrayList<MyNode> getCentralNodes(){
		
		ArrayList<MyNode> temp = new ArrayList<MyNode>();

		//TODO
		
		return temp;
	}
	
	public void printGraph(){
		
		System.out.println();
		System.out.println(" -- GRAPH --");
		
		for(int i = 0; i < nodes.size(); i++){
			
			nodes.get(i).printNode();
			System.out.println();
			
			for(int j = 0; j < nodes.get(i).getOutEdges().size(); j++){
				nodes.get(i).getOutEdges().get(j).printOutwardConnection();
				System.out.println();
			}
		}		
	}
}
