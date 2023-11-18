package Progama;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ultilitarios.Utils;

public class Conta {
	
	private static int contadorDEContas = 1;
	
	private int NumeroConta;
	private Pessoa pessoa;
	private Double Saldo = 0.0;
	private List<Transacao> transacoes;

	
	
	public Conta(Pessoa pessoa) {
		
		NumeroConta = contadorDEContas;
		this.pessoa = pessoa;
		contadorDEContas += 1;
		 this.transacoes = new ArrayList<>();
	}


	public int getNumeroConta() {
		return NumeroConta;
	}


	public void setNumeroConta(int numeroConta) {
		NumeroConta = numeroConta;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public Double getSaldo() {
		return Saldo;
	}


	public void setSaldo(Double saldo) {
		Saldo = saldo;
	}
	
	public String ToString() {
	    return "\nNúmero Da Conta: " + this.getNumeroConta() +
	           "\nNome: " + this.pessoa.getNome() +
	           "\nCpf: " + this.pessoa.getCpf() +
	           "\nEmail: " + this.pessoa.getEmail() +
	           "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
	           "\n";
	}
	
	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
		System.out.println("Deposito realizado com Sucesso");
		}
		else {
			System.out.println("Deposito falhou:(");
		}
	}
		
		
		public void sacar(Double valor) {
			if (valor > 0 && this.getSaldo() >= valor) {
				setSaldo(getSaldo() - valor);
				System.out.println("Saque realizado com Sucesso");
			}else {
				System.out.println("Não foi possivel realizar o Saque:(");
			}
		}
		
		public void transferir(Conta contaPARADEposito, Double valor) {
			if (valor > 0 && this.getSaldo() >= valor) {
				setSaldo(getSaldo() - valor);
				
				contaPARADEposito.Saldo = contaPARADEposito.getSaldo()+ valor;
				System.out.println("Transferencia Realiaza com sucesso!!!");
				
			}else {
				System.out.println(" transferencia falhou :(");
			}
			
		}

		 public void adicionarTransacao(Transacao transacao) {
		        this.transacoes.add(transacao);
		 }
		 
	
	

}
