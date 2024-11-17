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
public class StarWars {
    Queue priority1SW = new Queue();
    Queue priority2SW = new Queue();
    Queue priority3SW = new Queue();
    Queue refuerzoSW = new Queue();
    
    public static class Anakin extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        
        public Anakin(){
           super("Anakin");
           try {
            File file = new File("src/ImagesStarWars/Anakin.jpg");
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
    
    public static class C3PO extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        
        public C3PO(){
           super("C3PO");
           try {
            File file = new File("src/ImagesStarWars/C3PO.jpg");
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
    
    public static class Chewbacca extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        
        public Chewbacca(){
           super("Chewbacca");
           try {
            File file = new File("src/ImagesStarWars/Chewbacca.jpg");
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
    
    public static class DarthVader extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        
        public DarthVader(){
           super("DarthVader");
           try {
            File file = new File("src/ImagesStarWars/DarthVader.jpg");
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
    
    public static class LukeSkywalker extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        
        public LukeSkywalker(){
           super("LukeSkywalker");
           try {
            File file = new File("src/ImagesStarWars/LukeSkywalker.jpg");
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
    
    public static class ObiWan extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        
        public ObiWan(){
           super("ObiWan");
           try {
            File file = new File("src/ImagesStarWars/ObiWan.jpg");
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
    
    public static class Palpatine extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        
        public Palpatine(){
           super("Palpatine");
           try {
            File file = new File("src/ImagesStarWars/Palpatine.jpg");
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
    
    public static class PrincesaLeia extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        
        public PrincesaLeia(){
           super("PrincesaLeia");
           try {
            File file = new File("src/ImagesStarWars/PrincesaLeia.jpg");
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
    
    public static class R2D2 extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        
        public R2D2(){
           super("R2D2");
           try {
            File file = new File("src/ImagesStarWars/R2D2.jpg");
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
    
    public static class Yoda extends Characters {
        Random random = new Random();
        int id = random. nextInt(0,10000);
        private Image photo;
        
        
        public Yoda(){
           super("Yoda");
           try {
            File file = new File("src/ImagesStarWars/Yoda.jpg");
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
            priority1SW.enqueue(characters);
        }else if (cont == 2 ){
            priority2SW.enqueue(characters);
        }if (cont == 0 || cont == 1){
            priority3SW.enqueue(characters);
        }
    }
}
