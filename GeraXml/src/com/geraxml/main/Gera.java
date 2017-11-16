package com.geraxml.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.geraxml.model.Endereco;
import com.geraxml.model.Fornecedor;
import com.geraxml.model.Produtos;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Gera {

	public static void main(String[] args) {

		Fornecedor fornecedor = setFornecedor();
		// xstream.alias("Fornecedor", Fornecedor.class);
		// xstream.alias("produtos", Produtos.class);

		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.registerConverter(new ConverteData());
		String xml = xstream.toXML(fornecedor);

		System.out.println(xml);
		geraArquivo(xml);
		buscaArquivo();

	}

	public static void buscaArquivo() {
		FileReader ler = null;
		try {

			ler = new FileReader("C:\\xstream\\arquivogerado");
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("Fornecedor", Fornecedor.class);
			xstream.alias("produtos", Produtos.class);
			xstream.registerConverter(new ConverteData());
			Fornecedor forn = (Fornecedor) xstream.fromXML(ler);

			System.out.println("Nome :" + forn.getNome());
			System.out.println("CPF :" + forn.getCpf());
			System.out.println("Data :" + forn.getDataCadastro());

			for (Produtos prod : forn.getListProdutos()) {
				System.out.println("Prod cod:" + prod.getCodigo());
				System.out.println("Prod nome:" + prod.getNome());
				System.out.println(" ------------------- ");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void geraArquivo(String xml) {
		PrintWriter print = null;
		try {
			File file = new File("C:\\xstream\\arquivogerado");
			print = new PrintWriter(file);
			print.write(xml);
			print.flush();
			print.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			print.close();
		}
	}

	private static Fornecedor setFornecedor() {

		Fornecedor forn = new Fornecedor();

		forn.setNome("Informatica LTDA");
		forn.setCpf("123.456.879.-80");
		forn.setDataCadastro(new Date());

		Endereco end = new Endereco();
		end.setBairro("Tanque");
		end.setCep("37589-000");
		end.setCidade("Pouso Alegre");
		end.setNumero("75");
		end.setRua("rua dos jacarandas");
		forn.setEndereco(end);

		Produtos prod = new Produtos();
		prod.setCodigo("001");
		prod.setNome("Tv PLasma");

		Produtos prod2 = new Produtos();
		prod2.setCodigo("002");
		prod2.setNome("HDD 500 gb");

		List<Produtos> listProd = new ArrayList<Produtos>();
		listProd.add(prod);
		listProd.add(prod2);

		forn.setListProdutos(listProd);

		return forn;

	}

}
