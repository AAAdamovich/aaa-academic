/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-112 - Community College of Philadelphia (CCP)
*  Created: 5-4-2017 - Last Edited: 5-5-2017
*  Assignment 8
*  Description: Program primarily contains the FXML controller for the "Convert"
*   button handler. Aritmetic of conversion operations happens here and the
*   output is sent and displayed in each text box each time the "Convert" button
*   is pressed
*  Resources:
*   The Java Platform API Specification:
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*   Oracle Java FX Tutorials and Documentation:
*   http://docs.oracle.com/javase/8/javafx/get-started-tutorial/get_start_apps.htm
*   I used Wikipedia to find my conversion constants, not interested in precisison:
*   https://en.wikipedia.org/wiki/Pounds_per_square_inch 
*/

package pressureunitconverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
 
public class FXMLController {
    
    // FXML variables, declared in .fxml document
    
    @FXML
    private TextField psi;
    
    @FXML
    private TextField bar;
    
    @FXML
    private TextField mmhg;

    // Handler for conversion and text box update actions when the "Convert"
    // button is pressed
    @FXML
    private void handleConversionAction(ActionEvent event) {
        
        // Conversion values
        final double MMHG_IN_PSI = 51.71493;
        final double PSI_IN_BAR = 14.5038;
        // The number values for what is extracted from the user input text boxes
        double psiValue = 0.0;
        double barValue = 0.0;
        double mmhgValue = 0.0;
        
        // Extraction procedure to obtain PSI value from user input text box
        try{
            psiValue = Double.parseDouble(psi.getText());
        }
        // Try/Catch block is used to prevent entry of non-number characters
        catch(NumberFormatException | NullPointerException e){
            // In the event a non-number character is detected, program sets all
            // parameters to zero, and invalid input is erased
            psi.setText("0.0");
            psiValue = 0.0;
        }
        // Arithmetic conversion process using constant values
        mmhgValue = (psiValue * MMHG_IN_PSI);
        barValue = (psiValue / PSI_IN_BAR);
        // Update the two result text boxes with converted values
        bar.setText(Double.toString(barValue));
        mmhg.setText(Double.toString(mmhgValue));
    }
}
