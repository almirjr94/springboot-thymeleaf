package com.almirjr94.curso.boot.web.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.almirjr94.curso.boot.web.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

	@Override
	public List<Funcionario> findByNome(String nome) {
		return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%')", nome);
	}

	@Override
	public List<Funcionario> findByCargo(Long id) {
		
		return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
	}

	@Override
	public List<Funcionario> findBySaida(LocalDate saida) {
		
		return createQuery("select f from Funcionario f where f.dataSaida = ?1 order by f.dataEntrada asc", saida);
	}

	@Override
	public List<Funcionario> findByDataEntrada(LocalDate entrada) {
		return createQuery("select f from Funcionario f where f.dataEntrada = ?1 order by f.dataEntrada asc", entrada);
	}

	@Override
	public List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		return createQuery("select f from Funcionario f where f.dataEntrada >= ?1 and f.dataSaida <= ?2 order by f.dataEntrada asc", entrada, saida);
	}

}
