package service;

import model.Notificacao;

import java.time.Instant;

public class SMSService extends Notificacao {
    public String tipoNotificacao = "SMS";

    public SMSService(String destinatario, String mensagem) {
        super(destinatario, mensagem);
    }

    @Override
    public String enviar(){
        System.out.println("Dentro do SMSService...\nServiço realizado com sucesso!");
        return mensagem;
    }
    @Override
    public String getTipo(){
        return tipoNotificacao;
    }
    @Override
    public String getDestinatario(){
        return destinatario;
    }
}
