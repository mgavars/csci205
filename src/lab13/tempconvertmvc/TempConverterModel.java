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
package lab13.tempconvertmvc;

import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author mag051
 */
public class TempConverterModel {

    private SimpleBooleanProperty propDoFtoC;
    private SimpleBooleanProperty propDoCtoF;

    public String FStringToC(String sFTemp) {
        double farenTemp = Double.parseDouble(sFTemp);
        farenTemp = farenTemp * (9.0 / 5) - 32.0;
        String celsiusTemp = String.format("%.1f C", farenTemp);
        return celsiusTemp;
    }

    public String CStringToF(String sCTemp) {
        double celsiusTemp = Double.parseDouble(sCTemp);
        celsiusTemp = celsiusTemp * (9.0 / 5) + 32.0;
        String farenTemp = String.format("%.1f F", celsiusTemp);
        return farenTemp;
    }

    public TempConverterModel() {
        this.propDoFtoC = new SimpleBooleanProperty(true);
        this.propDoCtoF = new SimpleBooleanProperty(false);

    }

    public String stringConvert(String temp) {
        if (propDoFtoC.get()) {
            return this.FStringToC(temp);

        }
        if (propDoCtoF.get()) {
            return this.CStringToF(temp);
        }
        return temp;
    }

    public SimpleBooleanProperty getPropDoFtoC() {
        return propDoFtoC;
    }

    public SimpleBooleanProperty getPropDoCtoF() {
        return propDoCtoF;
    }

}
