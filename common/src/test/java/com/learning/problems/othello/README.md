
####Problem
**Othello** is played as follows: Each Othello piece is white on one side and black on the other. When a piece is surrounded by its opponents on both the left and right sides, or both the top and bottom, it is said to be captured and its color is flipped. On your turn, you must capture at least one of your opponent's pieces. The game ends when either user has no more valid moves. The win is assigned to the person with the most pieces. Implement the object-oriented design for Othello.
####SOLUTION

Let’s start with an example. Suppose we have the following moves in an Othello game:
1. Initialize the board with two black and two white pieces in the center. The black pieces are placed at the upper left hand and lower right hand corners.
2. Play a black piece at (row 6, column 4). This flips the piece at (row 5, column 4) from white to black.
3. Play a white piece at (row 4, column 3). This flips the piece at (row 4, column 4) from black to white.

This sequence of moves leads to the board below.

![alt text][othello_game_grid]

The core objects in Othello are probably the game, the board, the pieces (black or white), and the players. How do we represent these with elegant object-oriented design?

######Should BlackPiece and WhitePiece be classes?
At first, we might think we want to have a BlackPiece class and a WhitePiece class, which inherit from an abstract Piece. However, this is probably not a great idea. Each piece may flip back and forth between colors frequently, so continuously destroying and creating what is really the same object is probably not wise. It may be better to just have a Piece class, with a flag in it representing the current color.

######Do we need separate Board and Game classes?
Strictly speaking, it may not be necessary to have both a Game object and a Board object. Keeping the objects separate allows us to have a logical separation between the board (which contains just logic involving placing pieces) and the game (which involves times, game flow, etc.). However, the drawback is that we are adding extra layers to our program. A function may call out to a method in Game, only to have it immediately call Board. We have made the choice below to keep Game and Board separate, but you should discuss this with your interviewer.

######Who keeps score?
We know we should probably have some sort of score keeping for the number of black and white pieces. But who should maintain this information? One could make a strong argument for either Game or Board maintaining this information, and possibly even for Piece (in static methods). We have implemented this with Board holding this information, since it can be logically grouped with the board. It is updated by Piece or Board calling colorChanged and colorAdded methods within Board.

######Should Game be a Singleton class?
Implementing Game as a singleton class has the advantage of making it easy for anyone to call a method within Game, without having to pass around references to the Game object.

Making Game a singleton though means that it can only be instantiated once. Can we make this assumption? You should discuss this with your interviewer.

One possible design for Othello is below.
```java
 public enum Direction {
 left, right, up, down
 }

```

```java
 public enum Color {
 White, Black
 }

```

```java
 public class Game {
 private Player[ ] players;
 private static Game instance;
 private Board board;
 private final int ROWS = 10;
 private final int COLUMNS = 10;

 private Game() {
 board = new Board(ROWS, COLUMNS);
 players = new Player[2];
 players[0] = new Player(Color.Black);
 players[1] = new Player(Color.White);
 }

 public static Game getlnstance() {
 if (instance == null) instance = new Game();
 return instance;
 }

 public Board getBoard() {
 return board;
 }
 }
```

The Board class manages the actual pieces themselves. It does not handle much of the game play, leaving that up to the Game class.

```java
 public class Board {
 private int blackCount = 0;
 private int whiteCount = 0;
 private Piece[ ][ ] board;

 public Board(int rows, int columns) {
 board = new Piece[rows][columns];
 }

 public void initialize() {
 /* initialize center black and white pieces */
 }

 /* Attempt to place a piece of color color at (row, column).
 * Return true if we were successful. */
 public boolean placeColor(int row, int column, Color color) {
 …
 }

 /* flips pieces starting at (row, column) and proceeding in
 * direction d. */
 private int flipSection(int row, int column, Color color,
 Direction d) { ... }

 public int getScoreForColor(Color c) {
 if (c == Color.Black) return blackCount;
 else return whiteCount;
 }

 /* Update board with additional newPieces pieces of color
 *newColor. Decrease score of opposite color. */
 public void updateScore(Color newColor, int newPieces) { ... }
 }
```

As described earlier, we implement the black and white pieces with the Piece class, which has a simple Color variable representing whether it is a black or white piece.

```java
 public class Piece {
 private Color color;
 public Piece(Color c) { color = c; }

 public void flip() {
 if (color == Color.Black) color = Color.White;
 else color = Color.Black;
 }

 public Color getColor() { return color; }
 }
```

The Player holds only a very limited amount of information. It does not even hold its own score, but it does have a method one can call to get the score PIayer.getScore() will call out to the GameManager to retrieve this value.

```java
 public class Player {
 private Color color;
 public Player(Color c) { color = c; }

 public int getScore() { ... }

 public boolean playPiece(int r, int c) {
 return Game.getlnstance() .getBoard() .placeColor(r, c, color);
 }

 public Color getColor() { return color; }
 }
```

A fully functioning (automated) version of this code can be found in the downloadable code attachment.

Remember that in many problems, what you did is less important than why you did it. Your interviewer probably doesn't care much whether you chose implement Game as a singleton or not, but she probably does care that you took the time to think about it and discuss the trade-offs.

[othello_game_grid]: othello-grid.png "Othello game grid"