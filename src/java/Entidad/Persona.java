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
public class Persona {
    private int id_persona;
    private String dni;
    private String nombre;
    private String apellidos;
    private String ubigeo;
    private String direcciones;
    private String sexo;
    private String estadocivil;
    private String foto;
    private boolean valid;
    
    public int getPersona() {
        return id_persona;
    }
    public void setPersona(int persona) {
        this.id_persona = persona;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getUbigeo() {
        return ubigeo;
    }
    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }
    public String getDirecciones() {
        return direcciones;
    }
    public void setDirecciones(String direcciones) {
        this.direcciones = direcciones;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEstadocivil() {
        return estadocivil;
    }
    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    /**
     * @return the valid
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * @param valid the valid to set
     */
    public void setValid(boolean valid) {
        this.valid = valid;
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
    
}
