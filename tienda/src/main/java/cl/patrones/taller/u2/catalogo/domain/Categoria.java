package cl.patrones.taller.u2.catalogo.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String slug;

    @ManyToOne
    @JoinColumn(name = "padre_id")
    private Categoria padre;

	@OneToMany(mappedBy = "padre", fetch = FetchType.LAZY)
    private List<Categoria> hijos = new ArrayList<>();

	// Constructor vacío
	public Categoria() {}

	// Constructor con parámetros
    public Categoria(Long id, String nombre, String slug) {
        this.id = id;
        this.nombre = nombre;
        this.slug = slug;
    }

    // Getters y setters
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
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public Categoria getPadre() {
		return padre;
	}
	public void setPadre(Categoria padre) {
		this.padre = padre;
	}
	public List<Categoria> getHijos() {
		return hijos;
	}
	public void setHijos(List<Categoria> hijos) {
		this.hijos = hijos;
	}

	
}
