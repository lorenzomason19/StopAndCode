package it.lorenzo.StopAndCode3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comuni")
public class Comune {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(name = "codice_catastale", nullable = false, unique = true, length = 4)
  private String codiceCatastale;

  @Column(nullable = false, length = 10)
  private String provincia;

  @Column(nullable = false, length = 5)
  private String cap;

  @Column(nullable = false, length = 4)
  private String prefisso;

  @Column(nullable = false)
  private String mail;

  @Column(nullable = false)
  private String pec;

  @Column(nullable = false, length = 30)
  private String telefono;

  @Column(nullable = false, length = 30)
  private String fax;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_coordinata", nullable = false)
  private Coordinate coordinate;

  // Costruttori
  public Comune() {
  }

  // Getter e Setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCodiceCatastale() {
    return codiceCatastale;
  }

  public void setCodiceCatastale(String codiceCatastale) {
    this.codiceCatastale = codiceCatastale;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getCap() {
    return cap;
  }

  public void setCap(String cap) {
    this.cap = cap;
  }

  public String getPrefisso() {
    return prefisso;
  }

  public void setPrefisso(String prefisso) {
    this.prefisso = prefisso;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getPec() {
    return pec;
  }

  public void setPec(String pec) {
    this.pec = pec;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
  }
}
