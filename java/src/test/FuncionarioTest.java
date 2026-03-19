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
	private static Funcionario funcE;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.print("Configurando os testes ... ");
		
		funcA = new Funcionario("Fulano de Tal", "fulano@company.com", 5000, Funcionario.DESENVOLVEDOR);
		funcB = new Funcionario("Cicrano de Tel", "cicrano@company.com", 2500, Funcionario.GERENTE);
		funcC = new Funcionario("Beltrano de Til", "beltrano@company.com", 550, Funcionario.TESTADOR);
		funcD = new Funcionario("Siltrano de Fil", "siltrano@company.com", 1000, Funcionario.DBA);
		funcE = new Funcionario("Zicrano de Creu", "zicrano@company.com", 3000, Funcionario.DBA);

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
	void testSalarioGerenteMenor5000() {

		try {
			assertEquals(funcB.calculaSalario(), 2000);
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	void testSalarioTestadorMenor2000() {

		try {
			assertEquals(funcC.calculaSalario(), 467.5);
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

	@Test
	@Order(4)
	void testFuncionarioDBAMenor2000() {

		try {
			assertEquals(funcD.calculaSalario(), 850);
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	@Test
	@Order(4)
	void testFuncionarioDBAMaior2000() {

		try {
			assertEquals(funcE.calculaSalario(), 2250);
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	@Test
	@Order(5)
	void testEmailValido() {

		try {
			assertTrue(funcA.validarEmail("fulano@company.com"), "E-mail válido deve retornar true");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(5)
	void testEmailComPrefixoESufixo() {

		try {
			assertTrue(funcB.validarEmail("cicrano.silva@example.com"), "E-mail com prefixo e sufixo válidos deve retornar true");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(5)
	void testEmailSemArroba() {

		try {
			assertFalse(funcC.validarEmail("beltrancompany.com"), "E-mail sem @ deve retornar false");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(5)
	void testEmailVazio() {

		try {
			assertFalse(funcD.validarEmail(""), "E-mail vazio deve retornar false");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(5)
	void testEmailApenasArroba() {

		try {
			assertFalse(funcE.validarEmail("@"), "E-mail contendo apenas @ deve retornar false");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(5)
	void testEmailSemSufixo() {

		try {
			assertFalse(funcA.validarEmail("siltrano@"), "E-mail sem sufixo deve retornar false");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(5)
	void testEmailSemPrefixo() {

		try {
			assertFalse(funcB.validarEmail("@company.com"), "E-mail sem prefixo deve retornar false");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(5)
	void testEmailComMultiplasArrobas() {

		try {
			assertFalse(funcC.validarEmail("zicrano@company@com"), "E-mail com múltiplas @ deve retornar false");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}