package Progama;

public class ContaPoupanca extends Conta {

    private double taxaRendimento;

    
    public ContaPoupanca(Pessoa pessoa) {
        super(pessoa);
        this.taxaRendimento = 0.02; 
    }

    

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    
}
