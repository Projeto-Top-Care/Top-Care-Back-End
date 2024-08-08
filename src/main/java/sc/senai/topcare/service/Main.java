package sc.senai.topcare.service;

import sc.senai.topcare.entity.MetodoPagamento;
import sc.senai.topcare.service.implement.PedidoServiceImpl;

public class Main {

    public static void main(String[] args) {

        PedidoServiceImpl pedidoServicePix = new PedidoServiceImpl(MetodoPagamento.PIX);
        System.out.println(pedidoServicePix.getFormaPagamento());

        PedidoServiceImpl pedidoServiceBoleto = new PedidoServiceImpl(MetodoPagamento.BOLETO);
        System.out.println(pedidoServiceBoleto.getFormaPagamento());

        PedidoServiceImpl pedidoServiceCartao = new PedidoServiceImpl(MetodoPagamento.CARTAO_CREDITO);
        System.out.println(pedidoServiceCartao.getFormaPagamento());

    }

}
