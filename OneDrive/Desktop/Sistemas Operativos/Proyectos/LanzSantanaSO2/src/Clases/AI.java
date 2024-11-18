/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Interfaz.ApplicationWindow;
import java.util.Random;
import java.awt.Image;
/**
 *
 * @author santi
 */
public class AI extends Thread {
    
    List fightStarTrek = new List();
    List fightStarWars = new List();
    public static List Winners = new List();
    
    StarWars starwars = new StarWars();
    StarTrek startrek = new StarTrek();
    
    String estado = Acciones();
    
    public static int WinnerSW = 0;
    public static int WinnerST = 0;

    Administrator admin;
    ApplicationWindow applicationWindow;

    public AI(ApplicationWindow applicationWindow) {
        this.admin = new Administrator(this, applicationWindow);
        this.applicationWindow = applicationWindow;
    }

    int cicle = 0;
    
    @Override
    public void run() {
        admin.start();
    }
    
    
                                 //StarTrek          //StarWars
     public synchronized void Pelea(Characters characters1, Characters characters2) {
         System.out.println("Pelea method called with characters: " + characters1.getName() + " and " + characters2.getName());
         fightStarTrek.insertBegin(characters1);
         fightStarWars.insertBegin(characters2);
         
         cicle++;
         
        Image character1Photo = characters1.getPhoto();
        Image character2Photo = characters2.getPhoto();
        applicationWindow.updateWinnerCount(getWinnerSW(), getWinnerST());

         if (cicle % 1 == 0) {
             checkRefuerzoQueues();
         }


         if (cicle % 2 == 0){
             Random rand = new Random();
             if (rand.nextInt(100) < 80){
                 admin.addRandomCharacter();
             }
         }


         // Generate a random number between 1 and 100
         Random random = new Random();
         int randomNumber = random.nextInt(100) + 1;

         // 40% chance that the fight occurs
         if (randomNumber <= 40) {
             if (characters1.special.equals("enchufado") && (characters2.special.equals("calvo") || characters2.special.equals("malandro") || characters2.special.equals("calidoso") || characters2.special.equals("milloneta"))) {
                 Winners.insertBegin(characters1);
                 updateWinners();
                 WinnerST++;

             } else if (characters2.special.equals("enchufado") && (characters1.special.equals("calvo") || characters1.special.equals("malandro") || characters1.special.equals("calidoso") || characters1.special.equals("milloneta"))) {
                 Winners.insertBegin(characters2);
                 updateWinners();
                 WinnerSW++;

             } else if (characters1.special.equals("calvo") && (characters2.special.equals("malandro") || characters2.special.equals("calidoso") || characters2.special.equals("milloneta"))) {
                 Winners.insertBegin(characters1);
                 updateWinners();
                 WinnerST++;

             } else if (characters2.special.equals("calvo") && (characters1.special.equals("malandro") || characters1.special.equals("calidoso") || characters1.special.equals("milloneta"))) {
                 Winners.insertBegin(characters2);
                 updateWinners();
                 WinnerSW++;

             } else if (characters1.special.equals("malandro") && (characters2.special.equals("calidoso") || characters2.special.equals("milloneta"))) {
                 Winners.insertBegin(characters1);
                 updateWinners();
                 WinnerST++;

             } else if (characters2.special.equals("malandro") && (characters1.special.equals("calidoso") || characters1.special.equals("milloneta"))) {
                 Winners.insertBegin(characters2);
                 updateWinners();
                 WinnerSW++;

             } else if (characters1.special.equals("calidoso") && (characters2.special.equals("milloneta"))) {
                 Winners.insertBegin(characters1);
                 updateWinners();
                 WinnerST++;

             } else if (characters2.special.equals("calidoso") && (characters1.special.equals("milloneta"))) {
                 Winners.insertBegin(characters2);
                 updateWinners();
                 WinnerSW++;

             } else if (characters1.special.equals(characters2.special)) {
                 int randomWinner = random.nextInt(100) + 1;

                 // 50% chance to declare character1 as the winner
                 if (randomWinner <= 50) {
                     Winners.insertBegin(characters1);
                     updateWinners();
                     WinnerST++;
                 }
                 // 50% chance to declare character2 as the winner
                 else {
                     Winners.insertBegin(characters2);
                     updateWinners();
                     WinnerSW++;
                 }
             }
             // 27% chance that the fight is a draw
             else if (randomNumber <= 67) { // 40% + 27% = 67%
                 // Send both characters to the end of the priority1 queue
                 starwars.priority1SW.enqueue(characters1);
                 startrek.priority1ST.enqueue(characters2);
             }
             // 33% chance that the fight doesn't happen
             else {
                 // Send both characters to the refuerzoA queue
                 starwars.refuerzoSW.enqueue(characters1);
                 startrek.refuerzoST.enqueue(characters2);
             }

             fightStarTrek.deleteBegin();
             fightStarWars.deleteBegin();
             System.out.println("Amount of winners from Star Wars: " + WinnerSW);
             System.out.println("Amount of winners from Star Trek: " + WinnerST);



         }

     }
     
     private void checkRefuerzoQueues() {
        System.out.println("checkRefuerzoQueues method called");
        Random rand = new Random();

        // Check the refuerzoSW queue
        if (!starwars.refuerzoSW.isEmpty()) {
            Characters character = (Characters) starwars.refuerzoSW.dequeue().getElement();
            if (rand.nextInt(100) < 40) {
                // 40% chance to move the character to the priority1SW queue
                starwars.priority1SW.enqueue(character);
            } else {
                // If they fail, they go to the last place of the refuerzoSW queue
                starwars.refuerzoSW.enqueue(character);
            }
        } 
        
        // Check the refuerzoST queue
        if (!startrek.refuerzoST.isEmpty()) {
            Characters character = (Characters) startrek.refuerzoST.dequeue().getElement();
            if (rand.nextInt(100) < 40) {
                // 40% chance to move the character to the priority1ST queue
                startrek.priority1ST.enqueue(character);
            } else {
                // If they fail, they go to the last place of the refuerzoST queue
                startrek.refuerzoST.enqueue(character);
            }
        }
    }
     
     public String Acciones(){
        if(fightStarWars.getSize() == 0 || fightStarTrek.getSize() == 0){
            return "AI: Peleando";
        } else{
            return "AI: Decidiendo"; 
        }
    }
     
     public String getWinnersString() {
        StringBuilder winnersString = new StringBuilder();
        Node current = Winners.getHead();
        while (current != null) {
            Characters character = (Characters) current.getElement();
            winnersString.append(character.getName()).append("\n");
            current = current.getNext();
        }
        return winnersString.toString();
    }
     public void updateWinners() {
        applicationWindow.updateWinners(getWinnersString());
    }

    public int getWinnerSW() {
        return WinnerSW;
    }

    public int getWinnerST() {
        return WinnerST;
    }

    public List getWinners() {
        return Winners;
    }
}



