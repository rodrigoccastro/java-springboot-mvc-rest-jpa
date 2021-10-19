package com.example.springboot.Model.jpafamilia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaJpaRepositorio extends JpaRepository<PessoaJpa, String> { }

