package classes
import acessar

import clearConsole
import leitor


class Usuario(val nome: String) {
    val toDoList: MutableList<Tarefa> = mutableListOf()

    fun menu(){
        println("""
▀█▀ █▀█ ▄▄ █▀▄ █▀█   █░░ █ █▀ ▀█▀
░█░ █▄█ ░░ █▄▀ █▄█   █▄▄ █ ▄█ ░█░
🠒 $nome""")

        println("""
        Opções:
        1 - Adicionar Tarefas.
        2 - Deletar Tarefas.
        3 - Ver Tarefas.
        4 - Voltar ao menu de usuários.
        
        
        Digite o que deseja fazer: 
    """.trimIndent())
        val escolha: Int? = leitor.nextLine().toIntOrNull()

        when(escolha){
            1 -> {
                clearConsole()
                adicionarTarefa()
            }
            2 -> {
                clearConsole()
                deletarTarefas()
            }
            3 -> {
                clearConsole()
                verTarefas()
            }
            4 -> {
                clearConsole()
                readln()
                acessar.menu()
            }
            else -> {
                println("Opção Inválida!! Tecle Enter para voltar para o menu inicial.")
                readln()
                menu()
            }
        }

    }

    fun adicionarTarefa (){
        println("""
▄▀█ █▀▄ █ █▀▀ █ █▀█ █▄░█ ▄▀█ █▀█   ▀█▀ ▄▀█ █▀█ █▀▀ █▀▀ ▄▀█
█▀█ █▄▀ █ █▄▄ █ █▄█ █░▀█ █▀█ █▀▄   ░█░ █▀█ █▀▄ ██▄ █▀░ █▀█
""")
        try {
            print("Digite o nome da tarefa:")
            val nome: String = leitor.nextLine()
            print("Digite a data de término da tarefa (DD/MM/AA):")
            val data: String = leitor.nextLine()
            print("Digite a hora de término da tarefa:")
            val hora: String = leitor.nextLine()

            val tarefa = Tarefa(nome, data, hora, false)
            toDoList.add(tarefa)
            println("A tarefa foi criada com sucesso! Tecle ENTER para voltar ao menu: ")
            leitor.nextLine()
            menu()
        } catch (_: Exception){
            print("Opção Inválida! Tecle ENTER para voltar ao menu: ")
            leitor.nextLine()
            menu()
        }
    }

    fun verTarefas(){
        println("""
█░█ █▀▀ █▀█   ▀█▀ ▄▀█ █▀█ █▀▀ █▀▀ ▄▀█ █▀
▀▄▀ ██▄ █▀▄   ░█░ █▀█ █▀▄ ██▄ █▀░ █▀█ ▄█
""")
        try {
            if (toDoList.isNotEmpty()) {
                listarTarefas()
                print("Você deseja mudar o estado de alguma das tarefas? Se sim, digite o número atrelado a tarefa, se não, digite N: ")
                val escolha = leitor.nextLine()
                if (escolha.uppercase() == "N") {
                    menu()
                } else {
                    for (indice in toDoList.indices) {
                        if (indice == escolha.toInt()-1) {
                            toDoList[indice].terminado = !toDoList[indice].terminado
                            print("O estado foi mudado com sucesso, tecle ENTER para voltar ao menu: ")
                            readln()
                            menu()

                        } else {
                            println("Você digitou algo errado, tente novamente: ")
                            verTarefas()
                        }
                    }
                }
            }else {
                print("Não tem tarefas adicionadas ainda! Tecle ENTER para voltar ao menu: ")
                leitor.nextLine()
                menu()
            }
        } catch(_: Exception){
            println("Algo deu errado. Tecle ENTER para ir ao menu incial: ")
            readln()
            menu()
        }

    }

    fun listarTarefas(){

        if (toDoList.isNotEmpty()) {
            for((indice, i) in toDoList.withIndex()){
                println("${"N°".padEnd(4)} | ${"Classes.Tarefa".padEnd(40).padStart(10)} | ${"Data".padEnd(10)} | ${"Hora".padEnd(10)} | ${"Terminado".padEnd(4)}")

                println("${(indice+1).toString()+"°".padEnd(3)} | ${(i.nome).padEnd(40)} | ${(i.data).padEnd(10)} | ${(i.hora).padEnd(10)} | ${if (!i.terminado) { "☐" } else { "☑" }}")
            }
        } else {
            print("Não tem tarefas adicionadas ainda! Tecle ENTER para voltar ao menu: ")
            leitor.nextLine()
            menu()
        }
    }

    fun deletarTarefas(){
        println("""
█▀▄ █▀▀ █░░ █▀▀ ▀█▀ ▄▀█ █▀█   ▀█▀ ▄▀█ █▀█ █▀▀ █▀▀ ▄▀█ █▀
█▄▀ ██▄ █▄▄ ██▄ ░█░ █▀█ █▀▄   ░█░ █▀█ █▀▄ ██▄ █▀░ █▀█ ▄█
""")
        if (toDoList.isNotEmpty()) {
            listarTarefas()
            print("Digite o número atrelado a tarefa para deleta-la: ")
            val escolha: Int = leitor.nextLine().toInt()
            toDoList.removeAt(escolha-1)
            print("A tarefa foi deletada com sucesso! Tecle ENTER para voltar ao menu: ")
            leitor.nextLine()
            menu()
        } else{
            print("Não tem tarefas adicionadas ainda! Tecle ENTER para voltar ao menu: ")
            leitor.nextLine()
            menu()
        }
    }


}