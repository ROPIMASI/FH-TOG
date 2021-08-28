package dev.ronaldomarques.focopdv.tog.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dev.ronaldomarques.focopdv.tog.domain.Entity.Costumer;
import dev.ronaldomarques.focopdv.tog.domain.Entity.Order;

public class Gerador {

	public static List<Order> gerar(int q, Order pVazio) {

		// qtde, represent, lab, distrib, #further:ftp-info
		Random rnd = new Random();
		int rndInt = rnd.nextInt(9000);
		Order tmpPed = null;
		List<Order> pedidosCompletos = new ArrayList<Order>();

		for (int i = 0; i < q; i++) {
			tmpPed = new Order();
			tmpPed.setRep(pVazio.getRep());
			tmpPed.setLab(pVazio.getRep().getLaboratorios().get(0)); // FIXME: pegar um lab determinado.
			tmpPed.setDis(pVazio.getDis());
			tmpPed.setCli(new Costumer()); // FURTHER: buscar na carga.
			tmpPed.setNumPedInd(Integer.toString(10000 + rndInt + i));
			tmpPed.setData(LocalDate.now());
			tmpPed.setHora(LocalDateTime.now());
			tmpPed.setPrzPgto("28");
			tmpPed.setNumPedCli("");
			tmpPed.setValTotPed(BigDecimal.valueOf(9.99));

			tmpPed.setId(tmpPed.getRep().getNome() + tmpPed.getLab().getName() + tmpPed.getDis().getName()
					+ tmpPed.getNumPedInd());

			pedidosCompletos.add(tmpPed);
		}

		return pedidosCompletos;
	}
}
