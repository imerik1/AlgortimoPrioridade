import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgoritmoPrioridade {
    public static List<AlgoritmoPrioridade> processos = new ArrayList<>();
    public static Integer qtdProcessos;
    private final int pri;
    private final int time;
    private final int id;

    public AlgoritmoPrioridade(int pri, int time, int id) {
        this.pri = pri;
        this.time = time;
        this.id = id;
    }

    public static void main(String[] args) {
        criar();
        priorizar();
    }

    static void criar() {
        Scanner in = new Scanner(System.in);
        System.out.println(":::: ALGORITMO DE PRIORIDADE ::::");
        System.out.println(" ");
        System.out.print("Quantos processos terá? ");
        qtdProcessos = in.nextInt();
        System.out.println("Escolha a prioridade e o tempo do processo: ");
        for (int i = 0; i < qtdProcessos; i++) {
            System.out.println("::: PROCESSO " + (i + 1) + " :::");
            System.out.print("Qual a prioridade?");
            Integer prioridade = in.nextInt();
            System.out.print("Qual o tempo? ");
            Integer time = in.nextInt();
            AlgoritmoPrioridade processo = new AlgoritmoPrioridade(prioridade, time, i + 1);
            processos.add(processo);
            System.out.println(" ");
        }
    }

    static void priorizar() {
        int total = 0;
        int contador = 0;
        int quit = 0;
        for (int i = 0; i < processos.size(); i++) {
            if (quit == processos.size()) {
                System.out.println(" ");
                System.out.println("Todos os processos foram executados");
                break;
            }
            if (processos.get(0).getPri() == contador) {
                System.out.println(" ");
                System.out.println("Executado processo " + processos.get(0).getId() + " com tempo de " + processos.get(0).getTime() + "ms e prioridade " + processos.get(0).getPri());
                contador++;
                total += processos.get(0).getTime();
                i = 0;
            } else if (processos.get(i).getPri() == contador) {
                System.out.println(" ");
                System.out.println("Executado processo " + processos.get(i).getId() + " com tempo de " + processos.get(i).getTime() + "ms e prioridade " + processos.get(i).getPri());
                contador++;
                total += processos.get(i).getTime();
                i = 0;
            } else {
                if (i == processos.size() - 1) {
                    i = 0;
                    contador++;
                    continue;
                }
                continue;
            }
            System.out.println("O tempo decorrido é " + total + "ms");
            quit++;
        }
    }

    public int getId() {
        return id;
    }

    public int getPri() {
        return pri;
    }

    public int getTime() {
        return time;
    }
}
