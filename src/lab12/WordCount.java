/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 27, 2019
* Time: 8:16:02 PM
*
* Project: csci205
* Package: lab12
* File: WordCount
* Description:
*
* ****************************************
 */
package lab12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author mag051
 */
public class WordCount {

    private String filename;

    private File file;

    private int byteCount;

    private int newLineCount;

    private int wordCount;

    public WordCount(String filename) {
        this.filename = filename;
        this.byteCount = 0;
        this.wordCount = 0;
        this.newLineCount = 0;
    }

    public WordCount(File file) {
        this.file = file;
        this.byteCount = 0;
        this.wordCount = 0;
        this.newLineCount = 0;
    }

    /**
     * Return number of words in file.
     *
     * @param filename is name of file to read (full path/accessible)
     * @return number of words in file
     */
    public void doIt() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(this.filename));

        String line, word;
        while ((line = input.readLine()) != null) {
            this.byteCount += line.getBytes().length;
            this.newLineCount += 1;
            StringTokenizer tokens = new StringTokenizer(line);
            while (tokens.hasMoreTokens()) {
                this.wordCount++;
                word = tokens.nextToken();
            }
        }
    }

    @Override
    public String toString() {
        return this.newLineCount + "   " + this.wordCount + "   " + this.byteCount + "   " + this.filename;
    }

}
