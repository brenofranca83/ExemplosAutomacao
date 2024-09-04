package main;

public class Funcionario {

	public static final String DESENVOLVEDOR = "Desenvolvedor";
	public static final String DBA = "Administrador de Banco de Dados";
	public static final String TESTADOR = "Testador";
	public static final String GERENTE = "Gerente de Projetos";
	
	private String nome;
	private String email;
	private float salarioBase;
	private String cargo;
	
	public Funcionario() {
		this.nome = "";
		this.email = "";
		this.salarioBase = 0.f;
		this.cargo = Funcionario.DESENVOLVEDOR;
	}

	public Funcionario(String nome, String email, float salarioBase, String cargo) {
		super();
		this.nome = nome;
		this.email = email;
		this.salarioBase = salarioBase;
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(float salarioBase) {
		this.salarioBase = salarioBase;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public float calculaSalario() throws Exception {
		
		float salario = 0;
		
		switch (this.getCargo()) {
			
		case Funcionario.DESENVOLVEDOR:
			
			if(salarioBase >= 3000)
				salario = salarioBase - (salarioBase * 0.2f);
			else
				salario = salarioBase - (salarioBase * 0.1f);
			break;
			
		case Funcionario.DBA:
			
			if(salarioBase >= 2000) 
				salario = salarioBase - (salarioBase * 0.25f);
			else
				salario = salarioBase - (salarioBase * 0.15f);

		case Funcionario.GERENTE:
			
			if(salarioBase >= 5000) 
				salario = salarioBase - (salarioBase * 0.3f);
			else
				salario = salarioBase - (salarioBase * 0.2f);

			break;

		case Funcionario.TESTADOR:
			
			if(salarioBase >= 2000) 
				salario = salarioBase - (salarioBase * 0.25f);
			else
				salario = salarioBase - (salarioBase * 0.15f);
			break; 
			
		default:
			throw new Exception("Cargo Indefinido!");
		}
		
		return salario;
	}

}
