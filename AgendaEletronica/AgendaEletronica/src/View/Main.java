package View;

import java.util.Scanner;

import Controller.Agenda;
import Model.Contato;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Agenda agenda = new Agenda();
		String opcao;

		do {
			System.out.println("\nMenu:");
			System.out.println("1. Adicionar contato");
			System.out.println("2. Listar contatos");
			System.out.println("3. Buscar contato por nome ou email");
			System.out.println("4. Remover contato por nome ou email");
			System.out.println("5. Informar tamanho da agenda");
			System.out.println("6. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextLine();

			switch (opcao) {
			case "1":
				System.out.print("Nome: ");
				String nome = scanner.nextLine();
				System.out.print("Email: ");
				String email = scanner.nextLine();
				System.out.print("Telefone: ");
				long telefone = scanner.nextLong();
				scanner.nextLine();
				agenda.adicionarContato(new Contato(nome, email, telefone));
				break;
			case "2":
				System.out.println("Contatos:");
				agenda.listarContatos();
				System.out.print("Pressione Enter para voltar ao menu...");
				scanner.nextLine();
				break;
			case "3":
				System.out.print("Digite o nome ou email do contato: ");
				String busca = scanner.nextLine();
				Contato contatoEncontrado = agenda.buscarContatoPorNome(busca);
				if (contatoEncontrado == null) {
					contatoEncontrado = agenda.buscarContatoPorEmail(busca);
				}
				if (contatoEncontrado != null) {
					System.out.println("Contato encontrado:");
					System.out.println("Nome: " + contatoEncontrado.getNome());
					System.out.println("Email: " + contatoEncontrado.getEmail());
					System.out.println("Telefone: " + contatoEncontrado.getTelefone());
				} else {
					System.out.println("Contato não encontrado.");
				}
				System.out.print("Pressione Enter para voltar ao menu...");
				scanner.nextLine();
				break;
			case "4":
				System.out.print("Digite o nome ou email do contato a ser removido: ");
				String nomeOuEmail = scanner.nextLine();
				agenda.removerContato(nomeOuEmail);

				System.out.print("Pressione Enter para voltar ao menu...");
				scanner.nextLine();

				break;
			case "5":
				System.out.println("Tamanho da agenda: " + agenda.tamanhoAgenda());
				System.out.print("Pressione Enter para voltar ao menu...");
				scanner.nextLine();
				break;
			case "6":
				System.out.println("Programa finalizado.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (!opcao.equals("6"));
		scanner.close();
	}
}
