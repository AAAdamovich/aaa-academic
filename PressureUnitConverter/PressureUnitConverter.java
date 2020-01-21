/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-112 - Community College of Philadelphia (CCP)
*  Created: 5-2-2017 - Last Edited: 5-5-2017
*  Assignment 8
*  Description: Program displays a GUI (Graphical User Interface) with the 
*   purpose of converting a unit of pressure (PSI, Pounds per Squre Inch) to a 
*   few other commonly used units of pressure, such as bar and mmHg (Milligrams
*   of Mercury)
*  Resources:
*   The Java Platform API Specification:
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*   Oracle Java FX Tutorials and Documentation:
*   http://docs.oracle.com/javase/8/javafx/get-started-tutorial/get_start_apps.htm
*/

package pressureunitconverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PressureUnitConverter extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        // Size of GUI dialog box (width by height)
        Scene scene = new Scene(root, 500, 250);
        // Window title of GUI dialog box, NOT in-GUI title!
        stage.setTitle("Pressure Unit Converter - JavaFXML");
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}