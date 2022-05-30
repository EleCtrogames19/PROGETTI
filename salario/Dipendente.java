public class Dipendente implements DipendenteInterface {
        private String nome;
        private String cognome;
        private Qualifica qualifica;
        private int numeroOrePerMese;

        Dipendente(String nome, String cognome, Qualifica qualifica, int numeroOrePerMese) {
            this.nome = nome;
            this.cognome = cognome;
            this.qualifica = qualifica;
            this.numeroOrePerMese = numeroOrePerMese;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCognome() {
            return cognome;
        }

        public void setCognome(String cognome) {
            this.cognome = cognome;
        }

        public Qualifica getQualifica() {
            return qualifica;
        }

        public void setQualifica(Qualifica qualifica) {
            this.qualifica = qualifica;
        }

        public int getNumeroOrePerMese() {
            return numeroOrePerMese;
        }

        public void setNumeroOrePerMese(int numeroOrePerMese) {
            this.numeroOrePerMese = numeroOrePerMese;
        }

        public void update(int n) {
            this.numeroOrePerMese += n;
        }

    }

