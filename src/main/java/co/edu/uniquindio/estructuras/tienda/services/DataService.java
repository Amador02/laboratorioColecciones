package co.edu.uniquindio.estructuras.tienda.services;

import co.edu.uniquindio.estructuras.tienda.exceptions.ElementoDuplicadoException;
import co.edu.uniquindio.estructuras.tienda.exceptions.ElementoNoEncontradoException;
import co.edu.uniquindio.estructuras.tienda.exceptions.ElementoNuloException;
import co.edu.uniquindio.estructuras.tienda.model.Cliente;
import co.edu.uniquindio.estructuras.tienda.model.Producto;
import co.edu.uniquindio.estructuras.tienda.model.Tienda;
import co.edu.uniquindio.estructuras.tienda.model.Venta;

public class DataService {

	private DataService instance;
	private Tienda tienda;

	public DataService getInstance() {
		if (instance == null)
			return instance = new DataService();
		return instance;
	}

	private DataService() {
		this.tienda = new Tienda();
	}

	public void leerProductos() {
		tienda.setTreeProductos(ProductoDao.getInstance().loadData());
		;
	}

	public void leerHistoricoVentas() {
		tienda.setHistoricoVentas(VentaDao.getInstance().loadData());
	}

	public void leerMapClientes() {
		tienda.setMapClientes(ClienteDao.getIntance().loadData());
	}

	public void agregarProducto(Producto producto) throws ElementoNuloException {
		leerProductos();
		tienda.agregarProducto(producto);
		ProductoDao.getInstance().saveData(tienda.getTreeProductos());

	}

	public void agregarVenta(Venta venta) throws ElementoNuloException, ElementoDuplicadoException {
		leerHistoricoVentas();
		tienda.agregarVenta(venta);
		VentaDao.getInstance().saveData(tienda.getHistoricoVentas());
	}

	public void agregarCliente(Cliente cliente) throws ElementoNuloException, ElementoDuplicadoException {
		leerMapClientes();
		tienda.agregarCliente(cliente);
		ClienteDao.getIntance().saveData(tienda.getMapClientes());
	}

	public void eliminarProducto(Producto producto) throws ElementoNuloException, ElementoNoEncontradoException {
		leerProductos();
		tienda.eliminarProducto(producto);
		ProductoDao.getInstance().saveData(tienda.getTreeProductos());
	}

	public void eliminarVenta(Venta venta) throws ElementoNuloException, ElementoNoEncontradoException {
		leerHistoricoVentas();
		tienda.eliminarVenta(venta);
		VentaDao.getInstance().saveData(tienda.getHistoricoVentas());
	}

	public void eliminarCliente(Cliente cliente) throws ElementoNuloException, ElementoNoEncontradoException {
		leerMapClientes();
		tienda.eliminarCliente(cliente);
		ClienteDao.getIntance().saveData(tienda.getMapClientes());
	}

	public void actualizarProducto(Producto producto) {
		leerProductos();
		try {
			tienda.actualizarProducto(producto);
			ProductoDao.getInstance().saveData(tienda.getTreeProductos());
		} catch (ElementoNuloException | ElementoNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actualizarVenta(Venta venta) {
		leerHistoricoVentas();
		tienda.actualizarVenta(venta);
		VentaDao.getInstance().saveData(tienda.getHistoricoVentas());
	}

	public void actualizarCliente(Cliente cliente) throws ElementoNuloException, ElementoNoEncontradoException {
		leerMapClientes();
		tienda.actualizarCliente(cliente);
		ClienteDao.getIntance().saveData(tienda.getMapClientes());
	}

	public Producto buscarProducto(String codigo) throws ElementoNoEncontradoException {
		leerProductos();
		Producto productoEncontrado = tienda.buscarProducto(codigo);
		return productoEncontrado;

	}
	public Venta buscarVenta(String codigo) throws ElementoNoEncontradoException {
		leerHistoricoVentas();
		Venta ventaEncontrada= tienda.buscarVenta(codigo);
		return ventaEncontrada;
	}
	public Cliente buscarCliente(String cedula) throws ElementoNoEncontradoException {
		leerMapClientes();
		Cliente clienteEncontrado= tienda.buscarCliente(cedula);
		return clienteEncontrado;
	}

}
