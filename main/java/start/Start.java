package start;

import java.sql.SQLException;
import java.util.logging.Logger;

import BusinessLogic.Controller;
import presentation.View;


/**
 * @Author: Bretea Vlad
 *          
 * @Since: April 30, 2023
 */
public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException {

		View view=new View();
		view.setVisible(true);
		Controller controller=new Controller(view);
		

	}

}
