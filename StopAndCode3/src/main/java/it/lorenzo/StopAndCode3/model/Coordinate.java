package it.lorenzo.StopAndCode3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coordinate")
public class Coordinate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Double lat;

  @Column(nullable = false)
  private Double lng;

  @OneToOne(mappedBy = "coordinate")
  private Comune comune;

  public Coordinate() {
  }

  public Coordinate(Double lat, Double lng) {
    this.lat = lat;
    this.lng = lng;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Double getLng() {
    return lng;
  }

  public void setLng(Double lng) {
    this.lng = lng;
  }

  public Comune getComune() {
    return comune;
  }

  public void setComune(Comune comune) {
    this.comune = comune;
  }
}
