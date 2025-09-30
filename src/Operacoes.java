package src;

public class Operacoes {

    public void depositar(Cliente cliente, double valor, TipoContaEnum conta) {
    if (conta == TipoContaEnum.CORRENTE){
        cliente.saldoContaCorrente += valor;
    } else if (conta == TipoContaEnum.POUPANCA) {
        cliente.saldoContaPoupanca += valor;
    }

    }
    
    public TipoContaEnum tipoConta(int tipoConta){
        TipoContaEnum conta = TipoContaEnum.CORRENTE;
        if (tipoConta == 1){
            conta = TipoContaEnum.CORRENTE;
        } else if (tipoConta == 2){
            conta = TipoContaEnum.POUPANCA;
        } return conta;
    }
}
