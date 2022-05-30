import java.util.ArrayList;

public class Registro implements RegistroInterface {
    private ArrayList<Dipendente> dipendenti = new ArrayList<>();

    public void addDipendente(Dipendente d) {
        this.dipendenti.add(d);
    }

    public void removeDipendente(Dipendente d) {
        this.dipendenti.remove(d);
    }

    public Dipendente getDipendente(String nome, String cognome) throws DipendenteNonTrovatoException {
        for(int i=0; i<dipendenti.size(); i++) {
            Dipendente d = dipendenti.get(i);
            if(d.getNome().equals(nome) && d.getCognome().equals(cognome)) {
                return d;
            }
        }

        throw new DipendenteNonTrovatoException("Dipendente non trovato");
    }

    public Dipendente getDipendente(int i) {
        return dipendenti.get(i);
    }

    public double getSalary(int i) {
        int straordinario = 0;
        int ore = 0;

        int paga_straordinario = 0;
        int paga_ore = 0;

        Dipendente d = dipendenti.get(i);


        if(d.getNumeroOrePerMese() > 100) {
            ore = 100;
            straordinario = d.getNumeroOrePerMese() - 100;
        } else {
            ore = d.getNumeroOrePerMese();
            straordinario = 0;
        }

        switch(d.getQualifica()) {
            case OPERAIO:
                paga_ore = 10;
                paga_straordinario = 20;
                break;
            case MANAGER:
                paga_ore = 15;
                paga_straordinario = 30;
                break;
            case DIRIGENTE:
                paga_ore = 20;
                paga_straordinario = 40;
                break;
            case PRESIDENTE:
                paga_ore = 50;
                paga_straordinario = 100;
                break;
        }

        return paga_ore * ore + paga_straordinario * straordinario;
    }

    public int getNumeroDipendenti() {
        return dipendenti.size();
    }
}