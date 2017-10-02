import java.util.Random;

/**
 * ---------------------------------------------------------------------------
 * File name: Cell.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Koi Stephanos, stephanos@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 13, 2014
 * ---------------------------------------------------------------------------
 */

/**
 * To provide formatted cells for the Dungeon class
 *
 * <hr>
 * Date created: Nov 13, 2014
 * <hr>
 * @author Koi Stephanos
 */
public class Cell
{
	private Monster monster = new Monster();					//the monster in the cell
	private Weapon weapon = new Weapon();						//the weapon in the cell
	private Boolean bieberDead = false;							//if bieber has died
	private Boolean swiftDead = false;							//if swift has died
	private Boolean cyrusDead = false;							//if cyrus has died
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Nov 13, 2014 
	 *
	 * 
	 */
	public Cell ()
	{
	
	}
	

	/**
	 * Returns the weapon in the cell        
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @return weapon, null if no weapon present
	 */
	public Weapon getWeapon() 
	{
		return weapon;
	}
	
	/**
	 * Sets a new weapon in the cell        
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @param w, the weapon to be set
	 */
	public void setWeapon(Weapon w)
	{
		weapon = w;
	}
	
	/**
	 * Sets a new monster in the cell        
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @param m, the monster to be set
	 */
	public void setMonster(Monster m)
	{
		monster = m;
	}
	/**
	 * Returns the monster in the cell        
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @return monster, null if no monster present
	 */
	public Monster getMonster ()
	{
		if(monster != null)
		{
			String title = monster.getTitle ( );
			if(title.equals ("Justin Bieber") && !bieberDead)
				return monster;
			else if(title.equals ("Taylor Swift") && !swiftDead)
				return monster;
			else if(title.equals ("Miley Cyrus") && !cyrusDead)
				return monster;
		}	
		return monster;
	}
	
	/**
	 * Kills the monster in the cell        
	 *
	 * <hr>
	 * Date created: Nov 13, 2014
	 *
	 * <hr>
	 * @param m, the monster to be killed
	 */
	public void killMonster (Monster m)
	{
		String title = m.getTitle ( );
		
		if(title.equals ("Justin Bieber"))
			bieberDead = true;
		if(title.equals ("Miley Cyrus"))
			cyrusDead = true;
		if(title.equals ("Taylor Swift"))
			swiftDead = true;
	}
	
}
