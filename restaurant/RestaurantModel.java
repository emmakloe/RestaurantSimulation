import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;
import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import java.util.logging.*;
import jason.environment.grid.Location;
import java.util.Random;

public class RestaurantModel extends GridWorldModel{
	
	public static final int TABLE1=8;
    public static final int TABLE2=16;
	public static final int TABLE3=32;
	public static final int TABLE4=64;
	public static final int TABLE5=128;
	
	
	//grid size
    public static final int gridsizeX=11;
	public static final int gridsizeY=11;

    Location locationT1 = new Location(10,5);
    Location locationT2 = new Location(9,2);
	Location locationT3 = new Location(6,0);
	Location locationT4 = new Location(3,2);
	Location locationT5 = new Location(0,5);
	
	Location locationR1 = new Location(7,9);
	Location locationR2 = new Location(5,9);
	Location locationR3 = new Location(2,9);
	
	
	Location lTable1 = new Location(locationT1.x,locationT1.y);
	Location lTable2 = new Location(locationT2.x,locationT2.y);
	Location lTable3 = new Location(locationT3.x,locationT3.y);
	Location lTable4 = new Location(locationT4.x,locationT4.y);
	Location lTable5 = new Location(locationT5.x,locationT5.y);
	
	Location homelocationR1 = new Location(7,9);
	Location homelocationR2 = new Location(5,9);
	Location homelocationR3 = new Location(2,9);
	
	
	int chewCounts[]={0,0,0,0,0};
	boolean carryingOrder[]={false,false,false,false,false};
	int trying = 0;

	
	private Logger logger = Logger.getLogger("restaurant.mas2j."+RestaurantModel.class.getName());
	
	public RestaurantModel(){
			//gridX gridY and number of agents
			super(gridsizeX, gridsizeY, 3);
			
			setAgPos(0, locationR1);
			setAgPos(1, locationR2);
			setAgPos(2, locationR3);

			
			add(TABLE1, lTable1);
			add(TABLE2, lTable2);
			add(TABLE3, lTable3);
			add(TABLE4, lTable4);
			add(TABLE5, lTable5);
	}
	
	
	boolean moveTowards(Location destination, int robotID){
		Location robot = getAgPos(robotID);
		//int trying = 0;
		int distance = robot.distance(destination);
		
		if((robot.x < destination.x && !isFree(robot.x+1,robot.y)) || (robot.x > destination.x && !isFree(robot.x-1,robot.y))){
			trying++;
			if(trying==5 && robot.y !=0){
				robot.y--;
				trying = 0;
			}
			else if(trying==5){
				robot.y++;
				trying = 0;
			}
		}
		if((robot.y < destination.y && !isFree(robot.x,robot.y+1)) || (robot.y > destination.y && !isFree(robot.x,robot.y-1))){
			trying++;
			if(trying==5 && robot.x !=0){
				robot.x--;
				trying = 0;
			}
			else if(trying==5){
				robot.x++;
				trying = 0;
			}
		}
		if (robot.x < destination.x && isFree(robot.x+1,robot.y) && trying != 5){
			robot.x++;
		}
		else if (robot.x > destination.x && isFree(robot.x-1,robot.y) && trying != 5){
			robot.x--;
		}
        if (robot.y < destination.y && isFree(robot.x,robot.y+1) && trying != 5){
			robot.y++;
		}        
        else if (robot.y > destination.y && isFree(robot.x,robot.y-1) && trying != 5){
			robot.y--;
		}
		
		setAgPos(robotID,robot); 
		
		
		return true;	
	}

	boolean getOrder(int tableID){
		carryingOrder[tableID] = true;
		return true;
	}
	
	boolean handInOrder(int tableID){
		if(carryingOrder[tableID]){
			chewCounts[tableID] = 10;
			carryingOrder[tableID]=false;
			return true;
		}
		else{
			return false;
		}
	}
	
	boolean chewCount(int tableID){
		if(chewCounts[tableID] > 0){
			chewCounts[tableID] -= 1;
			return true;
		}
		else{
			return false;
		}
	}
	
	boolean pay(){
	 return true;
	}
	
	
	int getDistance(int table, int robotID){
		int result=0;
		if(robotID==0){
			switch (table){
				case 1:
					result = locationR1.distance(lTable1);
					break;
				case 2:
					result = locationR1.distance(lTable2);
					break;
				case 3:
					result = locationR1.distance(lTable3);
					break;
				case 4:
					result = locationR1.distance(lTable4);
					break;
				case 5:
					result = locationR1.distance(lTable5);
					break;
			}	
		}
		else if(robotID == 1){
			switch (table){
				case 1:
					result = locationR2.distance(lTable1);
					break;
				case 2:
					result = locationR2.distance(lTable2);
					break;
				case 3:
					result = locationR2.distance(lTable3);
					break;
				case 4:
					result = locationR2.distance(lTable4);
					break;
				case 5:
					result = locationR2.distance(lTable5);
					break;
			}	
		}
		else if(robotID == 2){
			switch (table){
				case 1:
					result = locationR3.distance(lTable1);
					break;
				case 2:
					result = locationR3.distance(lTable2);
					break;
				case 3:
					result = locationR3.distance(lTable3);
					break;
				case 4:
					result = locationR3.distance(lTable4);
					break;
				case 5:
					result = locationR3.distance(lTable5);
					break;
			}	
		}
		return result;
	}
}
