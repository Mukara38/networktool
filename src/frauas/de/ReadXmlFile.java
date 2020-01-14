package frauas.de;

import java.util.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;

public class ReadXmlFile {
	public List<MyGraph> read(String filename) {
		List<MyGraph> myGraphlist = new ArrayList<>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(filename);

			NodeList graphlist = doc.getElementsByTagName("graph");
			for (int i = 0; i < graphlist.getLength(); i++) {

				Element graph = (Element) graphlist.item(i);


				MyGraph myGraph = new MyGraph();
				myGraphlist.add(myGraph);
				myGraph.setID(graph.getAttribute("id"));
				myGraph.setEdgeDefault(graph.getAttribute("edgedefault"));
				System.out.println("Graph : " + myGraph.getID());
				System.out.println("Edgedefault: " + myGraph.getEdgeDefault());

				NodeList nodelist = graph.getElementsByTagName("node");

				for (int k = 0; k < nodelist.getLength(); k++) {

					Element node = (Element) nodelist.item(k);
					MyNode myNode = new MyNode();
					myNode.setID(node.getAttribute("id"));
					myGraph.getNodes().put(myNode.getID(), myNode);

					

					Element data = (Element) (node.getElementsByTagName("data").item(0));

					myNode.setVID(Integer.parseInt(data.getTextContent()));

					System.out.println("Node Id: " + myNode.getID() + " Vid: " + Integer.toString(myNode.getVID()));
				}
				NodeList edgelist = graph.getElementsByTagName("edge");
				for (int k = 0; k < edgelist.getLength(); k++) {
					Element edge = (Element) edgelist.item(k);

					MyEdge myEdge = new MyEdge();

					myEdge.setTarget(edge.getAttribute("target"));
					myEdge.setSource(edge.getAttribute("source"));

					
					NodeList dataList = edge.getElementsByTagName("data");
					for (int j = 0; j < dataList.getLength(); j++) {

					Element data = (Element) (dataList.item(j));
					if(data.getAttribute("key").equals("e_id"))
						myEdge.setID(Integer.parseInt(data.getTextContent()));

					if(data.getAttribute("key").equals("e_weight"))
						myEdge.setID(Integer.parseInt(data.getTextContent()));


					}

					System.out.println(" Edge Id: " + Integer.toString(myEdge.getID()) + " Target: " + myEdge.getTarget() + " Source: " + myEdge.getSource() + " Weight: " + Integer.toString(myEdge.getWeight()) );

					myGraph.getEdges().put(myEdge.getID(), myEdge);
				}

				System.out.println("Graph " + myGraph.getID() + " (" + myGraph.getEdgeDefault() +") with " + Integer.toString(myGraph.getNodes().size()) + " nodes, " + Integer.toString(myGraph.getEdges().size())  + " edges");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return myGraphlist;
	}
}
