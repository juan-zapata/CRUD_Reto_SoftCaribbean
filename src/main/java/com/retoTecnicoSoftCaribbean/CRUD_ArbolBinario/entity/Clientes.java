package com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.entity;




import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Table(name = "tcus_clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private int cus_nmcliente;
    @Column(length = 120)
    private String cus_dsnombres;
    @Column(length = 120)
    private String cus_dsapellidos;
    @Column(length = 120)
    private String cus_dsdireccion;
    @Column(length = 120, unique = true)
    private String cus_dscorreo;
    @Column(length = 20)
    private String cus_cdtelefono;
    @Column(length = 20)
    private String cus_cdtelefonoalter;
    @Column(length = 20, unique = true)
    private String cus_cdcelular;
    private int cus_nmcargo;
    @Column(length = 120)
    private String cus_dscargo;
    private int cus_nmciudad;
    @Column(length = 60)
    private String cus_dsciudad;
    @Column(updatable = false, nullable = false)
    private Calendar cus_fenacimiento;
    @Column(length = 1)
    private String cus_genero;
    private int cus_nmcomunidad;
    @Column(length = 120)
    private String cus_dscomunidad;
    @Column(length = 200)
    private String cus_dsempresalabora;
    private int cus_nmdivision;
    @Column(length = 120)
    private String  cus_dsdivision;
    private int cus_nmpais;
    @Column(length = 120)
    private String cus_dspais;
    @Column(length = 120)
    private String cus_hobbies;
    private Timestamp cus_febaja;
    private Timestamp cus_feregistro;

    public Clientes(){

    }

    public Clientes(int cus_nmcliente, String cus_dsnombres, String cus_dsapellidos, String cus_dsdireccion, String cus_dscorreo, String cus_cdtelefono, String cus_cdtelefonoalter, String cus_cdcelular, int cus_nmcargo, String cus_dscargo, int cus_nmciudad, String cus_dsciudad, Calendar cus_fenacimiento, String cus_genero, int cus_nmcomunidad, String cus_dscomunidad, String cus_dsempresalabora, int cus_nmdivision, String cus_dsdivision, int cus_nmpais, String cus_dspais, String cus_hobbies, Timestamp cus_febaja, Timestamp cus_feregistro) {
        this.id = id;
        this.cus_nmcliente = cus_nmcliente;
        this.cus_dsnombres = cus_dsnombres;
        this.cus_dsapellidos = cus_dsapellidos;
        this.cus_dsdireccion = cus_dsdireccion;
        this.cus_dscorreo = cus_dscorreo;
        this.cus_cdtelefono = cus_cdtelefono;
        this.cus_cdtelefonoalter = cus_cdtelefonoalter;
        this.cus_cdcelular = cus_cdcelular;
        this.cus_nmcargo = cus_nmcargo;
        this.cus_dscargo = cus_dscargo;
        this.cus_nmciudad = cus_nmciudad;
        this.cus_dsciudad = cus_dsciudad;
        this.cus_fenacimiento = cus_fenacimiento;
        this.cus_genero = cus_genero;
        this.cus_nmcomunidad = cus_nmcomunidad;
        this.cus_dscomunidad = cus_dscomunidad;
        this.cus_dsempresalabora = cus_dsempresalabora;
        this.cus_nmdivision = cus_nmdivision;
        this.cus_dsdivision = cus_dsdivision;
        this.cus_nmpais = cus_nmpais;
        this.cus_dspais = cus_dspais;
        this.cus_hobbies = cus_hobbies;
        this.cus_febaja = cus_febaja;
        this.cus_feregistro = cus_feregistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getCus_fenacimiento() {
        return cus_fenacimiento;
    }

    public void setCus_fenacimiento(Calendar cus_fenacimiento) {
        this.cus_fenacimiento = cus_fenacimiento;
    }

    public int getCus_nmcliente() {
        return cus_nmcliente;
    }

    public void setCus_nmcliente(int cus_nmcliente) {
        this.cus_nmcliente = cus_nmcliente;
    }

    public String getCus_dsnombres() {
        return cus_dsnombres;
    }

    public void setCus_dsnombres(String cus_dsnombres) {
        this.cus_dsnombres = cus_dsnombres;
    }

    public String getCus_dsapellidos() {
        return cus_dsapellidos;
    }

    public void setCus_dsapellidos(String cus_dsapellidos) {
        this.cus_dsapellidos = cus_dsapellidos;
    }

    public String getCus_dsdireccion() {
        return cus_dsdireccion;
    }

    public void setCus_dsdireccion(String cus_dsdireccion) {
        this.cus_dsdireccion = cus_dsdireccion;
    }

    public String getCus_dscorreo() {
        return cus_dscorreo;
    }

    public void setCus_dscorreo(String cus_dscorreo) {
        this.cus_dscorreo = cus_dscorreo;
    }

    public String getCus_cdtelefono() {
        return cus_cdtelefono;
    }

    public void setCus_cdtelefono(String cus_cdtelefono) {
        this.cus_cdtelefono = cus_cdtelefono;
    }

    public String getCus_cdtelefonoalter() {
        return cus_cdtelefonoalter;
    }

    public void setCus_cdtelefonoalter(String cus_cdtelefonoalter) {
        this.cus_cdtelefonoalter = cus_cdtelefonoalter;
    }

    public String getCus_cdcelular() {
        return cus_cdcelular;
    }

    public void setCus_cdcelular(String cus_cdcelular) {
        this.cus_cdcelular = cus_cdcelular;
    }

    public int getCus_nmcargo() {
        return cus_nmcargo;
    }

    public void setCus_nmcargo(int cus_nmcargo) {
        this.cus_nmcargo = cus_nmcargo;
    }

    public String getCus_dscargo() {
        return cus_dscargo;
    }

    public void setCus_dscargo(String cus_dscargo) {
        this.cus_dscargo = cus_dscargo;
    }

    public int getCus_nmciudad() {
        return cus_nmciudad;
    }

    public void setCus_nmciudad(int cus_nmciudad) {
        this.cus_nmciudad = cus_nmciudad;
    }

    public String getCus_dsciudad() {
        return cus_dsciudad;
    }

    public void setCus_dsciudad(String cus_dsciudad) {
        this.cus_dsciudad = cus_dsciudad;
    }

    public String getCus_genero() {
        return cus_genero;
    }

    public void setCus_genero(String cus_genero) {
        this.cus_genero = cus_genero;
    }

    public int getCus_nmcomunidad() {
        return cus_nmcomunidad;
    }

    public void setCus_nmcomunidad(int cus_nmcomunidad) {
        this.cus_nmcomunidad = cus_nmcomunidad;
    }

    public String getCus_dscomunidad() {
        return cus_dscomunidad;
    }

    public void setCus_dscomunidad(String cus_dscomunidad) {
        this.cus_dscomunidad = cus_dscomunidad;
    }

    public String getCus_dsempresalabora() {
        return cus_dsempresalabora;
    }

    public void setCus_dsempresalabora(String cus_dsempresalabora) {
        this.cus_dsempresalabora = cus_dsempresalabora;
    }

    public int getCus_nmdivision() {
        return cus_nmdivision;
    }

    public void setCus_nmdivision(int cus_nmdivision) {
        this.cus_nmdivision = cus_nmdivision;
    }

    public String getCus_dsdivision() {
        return cus_dsdivision;
    }

    public void setCus_dsdivision(String cus_dsdivision) {
        this.cus_dsdivision = cus_dsdivision;
    }

    public int getCus_nmpais() {
        return cus_nmpais;
    }

    public void setCus_nmpais(int cus_nmpais) {
        this.cus_nmpais = cus_nmpais;
    }

    public String getCus_dspais() {
        return cus_dspais;
    }

    public void setCus_dspais(String cus_dspais) {
        this.cus_dspais = cus_dspais;
    }

    public String getCus_hobbies() {
        return cus_hobbies;
    }

    public void setCus_hobbies(String cus_hobbies) {
        this.cus_hobbies = cus_hobbies;
    }

    public Timestamp getCus_febaja() {
        return cus_febaja;
    }

    public void setCus_febaja(Timestamp cus_febaja) {
        this.cus_febaja = cus_febaja;
    }

    public Timestamp getCus_feregistro() {
        return cus_feregistro;
    }

    public void setCus_feregistro(Timestamp cus_feregistro) {
        this.cus_feregistro = cus_feregistro;
    }
}
