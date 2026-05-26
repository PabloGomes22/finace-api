package com.example.finance_api.controller;

import com.example.finance_api.model.Transacao;
import com.example.finance_api.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transacoes")
@CrossOrigin(origins = "*")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping
    public List<Transacao> listar() {
        return transacaoRepository.findAll();
    }

    @GetMapping("/saldo")
    public ResponseEntity<?> saldo() {
        Double receitas = transacaoRepository.somarReceitas();
        Double despesas = transacaoRepository.somarDespesas();
        Double saldo = receitas - despesas;

        return ResponseEntity.ok(Map.of(
                "receitas", receitas,
                "despesas", despesas,
                "saldo", saldo
        ));
    }

    @GetMapping("/receitas")
    public List<Transacao> listarReceitas() {
        return transacaoRepository.findByTipo("RECEITA");
    }

    @GetMapping("/despesas")
    public List<Transacao> listarDespesas() {
        return transacaoRepository.findByTipo("DESPESA");
    }

    @PostMapping
    public Transacao criar(@RequestBody Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!transacaoRepository.existsById(id)) return ResponseEntity.notFound().build();
        transacaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}