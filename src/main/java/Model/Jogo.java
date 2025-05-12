package Model;

public class Jogo {

  private int id;
  private String titulo;

  public Jogo(int id, String titulo) {
    this.id = id;
    this.titulo = titulo;
  }

  public int getId() {
    return this.id;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String toString() {
    return id + " - " + titulo;
  }

}
