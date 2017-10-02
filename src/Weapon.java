/**
 * ---------------------------------------------------------------------------
 * File name: Weapon.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Koi Stephanos, stephanos@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 12, 2014
 * ---------------------------------------------------------------------------
 */

/**
 * Provides basic traits and methods for all weapons
 *
 * <hr>
 * Date created: Nov 12, 2014
 * <hr>
 * @author Koi Stephanos
 */
public class Weapon
{
	protected int damage;							//holds the weapon damage
	protected String name;							//holds weapon name
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Nov 12, 2014 
	 *
	 * 
	 */
	Weapon ( )
	{
		damage = 5;
		name = "Fists";
	}
	
	/**
	 * Returns weapon damage       
	 *
	 * <hr>
	 * Date created: Nov 12, 2014
	 *
	 * <hr>
	 * @return damage
	 */
	public int getDamage ( )
	{
		return damage;
	}
	
	/**
	 * Returns name of weapon       
	 *
	 * <hr>
	 * Date created: Nov 12, 2014
	 *
	 * <hr>
	 * @return name
	 */
	public String getName ( )
	{
		return name;
	}
}
