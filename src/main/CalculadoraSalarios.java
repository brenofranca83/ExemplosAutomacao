package main;

public class CalculadoraSalarios {

	public static void main(String[] args) {
		
		Funcionario funcA = new Funcionario("Fulano de Tal", "fulano@company.com", 5000, Funcionario.DESENVOLVEDOR);
		Funcionario funcB = new Funcionario("Cicrano de Tel", "cicrano@company.com", 2500, Funcionario.GERENTE);
		Funcionario funcC = new Funcionario("Beltrano de Til", "beltrano@company.com", 550, Funcionario.TESTADOR);
		Funcionario funcD = new Funcionario("Yo de Tol", "yo@company.com", 4000, Funcionario.TESTADOR);
		try {
			float salarioFuncA = funcA.calculaSalario();
			System.out.println("O salario do " + funcA.getNome() + " é: "+ salarioFuncA);
			float salarioFuncB = funcB.calculaSalario();
			System.out.println("O salario do " + funcB.getNome() + " é: "+ salarioFuncB);
			float salarioFuncC = funcC.calculaSalario();
			System.out.println("O salario do " + funcC.getNome() + " é: "+ salarioFuncC);
			float salarioFuncD = funcD.calculaSalario();
			System.out.println("O salario do " + funcD.getNome() + " é: "+ salarioFuncD);
			
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}

	}

}
