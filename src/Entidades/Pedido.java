package Entidades;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entidade_enum.statusPedido;

public class Pedido {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date momento;
	private statusPedido status;
	//COMPOSICOES:
	private Cliente cliente;
	private List<itemPedido> ip = new ArrayList<>();
	
	public Pedido() {
		
	}
	public Pedido(Date momento, statusPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}
	public Date getMomento() {
		return momento;
	}
	public statusPedido getStatus() {
		return status;
	}

	public void setStatus(statusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<itemPedido> getIp() {
		return ip;
	}
	public void addList(itemPedido item) {
		this.ip.add(item);
	}
	public void removeList(itemPedido item) {
		this.ip.remove(item);
	}
	public Double getTotal () {
		Double total=0.0;
		for(itemPedido c : ip) {
			total += c.getSubtotal();
		}
		return total;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nRESUMO DO PEDIDO: " + "\n");
		sb.append("MOMENTO DO PEDIDO: " + sdf.format(momento) + "\n");
		sb.append("STATUS DO PEDIDO: " + status + "\n");
		sb.append("Cliente: " + cliente + "\n");
		sb.append("Itens do pedido: " + "\n");
		for (itemPedido i : ip) {
			
			sb.append(i + "\n");
		}
		sb.append("Valor Total: " + getTotal());
		
		return sb.toString();
	}
	
}
