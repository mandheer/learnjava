####Problem
Implement a **jigsaw puzzle**. Design the data structures and explain an algorithm to solve the puzzle. You can assume that you have a fitsWith method which, when passed two puzzle pieces, returns true if the two pieces belong together.
####SOLUTION
We will assume that we have a traditional, simple jigsaw puzzle. The puzzle is grid-like, with rows and columns. Each piece is located in a single row and column and has four edges. Each edge comes in one of three types: inner, outer, and flat. A corner piece, for
example, will have two flat edges and two other edges, which could be inner or outer.

As we solve the jigsaw puzzle (manually or algorithmically), we'll need to store the position of each piece. We could think about the position as absolute or relative:
* Absolute Position: "This piece is located at position (12, 23)." Absolute position would belong to the Piece class itself and would include an orientation as well.
* Relative Position: “I don’t know where this piece is actually located, but I know that it is next to this other piece.” The relative position would belong to the Edge class.

For our solution, we will use only the relative position, by adjoining edges to neighboring edges.

A potential object-oriented design looks like the following:
```java
1 class Edge {
2 enum Type { inner, outer, flat }
3 Piece parent;
4 Type type;
5 int index; // Index into Piece.edges
6 Edge attached_to; // Relative position
7
8 /* See Algorithm section. Returns true if the two pieces
9 * should be attached to each other. */
10 boolean fitswith(Edge edge) { ... };
11 }
12
13 class Piece {
14 Edge[ ] edges;
15 boolean isCorner() { ... }
16 }
17
18 class Puzzle {
19 Piece[ ] pieces; /* Remaining pieces left to put away. */
20 Piece[ ][ ] solution;
21
22 /* See algorithm section. */
23 Edge[ ] inners, outers, flats;
24 Piece[ ] corners;
25
26 /* See Algorithm section. */
27 void sort() { ... }
28 void solve() { ... }
29 }
```
Algorithm to Solve the Puzzle

We will sketch this algorithm using a mix of pseudocode and real code.
Just as a kid might in solving a puzzle, we'll start with the easiest pieces first: the corners and edges. We can easily search through all the pieces to find just the edges. While we're at it though, it probably makes sense to group all the pieces by their edge types.
```java
1 void sort() {
2 for each Piece p in pieces { ;
3 if (P has two flat edges) then add p to corners
4 for each edge in p.edges {
5 if edge is inner then add to inners
6 if edge is outer then add to outers
7 }
8 }
9 }
```

We now have a quicker way to zero in on potential matches for any given edge. We then go through the puzzle, line by line, to match pieces.

The solve method, implemented below, operates by picking an arbitrary start with. It then finds an open edge on the corner and tries to match it to an open piece. When it finds a match, it does the following:
1. Attaches the edge.
2. Removes the edge from the list of open edges.
3. Finds the next open edge.

The next open edge is defined to be the one directly opposite the current edge, if it is available. If it is not available, then the next edge can be any other edge. This will cause the puzzle to be solved in a spiral-like fashion, from the outside to the inside.

The spiral comes from the fact that the algorithm always moves in a straight line, whenever possible. When we reach the end of the first edge, the algorithm moves to the only available edge on that corner piece—a 90-degree turn. It continues to take 90-degree turns at the end of each side until the entire outer edge of the puzzle is completed. When that last edge piece is in place, that piece only has one exposed edge remaining, which is again a 90-degree turn. The algorithm repeats itself for subsequent rings around the puzzle, until finally all the pieces are in place.

This algorithm is implemented below with Java-like pseudocode.
```java
1 public void solve() {
2 /* Pick any corner to start with */
3 Edge currentEdge = getExposedEdge(corner[0]);
4
5 /* Loop will iterate in a spiral like fashion until the puzzle
6 * is full. */
7 while (currentEdge != null) {
8 /* Match with opposite edges. Inners with outers, etc. */
9 Edge[ ] opposites = currentEdge.type == inner ?
10 outers : inners;
11 for each Edge fittingEdge in opposites {
12 if (currentEdge.fitsWith(fittingEdge)) {
13 attachEdges(currentEdge, fittingEdge); //attach edge
14 removeFromlist(currentEdge);
15 removeFromList(fittingEdge);
16
17 /* get next edge */
18 currentEdge = nextExposedEdge(fittingEdge);
19 break; // Break out of inner loop. Continue in outer.
20 }
21 }
22 }
23 }
24
25 public void removeFromList(Edge edge) {
26 (edge.type == flat) return;
27 Edge[ ] array = currentEdge.type == inner ? inners : outers;
28 array.remove(edge);
29 }
30
31 /* Return the opposite edge if possible. Else, return any exposed
32 * edge. */
33 public Edge nextExposedEdge(Edge edge) {
34 int next_index = (edge.index + 2) % 4; // Opposite edge
35 Edge next_edge = edge.parent.edges[next_index];
36 if isExposed(next_edge) {
37 return next_edge;
38 }
39 return getExposedEdge(edge.parent);
40 }
41
42 public Edge attachEdges(Edge e1, Edge e2) {
43 el.attached_to = e2;
44 e2.attached_to = e1;
45 }
46
47 public Edge isExposed(Edge e1) {
48 return edge.type != flat && edge.attached_to == null;
49 }
50
51 public Edge getExposedEdge(Piece p) {
52 for each Edge edge in p.edges {
53 if (isExposed(edge)) {
54 return edge;
55 }
56 }
57 return null;
58 }
```

For simplicity, we’re represented inners and outers as an Edge array. This is actually not a great choice, since we need to add and removed elements from it frequently. If we were writing a real code, we would probably want to implement these variables as linked lists.

Writing the full code for this problem in an interview would be far, far too much work. More likely, you would be asked to just sketch out the code.

