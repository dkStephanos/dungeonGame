import java.util.Random;

/**
 * ---------------------------------------------------------------------------
 * File name: Dungeon.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Koi Stephanos, stephanos@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 12, 2014
 * ---------------------------------------------------------------------------
 */

/**
 * To provide all necessary attributes and methods for the dungeon
 *
 * <hr>
 * Date created: Nov 12, 2014
 * <hr>
 * @author Koi Stephanos
 */
public class Dungeon
{
	private int dungeonHeight;					//holds dungeon height
	private int dungeonWidth;					//holds dungeon width
	private int currentHeight;					//holds current positional height in dungeon
	private int currentWidth;					//holds current positional width in dungeon
	protected Cell [ ][ ] dungeon;				//holds the dungeon
	protected Cell currentCell;					//holds current cell
	protected Boolean dungeonCompleted;			//holds if the game has been one or not
	private int exitRow;						//holds the row that contains the exit
	private Boolean hamGenerated = false;		//if ham has generated
	private Boolean crowbarGenerated = false;	//if crowbar has generated
	private Boolean soakerGenerated = false;	//if super soaker has generated
	protected Boolean bieberDead = false;		//if Bieber is dead
	protected Boolean swiftDead = false;		//if Swift is dead
	protected Boolean cyrusDead = false;		//if Cyrus is dead
	private Boolean bieberSpawned = false;		//if Bieber has spawned
	private Boolean cyrusSpawned = false;		//if Cyrus has spawned
	private Boolean swiftSpawned = false;		//if Swift has spawned
	Random ran = new Random ();           	  //holds the random number used for percentages
		
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Nov 12, 2014 
	 *
	 * 
	 */
	Dungeon ( )
	{
		//sets up dungeon as a whole
		dungeonHeight = 1 + ran.nextInt (4);
		dungeonWidth = 1 + ran.nextInt (9);
		dungeon = new Cell[dungeonHeight][dungeonWidth];
		exitRow = ran.nextInt (5);
		currentHeight = 0;
		currentWidth = 0;
		dungeonCompleted = false;
		currentCell = dungeon[0][0];
		
		//sets up each cell individually
		Monster monster;
		Weapon weapon;
		for(int i = 0; i < dungeonHeight; i++)
		{
			for(int j = 0; j < dungeonWidth; j++)
			{
				dungeon[i][j] = new Cell();
				monster = determineMonster();
				weapon = determineWeapon();
				if(i != 0 && j != 0)
					dungeon[i][j].setMonster(monster);
				dungeon[i][j].setWeapon (weapon);
			}	
		}
	}

	
	/**
	 * Takes a command from player and determines if one can move in that direction      
	 *
	 * <hr>
	 * Date created: Nov 12, 2014
	 *
	 * <hr>
	 * @param direction, the direction given by user
	 * @return value, true if can move
	 */
	public Boolean canMove (String direction) throws Exception
	{
		Boolean value = false;
		
		
			if(direction.equals ("go north"))
				{
					if(currentHeight > 0)
						{
							currentHeight--;
							value = true;
						}
					else throw new Exception("\nSorry, but I can't go in that direction.");
				}
			else if(direction.equals ("go east"))
				{
					if(currentWidth < (dungeonWidth - 1))
					{
						currentWidth++;
						value = true;
					}
					else if(currentHeight == exitRow)
					{
						dungeonCompleted = true;
						value = true;
					}

					else throw new Exception("\nSorry, but I can't go in that direction.");
				}
			else if(direction.equals ("go south"))
				{
					if(currentHeight < (dungeonHeight - 1))
					{
						currentHeight++;
						value = true;
					}
					else throw new Exception("\nSorry, but I can't go in that direction.");
				}
			else if(direction.equals ("go west"))
				{
						if(currentWidth > 0)
						{
							currentWidth--;
							value = true;
						}
					else throw new Exception("\nSorry, but I can't go in that direction.");
				}
				else throw new Exception("\nI do not know what you mean.");
		
		return value;
	}
	
	/**
	 * Sets current cell       
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 */
	public void setCell()
	{
		currentCell = dungeon[currentHeight][currentWidth];
	}
	
	/**
	 * Returns current cell   
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @return
	 */
	public Cell getCell()
	{
		return currentCell;
	}
	
	/**
	 * Determines if weapon will be spawned in cell       
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @return weapon, the weapon to be spawned, null if no weapon
	 */
	public Weapon determineWeapon ( )
	{
		Weapon weapon = null;
		int num = ran.nextInt(9000);
		
		if(num < 3000 && !soakerGenerated)
			{
			weapon = new SuperSoaker ();
			soakerGenerated = true;
			}
		else if(num > 3000 && num < 6000 && !crowbarGenerated)
			{
			weapon = new Crowbar ();
			crowbarGenerated = true;
			}
		else if (num > 6000 && !hamGenerated)
			{
			weapon = new Ham ();
			hamGenerated = true;
			}
		
		return weapon;
	}
	
	
	/**
	 * Determines if monster is to be spawned in cell        
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @return monster, the monster to be spawned, null if no monster
	 */
	public Monster determineMonster ( )
	{
		//sets up null monster
		Monster monster = null;
		
		//determines if monster will appear
		int num = ran.nextInt (10000);
		if(num < 5000)
		{
			//determines type of monster if monster is still alive
			num = ran.nextInt(9000);
			if(num < 3000 && !swiftSpawned)
				{
				monster = new Swift ();
				swiftSpawned = true;
				}
			else if(num > 3000 && num < 6000 && !cyrusSpawned)
				{
				monster = new Cyrus ();
				cyrusSpawned = true;
				}
			else if(num > 6000 && !bieberSpawned)
				{
				monster = new Bieber ();
				bieberSpawned = true;
				}
		}	
		return monster;
	}
	
	public String toString()
	{
		String message = "";					//holds the dungeon string
		String name = "";							//holds name of weapon
		String title = "";							//holds name of monster
		String output = "\n\n";								//holds the string to be output
		
		for(int i = 0; i < dungeonHeight; i++)
		{
			for(int j = 0; j < dungeonWidth; j++)
			{
				message = "";
				Weapon w = dungeon[i][j].getWeapon ( );
				if(w != null)
					name = w.getName ( );
				else
					name = "";
				Monster m = dungeon[i][j].getMonster ( );
				if(m != null)
					title = m.getTitle ( );
				else
					title = "";
				
				if(i == currentHeight && j == currentWidth)
					message += "[P";
				else
					message += "[";
				if(title.equals ("Justin Bieber"))
					message += "_B";
				if(title.equals ("Taylor Swift"))
					message += "_S";
				if(title.equals ("Miley Cyrus"))
					message += "_C";
				if(name.equals ("Crowbar"))
					message += "_R";
				if(name.equals ("Country Ham"))
					message += "_H";
				if(name.equals ("Super Soaker"))
					message += "_S";
				if(message.equals ("["))
					message += "__]";
				else
					message += "] ";
				output += message;
			}
			output += "\n";
		}
		return output;
	}
	
}


