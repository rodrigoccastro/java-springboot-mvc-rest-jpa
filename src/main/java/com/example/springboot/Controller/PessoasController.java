package com.example.springboot.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.Model.jpafamilia.PessoaJpa;
import com.example.springboot.Model.jpafamilia.PessoaJpaRepositorio;

@RestController
public class PessoasController {

	private PessoaJpaRepositorio repPessoa;

	PessoasController(PessoaJpaRepositorio obj) {
	       this.repPessoa = obj;
	}

	@RequestMapping(value = "/pessoas", method = RequestMethod.GET)
	public List<PessoaJpa> Get() {
		return repPessoa.findAll();
	}

	@RequestMapping(value = "/pessoa/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<PessoaJpa> GetById(@PathVariable(value = "cpf") String cpf)
	{
		Optional<PessoaJpa> pessoa = repPessoa.findById(cpf);
	    if(pessoa.isPresent())
	    	return new ResponseEntity<PessoaJpa>(pessoa.get(), HttpStatus.OK);
	    else
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/pessoa", method =  RequestMethod.POST)
	public PessoaJpa Post(@Validated @RequestBody PessoaJpa pessoa)
	{
		return repPessoa.save(pessoa);
	}

	@RequestMapping(value = "/pessoa/{cpf}", method =  RequestMethod.PUT)
	public ResponseEntity<PessoaJpa> Put(@PathVariable(value = "cpf") String cpf, @Validated @RequestBody PessoaJpa newPessoa)
	{
		Optional<PessoaJpa> oldPessoa = repPessoa.findById(cpf);
	    if(oldPessoa.isPresent()){
	    	PessoaJpa pessoa = oldPessoa.get();
	        pessoa.setNome(newPessoa.getNome());
	        repPessoa.save(pessoa);
	        return new ResponseEntity<PessoaJpa>(pessoa, HttpStatus.OK);
	    } else
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/pessoa/{cpf}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "cpf") String cpf)
	{
		Optional<PessoaJpa> pessoa = repPessoa.findById(cpf);
	    if(pessoa.isPresent()){
	    	repPessoa.delete(pessoa.get());
	        return new ResponseEntity<>(HttpStatus.OK);
	    } else
	      	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	


}
