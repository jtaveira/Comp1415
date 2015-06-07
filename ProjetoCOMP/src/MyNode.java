import java.util.ArrayList;

public class MyNode {

	private String name;
	private Integer id;
	private Integer group;
	private ArrayList<MyEdge> inEdges;
	private ArrayList<MyEdge> outEdges;
	private ArrayList<MyEdge> removedInEdges = new ArrayList<MyEdge>();
	private ArrayList<MyEdge> removedOutEdges = new ArrayList<MyEdge>();
	private boolean star;
	private boolean essential;
	private boolean central;
	private boolean visited;
	private Integer appearances = 0;
	
	public MyNode(String name, Integer id, Integer group, ArrayList<MyEdge> inEdges, ArrayList<MyEdge> outEdges){
		this.name = name;
		this.id = id;
		this.group = group;
		this.inEdges = inEdges;
		this.outEdges = outEdges;
		this.star = false;
		this.essential = false;
		this.central = false;
		this.visited = false;
	}
	
	public MyNode(String name, Integer id, Integer group){
		this.name = name;
		this.id = id;
		this.group = group;
		this.inEdges = new ArrayList<MyEdge>();
		this.outEdges = new ArrayList<MyEdge>();
		this.star = false;
		this.essential = false;
		this.central = false;
		this.visited = false;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public Integer getGroup(){
		return this.group;
	}
	
	public Integer getAppearances(){
		return this.appearances;
	}
	
	public ArrayList<MyEdge> getInEdges(){
		return this.inEdges;
	}
	
	public ArrayList<MyEdge> getOutEdges(){
		return this.outEdges;
	}
	
	public ArrayList<MyEdge> getRemovedInEdges(){
		return this.removedInEdges;
	}
	
	public ArrayList<MyEdge> getRemovedOutEdges(){
		return this.removedOutEdges;
	}
	
	public boolean getVisited(){
		return this.visited;
	}
	
	public boolean isStar(){
		return this.star;
	}
	
	public boolean isEssential(){
		return this.essential;
	}
	
	public boolean isCentral(){
		return this.central;
	}
	
	public void addRemovedInEdge(MyEdge edge){
		this.removedInEdges.add(edge);
	}
	
	public void addRemovedOutEdge(MyEdge edge){
		this.removedOutEdges.add(edge);
	}
	
	public void setAppearances(Integer appearance){
		this.appearances = appearance;
	}
	
	public void addAppearances(Integer appearance){
		this.appearances += appearance;
	}
	
	public void setIsStar(boolean bool){
		this.star = bool;
	}
	
	public void setIsEssential(boolean bool){
		this.essential = bool;
	}
	
	public void setIsCentral(boolean bool){
		this.central = bool;
	}
	
	public void setVisited(boolean bool){
		this.visited = bool;
	}
	
	public void clearInEdges(){
		this.inEdges.clear();
	}
	
	public void clearOutEdges(){
		this.outEdges.clear();
	}
	
	public void resetConnections(){
		this.inEdges.addAll(this.removedInEdges);
		this.outEdges.addAll(this.removedOutEdges);
		
		this.removedInEdges.clear();
		this.removedOutEdges.clear();
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
		this.outEdges.add(edge);
		node.inEdges.add(edge);
	}
	
	public void addEdge(MyNode node, Integer weight){
		MyEdge edge = new MyEdge(this, node, weight);
		this.outEdges.add(edge);
		node.inEdges.add(edge);
	}
	
	public void printNode(){
		System.out.print(this.name + " (" + this.group + ")");
	}
}
