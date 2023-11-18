package Progama;

public class ContaCorrente extends Conta {

    private double limiteChequeEspecial;

   
    public ContaCorrente(Pessoa pessoa) {
        super(pessoa);
        this.limiteChequeEspecial = 1000.0; // 
    }

    

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
}

    

