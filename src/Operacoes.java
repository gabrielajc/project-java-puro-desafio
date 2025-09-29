package src;

public class Operacoes {

    public void depositar(Cliente cliente, double valor, int conta) {
    if (conta == 1){
        cliente.saldoContaCorrente =+ valor;
    } else if (conta == 2) {
        cliente.saldoContaPoupanca =+ valor;
    }

    }
}
