package Progama;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ultilitarios.Utils;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
    	System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║     BEM-VINDOS AO BANCO RISADA FINANCEIRA        ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║ Selecione uma operação que deseja realizar:      ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║ 1. Criar conta                                   ║");
        System.out.println("╠──────────────────────────────────────────────────╣");
        System.out.println("║ 2. Depositar                                     ║");
        System.out.println("╠──────────────────────────────────────────────────╣");
        System.out.println("║ 3. Sacar                                         ║");
        System.out.println("╠──────────────────────────────────────────────────╣");
        System.out.println("║ 4. Transferir                                    ║");
        System.out.println("╠──────────────────────────────────────────────────╣");
        System.out.println("║ 5. Listar contas                                 ║");
        System.out.println("╠──────────────────────────────────────────────────╣");
        System.out.println("║ 6. Consultar conta                               ║");
        System.out.println("╠──────────────────────────────────────────────────╣");
        System.out.println("║ 7. Remover conta                                 ║");
        System.out.println("╠──────────────────────────────────────────────────╣");
        System.out.println("║ 8. consultar Balanço do Cliente                  ║");
        System.out.println("╠──────────────────────────────────────────────────╣"); 
        System.out.println("║ 9. criarContaEAssociarCliente                    ║");
        System.out.println("╠──────────────────────────────────────────────────╣"); 
        System.out.println("║ 10. .............                                ║");
        System.out.println("╠──────────────────────────────────────────────────╣");
        System.out.println("╠──────────────────────────────────────────────────╣");
        System.out.println("║ 15. Sair                                         ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        int operacao = input.nextInt();;

        switch (operacao) {
            case 1:
                criarConta();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                transferir();
                break;

            case 5:
                listarContas();
                break;
                
            case 6:
            	consultarConta();
                break;
                
            case 7:
                removerConta();
                break;
            case 8:
            	consultarBalançoCliente();
            	break;
            	
            case 9:
            	criarContaEAssociarCliente();
            	break;

            case 15:
                System.out.println("Flw é nóis!");
                System.exit(0); // para o sistema

            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        //System.out.println("Você está criando uma conta\n");

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("Email: ");
        String email = input.next();

        Pessoa cliente = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("--- Sua conta foi criada com sucesso! ---");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta contaa : contasBancarias) {
                if(contaa.getNumeroConta() == numeroConta) {
                    conta = contaa;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();

            conta.depositar(valorDeposito);
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();

    }

    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();

            conta.sacar(valorSaque);
            System.out.println("--- Saque realizado com sucesso! ---");
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();

    }

    public static void transferir() {
        System.out.println("Número da conta que vai enviar a transferência: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);

            }else {
                System.out.println("--- A conta para depósito não foi encontrada ---");
            }

        }else {
            System.out.println("--- Conta para transferência não encontrada ---");
        }
        operacoes();
    }

    public static void listarContas() {
    	    System.out.println("------------------------------------------------------");
    	    System.out.println("--------------- Lista de Contas Bancárias --------------");
    	    
    	    if (contasBancarias.size() > 0) {
    	        for (Conta conta : contasBancarias) {
    	            System.out.println("------------------------------------------------------");
    	            System.out.println("Número da Conta: " + conta.getNumeroConta());
    	            System.out.println("Nome do Cliente: " + conta.getPessoa().getNome());
    	            System.out.println("CPF do Cliente: " + conta.getPessoa().getCpf());
    	            System.out.println("Saldo: " + conta.getSaldo());
    	            System.out.println("------------------------------------------------------");
    	        }
    	    } else {
    	        System.out.println("--- Não há contas cadastradas ---");
    	    }

    	    operacoes();
    	}
    
    public static void consultarConta() {
        System.out.println("------------------------------------------------------");
        System.out.println("------------- Consulta de Conta Bancária ---------------");

        System.out.println("Digite o número da conta: ");
        int numeroContaConsulta = input.nextInt();

        Conta contaConsultada = encontrarConta(numeroContaConsulta);

        if (contaConsultada != null) {
            System.out.println("------------------------------------------------------");
            System.out.println("Número da Conta: " + contaConsultada.getNumeroConta());
            System.out.println("Nome do Cliente: " + contaConsultada.getPessoa().getNome());
            System.out.println("CPF do Cliente: " + contaConsultada.getPessoa().getCpf());
            System.out.println("Saldo: " + contaConsultada.getSaldo());
            System.out.println("------------------------------------------------------");
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();
    }
    
    public static void removerConta() {
        System.out.println("------------------------------------------------------");
        System.out.println("------------- Remoção de Conta Bancária ---------------");

        System.out.println("Digite o número da conta que deseja remover: ");
        int numeroContaRemover = input.nextInt();

        Conta contaRemover = encontrarConta(numeroContaRemover);

        if (contaRemover != null) {
            contasBancarias.remove(contaRemover);
            System.out.println("--- Conta removida com sucesso! ---");
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();
    }
    
    public static void consultarBalançoCliente() {
        System.out.println("------------------------------------------------------");
        System.out.println("------- Consulta de Balanço das Contas do Cliente ------");

        System.out.println("Digite o CPF do cliente que deseja consultar: ");
        String cpfCliente = input.next();

        double balancoTotal = 0.0;

        for (Conta conta : contasBancarias) {
            if (conta.getPessoa().getCpf().equals(cpfCliente)) {
                balancoTotal += conta.getSaldo();
            }
        }

        if (balancoTotal > 0.0) {
            System.out.println("Balanço total das contas do cliente " + cpfCliente + ": " + Utils.doubleToString(balancoTotal));
        } else {
            System.out.println("--- Cliente não encontrado ou não possui contas ---");
        }

        operacoes();
    }
    
 
    public static void criarContaEAssociarCliente() {
        System.out.println("------------------------------------------------------");
        System.out.println("--------- Criar Conta e Associar ao Cliente ----------");

        System.out.println("\nNome do Cliente: ");
        String nome = input.next();

        System.out.println("\nCPF do Cliente: ");
        String cpf = input.next();

        System.out.println("Email do Cliente: ");
        String email = input.next();

        Pessoa cliente = new Pessoa(nome, cpf, email);

        System.out.println("Tipo de Conta (1 - Corrente, 2 - Poupança): ");
        int tipoConta = input.nextInt();

        Conta conta;
        
        if (tipoConta == 1) {
            conta = new ContaCorrente(cliente);
        } else if (tipoConta == 2) {
            conta = new ContaPoupanca(cliente);
        } else {
            System.out.println("Tipo de conta inválido!");
            operacoes();
            return;
        }

        contasBancarias.add(conta);
        System.out.println("--- Conta criada e associada ao cliente com sucesso! ---");

        operacoes();
    }


	
    }
