# Exercício: Sistema de Notificações Multicanal

Este projeto simula (bem simplificadamente) um motor de notificações (E-mail e SMS) para explorar a combinação entre **Interfaces (contratos)** e **Classes Abstratas (moldes de estado)**.
A solução foi desenhada seguindo o princípio da inversão de dependência, onde o controlador não depende de implementações específicas, mas de abstrações.

---

## Conceitos de Orientação a Objetos Aplicados

| Conceito | Explicação Técnica |
| :--- | :--- |
| **Interface** | Utilizada como um contrato puro para garantir que diferentes serviços tenham os mesmos métodos. |
| **Classe Abstrata** | Utilizada para evitar redundância, centralizando atributos comuns e o timestamp de criação. |
| **Polimorfismo** | A `Impressora` chama `notificacao.enviar()` e a JVM decide em tempo de execução se executa a lógica de E-mail ou SMS. |
| **Composição de Datas** | Uso da API `java.time.Instant` para capturar o momento exato da geração do objeto na memória. |

---

### 1. Contratos: `CanalNotificacao` (Interface)
A interface define o comportamento mínimo esperado**.
*   Todo canal deve ser capaz de `enviar()`.
*   Todo canal deve informar seu `tipo` e `destinatario`.

### 2. Molde: `Notificacao` (Classe Abstrata)
Diferente da interface, a classe abstrata lida com **estado e estrutura**. Ela dita o que o objeto deve ter.
*   **Reuso de Código:** Implementa o campo `timeStamp` usando `Instant.now()`, garantindo que toda notificação tenha o registro de quando foi criada sem precisar repetir esse código em cada serviço.
*   **Atributos Protegidos:** `mensagem` e `destinatario` são definidos como `protected` para que as classes filhas os acessem diretamente, mas permaneçam ocultos para o resto do sistema.

### 3. Implementações Concretas: `EmailService` e `SMSService`
Aqui a lógica de negócio é executada.
*   **Especialização:** Cada serviço define sua própria String de `tipoNotificacao`.
*   **Polimorfismo:** O método `enviar()` simula a entrega da mensagem. Embora o Java permita a sobrescrita implícita, a boa prática de utilizar `@Override` foi aplicada para garantir a integridade do contrato durante a compilação.

### 4. Controlador: `Impressora`
Demonstra o poder do **desacoplamento**. O método `imprimir(Notificacao notificacao)` é capaz de processar qualquer novo tipo de serviço criado no futuro, desde que ele herde de `Notificacao`.
