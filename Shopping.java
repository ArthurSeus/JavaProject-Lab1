import java.util.Arrays;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int quantidadeMaximaLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaximaLojas];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equals(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipo) {
        int quantidade = 0;

        for (Loja loja : lojas) {
            if (tipo.equalsIgnoreCase("Informática") && loja instanceof Informatica) {
                quantidade++;
            } else if (tipo.equalsIgnoreCase("Cosmético") && loja instanceof Cosmetico) {
                quantidade++;
            } else if (tipo.equalsIgnoreCase("Vestuário") && loja instanceof Vestuario) {
                quantidade++;
            } else if (tipo.equalsIgnoreCase("Bijuteria") && loja instanceof Bijuteria) {
                quantidade++;
            } else if (tipo.equalsIgnoreCase("Alimentação") && loja instanceof Alimentacao) {
                quantidade++;
            }
        }
        
        return quantidade;
    }
    

    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaSeguroMaisCaro = null, lojaInformaticaAtual = null;
        double maiorValorSeguro = 0.0;

        for (Loja loja : lojas) {
            if (loja != null && loja instanceof Informatica) {
                lojaInformaticaAtual = (Informatica) loja;
                double valorSeguro = lojaInformaticaAtual.getSeguroEletronicos();
                if (valorSeguro > maiorValorSeguro) {
                    maiorValorSeguro = valorSeguro;
                    lojaSeguroMaisCaro = lojaInformaticaAtual;
                }
            }
        }

        return lojaSeguroMaisCaro;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", lojas=" + Arrays.toString(lojas) +
                '}';
    }
}

