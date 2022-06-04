import jason.environment.grid.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class RestaurantView extends GridWorldView{
	RestaurantModel rmodel;

    public RestaurantView(RestaurantModel model){
        super(model,"Restaurant",700);
        rmodel=model;
        defaultFont = new Font("Arial", Font.BOLD, 16);
        setVisible(true);
        repaint();
    }
	
	 /** draw application objects */
    @Override
    public void draw(Graphics g, int x, int y, int object) {
		g.setColor(Color.red);
		drawKitchen(g,x,y);
		switch(object){
			case RestaurantModel.TABLE1:
				super.drawObstacle(g,x,y);
				g.setColor(Color.white);
				super.drawString(g, x, y, defaultFont, "Table1");
				break;
			case RestaurantModel.TABLE2:
				super.drawObstacle(g,x,y);
				g.setColor(Color.white);
				super.drawString(g, x, y, defaultFont, "Table2");
				break;
			case RestaurantModel.TABLE3:
				super.drawObstacle(g,x,y);
				g.setColor(Color.white);
				super.drawString(g, x, y, defaultFont, "Table3");
				break;
			case RestaurantModel.TABLE4:
				super.drawObstacle(g,x,y);
				g.setColor(Color.white);
				super.drawString(g, x, y, defaultFont, "Table4");
				break;
			case RestaurantModel.TABLE5:
				super.drawObstacle(g,x,y);
				g.setColor(Color.white);
				super.drawString(g, x, y, defaultFont, "Table5");
				break;
		}
	}
	
	@Override
	public void drawAgent(Graphics g, int x, int y, Color c, int id){
		String label="tmp";
		c= Color.yellow;
		
		switch(id){
			case 0:
				label="Waiter1";
				c=Color.yellow;
				break;
			case 1:
				label="Waiter2";
				c=Color.yellow;
				break;
			case 2:
				label="Waiter3";
				c=Color.yellow;
				break;
			/*default:
				label="Table"+(id-2);
				c=Color.red;*/
				
		}
		
        super.drawAgent(g,x,y,c,-1);
        g.setColor(Color.black);
        super.drawString(g, x, y, defaultFont, label);
	}
	
	
	public void drawKitchen(Graphics g, int x, int y){
	g.setColor(Color.pink);
	g.fillRect( 0, 601, 700, 65);
	}
}
