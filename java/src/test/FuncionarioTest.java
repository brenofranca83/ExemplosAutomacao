package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import main.Funcionario;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FuncionarioTest {

	private static Funcionario funcA;
	private static Funcionario funcB;
	private static Funcionario funcC;
	private static Funcionario funcD;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.print("Configurando os testes ... ");
		
		funcA = new Funcionario("Fulano de Tal", "fulano@company.com", 5000, Funcionario.DESENVOLVEDOR);
		funcB = new Funcionario("Cicrano de Tel", "cicrano@company.com", 2500, Funcionario.GERENTE);
		funcC = new Funcionario("Beltrano de Til", "beltrano@company.com", 550, Funcionario.TESTADOR);
		funcD = new Funcionario("Fulan al-Fulani", "anatomy@class.com", 550, Funcionario.DBA);

		
		System.out.println("OK");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Testes Finalizados");
	}

	@Test
	@Order(1)
	void testSalarioDesenvolvedorMaior3000() {

		try {
			assertEquals(funcA.calculaSalario(), 4000);
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	void testSalarioDesenvolvedorMenor3000() {
		funcA.setSalarioBase(2000);

		try {
			assertEquals(funcA.calculaSalario(), 1800);
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	void testSalarioGerenteMenor5000() {
		funcB.setSalarioBase(2500);

		try {
			assertEquals(funcB.calculaSalario(), 2000);
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}
	}


	@Test
	@Order(2)
	void testSalarioGerenteMaior5000() {
		funcB.setSalarioBase(6000);

		try {
			assertEquals(funcB.calculaSalario(), 4200);
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	void testSalarioTestadorMenor2000() {
		funcC.setSalarioBase(550);

		try {
			assertEquals(funcC.calculaSalario(), 467.5);
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	void testSalarioTestadorMaior2000() {
		funcC.setSalarioBase(4000);

		try {
			assertEquals(funcC.calculaSalario(), 3000);
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}
	}
	
	@Test
	@Order(4)
	void testSalarioDBAMaior2000() {
		funcD.setSalarioBase(4000);

		try {
			assertEquals(funcD.calculaSalario(), 3000);
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}
	}
	
	@Test
	@Order(4)
	void testSalarioDBAMenor2000() {
		funcD.setSalarioBase(550);

		try {
			assertEquals(funcD.calculaSalario(), 467.5);
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}
	}

	@Test
	@Order(3)
	void testFuncionarioSemCargo() {

		try {
			funcA.setCargo("");
			assertThrows(Exception.class, ()->{funcA.calculaSalario();}, "Cargo Indefinido!");
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
}
