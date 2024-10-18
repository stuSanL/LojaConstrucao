package com.rrt.teste;


import com.rrt.dao.CategoriaDAO;
import com.rrt.models.Categoria;

import java.sql.SQLException;

public class TesteCategoria {
    public static void main(String[] args) throws SQLException {
        Categoria cat = new Categoria();
        CategoriaDAO cDAO = new CategoriaDAO();
        cat.setNome("Banheiro");
        cDAO.add(cat);
    }
}
