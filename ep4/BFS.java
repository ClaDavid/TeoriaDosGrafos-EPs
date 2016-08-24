package ep4;

import ep0.*;

import java.util.*;

public class BFS {

	public static void bfs_f(GrafoPonderado G, Vertice s) {

		Vertice[] vertices = G.getVertices(); // pega os vertices do grafo
		int n = G.getTotalDeVertices(); // pega o numero de vertices do grafo
		Vertice u;
		int peso = 0;

		for (int i = 0; i < n; i++) {

			u = vertices[i];
			u.cor = Cores.BRANCO;
			u.d = Constantes.INFINITO;
			u.PI = null;

		}

		s.cor = Cores.CINZA;
		s.d = 0;
		s.PI = null;
		Fila q = new Fila();
		q.insereNaFila(s);

		while (!q.filaVazia()) {
			u = (Vertice) q.removeDaFila();

			for (int i = 0; i < n; i++) {

				Iterator it = G.getListasDeAdjacencia()[i].iterator();

				while (it.hasNext()) {
					Arco a = (Arco) it.next();
					
					//verificar se o vertice eh adjacente ao vertice u
					if (a.getOrigem().getIndice() == u.getIndice()) {
						Vertice v = a.getDestino();

						if (v.cor == Cores.BRANCO || v.cor == Cores.CINZA) {
							v.cor = Cores.CINZA;
                                                        v.PI = u;
							peso = a.getPeso();
                                                        int pesoTotal = peso + v.PI.d;
                                                        if(pesoTotal > v.d){
                                                            continue;
                                                        }
                                                        v.d = pesoTotal;							
							
							q.insereNaFila(v);
						}
					}
				}
			}

			u.cor = Cores.PRETO;

		}

		//System.out.println("\n");

	}
}
