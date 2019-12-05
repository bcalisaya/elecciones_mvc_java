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
public class cedulaCandidato {
    private String dniVotante;
    private String dniCandidato;
    private String nombres;
    private String apellidos;
    private String nombre_partido;
    private String tipo_candidato;
    private String foto;
    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the nombre_partido
     */
    public String getNombre_partido() {
        return nombre_partido;
    }

    /**
     * @param nombre_partido the nombre_partido to set
     */
    public void setNombre_partido(String nombre_partido) {
        this.nombre_partido = nombre_partido;
    }

    /**
     * @return the tipo_candidato
     */
    public String getTipo_candidato() {
        return tipo_candidato;
    }

    /**
     * @param tipo_candidato the tipo_candidato to set
     */
    public void setTipo_candidato(String tipo_candidato) {
        this.tipo_candidato = tipo_candidato;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the dni
     */
    public String getDniVotante() {
        return dniVotante;
    }

    /**
     * @param dni the dni to set
     */
    public void setDniVotante(String dni) {
        this.dniVotante = dni;
    }

    /**
     * @return the dniCandidato
     */
    public String getDniCandidato() {
        return dniCandidato;
    }

    /**
     * @param dniCandidato the dniCandidato to set
     */
    public void setDniCandidato(String dniCandidato) {
        this.dniCandidato = dniCandidato;
    }
    
}
