/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.util.Random;
import javax.swing.ImageIcon;
import java.net.URL;
import javax.swing.JOptionPane;
import java.awt.Image;
/**
 *
 * @author santi
 */
public class Characters {
   public int Habilidad;
    public int PuntosVida;
    public int Fuerza;
    public int Agilidad;
    public boolean calidad;
    public String special;
    private Image photo;
    private static int idCounter = 0; // Contador estático para IDs únicos
    public final int id; // Atributo único por personaje
    
    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
    
    

    public int counter;

    public String name;
    
    

    public Characters(String name) {

        this.Habilidad = generarHabilidad(DetCalidad(60));
        this.PuntosVida = generarPuntosVida(DetCalidad(70));
        this.Fuerza = generarFuerza(DetCalidad(50));
        this.Agilidad = generarAgilidad(DetCalidad(40));
        this.calidad = false;
        this.special = generarEspecial();
        this.name = name;
        this.counter = 0;
        this.id = generateUniqueId();
    }
    
    private int generateUniqueId() {
        return ++idCounter; // Incrementa el contador global y devuelve el nuevo ID
    }
    
    public int getId() {
        return id;
    }

    public void incrementCounter(){
        this.counter++;
    }

    public void resetCounter(){
        this.counter = 0;
    }

    public int getHabilidad() {
        return Habilidad;
    }

    public void setHabilidad(int Habilidad) {
        this.Habilidad = Habilidad;
    }

    public int getPuntosVida() {
        return PuntosVida;
    }

    public void setPuntosVida(int PuntosVida) {
        this.PuntosVida = PuntosVida;
    }

    public int getFuerza() {
        return Fuerza;
    }

    public void setFuerza(int Fuerza) {
        this.Fuerza = Fuerza;
    }

    public int getAgilidad() {
        return Agilidad;
    }

    public void setAgilidad(int Agilidad) {
        this.Agilidad = Agilidad;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public boolean DetCalidad(int probabilidad){
        Random random = new Random();
        int num = random.nextInt(101);
        if (num <= probabilidad){
            return calidad = true;
        } else {
            return calidad = false;
        }
    }
    
    public int generarHabilidad(boolean calidad) {
        Random random = new Random();
        if (calidad){
            return random.nextInt(8,11 );
        }else {
            return random.nextInt(0,7);        
        }
    }
        
    public int generarPuntosVida(boolean calidad) {
        Random random = new Random();
        if (calidad){
            return random.nextInt(8,11 );
        }else {
            return random.nextInt(0,7);        
        }
    }
    
    public int generarFuerza(boolean calidad) {
        Random random = new Random();
        if (calidad){
            return random.nextInt(8,11 );
        }else {
            return random.nextInt(0,7);        
        }
    }
    
    public int generarAgilidad(boolean calidad) {
        Random random = new Random();
        if (calidad){
            return random.nextInt(8,11 );
        }else {
            return random.nextInt(0,7);        
        }
    }
    
    public String generarEspecial(){
        
        String milloneta = "milloneta";
        String enchufado = "enchufado";
        String malandro = "malandro";
        String calvo = "calvo";
        String calidoso = "calidoso";
        
        
        String[] strings = {milloneta,calidoso, enchufado, malandro, calvo};
        
        Random random = new Random();
        int randomIndex = random.nextInt(strings.length);
        String randomString = strings[randomIndex];
        
        return randomString;
        }

    @Override
    public String toString() {
        return String.format(
                "Character Details:\n" +
                        "------------------\n" +
                        "Name: %s\n" +
                        "ID: %s\n" +
                        "Habilidad: %d\n" +
                        "PuntosVida: %d\n" +
                        "Fuerza: %d\n" +
                        "Agilidad: %d\n" +
                        "Calidad: %b\n" +
                        "Special: %s\n",
                name, id, Habilidad, PuntosVida, Fuerza, Agilidad, calidad, special
        );
    }
    
    public ImageIcon createImageIcon(String path) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            JOptionPane.showMessageDialog(null, "Couldn't find file: " + path);
            return null;
        }
    }

    
}

