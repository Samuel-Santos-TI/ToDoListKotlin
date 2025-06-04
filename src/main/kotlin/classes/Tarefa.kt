package classes

class Tarefa (val nome : String, val data: String, val hora: String, var terminado: Boolean){
    override fun toString(): String {
        return "Tarefa(nome='$nome', data='$data', hora='$hora', terminado=$terminado)"
    }
}