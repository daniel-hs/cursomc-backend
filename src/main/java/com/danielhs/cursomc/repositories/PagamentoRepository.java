package com.danielhs.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielhs.cursomc.domain.Pagamento;

//A superclasse ja abrange todas
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
