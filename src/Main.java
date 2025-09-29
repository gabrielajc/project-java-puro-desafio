package src;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {


        System.out.println("""
                Bem vindo:
                Digite 1 para: Abertura de conta
                Digite 2 para: Operacao na conta existente
                """);

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao){

            case 1:
                System.out.println("Digite seu nome:");
                String nome = scanner.nextLine();
                Cliente cliente = new Cliente();
                cliente.nome = nome;

                System.out.println("""
                Qual tipo de conta voce gostaria de realizar uma operacao?
                Digite 1 para: Corrente 
                Digite 2 para: Poupanca
                """);

                int conta = scanner.nextInt();
                cliente.tipoConta = conta;
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

                switch (operacao){
                    case 1:
                        break;

                    case 2:
                        System.out.println("Valor a depositar:");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        Operacoes operacoes = new Operacoes();
                        if(conta == 1){
                            operacoes.depositar(cliente, valorDeposito, conta);
                        } else if (conta == 2){
                            operacoes.depositar(cliente, valorDeposito, conta);
                        }
                        System.out.println("""
                        Nome:""" + cliente.nome + """
        
                        Tipo de conta: Corrente
                        Saldo: """ + cliente.saldoContaCorrente +
                                """
        
                        Tipo de conta: Poupanca
                        Saldo: """ + cliente.saldoContaPoupanca +
                                """
        
                        Digite 1 para: Realizar outra operacao
                        Digite 2 para: Sair
                        """)

                        ;

                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }

//---------------------------------------------

                break;

            case 2:

                break;

            default:

        }
//
//        //case 1 e 2
//        System.out.println("Digite seu nome:");
//
//        //case 2
//
//        System.out.println("""
//                Qual tipo de conta voce gostaria de realizar uma operacao?
//                Digite 1 para: Corrente
//                Digite 2 para: Poupanca
//                """);
//
//
//
//        System.out.println("""
//        Selecione a operacao:
//        Digite 1 para: Transferencia
//        Digite 2 para: Deposito
//        Digite 3 para: Consultar Saldo
//        Digite 4 para: Sair
//        """);
//
//        //case 1
//
//        System.out.println("Valor a transefir:");
//
//       //continuacao e case 3
//        System.out.println("""
//                Nome: interpolacao nome
//
//                Tipo de conta: Corrente
//                Saldo: interpolacao saldo final da conta corrente
//
//                Tipo de conta: Poupanca
//                Saldo: interpolacao saldo final da conta poupanca
//
//                Digite 1 para: Realizar outra operacao
//                Digite 2 para: Sair
//                """);
//
//        //case 2
//
//        System.out.println("Valor a depositar:");
//
//        //continuacao e case 3
//        System.out.println("""
//                Nome: interpolacao nome
//
//                Tipo de conta: Corrente
//                Saldo: interpolacao saldo final da conta corrente
//
//                Tipo de conta: Poupanca
//                Saldo: interpolacao saldo final da conta poupanca
//
//                Digite 1 para: Realizar outra operacao
//                Digite 2 para: Sair
//                """);
//




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
