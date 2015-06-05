import java.util.ArrayList;

public class MyNode {

	private String name;
	private Integer group;
	private ArrayList<MyEdge> inEdges;
	private ArrayList<MyEdge> outEdges;
	
	public MyNode(String name, Integer group, ArrayList<MyEdge> inEdges, ArrayList<MyEdge> outEdges){
		this.name = name;
		this.group = group;
		this.inEdges = inEdges;
		this.outEdges = outEdges;
	}
	
	public MyNode(String name, Integer group){
		this.name = name;
		this.group = group;
		this.inEdges = new ArrayList<MyEdge>();
		this.outEdges = new ArrayList<MyEdge>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public Integer getGroup(){
		return this.group;
	}
	
	public ArrayList<MyEdge> getInEdges(){
		return inEdges;
	}
	
	public ArrayList<MyEdge> getOutEdges(){
		return outEdges;
	}
	
	public ArrayList<MyNode> getAdjacentNodes(){
		ArrayList<MyNode> temp = new ArrayList<MyNode>();
		
		for(int i = 0; i < inEdges.size(); i++)
			temp. add(inEdges.get(i).getSource());
		
		for(int i = 0; i < outEdges.size(); i++)
			temp. add(outEdges.get(i).getTarget());
		
		return temp;
	}
	
	public int getAdjacentNodesNum(){
		return inEdges.size() + outEdges.size();
	}
	
	public void addEdge(MyNode node){
		MyEdge edge = new MyEdge(this, node);
		outEdges.add(edge);
		node.inEdges.add(edge);
	}
	
	public void printNode(){
		System.out.println("Node: " + this.name + " Group: " + this.group);
	}
}
