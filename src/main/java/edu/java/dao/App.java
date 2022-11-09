package edu.java.dao;

import edu.java.dao.controleurs.controleurFilm.ControleurFilm;
import edu.java.dao.controleurs.controleurDept.ControleurDept;
import edu.java.dao.models.modelFilm.Dept;
import edu.java.dao.models.modelFilm.Film;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDeptno(700);
        dept.setDname("Ryad");
        dept.setLoc("Montreal");;
        
        ControleurDept CtrD = ControleurDept.getControleurDept();
        //String message = CtrD.CtrD_Enregistrer(dept);
        //System.out.println(message);
        System.out.println(CtrD.CtrD_Enlever(700));






        // Selon le choix de l'utilisateur faudra appeler la bonne méthode
        // du contrôleur.
        // CAS 1 : Enregistrer un film
        /* 
        Film film = new Film ();
        film.setTitre("Conan");
        film.setDuree(90);
        film.setRes("Arnold");
        film.setPochette("https://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjA...");
        
        ControleurFilm CtrF = ControleurFilm.getControleurFilm();
        String message = CtrF.CtrF_Enregistrer(film);
        System.out.println(message);
        */
    }
}
