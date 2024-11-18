/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 *
 * @author Abraham Santana
 */
public class StarTrek {
    Queue priority1ST = new Queue();
    Queue priority2ST = new Queue();
    Queue priority3ST = new Queue();
    Queue refuerzoST = new Queue();
    
    
    public static class GeordiLaForge extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        public GeordiLaForge(){
           super("GeordiLaForge");
           try {
            File file = new File("src/ImagesStarTrek/GeordiLaForge.jpg");
            if (file.exists()) {
                this.photo = ImageIO.read(file);
                System.out.println("Image loaded successfully.");
            } else {
                System.out.println("Image not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
           setPhoto(photo);
        }
    }
    
    public static class HikaruSulu extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        public HikaruSulu(){
           super("HikaruSulu");
           try {
            File file = new File("src/ImagesStarTrek/HikaruSulu.jpg");
            if (file.exists()) {
                this.photo = ImageIO.read(file);
                System.out.println("Image loaded successfully.");
            } else {
                System.out.println("Image not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
           setPhoto(photo);
        }
    }
    
    public static class JamesTiberius extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        public JamesTiberius(){
           super("JamesTiberius");
           try {
            File file = new File("src/ImagesStarTrek/JamesTiberius.jpg");
            if (file.exists()) {
                this.photo = ImageIO.read(file);
                System.out.println("Image loaded successfully.");
            } else {
                System.out.println("Image not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
           setPhoto(photo);
        }
    }
    
    public static class LeonardMccoy extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        public LeonardMccoy(){
           super("LeonardMccoy");
           try {
            File file = new File("src/ImagesStarTrek/LeonardMccoy.jpg");
            if (file.exists()) {
                this.photo = ImageIO.read(file);
                System.out.println("Image loaded successfully.");
            } else {
                System.out.println("Image not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
           setPhoto(photo);
        }
    }
    
    public static class MontgomeryScott extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        public MontgomeryScott(){
           super("MontgomeryScott");
           try {
            File file = new File("src/ImagesStarTrek/MontgomeryScott.jpg");
            if (file.exists()) {
                this.photo = ImageIO.read(file);
                System.out.println("Image loaded successfully.");
            } else {
                System.out.println("Image not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
           setPhoto(photo);
        }
    }
    
    public static class NyotaUhura extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        public NyotaUhura(){
           super("NyotaUhura");
           try {
            File file = new File("src/ImagesStarTrek/NyotaUhura.jpg");
            if (file.exists()) {
                this.photo = ImageIO.read(file);
                System.out.println("Image loaded successfully.");
            } else {
                System.out.println("Image not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
           setPhoto(photo);
        }
    }
    
    public static class PavelChekov extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        public PavelChekov(){
           super("PavelChekov");
           try {
            File file = new File("src/ImagesStarTrek/PavelChekov.jpg");
            if (file.exists()) {
                this.photo = ImageIO.read(file);
                System.out.println("Image loaded successfully.");
            } else {
                System.out.println("Image not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
           setPhoto(photo);
        }
    }
    
     public static class Spock extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        public Spock(){
           super("Spock");
           try {
            File file = new File("src/ImagesStarTrek/Spock.jpg");
            if (file.exists()) {
                this.photo = ImageIO.read(file);
                System.out.println("Image loaded successfully.");
            } else {
                System.out.println("Image not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
           setPhoto(photo);
        }
    }
     
     public static class WilliamRiker extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        public WilliamRiker(){
           super("WilliamRiker");
           try {
            File file = new File("src/ImagesStarTrek/WilliamRiker.jpg");
            if (file.exists()) {
                this.photo = ImageIO.read(file);
                System.out.println("Image loaded successfully.");
            } else {
                System.out.println("Image not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
           setPhoto(photo);
        }
    }
     
     public static class Worf extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        public Worf(){
           super("Worf");
           try {
            File file = new File("src/ImagesStarTrek/Worf.jpg");
            if (file.exists()) {
                this.photo = ImageIO.read(file);
                System.out.println("Image loaded successfully.");
            } else {
                System.out.println("Image not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
           setPhoto(photo);
        }
    }
     
     
     public void DetCalidadPersonajes(Characters characters){
        int cont = 0;
        if (characters.Habilidad >= 8){
            cont ++;
        }if (characters.Agilidad >= 8){
            cont ++;
        }if (characters.PuntosVida >= 8){
            cont ++;
        }if (characters.Fuerza >= 8){
            cont ++;
        }if (cont == 4 || cont == 3){
            priority1ST.enqueue(characters);
        }else if (cont == 2 ){
            priority2ST.enqueue(characters);
        }if (cont == 0 || cont == 1){
            priority3ST.enqueue(characters);
        }
    }
}
