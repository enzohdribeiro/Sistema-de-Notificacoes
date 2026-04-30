package service;

import model.Notificacao;

public class EmailService extends Notificacao {
    public String tipoNotificacao = "E-mail";

    public EmailService(String destinatario, String mensagem) {
        super(destinatario, mensagem);
    }

    @Override
    public String enviar(){
        System.out.println("Dentro do EmailService...\nServiço realizado com sucesso!");
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
