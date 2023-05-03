package org.example;

import java.util.Arrays;
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


     static final int countTry = 6;

     static int essai = 0;



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

        //recuperation de la phrase
        String sentence = getSentence();
        String[] sentenceWithSecret = initializeSentenceWithSecret(sentence);


        int essai = 0;
        boolean found = false;

        while(essai < countTry && !found){
            System.out.println("voici l'etat actuel de la recherche : " + displaySentenceWithSecret(sentenceWithSecret));
            getAndModifySentenceWithSecret(sentenceWithSecret, sentence);
            found = checkIfSentenceFounded(sentenceWithSecret);

        }

    }

    private static String displaySentenceWithSecret(String[] sentenceWithSecret) {
        String stringToDisplay = "";
        for(int i = 0; i<sentenceWithSecret.length; i++){
            stringToDisplay += sentenceWithSecret[i];
        }
        return stringToDisplay;
    }

    private static boolean checkIfSentenceFounded(String[] sentenceWithSecret) {
        return Arrays.stream(sentenceWithSecret).noneMatch(caractere -> caractere.equals("_"));
    }

    private static void getAndModifySentenceWithSecret(String[] sentenceWithSecret, String sentence) {
        System.out.println("Entrez un caractère : ");
        String saisie = sc.nextLine();
        if(!sentence.contains(saisie)){
            essai++;
            System.out.println("la lettre " + saisie + " n'est pas dans le mot.");
        }
        else {
            for(int i = 0; i<sentence.length(); i++){
                if(sentence.charAt(i) == saisie.charAt(0)) sentenceWithSecret[i] = saisie;
            }
        }

    }

    private static String[] initializeSentenceWithSecret(String sentence) {
        String[] sentenceSecret = new String[sentence.length()];
        Arrays.fill(sentenceSecret,"_");
        return sentenceSecret;
    }



    static String getSentence() {
        Random random = new Random();
        return sentences[random.nextInt(sentences.length)];
    }


}
