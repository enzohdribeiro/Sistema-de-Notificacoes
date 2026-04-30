package controller;

import model.Notificacao;

public class Impressora {
    public static void imprimir(Notificacao notificacao){
        System.out.println("---------------------------------");
        System.out.println("Tipo de notificação: " + notificacao.getTipo());
        System.out.println("Destinatário: " + notificacao.getDestinatario());
        System.out.println("Mensagem: " + notificacao.enviar());
        System.out.println("Timestamp: " + notificacao.timeStamp);
    }
}
