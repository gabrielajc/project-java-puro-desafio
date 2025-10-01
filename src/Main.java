package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("""
                Bem vindo:
                Digite 1 para: Abertura de conta
                Digite 2 para: Operacao na conta existente
                """);

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = new Cliente();
        Operacoes operacoes = new Operacoes();

        switch (opcao) {

            case 1:
                System.out.println("Digite seu nome:");
                String nome = scanner.nextLine();
                cliente.nome = nome;

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
                                                       Digite 1 para: Realizar outra operacao
                                                       Digite 2 para: Sair
                                                       """);
                            int nextStep = scanner.nextInt();
                            novaOperacao = (nextStep == 1) ? true : false;


                            break;

                        case 2:
                            System.out.println("Valor a depositar:");
                            double valorDeposito = scanner.nextDouble();
                            scanner.nextLine();
                            operacoes.depositar(cliente, valorDeposito, tipoContaSelecionada);

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
                                                       Digite 1 para: Realizar outra operacao
                                                       Digite 2 para: Sair
                                                       """);
                            int returnOp = scanner.nextInt();
                            novaOperacao = (returnOp == 1) ? true : false;

                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }

                } while (novaOperacao);

//---------------------------------------------

                break;

            case 2:
                if (cliente.nome != null) {

                }

                break;

            default:

        }



		/* desafio
		*
		*
		* Inicializar dados do cliente
Menu de opções
Visualização do saldo
Enviar valor
Receber valor
*
* resultado esperado ***********************
Dados iniciais do cliente:

Nome: Jacqueline Oliveira
Tipo conta: Corrente
Saldo inicial: R$ 2500,00
***********************

Operações

1- Consultar saldos
2- Receber valor
3- Transferir valor
4- Sair

Digite a opção desejada: */


    }
}
