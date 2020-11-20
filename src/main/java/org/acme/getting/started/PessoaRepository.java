package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {

	Pessoa login(String email, String senha) {
		return find("email = :pEmail and senha = :pSenha", Parameters.with("pEmail", email).and("pSenha", senha))
				.firstResult();
	}

}
