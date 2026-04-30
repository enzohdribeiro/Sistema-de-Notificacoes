package main;

import controller.Impressora;
import service.EmailService;
import service.SMSService;

public class Main {
    public static void main(String[] args) {
    EmailService n1 = new EmailService("Kleber","Seja bem-vindo!");
    SMSService n2 = new SMSService("Joana", "Olá! Tudo bem?");

    Impressora.imprimir(n1);
    Impressora.imprimir(n2);
    }
}
