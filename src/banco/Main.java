package banco;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		venilton.setCpf("474-432-218.27");
		Conta cc = new ContaCorrente(venilton);
		Conta cp = new ContaPoupanca(venilton);
		
		cc.depositar(900);
		cc.transferir(230, cp);
		
		cc.imprimirExtrato();
		cp.imprimirExtrato();

		
	}

}
