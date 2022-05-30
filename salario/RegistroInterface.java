public interface RegistroInterface {
    void addDipendente(Dipendente d);
    void removeDipendente(Dipendente d);
    double getSalary(int i);
    Dipendente getDipendente(int i);
    Dipendente getDipendente(String nome, String cognome) throws DipendenteNonTrovatoException;
}
