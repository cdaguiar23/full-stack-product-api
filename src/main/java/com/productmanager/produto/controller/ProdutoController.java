package com.productmanager.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productmanager.produto.dto.ProdutoDTO;
import com.productmanager.produto.service.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")
@Tag(name = "Produtos", description = "Endpoints para gerenciamento de produtos")
@SecurityRequirement(name = "Bearer Authentication")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

     // Listar todos os produtos
    @GetMapping
    @Operation(summary = "Listar todos os produtos", description = "Retorna uma lista de todos os produtos cadastrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso")
    })
    public ResponseEntity<List<ProdutoDTO>> listarTodos() {
        List<ProdutoDTO> produtos = service.listarTodos();
        return ResponseEntity.ok(produtos);
    }

     // Listar os produtos por id
    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto por ID", description = "Retorna um produto específico pelo seu ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto encontrado"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<ProdutoDTO> listarPorId(@Parameter(description = "ID do produto") @PathVariable Long id) {
        ProdutoDTO produto = service.listarPorId(id);
        return ResponseEntity.ok(produto);
    }
    
     // Criar um produto
    @PostMapping
    @Operation(summary = "Criar um novo produto", description = "Cria um novo produto no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<ProdutoDTO> criarProduto(@Valid @RequestBody ProdutoDTO dto) {
        ProdutoDTO produto = service.criarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

     // Atualizar um produto
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um produto", description = "Atualiza os dados de um produto existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<ProdutoDTO> atualizarProduto(@Parameter(description = "ID do produto") @PathVariable Long id, @Valid @RequestBody ProdutoDTO dto) {
        ProdutoDTO produto = service.atualizarProduto(id, dto);
        return ResponseEntity.ok(produto);
    }

    // DELETE FÍSICO
    @DeleteMapping("/{id}/hard")
    @Operation(summary = "Deletar produto permanentemente", description = "Remove um produto do sistema de forma permanente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<String> deletarFisicamente(@Parameter(description = "ID do produto") @PathVariable Long id) {
        boolean deleted = service.deletarFisico(id);
        if (!deleted) {
            return ResponseEntity.ok("Produto não encontrado");
        }
        return ResponseEntity.ok("Produto deletado permanentemente");
    }
}