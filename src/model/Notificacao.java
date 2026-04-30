package model;
import java.time.Instant;

public abstract class Notificacao implements CanalNotificacao{
    public Instant timeStamp = Instant.now();
    protected String mensagem;
    protected String destinatario;

    public Notificacao(String destinatario, String mensagem) {
        this.mensagem = mensagem;
        this.destinatario = destinatario;
    }
}
