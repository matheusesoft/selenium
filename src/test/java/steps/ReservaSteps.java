package steps;

import org.junit.Assert;

import cucumber.api.java.pt.*;
import pages.BookFlightPage;
import pages.FlightFinderPage;
import pages.LoginPage;
import pages.SelectFlightPage;

@SuppressWarnings("deprecation")
public class ReservaSteps {
	
	public LoginPage loginPage = new LoginPage();
	public FlightFinderPage flightFinderPage = new FlightFinderPage();
	public SelectFlightPage selectFlightPage = new SelectFlightPage();
	public BookFlightPage bookFlightPage = new BookFlightPage();
	
	@Dado("^que o \"(.*)\" esta aberto$")
	public void que_o_esta_aberto(String arg1) throws Throwable {
		Assert.assertTrue(this.loginPage.verificarPage(arg1));
	}
	
	@Quando("^informar o usuario \"(.*)\"$")
	public void informar_o_usuario(String userName) throws Throwable {
		loginPage.inserirUserName(userName); 	
	}
	
	@Quando("^informar a senha \"(.*)\"$")
	public void inserirSenha(String password) throws Throwable {
		loginPage.inserirPassword(password); 	
	}
	
	@Quando("^clicar no botao entrar$")
	public void clicar_no_botão_entrar() throws Throwable {
		loginPage.clicarBtnSignIn();
	}
	
	@Então("^a tela Flight Finder e exibida")
	public void a_tela_Flight_Finder_é_exibida() throws Throwable {
		Assert.assertTrue(this.flightFinderPage.verificarHome());
	}
	
	@Quando("^selecionar a cidade de origem \"(.*)\"$")
	public void selecionar_a_cidade_de_origem(String cidadeOrigem) throws Throwable {
		flightFinderPage.selecionarDepartingFrom(cidadeOrigem); 	
	}
	
	@Quando("^selecionar a cidade de destino \"(.*)\"$")
	public void selecionar_a_cidade_de_destino(String cidadeDestino) throws Throwable {
		flightFinderPage.selecionarArrivingIn(cidadeDestino); 	
	}
	
	@Quando("^selecionar data maior que data corrente$")
	public void selecionar_data_maior_que_corrente() throws Throwable {
		flightFinderPage.selecionarOnDay();
		flightFinderPage.selecionarOnMonth();
		flightFinderPage.selecionarReturningDay();
		flightFinderPage.selecionarReturningMonth();
	}
	
	@Quando("^selecionar a Class$")
	public void selecionar_a_Class() throws Throwable {
		flightFinderPage.selecionarClass(); 	
	}
	
	@Quando("^selecionar Passengers \"(.*)\"$")
	public void selecionar_Passengers(String passageiro) throws Throwable {
		flightFinderPage.selecionarPassengers(passageiro); 	
	}
	
	@Quando("^clicar no botao continue finder$") 
	public void clicar_no_botão_continue_finder()  throws Throwable {
		flightFinderPage.clicarBtnContinue(); 	
	}
	
	@Então("^a tela com opcao de voo e exibida$")
	public void a_tela_com_opções_de_voo_e_exibida() throws Throwable {
		Assert.assertTrue(this.selectFlightPage.verificarPagina());
	}
	
	@Quando("^selecionar o voo ida \"(.*)\" e voo volta \"(.*)\"$")
	public void selecionar_o_voo_ida_e_voo_volta(String vooOut, String vooIn) throws Throwable {
		selectFlightPage.selecionarOutFlight(vooOut);
		selectFlightPage.selecionarInFlight(vooIn);
	}
	
	@Quando("^clicar no botao continue reserve$")
	public void clicar_no_botão_continue_reserve() throws Throwable {
		selectFlightPage.clicarBtnContinue();
	}
	
	@Então("^a tela Book a Flight e exibida$")
	public void a_tela_Book_a_Flight_e_exibida() throws Throwable {
		Assert.assertTrue(bookFlightPage.verificarPagina());
	}
	
	@Então("^as opcoes selecionadas anteriormente sao exibidas corretamente$")
	public void as_opcoes_selecionadas_anteriormente_sao_exibidas_corretamente() throws Throwable {
		String[] valueOut = selectFlightPage.sOutFlight.trim().split("\\$");
		String[] valueIn = selectFlightPage.sInFlight.trim().split("\\$");
		//		Blue Skies Airlines$361$271$7:10
		String vooOut = valueOut[0]+" "+valueOut[1];
		String vooIn = valueIn[0]+" "+valueIn[1];
		
		Assert.assertTrue(vooOut.equals(bookFlightPage.getNomeOutFlight()));
		Assert.assertTrue(valueOut[2].equals(bookFlightPage.getPriceOutFlight()));
		
		Assert.assertTrue(vooIn.equals(bookFlightPage.getNomeInFlight()));
		Assert.assertTrue(valueIn[2].equals(bookFlightPage.getPriceInFlight()));
		
		float priceOutIn = Float.parseFloat(valueOut[2])+Float.parseFloat(valueIn[2]);
		float subtotal = Float.parseFloat(bookFlightPage.getSubtotal());
		Assert.assertTrue(priceOutIn == subtotal);
		
		String timeOut = valueOut[3];
		String timeIn = valueIn[3];
		Assert.assertTrue(timeOut.equals(bookFlightPage.getTimeOutFlight()));
		Assert.assertTrue(timeIn.equals(bookFlightPage.getTimeInFlight()));
	}
	
	@Quando("^informar first name \"(.*)\"$")
	public void informar_first_name(String firstName) throws Throwable {
		bookFlightPage.escreveNome(firstName);
	}
	
	@Quando("^informar last name \"(.*)\"$")
	public void informar_last_name(String lastName) throws Throwable {
		bookFlightPage.escreveUltimoNome(lastName);
	}
	
	@Quando("^preencher numero do cartao \"(.*)\"$")
	public void preencher_numero_do_cartao(String nroCartao) throws Throwable {
		bookFlightPage.escreveNumeroCartao(nroCartao);
	}
	
	@Quando("^preencher o nome do passageiro \"(.*)\"$")
	public void preencher_o_nome_do_passageiro(String passageiroNome) throws Throwable {
		bookFlightPage.escreveNomePassageiro(passageiroNome); 	
	}
	
	@Quando("^clicar em secure purchase$")
	public void clicar_em_secure_purchase() throws Throwable {
		bookFlightPage.clicarBtnContinue();
	}
	
	@Então("^a ordem e gerada$")
	public void a_ordem_e_gerada() throws Throwable {
		Assert.assertTrue(this.bookFlightPage.verificarOrdemGerada());
	} 
	
}
