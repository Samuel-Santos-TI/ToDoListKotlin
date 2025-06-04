package classes
import clearConsole
import leitor

class ToDoList  {
        val listaDeUsuarios: MutableList<Usuario> = mutableListOf()

        fun menu(){
            println("""
████████╗░█████╗░██████╗░░█████╗░██╗░░░░░██╗░██████╗████████╗
╚══██╔══╝██╔══██╗██╔══██╗██╔══██╗██║░░░░░██║██╔════╝╚══██╔══╝
░░░██║░░░██║░░██║██║░░██║██║░░██║██║░░░░░██║╚█████╗░░░░██║░░░
░░░██║░░░██║░░██║██║░░██║██║░░██║██║░░░░░██║░╚═══██╗░░░██║░░░
░░░██║░░░╚█████╔╝██████╔╝╚█████╔╝███████╗██║██████╔╝░░░██║░░░
░░░╚═╝░░░░╚════╝░╚═════╝░░╚════╝░╚══════╝╚═╝╚═════╝░░░░╚═╝░░░
""")

            println("""
        Opções:
        1 - Adicionar Usuário.
        2 - Deletar Usuário.
        3 - Acessar Usuário.
        4 - Sair.
        
        
        Digite o que deseja fazer: 
    """.trimIndent())
            val escolha: Int? = leitor.nextLine().toIntOrNull()

            when(escolha){
                1 -> {
                    clearConsole()
                    adicionarUsuario()
                }
                2 -> {
                    clearConsole()
                    deletarUsuario()

                }
                3 -> {
                    clearConsole()
                    acessarUsuario()
                }
                4 -> {
                    clearConsole()
                    print("Obrigado por usar nosso sistema!")
                }
                else -> {
                    clearConsole()
                    println("Opção Inválida!! Tecle Enter para voltar para o menu inicial.")
                    leitor.nextLine()
                    menu()
                }
            }

        }

        fun adicionarUsuario (){
            println("""
▄▀█ █▀▄ █ █▀▀ █ █▀█ █▄░█ ▄▀█ █▀█   █░█ █▀ █░█ ▄▀█ █▀█ █ █▀█
█▀█ █▄▀ █ █▄▄ █ █▄█ █░▀█ █▀█ █▀▄   █▄█ ▄█ █▄█ █▀█ █▀▄ █ █▄█
""")
            try {
                print("Digite o nome do usuário:")
                val nome: String = leitor.nextLine()

                val usuario = Usuario(nome)
                listaDeUsuarios.add(usuario)
                println("O usuário $nome foi criado com sucesso! Tecle ENTER para voltar ao menu: ")
                leitor.nextLine()
                menu()
            } catch (_: Exception){
                print("Opção Inválida! Tecle ENTER para tentar novamente: ")
                leitor.nextLine()
                adicionarUsuario()
            }
        }

        fun acessarUsuario(){
            println("""
▄▀█ █▀▀ █▀▀ █▀ █▀ ▄▀█ █▀█   █░█ █▀ █░█ ▄▀█ █▀█ █ █▀█
█▀█ █▄▄ ██▄ ▄█ ▄█ █▀█ █▀▄   █▄█ ▄█ █▄█ █▀█ █▀▄ █ █▄█
""")

            try {
                if (listaDeUsuarios.isNotEmpty()) {
                    listarUsuarios()
                    print("Digite o número de qual usuário você deseja acessar: ")
                    val escolha: Int = leitor.nextLine().toInt()

                    for ((indice, usuario) in listaDeUsuarios.withIndex()) {
                        if (indice == escolha-1) {
                            usuario.menu()
                        } else {
                            println("Esse usuário não existe! Tecle ENTER e tente novamente: ")
                            leitor.nextLine()
                            acessarUsuario()
                        }

                    }
                } else {
                    print("Não tem usuários adicionadas ainda! Tecle ENTER para voltar ao menu e adicionar algum: ")
                    leitor.nextLine()
                    menu()
                }
            } catch (_: Exception ){
                println("Algo deu errado! Siga as instruções corretamente: ")
                readln()
                acessarUsuario()
            }

        }

        fun listarUsuarios(){
            if (listaDeUsuarios.isNotEmpty()) {
                for((indice, i) in listaDeUsuarios.withIndex()){
                    println("${"N°".padEnd(4)} | ${"Usuário".padEnd(40).padStart(10)} ")

                    println("${(indice+1).toString()+"°".padEnd(3)} | ${(i.nome).padEnd(40)} ")
                }
            }else {
                print("Não tem usuarios adicionados ainda! Tecle ENTER para voltar ao menu: ")
                leitor.nextLine()
                menu()
            }
        }

        fun deletarUsuario(){
            println("""
█▀▄ █▀▀ █░░ █▀▀ ▀█▀ ▄▀█ █▀█   █░█ █▀ █░█ ▄▀█ █▀█ █ █▀█
█▄▀ ██▄ █▄▄ ██▄ ░█░ █▀█ █▀▄   █▄█ ▄█ █▄█ █▀█ █▀▄ █ █▄█
""")

            try {
                if (listaDeUsuarios.isNotEmpty()) {
                    listarUsuarios()
                    print("Digite o número atrelado a tarefa para deleta-la: ")
                    val escolha: Int = leitor.nextLine().toInt()
                    listaDeUsuarios.removeAt(escolha-1)
                    print("O usuário foi deletado com sucesso! Tecle ENTER para voltar ao menu: ")
                    leitor.nextLine()
                    menu()
                } else{
                    print("Não tem tarefas adicionadas ainda! Tecle ENTER para voltar ao menu: ")
                    leitor.nextLine()
                    menu()
                }
            } catch (_: Exception){
                println("Algo deu errado, tecle ENTER e tente novamente: ")
                readln()
                deletarUsuario()
            }
    }
}