package com.gestionProduit.backEnd.service.client;

import com.gestionProduit.backEnd.Entity.client;
import com.gestionProduit.backEnd.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<client> getAllClinet() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<client> getClinetById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public client createClient(client clientInfo) {
        return clientRepository.save(clientInfo);
    }

    @Override
    public client updateClinet(client clientInfo, Integer id) {
        Optional<client> clientOptional =  clientRepository.findById(id);
        if(clientOptional.isPresent()){
            client existingClinet = clientOptional.get();
            existingClinet.setPrenom(clientInfo.getPrenom());
            existingClinet.setNom(clientInfo.getNom());
            existingClinet.setAdresse(clientInfo.getAdresse());
            existingClinet.setNum_tel(clientInfo.getNum_tel());
            existingClinet.setVille(clientInfo.getVille());
            return clientRepository.save(existingClinet);
        }else{
            throw  new EntityNotFoundException("Client id not found : "+id);
        }
    }

    @Override
    public void removeClinetById(Integer id) {
        Optional<client> clientOptional =  clientRepository.findById(id);
        if(clientOptional.isPresent()){
            clientRepository.deleteById(id);
        }else{
            throw  new EntityNotFoundException("Client id not found : "+id);
        }

    }
}
