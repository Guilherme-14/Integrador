package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Cliente;
import com.projetojpa.repository.ClienteRepository;

@Service
public class ClienteService {

private final ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public List<Cliente> buscaTodosCliente(){
		return clienteRepository.findAll();
	}
	
	public Cliente BuscaClienteId(Long id) {
		Optional <Cliente> Cliente = clienteRepository.findById(id);
		return Cliente.orElse(null);
	}
	
	public Cliente salvaCliente(Cliente cliente) {
		return clienteRepository.save(cliente);	
	}
	
	public Cliente alterarCliente (Long id, Cliente alterarC) {
		Optional <Cliente> existeCliente = clienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			alterarC.setId(id);
			return clienteRepository.save(alterarC);
		}
		return null;
	}
	
	public boolean apagarCliente(Long id) {
		Optional <Cliente> existeCliente = clienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			clienteRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
