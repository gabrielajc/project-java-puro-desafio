package src;

public class Operacoes {

    public void depositar(Cliente cliente, double valor, TipoContaEnum conta) {
        if (conta == TipoContaEnum.CORRENTE) {
            cliente.saldoContaCorrente += valor;
        } else if (conta == TipoContaEnum.POUPANCA) {
            cliente.saldoContaPoupanca += valor;
        }

    }

    public void transferir(Cliente cliente, double valor, TipoContaEnum conta) {
        if (conta == TipoContaEnum.CORRENTE) {
            double saldoExistente = cliente.saldoContaCorrente;
            if (saldoExistente < valor) {
                System.out.println("Erro: o valor que você deseja transferir nao é suficiente na conta selecionada");
                return;
            }
            cliente.saldoContaCorrente -= valor;
        } else if (conta == TipoContaEnum.POUPANCA) {
            double saldoExistente = cliente.saldoContaPoupanca;
            if (saldoExistente < valor) {
                System.out.println("Erro: o valor que você deseja transferir nao é suficiente na conta selecionada");
                return;
            }
            cliente.saldoContaPoupanca -= valor;
        }
    }


    public TipoContaEnum tipoConta(int tipoConta) {
        TipoContaEnum conta = TipoContaEnum.CORRENTE;
        if (tipoConta == 1) {
            conta = TipoContaEnum.CORRENTE;
        } else if (tipoConta == 2) {
            conta = TipoContaEnum.POUPANCA;
        }
        return conta;
    }
}
