package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        Operacoes operacoes = new Operacoes();
        Scanner scanner = new Scanner(System.in);
        boolean exibeMenu = false;

        do {

        System.out.println("""
                Bem vindo:
                Digite 1 para: Abertura de conta
                Digite 2 para: Operacao na conta existente
                """);

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {

            case 1:
                System.out.println("Digite seu nome:");
                String nome = scanner.nextLine();
                Cliente cliente = new Cliente();
                cliente.nome = nome;
                clientes.add(cliente);

                exibeMenu = exibeOperacoes(scanner, cliente, operacoes);

                break;

            case 2:
                System.out.println("Digite nome cadastrado:");
                String nomeCadastrado = scanner.nextLine();
                Cliente clienteEncontrado = buscaCliente(clientes, nomeCadastrado);
                if (clienteEncontrado == null) {
                    System.out.println("Erro: Cliente não encontrado, confira se o nome é exatamente igual ao nome cadastrado.");
                    exibeMenu = true;
                } else {
                    System.out.println("Bem vindo(a) " + clienteEncontrado.nome);
                    exibeOperacoes(scanner, clienteEncontrado, operacoes);
                }
                break;

            default:
                System.out.println("Opcao invalida, por favor tente novamente");
                exibeMenu = true;

        }
        } while(exibeMenu);
    }

    private static boolean exibeOperacoes(Scanner scanner, Cliente cliente, Operacoes operacoes) {

        boolean novaOperacao = false;

        do {
            System.out.println("""
                    Qual tipo de conta voce gostaria de realizar uma operacao?
                    Digite 1 para: Corrente 
                    Digite 2 para: Poupanca
                    """);

            int tipoConta = scanner.nextInt();

            TipoContaEnum tipoContaSelecionada = operacoes.tipoConta(tipoConta);
            scanner.nextLine();

            System.out.println("""
                    Selecione a operacao:
                    Digite 1 para: Transferencia
                    Digite 2 para: Deposito
                    Digite 3 para: Consultar Saldo
                    Digite 4 para: Sair
                    """);

            int operacao = scanner.nextInt();
            scanner.nextLine();

            switch (operacao) {
                case 1:
                    System.out.println("Valor a transferir:");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine();
                    operacoes.transferir(cliente, valorTransferencia, tipoContaSelecionada);

                    exibeDados(cliente);
                    System.out.println("""
                            Digite 1 para: Realizar outra operacao
                            Digite 2 para: Sair
                            """);

                    int nextStep = scanner.nextInt();
                    novaOperacao = (nextStep == 1);


                    break;

                case 2:
                    System.out.println("Valor a depositar:");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    operacoes.depositar(cliente, valorDeposito, tipoContaSelecionada);

                    exibeDados(cliente);
                    System.out.println("""
                            Digite 1 para: Realizar outra operacao
                            Digite 2 para: Sair
                            """);

                    int returnOp = scanner.nextInt();
                    novaOperacao = (returnOp == 1);

                    break;
                case 3:
                    exibeDados(cliente);
                    System.out.println("""
                            Digite 1 para: Realizar outra operacao
                            Digite 2 para: Sair
                            """);
                    int returnOperacao = scanner.nextInt();
                    novaOperacao = (returnOperacao == 1);

                    break;
                case 4:
                    novaOperacao = false;
                    break;
                default:
                    System.out.println("Opcao invalida, por favor tente novamente");
                    novaOperacao = true;
            }

        } while (novaOperacao);
        return true;
    }

    private static void exibeDados(Cliente cliente) {
        System.out.println("""
                                   -------------------------------
                                   Nome:""" + cliente.nome + """
                                           
                                   Tipo de conta: Corrente
                                   Saldo: """ + cliente.saldoContaCorrente +
                           """
                                               
                                   Tipo de conta: Poupanca
                                   Saldo: """ + cliente.saldoContaPoupanca +
                           """
                                                                       
                                   -------------------------------          
                                   """);
    }

    public static Cliente buscaCliente(List<Cliente> clientes, String nomeBusca) {
        for (Cliente clienteAtual : clientes) {
            if (clienteAtual.nome.equals(nomeBusca)) {
                return clienteAtual;
            }
        }
        return null;
    }
}
