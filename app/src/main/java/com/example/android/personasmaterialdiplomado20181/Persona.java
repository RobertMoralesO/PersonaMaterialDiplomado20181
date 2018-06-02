package com.example.android.personasmaterialdiplomado20181;

/**
 * Created by android on 21/04/2018.
 */

public class Persona {
    private String id;
    private int foto;
    private String cedula;
    private String nombre;
    private String apellido;
    private int sexo;

    public Persona(){

    }

    public Persona(String id,int foto, String cedula, String nombre, String apellido, int sexo) {
        this.id= id;
        this.foto = foto;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
    }



    public Persona(String id){
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public void guardar(){
        Datos.agregar(this);
    }

    public void eliminar(){
        Datos.eliminarPersona(this);
    }

    public void modificar(){
        Datos.modificarPersona(this);
    }
}
