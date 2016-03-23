/*
 * AUTHOR:  Aaron Covington
 * TITLE: Unit 9 Project 5.10.  Maze Solver
 * DATE STARTED: 03/14/16
 * DATE LAST REVISITED: 03/20/16
 * CLASS: CS3363R
 * DESCRIPTION: This is an object I created to hold the coordinates of each step in the maze.
 */
public class Position {
	private int row;
	private int col;
	public Position(int row, int col){
		this.row = row;
		this.col = col;
	}
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
}
