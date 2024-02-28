package co.edu.uniquindio.estructuras.tienda.controllers;

import java.io.IOException;

import co.edu.uniquindio.estructuras.tienda.services.IAddClientController;
import co.edu.uniquindio.estructuras.tienda.utils.FxmlPerspective;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GestionClientesLogicController {

	private Button botonSeleccionado = new Button();

	public void irAActualizar(BorderPane root, Button boton) {
		MenuPrincipalLogicController.getInstance().ejecutarProceso(() -> {
			verifyActualizar();
			boton.setDisable(true);
			botonSeleccionado.setDisable(false);
			botonSeleccionado = boton;
			root.setCenter(perspectivaActualizar.getPerspective());
		});
	}

	public void irAAgregar(BorderPane root) {
		try {
			if (perspectivaAgregar == null)
				perspectivaAgregar = FxmlPerspective.loadPerspective("agregarCliente");
			MenuPrincipalLogicController.getInstance().cambiarPerspectiva(perspectivaAgregar);
			IAddClientController controller = (IAddClientController) perspectivaAgregar.getController();
			controller.configurarVolver(() -> {
				MenuPrincipalLogicController.getInstance().cambiarPerspectiva(root);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void verifyActualizar() {
		try {
			if (perspectivaActualizar == null)
				perspectivaActualizar = FxmlPerspective.loadPerspective("actualizarCliente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static GestionClientesLogicController instance;
	private FxmlPerspective perspectivaActualizar, perspectivaAgregar;

	public static GestionClientesLogicController getInstance() {
		if (instance == null)
			instance = new GestionClientesLogicController();
		return instance;
	}
}
