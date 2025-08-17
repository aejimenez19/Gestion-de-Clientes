package com.aejimenezdev.GestionDeClientes.Repository;

import com.aejimenezdev.GestionDeClientes.Model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}
