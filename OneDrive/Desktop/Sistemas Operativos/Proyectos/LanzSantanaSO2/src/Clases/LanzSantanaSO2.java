/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;
import Interfaz.ApplicationWindow;

/**
 *
 * @author Abraham Santana
 */
public class LanzSantanaSO2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationWindow appWindow = new ApplicationWindow();
        AI ai = new AI(appWindow);
        Administrator admin = new Administrator(ai, appWindow);
        admin.start();
        java.awt.EventQueue.invokeLater(new Runnable()  {
            public void run() {
                appWindow.setVisible(true);
            }
        });
    
    }
    
}
