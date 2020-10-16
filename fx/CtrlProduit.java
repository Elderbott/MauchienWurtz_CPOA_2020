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
		if (this.txtNom.getText().isEmpty() || this.txtDesc.getText().isEmpty() || this.txtTarif.getText().isEmpty() || !this.txtTarif.getText().matches("[0-9]+") || cbxCateg.getSelectionModel().getSelectedItem() == null)
			this.lblRes.setText("Champs invalides");
		else {
	        this.lblRes.setText(this.txtNom.getText()+" ("+cbxCateg.getSelectionModel().getSelectedItem()+"), "+this.txtTarif.getText()+" euros");
	        Produit pr = new Produit();
	        Categorie obj = new Categorie();
	        pr.setNom(this.txtNom.getText());
	        pr.setDescription(this.txtDesc.getText());
	        pr.setTarif(Double.parseDouble(this.txtTarif.getText()));
	        pr.setCategorie(cbxCateg.getSelectionModel().getSelectedItem());
	        pr.setVisuel(" ");
			boolean bool = daoLM.getProduitDAO().create(pr);
		}
	}
	
}
