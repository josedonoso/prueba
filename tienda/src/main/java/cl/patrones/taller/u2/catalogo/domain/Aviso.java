package cl.patrones.taller.u2.catalogo.domain;



public class Aviso {

	private Long id;
	private String titulo;
	private String sku;
	private double precio;
	private String imagen;
	private int stockTotal;
	private Categoria categoria;
	
	public Aviso() {
		super();
	}
	public Aviso(Long id, String titulo, String sku, long precio, String imagen, int stock, Categoria categoria) {
		this.id = id;
		this.titulo = titulo;
		this.sku = sku;
		this.precio = precio;
		this.imagen = imagen;
		this.stockTotal = stock;
		this.categoria = categoria;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getStock() {
		return stockTotal;
	}
	public void setStock(int stock) {
		this.stockTotal = stock;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}		
}
