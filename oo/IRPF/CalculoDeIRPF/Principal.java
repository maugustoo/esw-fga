import javax.swing.JOptionPane;

public class Principal {

	//Vetor de referencias para objetos do tipo IRPF
	//Cada posicao esta associada a declaracao de IR de um contribuinte pessoa fisica
	//Obs.: por enquanto nao se preocupe com o modificador static
	static IRPF[] contribuintes = new IRPF[0];
	
	
	
	public static void main (String[] args) {
		//Menu de opcoes
		Object[] opcoesPossiveis = {"--- Selecione uma opcao ---",
									"Cadastrar contribuinte", 
				                    "Cadastrar Rendimento", 
				                    "Cadastrar Deducao",
				                    "Cadastrar Dependente",
				                    "Calcular imposto", 
				                    "Sair"};
		Object opcaoDefault = opcoesPossiveis[0];
		Object opcaoSelecionada = null;
		do {
			opcaoSelecionada = JOptionPane.showInputDialog(null, 
											"Selecione uma das opcoes a seguir:", 
											"Calculo de IRPF", 
											JOptionPane.QUESTION_MESSAGE, 
											null, 
											opcoesPossiveis, 
											opcaoDefault);
			switch ((String) opcaoSelecionada) {
			case "Cadastrar contribuinte":
				cadastrarContribuinte();
			break;

			default:
				break;
			}
		} while (!((String)opcaoSelecionada).equals((String)opcoesPossiveis[6]));
	}



	private static IRPF cadastrarContribuinte() {
		//Leitura dos valores para Nome e sexo do contribuinte
		String nomeContribuinte = JOptionPane.showInputDialog("Informe o nome do dependente:");

		Object[] opcoes = {"--- Selecione uma opcao ---" , "Feminino", "Masculino"}; 
		Object opcaoDefault = opcoes[0];
		
		Object opcaoEscolhida = opcaoDefault;
		do {
			opcaoEscolhida = JOptionPane.showInputDialog(null, 
														 "Informe o sexo do contribuinte", 
														 "Sexo do contribuinte", 
														 JOptionPane.QUESTION_MESSAGE, 
														 null, 
														 opcoes, 
														 opcaoDefault);
		} while (opcaoEscolhida == opcaoDefault);
		
		//Instanciacao do objeto IRPF (=contribuinte)
		IRPF cidadao = new IRPF(nomeContribuinte, (String)opcaoEscolhida);
		
		//Armazenamento do objeto cidadao no vetor de contribuintes
		int qtdeContribuintesAtual = contribuintes.length;
		int novaQtdeContribuintes = qtdeContribuintesAtual + 1;
		IRPF[] temp = new IRPF[novaQtdeContribuintes];
		
		for (int i=0; i<qtdeContribuintesAtual; i++) {
			temp[i] = contribuintes[i];
		}
		
		temp [novaQtdeContribuintes - 1] = cidadao;
		
		//atualizacao do vetor de contribuintes 
		contribuintes = temp;
		
		return temp[novaQtdeContribuintes-1];
	}

}