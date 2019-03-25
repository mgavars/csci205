/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Mar 24, 2019
* Time: 9:28:41 PM
*
* Project: csci205
* Package: gui.tempconvertermvc
* File: TempConverterModel
* Description:
*
* ****************************************
 */
package gui.tempconvertermvc;

/**
 *
 * @author mag051
 */
public class TempConverterModel {

    public String FStringToC(String sFTemp) {
        double farenTemp = Double.parseDouble(sFTemp);
        farenTemp = farenTemp * (9.0 / 5) - 32.0;
        String celsiusTemp = String.format("%.1f C", farenTemp);
        return celsiusTemp;
    }

}
