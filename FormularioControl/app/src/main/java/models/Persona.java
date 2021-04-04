package models;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Persona {


    private String Nombre;
    private String Apellido;
    private String Cargo;
    private String Email;
    private int Salario;
    private int Edad;


    public Persona() {

    }

    public Persona(String nombre, String apellido, String cargo, String email, int salario, int edad) {
        Nombre = nombre;
        Apellido = apellido;
        Cargo = cargo;
        Email = email;
        Salario = salario;
        Edad = edad;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int salario) {
        Salario = salario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

}
