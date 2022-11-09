package edu.java.dao.models.modelFilm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoDept implements IDeptDao {
    private static Connection conn = null;
    private static DaoDept instanceDao = null;

    // MySQL
    //private static final String PILOTE = "com.mysql.jdbc.Driver";
    private static final String URL_BD = "jdbc:mysql://localhost/office";
    private static final String USAGER = "root";
    private static final String PASS = "";

    private static final String SUPPRIMER = "DELETE FROM dept WHERE deptno=?";
    private static final String GET_ALL = "SELECT * FROM dept ORDER BY deptno";
    private static final String GET_BY_ID = "SELECT * FROM dept WHERE deptno=?";
    private static final String GET_BY_LOC = "SELECT * FROM dept WHERE loc=?";
    private static final String ENREGISTRER = "INSERT INTO dept VALUES(?,?, ?)";
    private static final String MODIFIER = "UPDATE dept SET dname=?, loc=? WHERE deptno=?";

    // Singleton de connexion à la BD
    // getConnexion() est devenu une zonne critique. 
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion

    private DaoDept(){};
    
    public static synchronized DaoDept getDeptDao () {
        try {
            // Class.forName(PILOTE);
            if (instanceDao == null) {
                instanceDao = new DaoDept();
                conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            }
            return instanceDao;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public String MdlD_Enregistrer(Dept dept) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(ENREGISTRER, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, dept.getDeptno());
            stmt.setString(2, dept.getDname());
            stmt.setString(3, dept.getLoc());
           
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                dept.setDeptno(rs.getInt(1));
            }
            return "Dept bien enregistré";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MdlD_Fermer(stmt);
            //MdlD_Fermer(conn);
        }
    }

    // Read
    public List<Dept> MdlD_GetAll() {
        PreparedStatement stmt = null;
        List<Dept> listeDepts = new ArrayList<Dept>();

        try {
            stmt = conn.prepareStatement(GET_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));

                listeDepts.add(dept);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlD_Fermer(stmt);
            //MdlD_Fermer(conn);
        }

        return listeDepts;
    }

    public Dept MdlD_GetByDeptno(int deptno) {
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(GET_BY_ID);
            stmt.setInt(1, deptno);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));

                return dept;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlD_Fermer(stmt);
            //MdlD_Fermer(conn);
        }
    }

    public Dept MdlD_GetByLoc(String loc) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(GET_BY_LOC);
            stmt.setString(1, loc);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));

                return dept;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlD_Fermer(stmt);
            //MdlD_Fermer(conn);
        }
    }

    // Update, faudrat avant appeler MdlF_GetById(idf) pour obtenir
    // les données du film à modifier via une interface et après envoyer 
    // ce film à MdlF_Modifier(film) pour faire la mise à  jour.
    public int MdlD_Modifier(Dept dept) {
        PreparedStatement stmt = null;
       ;
        try {
            stmt = conn.prepareStatement(MODIFIER);
            stmt.setInt(1, dept.getDeptno());
            stmt.setString(2, dept.getDname());
            stmt.setString(3,dept.getLoc());

            return stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlD_Fermer(stmt);
           //MdlD_Fermer(conn);
        }
    }

    // Delete
    public int MdlD_Supprimer(int deptno) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(SUPPRIMER);
            stmt.setInt(1, deptno);

            return stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlD_Fermer(stmt);
           // MdlD_Fermer(conn);
        }
    }
/* 
    private static void MdlD_Fermer(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
*/
    private static void MdlD_Fermer(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

}
