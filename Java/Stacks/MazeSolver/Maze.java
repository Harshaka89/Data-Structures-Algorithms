/*
 * AUTHOR:  Aaron Covington
 * TITLE: Unit 9 Project 5.10.  Maze Solver
 * DATE STARTED: 03/14/16
 * DATE LAST REVISITED: 03/20/16
 * CLASS: CS3363R
 * DESCRIPTION: Let a 2-D array represent the maze.  Use a stack based algorithm to find a path through the maze.  Some mazes might have
 * more than one successful path, while others may have no path.  If a value is 0 it can be traveled to.  If a value is 1 it is a wall.
 * If backtracking is done the cell will be marked with a 'V' for visited.  The correct path is marked with periods.
 * OUTLINE:  Reads in a maze file and loads it into a 2d array.  It scans the perimeter of the maze to find the start coordinates.
 * The maze is then solved by tracking progress using a stack and checking all directions each step of the way.  If no advancement is
 * possible we backtrack.  If the stack becomes empty no solution is possible so program terminates.  If we reach the end the path 
 * will be displayed using periods.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Maze {
	public static Character[][] maze;
	public static Position start, end;
	
	/*Method to print all the elements of the maze*/
	public static void printMaze(){
		for(int i = 0; i < maze.length; i++){
			for(int j= 0; j < maze[0].length; j++){
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	//Method to find start and end point and also verify there are only 2
	public static void findStart() throws IllegalMazeException{
		int count = 0;
		for(int i = 0; i < maze.length; i++){ //Loop scans the border of the maze
			for(int j = 0; j < maze[0].length; j++){
				if(i == 0 || j == 0 || i == maze.length-1 || j == maze[0].length - 1){
					if(maze[i][j] == '0' && count == 0){ //if zero is found initialize start position
						start = new Position(i, j);
						count++;
					}
					else if(maze[i][j] == '0' && count == 1){ //if another zero is found initialize end position
						end = new Position(i, j);
						count++;
					}
					else if(maze[i][j] == '0' && count == 2){ //if another zero is found throw an exception because invalid maze
						throw new IllegalMazeException("Invalid Maze!  Can only contain 1 start and 1 end point");
					}
				}
			}
		}
	}
	//Method to create and initialize the maze by reading and processing the input file
	public static void loadMaze(String name){
		File file = new File(name);	
		try{
			Scanner input = new Scanner(file);
			final int RADIX = 10; //base 10 number system
			int M = input.nextInt(); //M represents the rows
			int N = input.nextInt(); //N represents the columns
			maze = new Character[M][N];
			for(int i = 0; i < maze.length; i++){
				for(int j = 0; j < maze[0].length; j++){
					maze[i][j] = Character.forDigit(input.nextInt(), RADIX); //insert our 0's and 1's into matrix
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
	}
	public static void solveMaze(){
		Position current = start; //point to the starting coordinates
		boolean isSolved = false; //variable to keep track of if problem is solved
		Position result; //Holds coordinates returned by direction checking methods
		MyStack<Position> search = new MyStack<Position>(); //stack that keeps track of the path
		search.push(current); //add starting coordinates to the stack
		while(!isSolved){
			
			result = checkUp(current); //get coordinates of above cell, returns current if out of bounds
			if(!isSame(current, result)){ //compares current and new coordinate returned
				maze[current.getRow()][current.getCol()] = '.'; //If not the same mark current cell as period
				current = result; //point to new coordinates
				search.push(current); //add new coordinates to the stack
				isSolved = isSolved(current); //check if maze is solved
				if(isSolved == true){ //if it is solved mark final position with period
					maze[current.getRow()][current.getCol()] = '.';
				}
				continue;
			}
			result = checkRight(current); //get coordinates of cell to the right, returns current if out of bounds
			if(!isSame(current, result)){ //compares current and new coordinate returned
				maze[current.getRow()][current.getCol()] = '.'; //If not the same mark current cell as period
				current = result; //point to new coordinates
				search.push(current); //add new coordinates to the stack
				isSolved = isSolved(current); //check if maze is solved
				if(isSolved == true){ //if it is solved mark final position with period
					maze[current.getRow()][current.getCol()] = '.';
				}
				continue;
			}
			result = checkDown(current); //get coordinates of the cell below, returns current if out of bounds
			if(!isSame(current, result)){ //compares current and new coordinate returned
				maze[current.getRow()][current.getCol()] = '.'; //If not the same mark current cell as period
				current = result; //point to new coordinates
				search.push(current); //add new coordinates to the stack
				isSolved = isSolved(current); //check if maze is solved
				if(isSolved == true){ //if it is solved mark final position with period
					maze[current.getRow()][current.getCol()] = '.';
				}
				continue;
			}
			result = checkLeft(current); //get coordinates of cell to the left, returns current if out of bounds
			if(!isSame(current, result)){ //compares current and new coordinate returned
				maze[current.getRow()][current.getCol()] = '.'; //If not the same mark current cell as period
				current = result; //point to new coordinates
				search.push(current); //add new coordinates to the stack
				isSolved = isSolved(current); //check if maze is solved
				if(isSolved == true){ //if it is solved mark final position with period
					maze[current.getRow()][current.getCol()] = '.';
				}
				continue;
			}
			//If we get to this point no path was found so we need to mark current position and backtrack
			maze[current.getRow()][current.getCol()] = 'V'; //Mark as visited
			search.pop(); //backtrack in maze by popping element
			if(search.isEmpty()){ //if stack is empty that means no path was found
				System.out.println("No path found!");
				return;
			}
			current = search.top(); //grab position on top of stack
			isSolved = isSolved(current); //check if solved
		}
	}
	/*Methods to check surrounding coordinates, if a coordinate is valid the new coordinate is returned, otherwise
	 * the current position is returned*/
	public static Position checkUp(Position p){
		if((p.getRow() - 1) < 0){ //ensure cell above current is not out of bounds
			return p; //if it is then return current position
		}
		else{
			Position newPosition = new Position(p.getRow()-1, p.getCol()); //point to new position
			if(isValid(newPosition)){ //check if position is valid spot to move to
				return newPosition; //if it is then return new position
			}
			else{
				return p; //otherwise return current position
			}
		}
	}
	public static Position checkRight(Position p){
		if((p.getCol() + 1) == maze[0].length){ //ensure cell to the right of current is not out of bounds
			return p; //if it is then return current position
		}
		else{
			Position newPosition = new Position(p.getRow(), p.getCol()+1); //point to new position
			if(isValid(newPosition)){ //check if position is valid spot to move to
				return newPosition; //if it is then return new position
			}
			else{
				return p; //otherwise return current position
			}
		}	
	}
	public static Position checkDown(Position p){
		if((p.getRow() + 1) == maze.length){ //ensure cell below current is not out of bounds
			return p; //if it is then return current position
		}
		else{
			Position newPosition = new Position(p.getRow() + 1, p.getCol()); //point to new position
			if(isValid(newPosition)){ //check if position is valid spot to move to
				return newPosition; //if it is then return new position
			}
			else{
				return p; //otherwise return current position
			}
		}	
	}
	public static Position checkLeft(Position p){
		if((p.getCol() -1) < 0){ //ensure cell to the left of current isn't out of bounds
			return p; //if it is then return current position
		}
		else{
			Position newPosition = new Position(p.getRow(), p.getCol()-1); //point to new position
			if(isValid(newPosition)){ //check if position is valid spot to move to
				return newPosition; //if it is then return new position
			}
			else{
				return p; //otherwise return current position
			}
		}	
	}
	//method isSame checks two positions to see if they are the same
	public static boolean isSame(Position x, Position y){
		if((x.getRow() == y.getRow()) && (x.getCol() == y.getCol())){ //compares row and column of x and y to see if they match
			return true; //if they do return true
		}
		return false; //otherwise return false
	}
	//Method isValid checks if the value at a position is a zero, if it is return true because we can move there
	public static boolean isValid(Position p){ //ensure value at position is a 0
		if(maze[p.getRow()][p.getCol()] == '0'){ //check if value at position is a zero, if it is return true
			return true;
		} 
		return false; //otherwise return false
	}
	//isSolved checks if the maze is solved
	public static boolean isSolved(Position p){
		if(isSame(p, start)){
			return false;
		}
		else{
			if(p.getCol() == 0 || p.getCol() == (maze[0].length-1)){
				return true;
			}
			if(p.getRow() == 0 || p.getRow() == (maze.length-1)){
				return true;
			}
		}
		return false;
	}
	
	//driver method
	public static void main(String[] args) throws IllegalMazeException{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of a maze file: ");
		String name = input.nextLine(); //Take name of maze file as input
		loadMaze(name); //load maze
		findStart();
		printMaze();
		solveMaze();
		printMaze();
		
	}
}
