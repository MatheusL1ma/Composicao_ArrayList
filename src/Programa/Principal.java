package Programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entidade_enum.statusPedido;
import Entidades.Cliente;
import Entidades.Pedido;
import Entidades.Produto;
import Entidades.itemPedido;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List <Pedido> ped = new ArrayList<>();//CRIADO TIPO PEDIDO PARA USAR A FUNCAO ADDLIST QUE ESTA DENTRO DA CLASSE

		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de nascimento:(DD/MM/YYY) ");
		String dt = sc.next();
		Date data = sdf.parse(dt);//CONVERSAO DE STRING PARA DATA
		
		Cliente cliente = new Cliente(nome, email, data);//INSTANCIA CLIENTE

		System.out.print("Status: ");
		statusPedido st = statusPedido.valueOf(sc.next());//INSTANCIA ENUM
		
		Pedido p1 = new Pedido(new Date(), st, cliente);//INSTANCIA PEDIDO
		
		System.out.print("Quantos itens tera o seu pedido?  ");
		int n = sc.nextInt();

		for(int i=0; i<n; i++) {
			System.out.println();
			System.out.println("Digite o #" + (i+1) + " Item: " );
			System.out.println();
			System.out.print("Nome Produto: ");
			sc.nextLine();//LIMPAR BUFFER
			String nomeProduto = sc.nextLine();
			System.out.print("Preço Produto: ");
			Double preco = sc.nextDouble();
			System.out.print("Quantidade: ");
			Integer quantidade = sc.nextInt();
			
			itemPedido i1 = new itemPedido (quantidade, preco, new Produto(nomeProduto, preco));//INSTANCIA ITEM PEDIDO
			
			p1.addList(i1);//ADICIONANDO NA LISTA DO TIPO PEDIDO, A CLASSE ITEMPEDIDO QUE ESTA NA FUNCAO DENTRO DA CLASSE PEDIDO
		}
		System.out.println(p1);

	sc.close();
	}

}
