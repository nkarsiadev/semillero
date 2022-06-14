package com.pichincha.maaseichaq.Service;

import com.pichincha.maaseichaq.Entity.*;
import com.pichincha.maaseichaq.ExceptionsProyect.Exception.BadRequestException;
import com.pichincha.maaseichaq.ExceptionsProyect.Exception.NotFoundException;
import com.pichincha.maaseichaq.Repository.CuentaRepository;
import com.pichincha.maaseichaq.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaService implements CuentaServicio{
    @Autowired
    CuentaRepository cuentaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Cuenta> obtenerCuentas() {
        List<Cuenta> cuentas = (List<Cuenta>) cuentaRepository.findAll();
        if (cuentas.size() > 0){
            return cuentas;
        }else {
            throw new BadRequestException("{\"message\":\"No existen cuentas\",\"status\":false}");
        }
    }

    @Override
    public Optional<Cuenta> obtenerPorId(Long id) {
        if (!cuentaRepository.existsById(id)){
            throw new NotFoundException("No existe cuenta con el id "+id);
        }
        return cuentaRepository.findById(id);
    }

    @Override
    public Cuenta obtenerPorNumCuenta(String num_cuenta) {
        if (!cuentaRepository.existByNumCuenta(num_cuenta)){
            throw new NotFoundException("No existe la cuenta con el numero "+num_cuenta);
        }
        return cuentaRepository.searchNumCuenta(num_cuenta);
    }

    @Override
    public Cuenta guardarCuenta(Cuenta cuenta, Long id) {
        if (usuarioRepository.existsById(id)) {
            Optional<Usuario> user = usuarioRepository.findById(id);
            cuenta.setUsuario(user.get());
            if (!cuentaRepository.existByNumCuenta(cuenta.getNum_cuenta())) {
                return cuentaRepository.save(cuenta);
            } else {
                throw new BadRequestException("Ya existe el numero de cuenta "+cuenta.getNum_cuenta());
            }
        }else {
            throw new NotFoundException("No existe el usuario con el id "+id);
        }
    }

    @Override
    public String eliminarCuenta(Long id) {
        if (cuentaRepository.existsById(id)){
            cuentaRepository.deleteById(id);
            return "{\"message\":\"Cuenta eliminada exitosamente\",\"status\":true}";
        }else {
            throw new NotFoundException("{\"message\":\"No existe la cuenta con el id "+id+"\",\"status\":false}");
        }

    }

    @Override
    public Cuenta actualizarCuenta(Long id, Cuenta cuenta, Long id_user) {
        if (cuentaRepository.existsById(id)){
            Optional<Cuenta> cnt = cuentaRepository.findById(id);
            if (usuarioRepository.existsById(id_user)) {
                if (cnt.get().obtenerUsuario().getId() == id_user) {
                    Optional<Usuario> user = usuarioRepository.findById(id_user);
                    String traeNumCuenta = cuenta.getNum_cuenta();
                    if (cuentaRepository.existByNumCuenta(traeNumCuenta)) {
                        Cuenta objCuenta = cuentaRepository.searchNumCuenta(traeNumCuenta);
                        String searchNumCuenta = objCuenta.getNum_cuenta();
                        if (searchNumCuenta.equals(traeNumCuenta)) {
                            cuenta.setUsuario(user.get());
                            cuenta.setId_cuenta(id);
                            return cuentaRepository.save(cuenta);
                        } else {
                            throw new BadRequestException("No se puede modificar el número de cuenta");
                        }
                    } else {
                        throw new BadRequestException("No se puede modificar el número de cuenta");
                    }
                }else{
                    throw new BadRequestException("No se puede modicar la cuenta");
                }
            }else {
                throw new NotFoundException("No existe el usuario con el id "+id_user);
            }
        }else{
            throw new NotFoundException("No existe la cuenta con el id "+id);
        }
    }
}
