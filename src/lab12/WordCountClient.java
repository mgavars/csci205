/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 27, 2019
* Time: 9:02:10 PM
*
* Project: csci205
* Package: lab12
* File: WordCountClient
* Description:
*
* ****************************************
 */
package lab12;

import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author mag051
 */
public class WordCountClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        JFileChooser chooser = new JFileChooser(".");
        String filename = null;
        int chooseVal = chooser.showOpenDialog(null);
        if (chooseVal == JFileChooser.APPROVE_OPTION) {
            filename = chooser.getSelectedFile().getPath();
        }
        else {
            System.exit(0);
        }
        WordCount wc = new WordCount(filename);
        wc.doIt();
        while (JOptionPane.showConfirmDialog(null,
                                             wc.toString() + "\nTry Again?",
                                             "Word Counter",
                                             JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            chooser = new JFileChooser(".");
            filename = null;
            chooseVal = chooser.showOpenDialog(null);
            if (chooseVal == JFileChooser.APPROVE_OPTION) {
                filename = chooser.getSelectedFile().getPath();
            }
            else {
                System.exit(0);
            }
            wc = new WordCount(filename);
            wc.doIt();
        }
        JOptionPane.showMessageDialog(null, "Goodbye!");
        System.exit(0);

    }

}
