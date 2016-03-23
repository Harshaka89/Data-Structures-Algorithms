/*
 * AUTHOR:  Aaron Covington
 * TITLE: Unit 9 Project 5.10.  Maze Solver
 * DATE STARTED: 03/14/16
 * DATE LAST REVISITED: 03/20/16
 * CLASS: CS3363R
 * DESCRIPTION: This is an exception that gets thrown if the maze is invalid (there are more than 1 entry point and 1 exit point).
 */
public class IllegalMazeException extends Exception {

	public IllegalMazeException(String string) {
		System.out.println(string);
	}

}
