/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;

public class Agenda {


    private final List<Contatos> contatosAgenda = new ArrayList();
    
        public Agenda() {
        
    }

    public List<Contatos> getContatosAgenda() {
        return contatosAgenda;
    }
	
	public void adicionarContato(Contatos c) {
		contatosAgenda.add(c);
		
	}

	public void removerContato(Contatos c) {
		contatosAgenda.remove(c.getId());
	}

	public void editarContato(Contatos antigo, String novoNome, String novoEmail, int novoTelefone) {
		for (Contatos contato : contatosAgenda) {
			if (contato.equals(antigo)) {
				contato.setNome(novoNome);
				contato.setEmail(novoEmail);
				contato.setTelefone(novoTelefone);
				break;
			}
		}

	}

	public void buscarContato(Contatos c) {
		for (Contatos contato : contatosAgenda) {
			if (contato.equals(c)) {
				System.out.println("Nome: " + contato.getNome());
				System.out.println("Email: " + contato.getEmail());
				System.out.println("Telefone: " + contato.getTelefone());
			}

		}

	}

	public void mostrarInfoContatos() {
		for (Contatos contato : contatosAgenda) {
			System.out.println("\nNome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Telefone: " + contato.getTelefone());
		}
	}
}