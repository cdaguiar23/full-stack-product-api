package com.productmanager.produto.service;

import java.util.List;
import java.util.Optional;
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

    // Listar os produtos por id
     public ProdutoDTO listarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        return convertToDTO(produto);
    }

    // Criar um produto
     public ProdutoDTO criarProduto(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setResponsavel(dto.getResponsavel());
        produto.setTipoCategoria(dto.getTipoCategoria());
        Produto savedProduto = repository.save(produto);
        return convertToDTO(savedProduto);
    }

    //Atualiza produto
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO dto) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setResponsavel(dto.getResponsavel());
        produto.setTipoCategoria(dto.getTipoCategoria());
        Produto updatedProduto = repository.save(produto);
        return convertToDTO(updatedProduto);
    }

    // DELETE FÍSICO
    public boolean deletarFisico(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
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
        return dto;
    }
}