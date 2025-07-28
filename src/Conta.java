
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		// Adicionando uma validação simples para saque
		if (saldo >= valor && valor > 0) {
			saldo -= valor;
		} else if (valor <= 0) {
            System.out.println("Valor de saque deve ser positivo.");
        }
        else {
			System.out.println("Saldo insuficiente!");
		}
	}

	@Override
	public void depositar(double valor) {
		// Adicionando uma validação simples para depósito
		if (valor > 0) {
			saldo += valor;
		} else {
			System.out.println("Valor de depósito deve ser positivo.");
		}
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		// Primeiro saca da conta de origem
		if (this.saldo >= valor && valor > 0) {
			this.sacar(valor);
			// Depois deposita na conta de destino
			contaDestino.depositar(valor);
		} else if (valor <= 0) {
            System.out.println("Valor de transferência deve ser positivo.");
        }
        else {
			System.out.println("Saldo insuficiente para realizar a transferência.");
		}
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

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
