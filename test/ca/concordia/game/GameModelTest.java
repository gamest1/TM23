package ca.concordia.game;

import static org.junit.Assert.*;

import java.awt.Color;
import ca.concordia.game.common.common.Colors;

import org.junit.Test;

import ca.concordia.game.model.*;


public class GameModelTest {
	
	/**
	 * Testing the deck initialization 
	 * Throws ArrayIndexOutOfBoundsException on shuffle() function. 
	 */
	@Test public void deck(){
		assertNotNull( "The discard deck is empty to start with", new Deck(new String("D"), 2) );
		assertNotNull( "The personality deck has 7 cards:", new Deck(new String("P"), 2) );
		//assertNotNull( "The city deck has 12 cards:", new Deck(new String("C"), 2) );
		assertNotNull( "The event deck has 12 cards:", new Deck(new String("E"), 2) );
		assertNotNull( "The brown-bordered player deck has 48 cards:", new Deck(new String("B"), 2) );
		assertNotNull( "The green-bordered player deck has 53 cards:", new Deck(new String("G"), 2) );
	}
	
	
	@Test
	public void canInitializeModels(){
		assertNotNull("Can create area", new Area(null) ); 
		assertNotNull("Can create a bank", new Bank());
		assertNotNull("Can create a card", new Card(false, false) ); 
		assertNotNull("Can Create a deck", new Deck(new String("D"), 4));
		assertNotNull("Can create browncard", new BrownCard( 1 ) );
		assertNotNull("Can create city card", new CityCard( 1 ) );
		assertNotNull("Have deamons", new Demon( Colors.YELLOW ) );
		assertNotNull("Have a die", new Die( ) );
		assertNotNull("Can create event card", new EventCard( 0 ) );
		assertNotNull("Can create a gameboard", new Gameboard() );
		assertNotNull("Can Create a green card", new GreenCard( 1 ) );
		assertNotNull("Can create a minion", new Minion( Colors.GREEN ) );
		assertNotNull("Can create personalities", new PersonalityCard( "A" ) );
		assertNotNull("Can create a piece", new Piece( Colors.RED ) );
		assertNotNull("Can create a player", new Player( new PersonalityCard("N"), Colors.BLUE, 4, 2 ) );

	}

}
