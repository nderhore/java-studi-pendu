package org.example;

import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{


    //jeu de données
     static final String[] sentences = {"norme","ordinateur","voiture","java","canard"};
     static final int essai = 6;

    static Scanner sc = new Scanner(System.in);

    public static void main( String[] args )
    {

        System.out.println( "Bienvenue dans notre jeu du pendu !" );
        String saisie = selectChoice();

        switch (saisie){
            case "b":
                launchGame();
                break;
            case "x":
                System.exit(0);
        }

        //InputWord : lecture clavier sur la lettre saisie

        //CalculateTry : incrémente un compteur avec les essais. Bien sur, l'essai est en dur

        //DisplaySetence : affiche la phrase avec les lettres trouvées , tata => _a_a
    }

     static String selectChoice() {
        String saisie = "";

        while(!(saisie.equals("b") || saisie.equals("x"))) {
            System.out.println("Entrez b pour commencer, x pour quitter.");
            saisie = sc.nextLine();
        }
        return saisie;
    }

    static void launchGame() {
        System.out.println("Debut du jeu !");
        System.out.println("Generation d'un mot ...");
        String sentence = getSentence();


    }

     static String getSentence() {
        Random random = new Random();
        return sentences[random.nextInt(sentences.length)];
    }


}
