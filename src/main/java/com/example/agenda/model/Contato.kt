package com.example.agenda.model

data class Contato(val id:Int, val name:String, val sobrenome:String, val fone:String, val email:String,)

class BD{
    fun Contatos():MutableList<Contato> {
        val ct = mutableListOf<Contato>();
        ct.add(Contato(1,"andrey","Queiroz","92992929", "qurieo@gmail.com"));
        ct.add(Contato(2,"fulano","silva","92992929", "qurieo@gmail.com"));
        ct.add(Contato(3,"ciclano","pereira","92992929", "qurieo@gmail.com"));
        ct.add(Contato(4,"beltrano","batista","92992929", "qurieo@gmail.com"));
        ct.add(Contato(5,"andrey","Queiroz","92992929", "qurieo@gmail.com"));
        ct.add(Contato(6,"fulano","silva","92992929", "qurieo@gmail.com"));
        ct.add(Contato(7,"ciclano","pereira","92992929", "qurieo@gmail.com"));
        ct.add(Contato(8,"beltrano","batista","92992929", "qurieo@gmail.com"));
        ct.add(Contato(9,"andrey","Queiroz","92992929", "qurieo@gmail.com"));
        ct.add(Contato(10,"fulano","silva","92992929", "qurieo@gmail.com"));
        ct.add(Contato(11,"ciclano","pereira","92992929", "qurieo@gmail.com"));
        ct.add(Contato(12,"beltrano","batista","92992929", "qurieo@gmail.com"));
        return ct;
    }
}