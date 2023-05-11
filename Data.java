public class Data {
    private int dia;
    private int mes;
    private int ano;
    
    public Data(int dia, int mes, int ano) {
        if (!isDataValida(dia, mes, ano)) {
            System.out.println("Data inválida. Será atribuída a data padrão: 01/01/2000.");
            dia = 1;
            mes = 1;
            ano = 2000;
        }
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia() {
        return dia;
    }
    
    public void setDia(int dia) {
        if (isDataValida(dia, mes, ano)) {
            this.dia = dia;
        } else {
            System.out.println("Dia inválido. A data não foi alterada.");
        }
    }
    
    public int getMes() {
        return mes;
    }
    
    public void setMes(int mes) {
        if (isDataValida(dia, mes, ano)) {
            this.mes = mes;
        } else {
            System.out.println("Mês inválido. A data não foi alterada.");
        }
    }
    
    public int getAno() {
        return ano;
    }
    
    public void setAno(int ano) {
        if (isDataValida(dia, mes, ano)) {
            this.ano = ano;
        } else {
            System.out.println("Ano inválido. A data não foi alterada.");
        }
    }
    
    public boolean verificaAnoBissexto() {
        if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
    
    private boolean isDataValida(int dia, int mes, int ano) {
        if (ano < 1 || mes < 1 || mes > 12 || dia < 1 || dia > diasNoMes(mes, ano)) {
            return false;
        } else {
            return true;
        }
    }
    
    private int diasNoMes(int mes, int ano) {
        switch(mes) {
            case 2:
                return verificaAnoBissexto() ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public boolean depoisDe(Data outraData) {
        if (this.ano > outraData.ano) {
            return true;
        } else if (this.ano == outraData.ano && this.mes > outraData.mes) {
            return true;
        } else if (this.ano == outraData.ano && this.mes == outraData.mes && this.dia > outraData.dia) {
            return true;
        } else {
            return false;
        }
    }
}
 
