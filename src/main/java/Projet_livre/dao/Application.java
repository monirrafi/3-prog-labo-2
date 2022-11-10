package Projet_livre.dao;

import Projet_livre.dao.controleurLivre.ControleurLivre;
import Projet_livre.dao.modelLivre.Livre;
import Projet_livre.dao.vueLivre.VueLivre;

public final class Application {
    private Application() {
    }

    public static void main(String[] args) {

      /*  
        Livre livre1 = new Livre(237,"Une autre vie",1,2023,445,"roman");
        ControleurLivre ctrLivre = ControleurLivre.getControleurLivre();
        for(Livre livre:ctrLivre.CtrLivre_GetAll()){
            System.out.println( livre.toString());
        }

		ctrLivre.CtrLivre_ChargerDB();
        System.out.println(ctrLivre.CtrLivre_Modifier(livre));

        System.out.println(ctrLivre.CtrLivre_Enlever(200));
        
        Livre livreId = ctrLivre.CtrLivre_GetById(200);
        if(livreId == null){
            System.out.println("n'exite pas");
        }else{
            System.out.println(livreId.toString());
        }*

        Livre livreTitre = ctrLivre.CtrLivre_GetByTitre("Une autre vie");
        if(livreTitre == null){
            System.out.println("n'exite pas");
        }else{
            System.out.println(livreTitre.toString());
        }*/
        VueLivre vue = new VueLivre();
        //vue.affichage();
        vue.setVisible(true);
	}
}