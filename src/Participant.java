/**
 * ---------------------------------------------------------------------------
 * File name: Participant.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Koi Stephanos, stephanos@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 12, 2014
 * ---------------------------------------------------------------------------
 */

/**
 * To provide general traits for all characters in game
 *
 * <hr>
 * Date created: Nov 12, 2014
 * <hr>
 * @author Koi Stephanos
 */
public abstract class Participant
{
	protected String title;				//title of unit
	protected int damage;				//unit damage
	protected int health;				//unit health
	protected Boolean isDead;			//unit's life status
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Nov 12, 2014 
	 *
	 * 
	 */
	Participant ( )
	{
		
	}
}
