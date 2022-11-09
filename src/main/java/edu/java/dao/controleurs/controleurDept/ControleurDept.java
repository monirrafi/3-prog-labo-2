package edu.java.dao.controleurs.controleurDept;
import edu.java.dao.models.modelFilm.Dept;
import edu.java.dao.models.modelFilm.DaoDept;
// import edu.java.dao.models.modelFilm.DaoFilm;
public class ControleurDept implements IActionsDept {

    private static ControleurDept CtrD_Instance = null;
    private static DaoDept Dao_Instance = null;
    // Singleton du contrôleur
    // getControleurFilm() est devenu une zonne critique.
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion
    private ControleurDept(){}

    public static synchronized ControleurDept getControleurDept() {
        try {
            if (CtrD_Instance == null) {
                CtrD_Instance = new ControleurDept();
                Dao_Instance = DaoDept.getDeptDao();
            }
            return CtrD_Instance;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public String CtrD_Enregistrer(Dept dept) {
        String message = null;
        message = Dao_Instance.MdlD_Enregistrer(dept);
        return message;
    }

    @Override
    public int CtrD_Enlever(int deptno) {
        int sup = Dao_Instance.MdlD_Supprimer(deptno);
        return sup;
    }

}
