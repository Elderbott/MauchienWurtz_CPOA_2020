package fx;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import metier.Categorie;
import metier.Produit;

public class CtrlProduit implements Initializable {
	

	@FXML private ChoiceBox<Categorie> cbxCateg;
	@FXML private Label lblRes;
	@FXML private Button btnCreate;
	@FXML private TextField txtNom;
	@FXML private TextField txtTarif;
	@FXML private TextArea txtDesc;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 DAOFactory daoLM = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	     this.cbxCateg.setItems(FXCollections.observableArrayList(daoLM.getCategorieDAO().getAll()));
	}

	@FXML
    private void createProduit(ActionEvent event) {
		DAOFactory daoLM = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
		if (this.txtNom.getText().trim().isEmpty() || this.txtDesc.getText().trim().isEmpty() || this.txtTarif.getText().isEmpty() || !this.txtTarif.getText().trim().matches("[0-9]+") || cbxCateg.getSelectionModel().getSelectedItem() == null)
			this.lblRes.setText("Champs invalides");
		else {
	        this.lblRes.setText(this.txtNom.getText().trim()+" ("+cbxCateg.getSelectionModel().getSelectedItem()+"), "+this.txtTarif.getText().trim()+" euros");
	        Produit pr = new Produit();
	        Categorie obj = new Categorie();
	        pr.setNom(this.txtNom.getText().trim());
	        pr.setDescription(this.txtDesc.getText().trim());
	        pr.setTarif(Double.parseDouble(this.txtTarif.getText().trim()));
	        pr.setCategorie(cbxCateg.getSelectionModel().getSelectedItem());
	        pr.setVisuel(" ");
			boolean bool = daoLM.getProduitDAO().create(pr);
		}
	}
	
}
