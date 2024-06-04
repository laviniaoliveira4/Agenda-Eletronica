package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Contato;

public class Agenda {
	private List<Contato> contatos = new ArrayList<>();

	public void adicionarContato(Contato contato) {
		contatos.add(contato);
	}

	public void listarContatos() {
		for (Contato contato : contatos) {
			String exibir = "Nome: " + contato.getNome() + ", Email: " + contato.getEmail() + ", Telefone: "
					+ contato.getTelefone();
			System.out.println(exibir);

			if (exibir == null) {
				System.out.println("Contato não encontrado.");
			}
		}
	}

	public Contato buscarContatoPorNome(String nome) {
		for (Contato contato : contatos) {
			if (contato.getNome().equalsIgnoreCase(nome)) {
				return contato;
			}
		}
		return null;
	}

	public Contato buscarContatoPorEmail(String email) {
		for (Contato contato : contatos) {
			if (contato.getEmail().equalsIgnoreCase(email)) {
				return contato;
			}
		}
		return null;
	}

	public void removerContato(String nomeOuEmail) {
		Contato contato = buscarContatoPorNome(nomeOuEmail);
		if (contato == null) {
			contato = buscarContatoPorEmail(nomeOuEmail);
		}

		if (contato != null) {
			if (contatos.contains(contato)) {
				contatos.remove(contato);
				System.out.println("Contato removido com sucesso.");
			} else {
				System.out.println("Contato não encontrado ou não foi removido.");
			}
		} else {
			System.out.println("Contato não encontrado ou não foi removido.");
		}
	}

	public int tamanhoAgenda() {
		return contatos.size();
	}
}
