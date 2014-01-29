/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ssssssnake.duell;

import environment.ApplicationStarter;
import image.ResourceTools;

/**
 *
 * @author user
 */
public class SsssssnakeDuell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        start();
        // TODO code application logic here
    }

    private static void start() {
        ApplicationStarter.run("Snake Express", new SnakeEnvironment());
    }
}
