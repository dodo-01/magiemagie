/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magiemagie;

import com.sun.javafx.geom.AreaOp;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Formation
 */
public class Jeu {

    private ArrayList<Joueur> joueurs = new ArrayList<>();
    private Joueur joueurEnCours;
        
    public void lancerSort(){  
        
        //1.Affiche les sorts possible pour joueurEnCours
        Carte carteCorneDeLicorne = new Carte();
        Carte carteBaveDeCrapaud = new Carte();
        Carte carteAileDeChauveSouris = new Carte();
        Carte carteLapisLazuli = new Carte();
        Carte carteMandragore = new Carte();
          
        carteCorneDeLicorne.setType(Carte.TypeCarte.CORNE_DE_LICORNE);
        carteBaveDeCrapaud.setType(Carte.TypeCarte.BAVE_DE_CRAPAUD);
        carteAileDeChauveSouris.setType(Carte.TypeCarte.AILE_DE_CHAUVE_SOURIS);
        carteLapisLazuli.setType(Carte.TypeCarte.LAPIS_LAZULI);
        carteMandragore.setType(Carte.TypeCarte.MANDRAGORE);

        
        if(this.joueurEnCours.getCartes().contains(carteCorneDeLicorne)&&
           this.joueurEnCours.getCartes().contains(carteBaveDeCrapaud)){
           System.out.println("[1]invisibilité");  
        }
        if(this.joueurEnCours.getCartes().contains(carteCorneDeLicorne)&&
           this.joueurEnCours.getCartes().contains(carteMandragore)){     
           System.out.println("[2]philtre d'amour");  
        }   
        if(this.joueurEnCours.getCartes().contains(carteBaveDeCrapaud)&&
           this.joueurEnCours.getCartes().contains(carteLapisLazuli)){     
           System.out.println("[3]hypnose"); 
        }   
        if(this.joueurEnCours.getCartes().contains(carteLapisLazuli)&& 
           this.joueurEnCours.getCartes().contains(carteAileDeChauveSouris)){     
           System.out.println("[4]divination"); 
        }   
        if(this.joueurEnCours.getCartes().contains(carteAileDeChauveSouris)&&
           this.joueurEnCours.getCartes().contains(carteMandragore)){
           System.out.println("[5]sommeil profond");
        }  
        
        
         //.2Saisie sort à lancer
        
        boolean termine = false;
        while(termine == false);
        
        String choix = new Scanner(System.in).nextLine();
        
        switch (choix){
            case "1":
                sortInvisibilite();
                break;
            case "2":
                sortPhiltreDAmour();
                break;
            case "3":
                sortHypnose();
                break;
            case "4":
               sortDivination();
                break;
            case "5":
                sortSommeilProfond();
                break;
 
            default:
                System.out.println("Ce sort n'existe pas");
                
                termine = true;
                break;
                
        }
            
        
        //3.Lancement du sort
        
        
        //4.Supprime les 2 cartes ayatn permis de lancer le sort
        
        
        
        
        
    }

    public void passerTour(){       
    }
    
    public void menuAction(){
    
    boolean termine = false;
    do{
        
        
        //1. Afficher menu
        
        System.out.println("A vous de jouer" +" "+ this.joueurEnCours.getNom());
        System.out.println("Vos cartes :"+" " + this.joueurEnCours.getCartes()) ;
        System.out.print("Actions possibles: [1] lancer un sort [2] passer son tour. Votre choix :");
        Scanner scan = new Scanner (System.in);
        String choix = scan.nextLine();
        
        //2.Lance sort ou passe tour
        
       
                  
        switch(choix){
            case "1":
                this.lancerSort();
                termine = true;
                break;
            case "2":
                this.passerTour();
                termine = true;
                break;
            default:
                System.out.println("Commande invalide");
        }
    }while(termine == false);
}
        
    public Joueur getJoueurEnCours() {
        return joueurEnCours;
    }

    public void setJoueurEnCours(Joueur joueurEnCours) {
        this.joueurEnCours = joueurEnCours;
    }
    
    
    
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }


    
    public void demarrerPartie() {

    //1.Distribuer 7 cartes par joueur
    for (Joueur joueur : joueurs) {   //for (Object elem : col...)
        
         //Distribue 7 cartes pour le jour actuel
        for (int i = 0; i <7; i++){   //tant que   (repeter 7 fois)          
            
            Carte carte = new Carte(); //creation objet carte
           
            Random random = new Random();
            int nb = random.nextInt(5);
            
            switch(nb){
                case 0:
                    carte.setType(Carte.TypeCarte.AILE_DE_CHAUVE_SOURIS);
                    break;
                case 1:
                    carte.setType(Carte.TypeCarte.BAVE_DE_CRAPAUD);
                    break;                    
                case 2:
                    carte.setType(Carte.TypeCarte.CORNE_DE_LICORNE);
                    break;                   
                case 3:
                    carte.setType(Carte.TypeCarte.LAPIS_LAZULI);
                    break;                   
                case 4:
                    carte.setType(Carte.TypeCarte.MANDRAGORE);
                    break;                   
                default:    //obligation de mettre default tjrs                   
                    break;                                    
            }
                joueur.getCartes().add(carte);                
        }
    }
       
    //2.Donne la main au 1er joueur
    this.joueurEnCours = this.joueurs.get(0);
    
    //3.Affiche menu d'action
    this.menuAction();
    
    }
        
            
     public void afficherMenuNouveauJoueur() {

    //1.saisie du nom joueur   
    System.out.print("Nom nouveau joueur: ");
    Scanner s = new Scanner(System.in);
    String nomJoueur = s.nextLine();

    //2.crée un joueur et lui set un nom
    Joueur joueur = new Joueur();
    joueur.setNom(nomJoueur);
    
    //3.ajouter ds liste joueurs
    this.joueurs.add(joueur);
    
    }
    
    
    
    public void afficherMenuPrincipal() {
        
        boolean quitter = false;
        while (quitter == false) {

            //Affiche menu    
            System.out.println("Menu :");
            System.out.println("------");
            System.out.println("1.Nouveau joueur");
            System.out.println("2.Démarrer partie");
            System.out.println("L.Liste des joueurs");
            System.out.println("3.Quitter");

            //Saisie clavier
            Scanner scanner = new Scanner(System.in);
            String choixUtil = scanner.nextLine();

            switch (choixUtil) {
                case "L":
                    System.out.println(this.joueurs);
                    break;
                case "1":
                    afficherMenuNouveauJoueur();
                    break;
                case "2":
                    demarrerPartie();
                    break;
                case "3":
                    quitter = true;
                    break;
                default:
                    System.out.println("Commande inconnue");
                    break;
            }
        }

    }

    private void sortInvisibilite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortPhiltreDAmour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortHypnose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortDivination() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortSommeilProfond() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
