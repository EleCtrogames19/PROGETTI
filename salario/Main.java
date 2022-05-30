import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int salarioMedio = 0;
        int azione = 0;

        Scanner in = new Scanner(System.in);

        Registro r = new Registro();


        do {
            System.out.println("Quale azione vuoi eseguire?");
            System.out.println("1) Inserimento dipendente");
            System.out.println("2) Rimuovi dipendente");
            System.out.println("3) Stampa salario per ogni dipendente");
            System.out.println("4) Salario medio globale");
            System.out.println("5) Aggiungi ore lavorate ad un dipendente");
            System.out.println("0) Esci");


            azione = in.nextInt();
            switch (azione) {
                case 1:
                    System.out.println("Inserisci nome dipendente:");
                    String nome = in.next();

                    System.out.println("Inserisci cognome dipendente:");
                    String cognome = in.next();

                    System.out.println("Inserisci qualifica dipendente:");
                    System.out.println("1) Operaio");
                    System.out.println("2) Manager");
                    System.out.println("3) Dirigente");
                    System.out.println("4) Presidente");

                    Qualifica qualifica = null;
                    int q = in.nextInt();
                    switch (q) {
                        case 1:
                            qualifica = Qualifica.OPERAIO;
                            break;
                        case 2:
                            qualifica = Qualifica.MANAGER;
                            break;
                        case 3:
                            qualifica = Qualifica.DIRIGENTE;
                            break;
                        case 4:
                            qualifica = Qualifica.PRESIDENTE;
                            break;
                    }

                    System.out.println("Inserisci numero ore lavorate nel mese:");
                    int numeroOrePerMese = in.nextInt();

                    Dipendente d = new Dipendente(nome, cognome, qualifica, numeroOrePerMese);

                    r.addDipendente(d);
                    break;

                case 2:
                    System.out.println("Inserisci nome del dipendente da rimuovere:");
                    String nomeRimuovere = in.next();
                    System.out.println("Inserisci cognome del dipendente da rimuovere:");
                    String cognomeRimuovere = in.next();

                    try {
                        Dipendente dipendenteRimuovere = r.getDipendente(nomeRimuovere, cognomeRimuovere);
                        r.removeDipendente(dipendenteRimuovere);
                    } catch(DipendenteNonTrovatoException e) {
                        System.err.println("Dipendete non trovato!");
                    }
                    break;

                case 3:
                    for (int i = 0; i < r.getNumeroDipendenti(); i++) {
                        Dipendente dipendenteSalario = r.getDipendente(i);
                        System.out.println("Nome: " + dipendenteSalario.getNome() + " Cognome: " + dipendenteSalario.getCognome() + " Salario: " + r.getSalary(i));
                        salarioMedio += r.getSalary(i);
                    }
                    break;

                case 4:
                    double salari=0;
                    for (int i=0; i<r.getNumeroDipendenti();i++){
                        salari += r.getSalary(i);
                    }

                    salari /= r.getNumeroDipendenti();
                    System.out.println("Salario medio globale: " + salari);
                    break;

                case 5:
                    System.out.println("Inserisci nome del dipendente:");
                    String nomeDipendente = in.next();
                    System.out.println("Inserisci cognome del dipendente:");
                    String cognomeDipendente = in.next();
                    System.out.println("Inserire ore da aggiungere:");
                    int oreAggiungere = in.nextInt();

                    try {
                        Dipendente dipendenteAggiornare = r.getDipendente(nomeDipendente, cognomeDipendente);
                        dipendenteAggiornare.update(oreAggiungere);
                    } catch(DipendenteNonTrovatoException e) {
                        System.err.println("Dipendente non trovato!");
                    }

                    break;

            }
        } while(azione != 0);

    }
}
