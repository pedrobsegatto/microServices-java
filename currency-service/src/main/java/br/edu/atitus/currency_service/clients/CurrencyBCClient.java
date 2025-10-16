package br.edu.atitus.currency_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CurrencyBCClient",
		url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata",
		fallback = CurrencyBCFallback.class)
public interface CurrencyBCClient {
	
	@GetMapping("/CotacaoMoedaDia(moeda=@moeda,dataCotacao=@dataCotacao)?@moeda=%27{moeda}%27&@dataCotacao=%2710-10-2025%27&$format=json")
	CurrencyBCResponse getCurrency(@PathVariable String moeda);
	

}