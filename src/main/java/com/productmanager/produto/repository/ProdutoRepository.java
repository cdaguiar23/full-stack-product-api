package com.productmanager.produto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productmanager.produto.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
