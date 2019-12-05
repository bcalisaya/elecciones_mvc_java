/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Bryan
 */
public class Candidato {
    private String id_candidatos;
    private String dni;
    private String tipo_candidato;
    private String foto;
    private String partido;
    public String getId_candidatos() {
        return id_candidatos;
    }
    public void setId_candidatos(String id_candidatos) {
        this.id_candidatos = id_candidatos;
    }
    
    public String getTipo_candidato() {
        return tipo_candidato;
    }
    public void setTipo_candidato(String tipo_candidato) {
        this.tipo_candidato = tipo_candidato;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getPartido() {
        return partido;
    }

    /**
     * @param partido the partido to set
     */
    public void setPartido(String partido) {
        this.partido = partido;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
}
