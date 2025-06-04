
# 📝 ToDoList em Kotlin

Um sistema simples de **lista de tarefas (To-Do List)** desenvolvido totalmente em **Kotlin**, com foco no uso de **Programação Orientada a Objetos (POO)**.

Este projeto foi criado como prática de fundamentos da linguagem Kotlin e organização de código com foco em clareza, responsabilidade única e separação de lógica.

---

## 🚀 Funcionalidades

- 📌 Adicionar tarefas  
- 📋 Listar tarefas  
- ✅ Marcar tarefas como concluídas  
- ❌ Remover tarefas

---

## 📁 Estrutura do Projeto

```
ToDoList-Kotlin/
├── src/
│   └── main/
│       └── kotlin/
│           ├── classes/        # Classes principais (como Tarefa)
│           ├── Main.kt         # Função main com o fluxo principal do programa
│           └── funcoes.kt      # Funções auxiliares (ex: manipulação de tarefas)
├── .idea/                      # Configurações da IDE
├── .gitignore                  # Arquivos ignorados pelo Git
└── pom.xml                     # Configuração Maven (se aplicável)
```

> O código-fonte está organizado em `src/main/kotlin/`, respeitando a estrutura típica de projetos Kotlin com Maven.

---

## 💡 Tecnologias e Ferramentas

- Kotlin (versão utilizada: X.X.X)  
- IntelliJ IDEA (ou outra IDE compatível)  
- Execução via terminal ou ambiente de desenvolvimento  
- Gerenciador de build: Maven (pom.xml incluso)

---

## ▶️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/Samuel-Santos-TI/ToDoList-Kotlin.git
```

2. Acesse a pasta do projeto:
```bash
cd ToDoList-Kotlin
```

3. Compile e execute com sua IDE (ex: IntelliJ), ou usando o terminal com `kotlinc`:
```bash
kotlinc src/main/kotlin/Main.kt src/main/kotlin/funcoes.kt src/main/kotlin/classes/*.kt -include-runtime -d todolist.jar
java -jar todolist.jar
```

---

## 📚 O que foi praticado

- Organização de código com POO  
- Uso de classes e métodos para representar entidades  
- Manipulação básica de dados no terminal  
- Divisão de responsabilidades entre arquivos e funções

---

## 📄 Licença

Este projeto está licenciado sob a **MIT License** — fique à vontade para estudar, modificar e compartilhar!

---

**Desenvolvido por [Samuel Santos](https://github.com/Samuel-Santos-TI) 💻**





