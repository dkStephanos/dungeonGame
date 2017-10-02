/**
 * ---------------------------------------------------------------------------
 * File name: Player.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Koi Stephanos, stephanos@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 12, 2014
 * ---------------------------------------------------------------------------
 */

/**
 * To provide methods and attributes specific to the Player character 
 *
 * <hr>
 * Date created: Nov 12, 2014
 * <hr>
 * @author Koi Stephanos
 */
public class Player extends Participant
{
	
	Weapon weapon = new Weapon ();			//the player's currently equipped weapon
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Nov 12, 2014 
	 *
	 * 
	 */
	public Player ( )
	{
		title = "Lord of Ham";
		damage = 5;
		health = 100;
		isDead = false;
		weapon = null;
	}
	
	/**
	 * Gets the currently equipped weapon      
	 *
	 * <hr>
	 * Date created: Nov 12, 2014
	 *
	 * <hr>
	 * @return weapon, the current weapon
	 */
	public Weapon getWeapon ( )
	{
		return weapon;
	}
	
	/**
	 * Sets the current weapon to the passed weapon         
	 *
	 * <hr>
	 * Date created: Nov 12, 2014
	 *
	 * <hr>
	 * @param w, the weapon to be set
	 */
	public void setWeapon (Weapon w)
	{
		weapon = w;
	}
	
	/**
	 * Returns current player health         
	 *
	 * <hr>
	 * Date created: Nov 12, 2014
	 *
	 * <hr>
	 * @return health, the player's remaining health
	 */
	public int getHealth ()
	{
		return health;
	}
	
	/**
	 * Sets current player health       
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @param health, the new health to be set
	 */
	public void setHealth (int health)
	{
		this.health = health;
	}

}
