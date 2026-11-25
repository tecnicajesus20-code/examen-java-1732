package com.carmotors.dao;

import com.carmotors.modelo.RepuestoMinimo;
import java.sql.Connection;
import java.util.List;
/*
1. https://github.com/yondermaldonado/java_examen1_proyecto.git
2.https://github.com/yondermaldonado/java_examen2_proyecto.git
3. https://github.com/yondermaldonado/java_examen3_proyecto.git
4. https://github.com/yondermaldonado/java_examen4_proyecto.git
5. https://github.com/yondermaldonado/java_examen5_proyecto.git
 */
/** DAO: contrato que usa AlertasInventarioService para pedir repuestos y minimos. */
public interface AlertasDAO {
    List<RepuestoMinimo> listarRepuestos(Connection conexion);
}
