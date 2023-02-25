//15. Graph
// 0 -- 1
// |    |
// 3 -- 2
// adjacency list 1
List[] graph = new ArrayList[4]; // array with ArrayList
for (int i = 0; i < graph.length; ++i)
  graph[i] = new ArrayList<>();
graph[0].add(1); graph[0].add(3);
graph[1].add(2); graph[1].add(0);
graph[2].add(1); graph[2].add(3);
graph[3].add(0); graph[3].add(2);
System.out.println(graph[0].toString()); // 0 -> {1, 3}
System.out.println(graph[1].toString()); // 1 -> {2, 0}

// adjacency list 2 recommend
Map<Integer, List<Integer>> graph2 = new HashMap<>(); // map with ArrayList
for (int i = 0; i < 4; i++)
  graph2.put(i, new ArrayList<>());
graph2.get(0).add(1); graph2.get(0).add(3);
graph2.get(1).add(2); graph2.get(1).add(0);
graph2.get(2).add(1); graph2.get(2).add(3);
graph2.get(3).add(0); graph2.get(3).add(2);
System.out.println(graph2.get(0).toString()); // 0 -> {1, 3}
System.out.println(graph2.get(1).toString()); // 1 -> {2, 0}

// adjacency matrix
boolean[][] graph3 = new boolean[4][4];
for (int i = 0; i < 4; i++) graph3[i][i] = true;
graph3[0][1] = true; graph3[0][1] = true;
graph3[1][3] = true; graph3[1][0] = true;
graph3[2][1] = true; graph3[2][3] = true;
graph3[3][2] = true; graph3[3][0] = true;
System.out.println("    0     1     2     3");
for (int i = 0; i < 4; ++i) {
   System.out.println(i + " " + Arrays.toString(graph3[i]));
}
