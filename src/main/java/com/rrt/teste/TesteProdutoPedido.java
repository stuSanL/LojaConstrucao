package com.rrt.teste;

import com.rrt.dao.ClienteDAO;
import com.rrt.dao.PedidoDAO;
import com.rrt.dao.ProdutoPedidoDAO;
import com.rrt.models.Pedido;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;

public class TesteProdutoPedido {

    public static void main(String[] args) {
        ProdutoPedidoDAO dao = new ProdutoPedidoDAO();
        ClienteDAO cdao = new ClienteDAO();
        PedidoDAO pdao = new PedidoDAO();
        dao.findByPedidoId(1).forEach(p->{
            System.out.println(p.getPedido().getCliente().getNome() + " " + p.getId() + ". " + p.getProduto().getNome() + " : " + p.getProduto().getPreco() + " * " + p.getQuantidade());
        });
        dao.findByPedidoId(2).forEach(p->{
            System.out.println(p.getPedido().getCliente().getNome() + " " + p.getId() + ". " + p.getProduto().getNome() + " : " + p.getProduto().getPreco() + " * " + p.getQuantidade());
        });
        double preco = dao.PedidoTotalPrice(1);
        Format formatter = new DecimalFormat("#.##");
        System.out.println(formatter.format(preco));

        /*System.out.println(pdao.findById(1).getData_pedido());
        System.out.println(cdao.findById(1).getId());*/
        /*cdao.findAll().forEach(c->{
            System.out.println(c.getNome());;
        });*/
        /*Pedido p = pdao.findById(1);
        System.out.println(p.getData_pedido() + " " + p.getCliente().toString() + "\nCliente getNome: " + p.getCliente().getNome());*/
    }
}
