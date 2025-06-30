package cl.patrones.taller.u2.bodegaje.domain;

import java.util.ArrayList;
import java.util.List;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Producto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String sku;
	private String nombre;
	private String imagen;
	private Long costo;	  
	
	@ManyToOne
    @JoinColumn(name = "categoria_id")
	private Categoria categoria;
	private List<Stock> stocks = new ArrayList<>();
	
	public Producto(String sku, String nombre, Long costo, String imagen, Categoria categoria) {
		super();
		this.sku = sku;
		this.nombre = nombre;
		this.costo = costo;
		this.imagen = imagen;
		this.categoria = categoria;
	}
	public Producto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getCosto() {
		return costo;
	}
	public void setCosto(Long costo) {
		this.costo = costo;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", categoria=" + categoria.getNombre() +
               ", stocks=" + stocks.stream().mapToInt(Stock::getCantidad).sum() + "]";
    }
}
