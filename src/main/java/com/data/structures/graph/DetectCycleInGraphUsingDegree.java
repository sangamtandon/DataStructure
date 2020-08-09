package com.data.structures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author sangamt
 *	This class detects if there is any cycle in a undirectional graph using the degree of vertices.
 *	If there is cycle, vertices which create the cycle will be the output
 *	If there is no cycle, -1 will be the Output.
 *	
 *	PSEUDO CODE:
 *	1. Create Adjacency List of the Undirectional Graph
 *	2. Create a Map of Vertices and it's degree as key-value pair
 *	3. Iterate through map and store the vertices with degree 1 in a queue
 *	4. for each vertex in the queue and mark the vertex as visited and fetch the 
 *	   adjacent nodes(vertices) of the vertex from the adjacency list.
 *	5. For every adjacent vertex, decrease the degree of vertex by 1 in Map created in point 2.
 *	6. Repeat step 3 to 5
 *	7. Vertices which are not marked visited in queue will create cycle in graph 
 */

public class DetectCycleInGraphUsingDegree {

	public static void main(String[] args) {
		//Input
		int numberOfVertices = 5;
		
		//Step 1
		List<ArrayList<Integer>> matrix = new ArrayList<>();

		for (int i = 0; i < numberOfVertices; i++) {
			matrix.add(new ArrayList<Integer>());
		}
		
		addVertex(matrix,0,1);
		addVertex(matrix,0,2);
		addVertex(matrix,2,1);
		addVertex(matrix,2,3);
		addVertex(matrix,3,4);
		
		//Step 2
		Map<Integer, Integer> verticesDegreeMap = new HashMap<>();
		
		for (ArrayList<Integer> arrayList : matrix) {
			verticesDegreeMap.put(matrix.indexOf(arrayList), arrayList.size());
		}
		
		//Step 3
		Map<Integer, String> degreeOneVerticesMap = new HashMap<>();
		populateDegreeOneVerticesMap(verticesDegreeMap, degreeOneVerticesMap);
		
		
		while (degreeOneVerticesMap.containsValue("Unmarked")) {

			for (Integer key : degreeOneVerticesMap.keySet()) {
				if (degreeOneVerticesMap.get(key).equals("Unmarked")) {
					for (Integer vertex : matrix.get(key)) {
						verticesDegreeMap.put(vertex, verticesDegreeMap.get(vertex) - 1);
						populateDegreeOneVerticesMap(verticesDegreeMap, degreeOneVerticesMap);
						degreeOneVerticesMap.put(key, "Marked");
					}
				}
			}
		}
		
		if (degreeOneVerticesMap.size() == matrix.size()) {
			System.out.println("Graph doesn't contains cycle.");
		}
		else {
			for (Integer key : verticesDegreeMap.keySet()) {
				if (!degreeOneVerticesMap.containsKey(key)) {
					System.out.println(key);
				}
			}
			
		}

	}

	private static void populateDegreeOneVerticesMap(Map<Integer, Integer> verticesDegreeMap,
			Map<Integer, String> degreeOneVerticesMap) {
		for (Integer key : verticesDegreeMap.keySet()) {
			if (verticesDegreeMap.get(key) == 1 && !degreeOneVerticesMap.containsKey(key)) {
				degreeOneVerticesMap.put(key, "Unmarked");
			}
		}
	}

	private static void addVertex(List<ArrayList<Integer>> matrix, int u, int v) {
		matrix.get(u).add(v);
		matrix.get(v).add(u);
	}

}
