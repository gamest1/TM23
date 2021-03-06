package ca.concordia.game.model;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

import ca.concordia.game.common.common.Colors;

/**
 * Class Area contains the possible object that could be available to an area.
 * 
 * @author Pascal Maniraho 
 * @author Gustavo Pereira
 * @author Bhavik Desai 
 * @author Jesus Esteban Garro Matamoros 
 * @author Diego Pizarro
 */

public class Area {
	
	private CityCard cityCard;//A city card belongs to an Area.
	private ArrayList<Piece> minions;
	private boolean troubleMarker;
	private boolean building;
	private Colors buildingColor;
	private int demon;
	private int troll;
	
	

	/**
	 * Constructor for new game.
	 * @param cityCard
	 */
	public Area(CityCard cityCard)
	{
		this.cityCard=cityCard;
		this.troubleMarker=false;
		this.building=false;
		this.buildingColor=Colors.NONE;
		this.demon=0;
		this.troll=0;
		minions= new ArrayList<Piece>();
		
	}
	

	/**
	 * Constructor for loaded game. Reset everything.
	 * @param cityCard
	 * @param troubleMarker
	 * @param building
	 * @param demon
	 * @param troll
	 */
	public Area(CityCard cityCard,boolean troubleMarker,boolean building,Colors buildingColor,int demon,int troll)
	{
		this.cityCard=cityCard;
		this.troubleMarker=troubleMarker;
		this.building=building;
		this.buildingColor=buildingColor;

		this.demon=demon;
		this.troll=troll;
		
		
		minions= new ArrayList<Piece>();
		
	}
	
	
	/**
	 * Checks if the color of a player controls the area.Returns true if it does otherwise it returns false.
	 * @param color(Colors)
	 * @return boolean
	 */
	public boolean controlsArea(Colors color)
	{
		//Map will contain the number of minions from each player currently on this area.
		Map<Colors,Integer> playerMinions=new HashMap<Colors,Integer>();
		//All possible players.
		playerMinions.put(Colors.RED, 0);
		playerMinions.put(Colors.BLUE, 0);
		playerMinions.put(Colors.YELLOW, 0);
		playerMinions.put(Colors.GREEN, 0);
		
		Colors currentColor= Colors.NONE;
		for(int i=0;i<this.minions.size();i++)
		{
			currentColor=this.minions.get(i).getColor();
			playerMinions.put(currentColor,playerMinions.get(currentColor)+1);
		}
		
		if(this.building)//if true:a building exists
			playerMinions.put(buildingColor, playerMinions.get(buildingColor)+1);
		
		//Get the entry with the maximum value in the HashMap.				
		Entry<Colors,Integer> maxEntry = null;
		for(Entry<Colors,Integer> entry : playerMinions.entrySet()) {
		    if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
		        maxEntry = entry;
		    }
		}
		
		//check if there's a player with the same number of playing pieces.
		playerMinions.remove(maxEntry.getKey());
		
		Entry<Colors,Integer> maxEntry2 = null;
		for(Entry<Colors,Integer> entry : playerMinions.entrySet()) {
		    if (maxEntry2 == null || entry.getValue() > maxEntry2.getValue()) {
		        maxEntry2 = entry;
		    }
		}
		//If two or more players have the same number of playing pieces then no one controls the area. Or if there is an equal or greater number of trolls 
		//than player pieces in the current area then there's no control of the area.
		if(maxEntry.getValue() == maxEntry2.getValue() || maxEntry.getValue()< this.demon) 
		{
			return false;
		}
		//Check if the color of the player being checked is the same as the one that has the most playing cards on the area.
		if(maxEntry.getKey()==color)
			return true;
		else
			return false;
		
	}
	

	/**
	 * Getter
	 * @return CityCard
	 */
	public CityCard getCityCard()
	{
		return this.cityCard;
	}
	/**
	 * Getter
	 * @return boolean
	 */
	public boolean getTroubleMarker()
	{
		return this.troubleMarker;
	}
	/**
	 * Getter
	 * @return boolean
	 */
	public boolean getBuilding()
	{
		return this.building;
	}
	/**
	 * Getter
	 * @return int
	 */
	public int getDemon()
	{
		return this.demon;
	}
	/**
	 * Getter
	 * @return int
	 */
	public int getTroll()
	{
		return this.troll;
	}
	/**
	 * Getter
	 * @return ArrayList<Piece>
	 */
	public ArrayList<Piece> getMinions()
	{
		return this.minions;
	}

	/**
	 * Getter
	 * @return Colors
	 */
	public Colors getBuildingColor()
	{
		return this.buildingColor;
	}

	/**
	 * 
	 * toString method for Area Class.
	 */
	@Override
	public String toString()
	{
		String info="Area Name: "+ this.cityCard.getName()+" ." + " Trouble Marker: "+this.troubleMarker+". Building: "+this.building+" .";
		info= info+ " Demons: "+this.demon+ ". Trolls: "+this.troll +" .\n";
		String info2="Minions in current area: \n";
		
		for(int i=0;i<this.minions.size();i++)
		{
			info2=info2+ this.minions.get(i).toString()+", ";
		}
		info2=info2+"\n\n";
		return info+info2;
	}
	

	/**
	 * Add a minion to area
	 * @param minion
	 */
	public void addMinion(Piece minion)
	{
		this.minions.add(minion);
	}
	

	/**
	 * Add a minion to area
	 * @param minion
	 */
	public void removeMinion(Piece minion)
	{
		this.minions.remove(minion);
	}
	
	/**
	 * Add troubleMarker to area if possible(Only one trouble marker is allowed per area). Return true if successful else return false.
	 * @return
	 */
	public boolean addTroubleMarker(){
		if(this.troubleMarker==false ){
			//There's no trouble marker on this area.
			this.troubleMarker=true;
			return true;
		}else{
			//A trouble marker already exists on this area.
			return false;
		}
	}
	

	/**
	 * remove troubleMarker to area if possible(Only one trouble marker is allowed per area). Return true if successful else return false.
	 * @return
	 */
	public boolean removeTroubleMarker()
	{
		if(this.troubleMarker==true )//There's no trouble marker on this area.
		{
			this.troubleMarker=false;
			return true;
		}else
		{//A trouble marker already exists on this area.
			return false;
		}
	}
	

	/**
	 * Add Building to area if possible(Only one Bulding  is allowed per area). Also set the color of the building.
	 * @return
	 */
	public boolean addBuilding(Player player)
	{
		if(this.building==false)//There's no trouble marker on this area.
		{
			this.building=true;
			this.buildingColor=player.getColor();
			return true;
		}else
		{//A trouble marker already exists on this area.
				return false;
		}
	}
	

	/**
	 * Add Bulding to area if possible(Only one Bulding is allowed per area). Return true if successful else return false.
	 * @return
	 */
	public boolean removeBuilding()
	{
		if(this.building==true)//There's no trouble marker on this area.
		{
			this.building=false;
			return true;
		}else
		{//A trouble marker already exists on this area.
				return false;
		}
	}
	

	/**
	 * Add or remove demon to area. If the argument is 1 then it will add a demon else if it is 2 it will remove a demon if possible.
	 * Will return a boolean depending on weather the action was successful
	 * @param addRemove
	 * @return boolean
	 */
	public boolean addRemoveDemon(int addRemove)
	{
		if(addRemove==1)//add demon
		{
			this.demon++;
			return true;
		}else if (addRemove==2)//remove demon if possible
		{
			if(this.demon >0)
			{
				this.demon--;
				return true;
			}else
				return false;
		}
		return false;
	}
	

	/**
	 * Add or remove troll to area. If the argument is 1 then it will add a troll else if it is 2 it will remove a troll if possible.
	 * Will return a boolean depending on weather the action was successful
	 * @param addRemove
	 * @return boolean
	 */
	public boolean addRemoveTroll(int addRemove){
		if( addRemove == 1 ){
			//add troll
			this.troll++;
			return true;
			//remove troll if possible
		}else if ( addRemove == 2 ){
			if( this.troll > 0 ){
				this.troll--;
				return true;
			}else{
				return false;
			} 
		}
		return false;
	}

}
