package banco;

public abstract class Conta implements IConta{
	
	private static int SEQUENCIAL = 1;
	private static final int AGENCIA_PADRAO = 1024;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	private Cliente cliente;

	
	protected void imprimirInfos() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("CPF: %s", this.cliente.getCpf()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numero));
		System.out.println(String.format("Saldo: R$%.2f", this.saldo));
	}
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}
	
	@Override
	public void depositar(double valor) {
		saldo += valor;
	}
	
	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	
}
