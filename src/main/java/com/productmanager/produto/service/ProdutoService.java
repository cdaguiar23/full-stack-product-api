package com.productmanager.produto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productmanager.produto.dto.ProdutoDTO;
import com.productmanager.produto.entity.Produto;
import com.productmanager.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
      @Autowired
    private ProdutoRepository repository;

    // Listar todos os produtos
    public List<ProdutoDTO> listarTodos() {
        List<Produto> produtos = repository.findAll();
        return produtos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

     // Helper method
     private ProdutoDTO convertToDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setResponsavel(produto.getResponsavel());
        dto.setDataCriacao(produto.getDataCriacao());
        dto.setDataModificacao(produto.getDataModificacao());
        dto.setTipoCategoria(produto.getTipoCategoria());
        dto.setAtivo(produto.getAtivo());
        return dto;
    }
}

