package com.productmanager.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productmanager.produto.dto.ProdutoDTO;
import com.productmanager.produto.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

     // Listar todos os produtos
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarTodos() {
        List<ProdutoDTO> produtos = service.listarTodos();
        return ResponseEntity.ok(produtos);
    }

     // Listar os produtos por id
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> listarPorId(@PathVariable Long id) {
        ProdutoDTO produto = service.listarPorId(id);
        return ResponseEntity.ok(produto);
    }
    
     // Criar um produto
    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@Valid @RequestBody ProdutoDTO dto) {
        ProdutoDTO produto = service.criarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

     // Atualizar um produto
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @Valid @RequestBody ProdutoDTO dto) {
        ProdutoDTO produto = service.atualizarProduto(id, dto);
        return ResponseEntity.ok(produto);
    }
}
