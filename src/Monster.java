/**
 * ---------------------------------------------------------------------------
 * File name: Monster.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Koi Stephanos, stephanos@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 12, 2014
 * ---------------------------------------------------------------------------
 */

/**
 * Provides construct for more specific monsters
 *
 * <hr>
 * Date created: Nov 12, 2014
 * <hr>
 * @author Koi Stephanos
 */
public class Monster extends Participant
{
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Nov 12, 2014 
	 *
	 * 
	 */
	public Monster ( )
	{
		super ( );
		//provides specific monster qualities
		title = "Monster";
		damage = 4;
		health = 100;
		isDead = false;
	}
	
	/**
	 * Returns monster's damage        
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
	 * Return's the title of the monster        
	 *
	 * <hr>
	 * Date created: Nov 12, 2014
	 *
	 * <hr>
	 * @return title
	 */
	public String getTitle ( )
	{
		return title;
	}
	
	/**
	 * Returns monster's current health        
	 *
	 * <hr>
	 * Date created: Nov 12, 2014
	 *
	 * <hr>
	 * @return health
	 */
	public int getHealth ( )
	{
		return health;
	}
	
	
}
