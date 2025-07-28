import java.util.ArrayList; // Importa a classe ArrayList
import java.util.List; // Importa a interface List

public class Banco {

	private String nome;
	private List<Conta> contas;

    // Construtor para inicializar o nome do banco e a lista de contas
    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>(); // Inicializa a lista de contas vazia
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

    // Método para adicionar uma conta ao banco
    public void adicionarConta(Conta conta) {
        if (conta != null) {
            this.contas.add(conta);
            System.out.println("Conta " + conta.getNumero() + " adicionada ao banco " + this.nome + ".");
        } else {
            System.out.println("Não é possível adicionar uma conta nula.");
        }
    }

    // Método para remover uma conta do banco
    public boolean removerConta(int numeroConta) {
        Conta contaParaRemover = null;
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                contaParaRemover = conta;
                break;
            }
        }
        if (contaParaRemover != null) {
            contas.remove(contaParaRemover);
            System.out.println("Conta " + numeroConta + " removida do banco " + this.nome + ".");
            return true;
        } else {
            System.out.println("Conta " + numeroConta + " não encontrada no banco.");
            return false;
        }
    }

    // Método para buscar uma conta pelo número
    public Conta buscarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null; // Retorna null se a conta não for encontrada
    }

    // Método para listar todas as contas do banco
    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("O banco " + this.nome + " não possui contas cadastradas.");
            return;
        }
        System.out.println("\n=== Contas Cadastradas no " + this.nome + " ===");
        for (Conta conta : contas) {
            // Assumindo que você quer imprimir um resumo, não o extrato completo aqui
            System.out.println(String.format("Agência: %d, Número: %d, Titular: %s, Saldo: %.2f", 
                                             conta.getAgencia(), conta.getNumero(), conta.cliente.getNome(), conta.getSaldo()));
        }
        System.out.println("==========================================");
    }
}
