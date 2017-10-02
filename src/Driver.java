import java.util.Scanner;

/**
 * ---------------------------------------------------------------------------
 * File name: Driver.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Koi Stephanos, stephanos@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 12, 2014
 * ---------------------------------------------------------------------------
 */

/**
 * To Execute methods of the Game class
 *
 * <hr>
 * Date created: Nov 12, 2014
 * <hr>
 * @author Koi Stephanos
 */
public class Driver
{
	static Scanner kb = new Scanner(System.in);					//creates scanner item for input
	static Game game = new Game();								//creates instance of game class
	static String output;										//holds all output for driver
	static String input;										//holds all input for driver
	static Boolean gameOver = false;							//holds if the game has ended
	
	
	/**
	 * To execute methods of the driver and game classes      
	 *
	 * <hr>
	 * Date created: Nov 12, 2014
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		welcomeMessage();
		output = game.dungeon.toString ( );
		System.out.print (output);
		
		while(!gameOver)
		{
			try
			{
				//prompts user for move and collects the command
				output = game.newMove();
				System.out.print (output);
				input = getCommand();
				
				//performs the cell move
				output = game.moveCell (input);
				System.out.print (output);
				output = game.dungeon.toString ( );
				System.out.print (output);
				gameOver = game.gameOver ( );
				
				//performs weapon operations
				output = game.newWeapon ( );
				if(!output.equals (""))
				{
					System.out.print (output);
					while(true)
					{	
						input = getCommand();
						output = game.switchWeapon (input);
						System.out.print (output);
						if(!output.equals ("\nError! Must enter either Y or N.  "))
							break;
					}
				}
				//performs monster operations
				output = game.fightMonster ( );
				if(!output.equals(""))
				System.out.print (output);
				gameOver = game.gameOver ( );
				
				
			}
			//catches and displays any thrown exceptions
			catch(Exception e)
			{
				output = e.getMessage ( );
				System.out.print ("\n" + output);
			}
			
		}
		
		

	}
	
	/**
	 * Gets input from user and returns it for use        
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @return command, the command entered by the user
	 */
	public static String getCommand ()
	{	
		String command = kb.nextLine ( );
		
		return command;
	}
	
	/**
	 * Displays a welcome message with brief game description        
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 */
	public static void welcomeMessage ()
	{
		System.out.print ("\nWelcome to The Adventures of The Ham King! " +
						"\nThe objective is to navigate through the maze to the exit!" +
						"\nAllong the way you will encounter weapons and monsters so be careful..");
	}
	

}
