package br.com.alura.literalura.literalura.model;

import jakarta.persistence.*;

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id",nullable = false)
    private Autor autor;
    private String idioma;
    private Integer downloads;

    public Livro(){}

    public Livro(DadosLivro dadosLivro,Autor autor) {
        this.titulo=dadosLivro.titulo();
        this.autor=autor;
        this.idioma=dadosLivro.idioma().get(0);
        this.downloads=dadosLivro.dowloads();

    }

    public Integer getDownloads() {
        return downloads;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDowloads() {
        return downloads;
    }

    public void setDowloads(Integer dowloads) {
        this.downloads = dowloads;
    }


    @Override
    public String toString(){
        return "----------LIVRO-----------"+"\n"+
                "Titulo: "+titulo+"\n"+
                "Autor: "+autor.getNome()+"\n"+
                "Idioma: "+idioma+"\n"+
                "Dowloads:"+downloads+"\n"+
                "----------------------------"+"\n";

    }
}
