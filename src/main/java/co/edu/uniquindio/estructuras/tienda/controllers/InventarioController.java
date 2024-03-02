package co.edu.uniquindio.estructuras.tienda.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class InventarioController implements Initializable {

	@FXML
	private VBox vboxInventario;

	@FXML
	void mostrarInventarioEvent(ActionEvent event) {
		InventarioLogicController.getInstance().mostrarInventarioAction();
	}

	@FXML
	void ordenarAlfabeticoEvent(ActionEvent event) {
		InventarioLogicController.getInstance().ordenarAlfabeticoAction();
	}

	@FXML
	void ordenarCantidadEvent(ActionEvent event) {
		InventarioLogicController.getInstance().ordenarCantidadAction();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		InventarioLogicController.getInstance().configLista(vboxInventario);
		InventarioLogicController.getInstance().cargarDatos();
	}
}
