package tmps;

public class Product {
  private String titlu;
  private String descriere;
  private int grame;
  private int pret;

  public Product(String titlu, String descriere, int grame, int pret) {
    this.descriere = descriere;
    this.grame = grame;
    this.pret = pret;
    this.titlu = titlu;
  }


  public void setTitlu(String titlu) {
    this.titlu = titlu;
  }

  public void setDescriere(String descriere) {
    this.descriere = descriere;
  }

  public void setGrame(int grame) {
    this.grame = grame;
  }

  public void setPret(int pret) {
    this.pret = pret;
  }

  public String getTitlu() {
    return titlu;
  }

  public String getDescriere() {
    return descriere;
  }

  public int getGrame() {
    return grame;
  }

  public int getPret() {
    return pret;
  }

  public Object copy() {
    return this;
  }
}
