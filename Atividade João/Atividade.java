import java.util.ArrayList;

public class Atividade {

    static class Animal {
        private String nome;
        private int idade;
        private String especie;
        private String historicoSaude;
        private boolean adotado;

        public Animal(String nome, int idade, String especie, String historicoSaude) {
            this.nome = nome;
            this.idade = idade;
            this.especie = especie;
            this.historicoSaude = historicoSaude;
            this.adotado = false;
        }

        public String getNome() {
            return nome;
        }

        public boolean isAdotado() {
            return adotado;
        }

        public void adotar() {
            this.adotado = true;
        }

        public void emitirSom() {
            System.out.println("O animal faz um som.");
        }

        public void exibirInfo() {
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
            System.out.println("Espécie: " + especie);
            System.out.println("Histórico: " + historicoSaude);
            System.out.println("Adotado: " + (adotado ? "Sim" : "Não"));
            System.out.println("----------------------");
        }
    }

    static class Cachorro extends Animal {
        public Cachorro(String nome, int idade, String historicoSaude) {
            super(nome, idade, "Cachorro", historicoSaude);
        }

        @Override
        public void emitirSom() {
            System.out.println(getNome() + ": Au Au!");
        }
    }

    static class Gato extends Animal {
        public Gato(String nome, int idade, String historicoSaude) {
            super(nome, idade, "Gato", historicoSaude);
        }

        @Override
        public void emitirSom() {
            System.out.println(getNome() + ": Miau!");
        }
    }

    static class Abrigo {
        private ArrayList<Animal> animais = new ArrayList<>();

        public void adicionarAnimal(Animal animal) {
            animais.add(animal);
            System.out.println(animal.getNome() + " foi adicionado!");
        }

        public void listarAnimais() {
            System.out.println("\n=== LISTA DE ANIMAIS ===");
            for (Animal a : animais) {
                a.exibirInfo();
            }
        }

        public void adotarAnimal(String nome) {
            for (Animal a : animais) {
                if (a.getNome().equalsIgnoreCase(nome) && !a.isAdotado()) {
                    a.adotar();
                    System.out.println(nome + " foi adotado!");
                    return;
                }
            }
            System.out.println("Animal não encontrado ou já adotado.");
        }
    }

    public static void main(String[] args) {

        Abrigo abrigo = new Abrigo();

        Animal cachorro = new Cachorro("Rex", 4, "Saudável");
        Animal gato = new Gato("Mimi", 2, "Vacinado");

        abrigo.adicionarAnimal(cachorro);
        abrigo.adicionarAnimal(gato);

        abrigo.listarAnimais();

        cachorro.emitirSom();
        gato.emitirSom();

        abrigo.adotarAnimal("Rex");

        abrigo.listarAnimais();
    }
}