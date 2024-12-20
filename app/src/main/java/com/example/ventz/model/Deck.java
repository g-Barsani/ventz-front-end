package com.example.ventz.model;

// Uma classe com apenas getters e setters chama-se java bean

public class Deck {

    private Integer idDeck;
    private String nome;
    private String nomeCriador;
//    int qttCartas;
    int id_usuario_fk_id_usuario;

    public Deck() { }

    public Deck(Integer idDeck, String nome, int id_usuario_fk_id_usuario) {
        this.idDeck = idDeck;
        this.nome = nome;
        this.id_usuario_fk_id_usuario = id_usuario_fk_id_usuario;


    }

    public Deck(String nome, int id_usuario_fk_id_usuario) {
        this.nome = nome;
        this.id_usuario_fk_id_usuario = id_usuario_fk_id_usuario;
    }public Deck(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "idDeck=" + idDeck +
                ", nome='" + nome + '\'' +
                ", id_usuario_fk_id_usuario=" + id_usuario_fk_id_usuario +
                '}';
    }

    public Integer getIdDeck() {
        return idDeck;
    }

    public void setIdDeck(Integer idDeck) {
        this.idDeck = idDeck;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_usuario_fk_id_usuario() {
        return id_usuario_fk_id_usuario;
    }

    public void setId_usuario_fk_id_usuario(int id_usuario_fk_id_usuario) {
        this.id_usuario_fk_id_usuario = id_usuario_fk_id_usuario;
    }
}
