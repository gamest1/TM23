package ca.concordia.game.model;

<<<<<<< HEAD
import java.util.ArrayList;

=======
>>>>>>> 199818afe8100991ffae794dbcebaff5513bca99
/**
 * Brown card is a type of Card. for this version of the system it contains a unique number and the color Brown for all cards of this type.
 * @author Pascal,Gustavo,bhavik,Esteban,Diego
 *
 */

public class BrownCard extends Card {
	
	private String color;
	private int number;
<<<<<<< HEAD
	private String name;
	private ArrayList<Symbol> symbols;
	private Action especialAbility;
=======
>>>>>>> 199818afe8100991ffae794dbcebaff5513bca99
	
	/**
	 * Constructor
	 * @param i
	 */
	public BrownCard(int i) {
		//City Cards are always Visible!
		super(false,false);
		
		this.color="BROWN";
		this.number=i;
		//Handle 53 cases:
		switch(i) {
			
		}
	}
	
	/**
	 * Getter
	 * @return
	 */
	public int getNumber()
	{
		return this.number;
	}
}
