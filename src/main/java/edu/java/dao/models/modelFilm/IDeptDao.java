package edu.java.dao.models.modelFilm;

import java.util.List;

public interface IDeptDao {

    // Pour le CRUD - Create Read Update Delete
    
    // Create
    public String MdlD_Enregistrer(Dept dept);
    
    // Read
    public List<Dept> MdlD_GetAll();

    public Dept MdlD_GetByDeptno(int deptno);

    public Dept MdlD_GetByLoc(String loc);
    
    // Update
    public int MdlD_Modifier(Dept user);

    // Delete
    public int MdlD_Supprimer(int deptno);

}
