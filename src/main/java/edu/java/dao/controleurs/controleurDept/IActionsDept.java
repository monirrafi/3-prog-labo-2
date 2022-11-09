package edu.java.dao.controleurs.controleurDept;
import edu.java.dao.models.modelFilm.Dept;

public interface IActionsDept {
    // Pour le CRUD - Create Read Update Delete

    // Create
    public String CtrD_Enregistrer(Dept dept);
    
    // // Read
    // public List<Film> CtrF_GetAllFilms();

    // public Film CtrF_GetFilmById(int idf);

    // public Film CtrF_GetFilmByTitre(String titre);

    // // Update
    // public int CtrF_Modifier(Film user);

    // // Delete
     public int CtrD_Enlever(int deptno); 
}
