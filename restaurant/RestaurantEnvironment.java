// Environment code for project restaurant.mas2j
//HASZNÁLT FORRÁS: DOMESTIC ROBOT EXAMPLE

import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import java.util.logging.*;
import jason.environment.grid.Location;


                         
import java.util.logging.*;


public class RestaurantEnvironment extends Environment {
	
	  public static final Literal at11 = Literal.parseLiteral("at(robot1,table1)");
	  public static final Literal at12 = Literal.parseLiteral("at(robot1,table2)");
	  public static final Literal at13 = Literal.parseLiteral("at(robot1,table3)");
	  public static final Literal at14 = Literal.parseLiteral("at(robot1,table4)");
	  public static final Literal at15 = Literal.parseLiteral("at(robot1,table5)");
	  
	  public static final Literal at21 = Literal.parseLiteral("at(robot2,table1)");
	  public static final Literal at22 = Literal.parseLiteral("at(robot2,table2)");
	  public static final Literal at23 = Literal.parseLiteral("at(robot2,table3)");
	  public static final Literal at24 = Literal.parseLiteral("at(robot2,table4)");
	  public static final Literal at25 = Literal.parseLiteral("at(robot2,table5)");
	  
	  public static final Literal at31 = Literal.parseLiteral("at(robot3,table1)");
	  public static final Literal at32 = Literal.parseLiteral("at(robot3,table2)");
	  public static final Literal at33 = Literal.parseLiteral("at(robot3,table3)");
	  public static final Literal at34 = Literal.parseLiteral("at(robot3,table4)");
	  public static final Literal at35 = Literal.parseLiteral("at(robot3,table5)");
	  
	  public static final Literal ah1 = Literal.parseLiteral("at(robot1,home1)");
	  public static final Literal ah2 = Literal.parseLiteral("at(robot2,home2)");
	  public static final Literal ah3 = Literal.parseLiteral("at(robot3,home3)");
	 	  
	   public static final Literal hto1 = Literal.parseLiteral("has(table1,order)");
	   public static final Literal hto2 = Literal.parseLiteral("has(table2,order)");
	   public static final Literal hto3 = Literal.parseLiteral("has(table3,order)");
	   public static final Literal hto4 = Literal.parseLiteral("has(table4,order)");
	   public static final Literal hto5 = Literal.parseLiteral("has(table5,order)");


       private Logger logger = Logger.getLogger("restaurant.mas2j."+RestaurantEnvironment.class.getName());
	
	   RestaurantModel model;

    @Override
    public void init(String[] args) {
        model = new RestaurantModel();

        if (args.length == 1 && args[0].equals("gui")) {
            RestaurantView view  = new RestaurantView(model);
            model.setView(view);
        }
        updatePercepts();
    }

	 /** creates the agents percepts based on the RestaurantModel */
	void updatePercepts(){
        clearPercepts("robot1");
		clearPercepts("robot2");
		clearPercepts("robot3");
		clearPercepts("auctioneer");
		clearPercepts("table1");
		clearPercepts("table2");
		clearPercepts("table3");
		clearPercepts("table4");
		clearPercepts("table5");
		
		Location robot1 = model.getAgPos(0);
		Location robot2 = model.getAgPos(1);
		Location robot3 = model.getAgPos(2);
		
		
		if(model.chewCounts[0] > 0){
			addPercept("table1", hto1);
		}
		if(model.chewCounts[1] > 0){
			addPercept("table2", hto2);
		}
		if(model.chewCounts[2] > 0){
			addPercept("table3", hto3);
		}
		if(model.chewCounts[3] > 0){
			addPercept("table4", hto4);
		}
		if(model.chewCounts[4] > 0){
			addPercept("table5", hto5);
		}
		
		if (robot1.equals(model.lTable1)) {
            addPercept("robot1", at11);
        }
		 if (robot1.equals(model.lTable2)) {
            addPercept("robot1", at12);
        }
		 if (robot1.equals(model.lTable3)) {
            addPercept("robot1", at13);
        }
		if (robot1.equals(model.lTable4)) {
            addPercept("robot1", at14);
        }
		 if (robot1.equals(model.lTable5)) {
            addPercept("robot1", at15);
        }
		 if (robot1.equals(model.homelocationR1)) {
            addPercept("robot1", ah1);
			int distance = 0; 
			
			distance = model.homelocationR1.distance(model.lTable1);
			Literal dt11 = Literal.parseLiteral("distance(robot1,table1,"+distance+")");
			addPercept("robot1",dt11);
			
			distance = model.homelocationR1.distance(model.lTable2);
			Literal dt12 = Literal.parseLiteral("distance(robot1,table2,"+distance+")");
			addPercept("robot1",dt12);
			
			distance = model.homelocationR1.distance(model.lTable3);
			Literal dt13 = Literal.parseLiteral("distance(robot1,table3,"+distance+")");
			addPercept("robot1",dt13);
			
			distance = model.homelocationR1.distance(model.lTable4);
			Literal dt14 = Literal.parseLiteral("distance(robot1,table4,"+distance+")");
			addPercept("robot1",dt14);
			
			distance = model.homelocationR1.distance(model.lTable5);
			Literal dt15 = Literal.parseLiteral("distance(robot1,table5,"+distance+")");
			addPercept("robot1",dt15);
		}
		
		if (robot2.equals(model.lTable1)) {
            addPercept("robot2", at21);
        }
		 if (robot2.equals(model.lTable2)) {
            addPercept("robot2", at22);
        }
		 if (robot2.equals(model.lTable3)) {
            addPercept("robot2", at23);
        }
		if (robot2.equals(model.lTable4)) {
            addPercept("robot2", at24);
        }
		 if (robot2.equals(model.lTable5)) {
            addPercept("robot2", at25);
        }
		 if (robot2.equals(model.homelocationR2)) {
            addPercept("robot2", ah2);
			int distance = 0; 
			
			distance = model.homelocationR2.distance(model.lTable1);
			Literal dt21 = Literal.parseLiteral("distance(robot2,table1,"+distance+")");
			addPercept("robot2",dt21);
			
			distance = model.homelocationR2.distance(model.lTable2);
			Literal dt22 = Literal.parseLiteral("distance(robot2,table2,"+distance+")");
			addPercept("robot2",dt22);
			
			distance = model.homelocationR2.distance(model.lTable3);
			Literal dt23 = Literal.parseLiteral("distance(robot2,table3,"+distance+")");
			addPercept("robot2",dt23);
			
			distance = model.homelocationR2.distance(model.lTable4);
			Literal dt24 = Literal.parseLiteral("distance(robot2,table4,"+distance+")");
			addPercept("robot2",dt24);
			
			distance = model.homelocationR2.distance(model.lTable5);
			Literal dt25 = Literal.parseLiteral("distance(robot2,table5,"+distance+")");
			addPercept("robot2",dt25);
		}
		
		if (robot3.equals(model.lTable1)) {
            addPercept("robot3", at31);
        }
		 if (robot3.equals(model.lTable2)) {
            addPercept("robot3", at32);
        }
		 if (robot3.equals(model.lTable3)) {
            addPercept("robot3", at33);
        }
		if (robot3.equals(model.lTable4)) {
            addPercept("robot3", at34);
        }
		 if (robot3.equals(model.lTable5)) {
            addPercept("robot3", at35);
        }
		 if (robot3.equals(model.homelocationR3)) {
            addPercept("robot3", ah3);
			int distance = 0; 
			
			distance = model.homelocationR3.distance(model.lTable1);
			Literal dt31 = Literal.parseLiteral("distance(robot3,table1,"+distance+")");
			addPercept("robot3",dt31);
			
			distance = model.homelocationR3.distance(model.lTable2);
			Literal dt32 = Literal.parseLiteral("distance(robot3,table2,"+distance+")");
			addPercept("robot3",dt32);
			
			distance = model.homelocationR3.distance(model.lTable3);
			Literal dt33 = Literal.parseLiteral("distance(robot3,table3,"+distance+")");
			addPercept("robot3",dt33);
			
			distance = model.homelocationR3.distance(model.lTable4);
			Literal dt34 = Literal.parseLiteral("distance(robot3,table4,"+distance+")");
			addPercept("robot3",dt34);
			
			distance = model.homelocationR3.distance(model.lTable5);
			Literal dt35 = Literal.parseLiteral("distance(robot3,table5,"+distance+")");
			addPercept("robot3",dt35);
		}
		
}
	


    @Override
    public boolean executeAction(String agName, Structure action) {
		boolean result = false;
		
		if(action.getFunctor().equals("move_towards")){
			String l = action.getTerm(0).toString();
			String robot = action.getTerm(1).toString();
			int robotID = Integer.parseInt(robot);
			Location destination = null;
			
			if(l.equals("table1")){
				destination = model.lTable1;
			}
			else if(l.equals("table2")){
				destination = model.lTable2;
			}
			else if(l.equals("table3")){
				destination = model.lTable3;
			}
			else if(l.equals("table4")){
				destination = model.lTable4;
			}
			else if(l.equals("table5")){
				destination = model.lTable5;
			}
			else if(l.equals("home1")){
				destination = model.homelocationR1;
			}
			else if(l.equals("home2")){
				destination = model.homelocationR2;
			}
			else if(l.equals("home3")){
				destination = model.homelocationR3;
			}
			
			try{
				result = model.moveTowards(destination,robotID);
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
		
		else if(action.getFunctor().equals("get")){
			String table = action.getTerm(0).toString();
			int tableID = Integer.parseInt(table);
			result = model.getOrder(tableID);
		}
		
		else if(action.getFunctor().equals("hand_in")){
			String table = action.getTerm(0).toString();
			int tableID = Integer.parseInt(table);
			result = model.handInOrder(tableID);
		}
		
		else if(action.getFunctor().equals("chew")){
			String table = action.getTerm(0).toString();
			int tableID = Integer.parseInt(table);
			result = model.chewCount(tableID);
		}
		
		else if(action.getFunctor().equals("pay")){
			result = model.pay();
		}
		
		if (result) {
            updatePercepts();
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
        return result;		
    }



    /** Called before the end of MAS execution */

  /*  @Override

    public void stop() {

        super.stop();

    }*/

}


