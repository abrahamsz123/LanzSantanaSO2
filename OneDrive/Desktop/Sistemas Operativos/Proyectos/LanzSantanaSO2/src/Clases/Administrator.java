/**
 *
 * @author santi
 */
package Clases;
import Interfaz.ApplicationWindow;
import javax.swing.*;
import java.util.Random;

public class Administrator extends Thread {
    StarWars starWars = new StarWars();
    StarTrek starTrek = new StarTrek();
    AI ai;

    int time = 10000;

    ApplicationWindow applicationWindow;

    private DefaultListModel<String> starWarsListModel;
    private DefaultListModel<String> starTrekListModel;

    private DefaultListModel<String> starWarsReinforcementListModel;
    private DefaultListModel<String> starTrekReinforcementListModel;

    public Administrator(AI ai, ApplicationWindow applicationWindow){
        starWarsListModel = new DefaultListModel<>();
        starTrekListModel = new DefaultListModel<>();
        starWarsReinforcementListModel = new DefaultListModel<>();
        starTrekReinforcementListModel = new DefaultListModel<>();
        this.applicationWindow = applicationWindow;
        this.ai = ai;
    }
    @Override
    public void run() {

        Characters anakin = new StarWars.Anakin();
        Characters c3po = new StarWars.C3PO();
        Characters chewbacca = new StarWars.Chewbacca();
        Characters darthvader = new StarWars.DarthVader();
        Characters lukeskywalker = new StarWars.LukeSkywalker();
        Characters obiwan = new StarWars.ObiWan();
        Characters palpatine = new StarWars.Palpatine();
        Characters princessleia = new StarWars.PrincesaLeia();
        Characters r2d2 = new StarWars.R2D2();
        Characters yoda = new StarWars.Yoda();

        Characters geordilaforge = new StarTrek.GeordiLaForge();
        Characters hikarusulu = new StarTrek.HikaruSulu();
        Characters jamestiberius = new StarTrek.JamesTiberius();
        Characters leonardmccoy = new StarTrek.LeonardMccoy();
        Characters montgomeryscott = new StarTrek.MontgomeryScott();
        Characters nyotauhura = new StarTrek.NyotaUhura();
        Characters pavelchekov = new StarTrek.PavelChekov();
        Characters spock = new StarTrek.Spock();
        Characters williamriker = new StarTrek.WilliamRiker();
        Characters worf = new StarTrek.Worf();

        // Se crean instancias de todos los personajes de Avatar y Regular Show
        // Se agregan a las colas de prioridad

        starWars.DetCalidadPersonajes(anakin);
        starWars.DetCalidadPersonajes(c3po);
        starWars.DetCalidadPersonajes(chewbacca);
        starWars.DetCalidadPersonajes(darthvader);
        starWars.DetCalidadPersonajes(lukeskywalker);
        starWars.DetCalidadPersonajes(obiwan);
        starWars.DetCalidadPersonajes(palpatine);
        starWars.DetCalidadPersonajes(princessleia);
        starWars.DetCalidadPersonajes(r2d2);
        starWars.DetCalidadPersonajes(yoda);

        starTrek.DetCalidadPersonajes(geordilaforge);
        starTrek.DetCalidadPersonajes(hikarusulu);
        starTrek.DetCalidadPersonajes(jamestiberius);
        starTrek.DetCalidadPersonajes(leonardmccoy);
        starTrek.DetCalidadPersonajes(montgomeryscott);
        starTrek.DetCalidadPersonajes(nyotauhura);
        starTrek.DetCalidadPersonajes(pavelchekov);
        starTrek.DetCalidadPersonajes(spock);
        starTrek.DetCalidadPersonajes(williamriker);
        starTrek.DetCalidadPersonajes(worf);



        while (true) {
            administrarColas();
            addRandomCharacter();
            updateQueueList(starWars.priority1SW, starWars.priority2SW, starWars.priority3SW, starWars.refuerzoSW, starWarsListModel);
            updateQueueList(starTrek.priority1ST, starTrek.priority2ST, starTrek.priority3ST, starTrek.refuerzoST, starTrekListModel);
            try {
                Thread.sleep(time); // Sleep for a while before checking the queues again

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void administrarColas() {
        AI ai = new AI(applicationWindow);
        Characters character1 = null;
        Characters character2 = null;
        
            // Add print statements to check the state of your queues and characters
        System.out.println("administrarColas method called");
        System.out.println("Initial state of avatar.priority1A: " + starWars.priority1SW);
        System.out.println("Initial state of avatar.priority2A: " + starWars.priority2SW);
        System.out.println("Initial state of avatar.priority3A: " + starWars.priority3SW);
        System.out.println("Initial state of regularShow.priority1RS: " + starTrek.priority1ST);
        System.out.println("Initial state of regularShow.priority2RS: " + starTrek.priority2ST);
        System.out.println("Initial state of regularShow.priority3RS: " + starTrek.priority3ST);

        // Increment the counter for each character in the priority2A and priority3A queues
        incrementCountersAndCheck(starWars.priority2SW, starWars.priority3SW, starWars.priority1SW);
        incrementCountersAndCheck(starWars.priority3SW, null, starWars.priority2SW);

        // Increment the counter for each character in the priority2RS and priority3RS queues
        incrementCountersAndCheck(starTrek.priority2ST, starTrek.priority3ST, starTrek.priority1ST);
        incrementCountersAndCheck(starTrek.priority3ST, null, starTrek.priority2ST);

        // Fetch the head of the queue with the highest priority from Avatar
        if (!starWars.priority1SW.isEmpty()) {
            character1 = (Characters) starWars.priority1SW.dequeue().getElement();
        } else if (!starWars.priority2SW.isEmpty()) {
            character1 = (Characters) starWars.priority2SW.dequeue().getElement();
        } else if (!starWars.priority3SW.isEmpty()) {
            character1 = (Characters) starWars.priority3SW.dequeue().getElement();
        } else if (!starWars.refuerzoSW.isEmpty()) {
            character1 = (Characters) starWars.refuerzoSW.dequeue().getElement();
        }

        // Fetch the head of the queue with the highest priority from RegularShow
        if (!starTrek.priority1ST.isEmpty()) {
            character2 = (Characters) starTrek.priority1ST.dequeue().getElement();
        } else if (!starTrek.priority2ST.isEmpty()) {
            character2 = (Characters) starTrek.priority2ST.dequeue().getElement();
        } else if (!starTrek.priority3ST.isEmpty()) {
            character2 = (Characters) starTrek.priority3ST.dequeue().getElement();
        } else if (!starTrek.refuerzoST.isEmpty()) {
            character2 = (Characters) starTrek.refuerzoST.dequeue().getElement();
        }

        // If we have a character from both shows, make them fight
        if (character1 != null && character2 != null) {
            final Characters finalCharacter1 = character1;
            final Characters finalCharacter2 = character2;
            new Thread(() -> ai.Pelea(finalCharacter1, finalCharacter2)).start();
            
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Assuming you have a reference to the ApplicationWindow instance
                applicationWindow.updateCharacterInfo(finalCharacter1, finalCharacter2);
                applicationWindow.updateWinnerCount(ai.getWinnerSW(), ai.getWinnerST());
            }
            });
        }
        
        
    }

    private void updateQueueList(Queue priority1, Queue priority2, Queue priority3, Queue reinforcement, DefaultListModel<String> listModel) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                listModel.clear();
                listModel.addElement("Priority 1: " + queueToString(priority1));
                listModel.addElement("Priority 2: " + queueToString(priority2));
                listModel.addElement("Priority 3: " + queueToString(priority3));
                listModel.addElement("Reinforcement: " + queueToString(reinforcement));
            }
        });
    }
    
    private String queueToString(Queue queue) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queue.getLength(); i++) {
            Characters character = (Characters) queue.dequeue().getElement();
            sb.append(character.getName()).append(", ");
            queue.enqueue(character);
        }
        return sb.toString();
    }
    
    public DefaultListModel<String> getStarWarsListModel() {
        return starWarsListModel;
    }

    public DefaultListModel<String> getStarTrekListModel() {
        return starTrekListModel;
    }

    public DefaultListModel<String> getStarWarsReinforcementListModel() {
        return starWarsReinforcementListModel;
    }
    public DefaultListModel<String> getStarTrekReinforcementListModel() {
        return starTrekReinforcementListModel;
    }


    public void addRandomCharacter() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        if (randomNumber == 0) {
            starWars.DetCalidadPersonajes(new StarWars.Anakin());
            starTrek.DetCalidadPersonajes(new StarTrek.GeordiLaForge());
        } else if (randomNumber == 1) {
            starWars.DetCalidadPersonajes(new StarWars.C3PO());
            starTrek.DetCalidadPersonajes(new StarTrek.HikaruSulu());
        } else if (randomNumber == 2) {
            starWars.DetCalidadPersonajes(new StarWars.Chewbacca());
            starTrek.DetCalidadPersonajes(new StarTrek.JamesTiberius());
        } else if (randomNumber == 3) {
            starWars.DetCalidadPersonajes(new StarWars.DarthVader());
            starTrek.DetCalidadPersonajes(new StarTrek.LeonardMccoy());
        } else if (randomNumber == 4) {
            starWars.DetCalidadPersonajes(new StarWars.LukeSkywalker());
            starTrek.DetCalidadPersonajes(new StarTrek.MontgomeryScott());
        } else if (randomNumber == 5) {
            starWars.DetCalidadPersonajes(new StarWars.ObiWan());
            starTrek.DetCalidadPersonajes(new StarTrek.NyotaUhura());
        } else if (randomNumber == 6) {
            starWars.DetCalidadPersonajes(new StarWars.Palpatine());
            starTrek.DetCalidadPersonajes(new StarTrek.PavelChekov());
        } else if (randomNumber == 7) {
            starWars.DetCalidadPersonajes(new StarWars.PrincesaLeia());
            starTrek.DetCalidadPersonajes(new StarTrek.Spock());
        } else if (randomNumber == 8) {
            starWars.DetCalidadPersonajes(new StarWars.R2D2());
            starTrek.DetCalidadPersonajes(new StarTrek.WilliamRiker());
        } else if (randomNumber == 9) {
            starWars.DetCalidadPersonajes(new StarWars.Yoda());
            starTrek.DetCalidadPersonajes(new StarTrek.Worf());
        }
    }

    public void incrementCountersAndCheck(Queue currentQueue, Queue nextQueue, Queue previousQueue) {
        for (int i = 0; i < currentQueue.getLength(); i++) {
            Characters character = (Characters) currentQueue.dequeue().getElement();
            character.incrementCounter();
            if (character.counter >= 8 && previousQueue != null) {
                character.resetCounter();
                previousQueue.enqueue(character);
            } else {
                currentQueue.enqueue(character);
            }
        }
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    
}