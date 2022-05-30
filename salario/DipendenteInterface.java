public interface DipendenteInterface {
    String getNome();
    String getCognome();
    Qualifica getQualifica();
    int getNumeroOrePerMese();

    void setQualifica(Qualifica qualifica);
    void setNumeroOrePerMese(int numeroOrePerMese);

    void update(int n);
}
