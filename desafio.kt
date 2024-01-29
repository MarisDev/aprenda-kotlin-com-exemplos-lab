data class Usuario(val nome: String)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("${usuario.nome} foi matriculado na formação ${nome}.")
        } else {
            println("${usuario.nome} já está matriculado nesta formação.")
        }
    }
}

fun main() {
    val usuario1 = Usuario("Maristela")
    val usuario2 = Usuario("Augusto")

    val conteudo1 = ConteudoEducacional("Android Developer", 67)
    val conteudo2 = ConteudoEducacional("Lógica de Programação", 41)

    val formacao1 = Formacao("Android Developer", listOf(conteudo1, conteudo2), Nivel.INTERMEDIARIO)

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao1.matricular(usuario1)  // Tentando matricular o mesmo usuário novamente

    println("Inscritos na formação ${formacao1.nome}: ${formacao1.inscritos.map { it.nome }}")
}
