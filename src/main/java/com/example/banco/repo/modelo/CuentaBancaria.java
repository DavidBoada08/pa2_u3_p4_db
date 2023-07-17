package com.example.banco.repo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentabancaria")
public class CuentaBancaria {

    @Id
    @SequenceGenerator(name = "seq_cuentabancaria", sequenceName = "seq_cuentabancaria", allocationSize = 1)
    @GeneratedValue(generator = "seq_cuentabancaria", strategy = GenerationType.SEQUENCE)
    @Column(name = "cuen_id")
    private Integer id;

    @Column(name = "cuen_numero")
    private String numero;

    @Column(name = "cuen_saldo")
    private BigDecimal saldo;

    @Column(name = "cuen_tipo")
    private String tipo;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "cuen_id_pro")
    private Propietario propietario;

    @OneToMany(mappedBy = "cuentaBancariaOrigen", cascade = CascadeType.ALL)
    private List<Transferencia> transferencias;

    @OneToMany(mappedBy = "cuentaBancariaDestino", cascade = CascadeType.ALL)
    private List<Transferencia> transferenciasDestino;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Transferencia> getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(List<Transferencia> transferencias) {
        this.transferencias = transferencias;
    }

    public List<Transferencia> getTransferenciasDestino() {
        return transferenciasDestino;
    }

    public void setTransferenciasDestino(List<Transferencia> transferenciasDestino) {
        this.transferenciasDestino = transferenciasDestino;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo
                +"]";
    }

}
