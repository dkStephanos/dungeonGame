import java.util.Random;

/**
 * ---------------------------------------------------------------------------
 * File name: Game.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Koi Stephanos, stephanos@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 12, 2014
 * ---------------------------------------------------------------------------
 */

/**
 * To provide the necessary methods to play the game
 *
 * <hr>
 * Date created: Nov 12, 2014
 * <hr>
 * @author Koi Stephanos
 */
public class Game
{	
	Random ran = new Random();							//holds random number for percentage calculations
	Dungeon dungeon = new Dungeon();					//holds the dungeon for the game
	Player player = new Player();						//holds the player of the game
	
	
	/**
	 * To determine if move is possible and execute move        
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @param command, direction of move passed by user
	 * @return message, contains result of move
	 * @throws Exception, thrown if user inputs unknown command
	 */
	public String moveCell (String command) throws Exception
	{
		//determines if move can be made
		String message = "";
		Boolean value = dungeon.canMove (command);
		//determines if move results in victory
		if(dungeon.dungeonCompleted)
			message = "\n\n\nCongratulations! You have beaten the dungeon! You truly are the Ham King!";
		//performs cell move
		else if(value)
		{
			dungeon.setCell ( );
			message = "\nYou enter a new cell. Your current health: " + player.getHealth();
		}
		return message;		
	}
	
	/**
	 * Determines if monster is present and performs fight if it is       
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @return message, contains a list of all fight events with outcome
	 */
	public String fightMonster ()
	{
		//gathers necessary info for monster fight
		String message = "";
		Random num = new Random();
		int playerHealth = player.getHealth ( );
		Cell currentCell = dungeon.getCell ( );
		Monster monster = currentCell.getMonster ();
		Weapon weapon = player.getWeapon ( );
		int playerDamage;
		if(weapon != null)
			playerDamage = weapon.getDamage ( );
		else
			playerDamage = player.damage;
		
		if(monster != null)
		{
			String monsterTitle = monster.getTitle ( );
			//monster fight for Justin Bieber
			if(monsterTitle.equals ("Justin Bieber") && !dungeon.bieberDead)
			{	
				int monsterHealth = monster.getHealth ( );
				int monsterDamage = monster.getDamage ( );
				message = "\n\nThere is a monster in here! " + monster.getTitle ( ) + " is preparing to attack!";
				//carries out fight
				while(true)
				{
					//player attacking monster
					if(num.nextInt (10000) > 1000)
					{
						monsterHealth -= playerDamage;
						message += "\n\nYou struck the monster dealing " + playerDamage + " damage!";
						if(monsterHealth <= 0)
						{
							message += "\n\nVictory, you have slain " + monsterTitle;
							dungeon.bieberDead = true;
							player.setHealth(playerHealth);
							break;
						}
					}
					else
						message += "\n\nOh no! You missed the monster!";
					//monster attacking player
					if(num.nextInt (10000) > 2000)
					{
						playerHealth -= monsterDamage;
						message += "\nYou have been hit by the monster and taken " + monsterDamage + " damage!";
						if(playerHealth <= 0)
						{
							message += "\n\n\nYou Died. You were murdered by Justin Bieber. Game Over.";
							player.isDead = true;
							break;
						}
					}
					else
						message += "\nYou dogded the monster's attack!";
				}
			}
			//monster fight for Taylor Swift
			if(monsterTitle.equals ("Taylor Swift") && !dungeon.swiftDead)
			{	
				int monsterHealth = monster.getHealth ( );
				int monsterDamage = monster.getDamage ( );
				message = "\n\nThere is a monster in here! " + monster.getTitle ( ) + " is preparing to attack!";
				//carries out fight
				while(true)
				{
					if(num.nextInt (10000) > 1000)
					{
						monsterHealth -= playerDamage;
						message += "\n\nYou struck the monster dealing " + playerDamage + " damage!";
						if(monsterHealth <= 0)
						{
							message += "\n\nVictory, you have slain " + monsterTitle;
							dungeon.swiftDead = true;
							player.setHealth(playerHealth);
							break;
						}
					}
					else
						message += "\n\nOh no! You missed the monster!";
					if(num.nextInt (10000) > 2000)
					{
						playerHealth -= monsterDamage;
						message += "\nYou have been hit by the monster and taken " + monsterDamage + " damage!";
						if(playerHealth <= 0)
						{
							message += "\n\n\nYou Died. You were murdered by Taylor Swift. Game Over.";
							player.isDead = true;
							break;
						}
					}
					else
						message += "\nYou dogded the monster's attack!";
				}
			}
			//monster fight for Miley Cyrus
			if(monsterTitle.equals ("Miley Cyrus") && !dungeon.cyrusDead)
			{	
				int monsterHealth = monster.getHealth ( );
				int monsterDamage = monster.getDamage ( );
				message = "\n\nThere is a monster in here! " + monster.getTitle ( ) + " is preparing to attack!";
				//carries out fight
				while(true)
				{
					if(num.nextInt (10000) > 1000)
					{
						monsterHealth -= playerDamage;
						message += "\n\nYou struck the monster dealing " + playerDamage + " damage!";
						if(monsterHealth <= 0)
						{
							message += "\n\nVictory, you have slain " + monsterTitle;
							dungeon.cyrusDead = true;
							player.setHealth(playerHealth);
							break;
						}
					}
					else
						message += "\n\nOh no! You missed the monster!";
					if(num.nextInt (10000) > 2000)
					{
						playerHealth -= monsterDamage;
						message += "\nYou have been hit by the monster and taken " + monsterDamage + " damage!";
						if(playerHealth <= 0)
						{
							message += "\n\n\nYou Died. You were murdered by Miley Cyrus. Game Over.";
							player.isDead = true;
							break;
						}
					}
					else
						message += "\nYou dogded the monster's attack!";
				}
			}
		}	
		return message;
	}
	
	/**
	 * Provides the weapon in that cell, if there is one, and asks user if they would like to switch to that weapon        
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @return message, a string containing the weapon name and prompt to switch
	 */
	public String newWeapon()
	{
		String message = "";
		String strWeapon = "";
		Cell cell = dungeon.getCell ( );
		Weapon weapon = cell.getWeapon ( );
		Weapon plyrWeapon = player.getWeapon ( );
		if(plyrWeapon != null)
			strWeapon = plyrWeapon.getName ( );
		else
			strWeapon = "Fists";
		if(weapon != null)
			message = "\n\nWeapon discovered: " + weapon.getName ( ) + " Would you like to trade for you current weapon (" + strWeapon + ")?  (Y or N) ";
		
		return message;
	}
	
	/**
	 * Performs weapon switch leaving old weapon in cell if directed by user      
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @param command, yes or no as given by user
	 * @return message, string containing outcome of switch
	 * @throws Exception, thrown if user inputs something other than Y, y, N, or n
	 */
	public String switchWeapon(String command) throws Exception
	{
		String message = "";
		Cell cell = dungeon.getCell ( );
		Weapon cellWeapon = cell.getWeapon ( );
		Weapon tempWeapon = player.getWeapon ( );
	
				if(command.equals ("Y") || command.equals ("y"))
				{
					player.setWeapon (cellWeapon);
					cell.setWeapon (tempWeapon);
					String name = cellWeapon.getName ( );
					message = "\nWeapon swapped! New weapon is the " + name + "!";
					if(name.equals ("Country Ham"))
						message += " Kingship Renewed!";
				}
				else if (command.equals ("N") || command.equals ("n"))
					message = "\nCurrent weapon kept.";	
				else
					message = "\nError! Must enter either Y or N.  ";
				
		return message;
	}
	
	
	/**
	 * Prompts user for direction to move         
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @return message, the prompt
	 */
	public String newMove()
	{	
		String message = "";
		message = "\n\n\nWhich direction do you want to go?" + "\n" + "(Type 'go' followed by 'east', 'west', 'north', or 'south')		";
		
		return message;
	}
	
	/**
	 * Determines if game has ended       
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @return boolean, true if game is over
	 */
	public Boolean gameOver()
	{	
		//game ends if player is dead
		if(player.isDead)
			return player.isDead;
		//game ends if dungeon is completed
		else
			return dungeon.dungeonCompleted;
	}
}
