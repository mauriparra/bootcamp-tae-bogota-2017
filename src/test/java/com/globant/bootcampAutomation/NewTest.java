package com.globant.bootcampAutomation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class NewTest {
	
	@Test
	public void PruebaNumerosPrimos() {
		int numeroPrueba = 13;
		int flag = 0;
		int i = 1;
		while (i <= numeroPrueba) {
			if (numeroPrueba % i == 0) {
				flag = flag + 1;
			}

			i = i + 1;
		}
		if (flag == 2) {
			System.out.println("es primo");
		} else {
			System.out.println("no primo");
		}
		
		assertEquals(2, flag);
	}

	@Test
	public void PruebaSumaEscenario1() {
		int num1 = 2;
		int num2 = 2;
		int resultado = num1 + num2;
		assertEquals(4, resultado);
	}

	@Test
	public void PruebaSumaEscenario2() {
		int num1 = -8;
		int num2 = -8;
		int resultado = num1 + num2;
		assertEquals(-16, resultado);
	}

	@Test(expectedExceptions = ArithmeticException.class)
	public void PruebaDivisionEscenario1() {
		int num1 = 20;
		int num2 = 0;
		int resultado = num1 / num2;
		// assertEquals(5, resultado);
	}

	@Test
	public void PruebaDivisionEscenario2() {
		int num1 = 8;
		int num2 = 2;
		int resultado = num1 / num2;
		assertEquals(4, resultado);
	}

	@Test
	public void PruebaRestaEscenario1() {
		int num1 = 4;
		int num2 = 3;
		int resultado = num1 - num2;
		assertEquals(1, resultado);
	}

	@Test
	public void PruebaRestaEscenario2() {
		int num1 = -54;
		int num2 = -30;
		int resultado = num1 - num2;
		assertEquals(-24, resultado);
	}

	@Test
	public void PruebaMultiplicarEscenario1() {
		int num1 = 5;
		int num2 = 5;
		int resultado = num1 * num2;
		assertEquals(25, resultado);
	}

	@Test
	public void PruebaMultiplicarEscenario2() {
		int num1 = -6;
		int num2 = -6;
		int resultado = num1 * num2;
		assertEquals(36, resultado);
	}

	@Test
	public void PruebaMultiplicarEscenario3() {
		int num1 = 2;
		int num2 = 2;
		int resultado = num1 * num2;
		assertEquals(8373, resultado);
	}

}
