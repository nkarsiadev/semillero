package com.pichincha.maaseichaq.Service;

import com.pichincha.maaseichaq.Entity.Cuenta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CuentaServicio {
    public List<Cuenta> obtenerCuentas();
    public Optional<Cuenta> obtenerPorId(Long id);
    public Cuenta obtenerPorNumCuenta(String num_cuenta);
    public Cuenta guardarCuenta(Cuenta cuenta, Long id);
    public String eliminarCuenta(Long id);
    public Cuenta actualizarCuenta(Long id, Cuenta cuenta, Long id_user);
}
