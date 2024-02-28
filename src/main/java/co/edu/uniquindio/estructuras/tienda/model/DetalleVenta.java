package co.edu.uniquindio.estructuras.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DetalleVenta {

	@EqualsAndHashCode.Include
	@NonNull
	private Producto producto;
	private int cantVendida;

	public double calcPrecioParcial() {
		return cantVendida * producto.getPrecio();
	}
}
